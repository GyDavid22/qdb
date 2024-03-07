package com.qdb.qdb.configuration;

import com.qdb.qdb.entity.Image;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.repository.ImageRepository;
import com.qdb.qdb.repository.QuestionRepository;
import com.qdb.qdb.repository.UserRepository;
import com.qdb.qdb.service.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class to import and export data from the database if the application is launched with the corresponding command line argument.
 */
@Configuration
public class ImportExportData implements ApplicationRunner {
    private final int BATCH_SIZE = 50;
    @Autowired
    private final ApplicationContext context;
    @Autowired
    private final UserService uService;
    @Autowired
    private final QuestionRepository qRepo;
    @Autowired
    private final ImageRepository iRepo;
    @Autowired
    private final UserRepository uRepo;

    public ImportExportData(ApplicationContext context, UserService uService, QuestionRepository qRepo, ImageRepository iRepo, UserRepository uRepo) {
        this.context = context;
        this.uService = uService;
        this.qRepo = qRepo;
        this.iRepo = iRepo;
        this.uRepo = uRepo;
    }

    @Override
    public void run(ApplicationArguments args) {
        for (String i : args.getSourceArgs()) {
            if (i.equalsIgnoreCase("--import")) {
                importData();
                break;
            } else if (i.equalsIgnoreCase("--export")) {
                exportData();
                break;
            }
        }
    }

    public void exportData() {
        try {
            File outputfolder = new File("exportdata");
            if (!outputfolder.exists()) {
                outputfolder.mkdir();
            } else {
                deleteExportFolderContent(outputfolder.listFiles());
            }

            exportUsers();
            exportQuestions();
        } catch (Exception e) {
            System.err.println("An error happened during exporting:");
            e.printStackTrace();
        }
        SpringApplication.exit(context);
    }

    private void deleteExportFolderContent(File[] files) {
        for (File i : files) {
            if (i.isFile()) {
                i.delete();
            } else {
                deleteExportFolderContent(i.listFiles());
                i.delete();
            }
        }
    }

    private void exportUsers() throws IOException {
        JSONArray ja = new JSONArray();
        File imagesFolder = new File("exportdata/profilepictures");
        imagesFolder.mkdir();
        for (User u : uRepo.findAll()) {
            JSONObject jo = new JSONObject();
            jo.put("username", u.getUserName());
            jo.put("hashedpassword", new String(u.getHashedPassword()));
            jo.put("salt", new String(u.getSalt()));
            jo.put("rank", u.getRank().toString());
            if (u.getProfilePicture() != null) {
                try (FileOutputStream fos = new FileOutputStream("exportdata/profilepictures/" + u.getUserName() + "." + u.getProfilePicture().getFormat().toString().toLowerCase())) {
                    fos.write(u.getProfilePicture().getContent());
                }
            }
            ja.add(jo);
        }
        try (FileWriter fw = new FileWriter("exportdata/users.json")) {
            fw.write(ja.toJSONString());
        }
    }

    public void exportQuestions() throws IOException {
        JSONArray ja = new JSONArray();
        File questionsfolder = new File("exportdata/questions");
        questionsfolder.mkdir();
        for (Question q : qRepo.findAll()) {
            JSONObject jo = new JSONObject();
            jo.put("title", q.getTitle());
            JSONArray tags = new JSONArray();
            for (Tag t : q.getTags()) {
                JSONObject tag = new JSONObject();
                tag.put("name", t.getName());
                tags.add(tag);
            }
            jo.put("tags", tags);
            jo.put("owner", q.getOwner() == null ? "null" : q.getOwner().getUserName());
            JSONArray images = new JSONArray();
            for (Image i : q.getImages()) {
                JSONObject image = new JSONObject();
                image.put("name", i.getName());
                try (FileOutputStream fos = new FileOutputStream("exportdata/questions/" + i.getName())) {
                    fos.write(i.getContent());
                }
                images.add(image);
            }
            jo.put("images", images);
            jo.put("body", q.getId() + ".md");
            try (FileWriter fw = new FileWriter("exportdata/questions/" + q.getId() + ".md")) {
                fw.write(q.getMdbody());
            }
            ja.add(jo);
        }
        try (FileWriter fw = new FileWriter("exportdata/questionsmetadata.json")) {
            fw.write(ja.toJSONString());
        }
    }

    public void importData() {
        for (User u : uRepo.findAll()) {
            uService.deleteUser(u.getUserName());
        }
        User u = new User();
        u.setUserName("QuestionEditor");
        u.setSalt("d8ee5dG/lBjn5H1WYS5/c2QqjuA1mOMLdltOR22VkJI=".toCharArray());
        u.setHashedPassword("FhfmDIt/UbqKAfOhY4bv+HrbzDBLXghnMBVfXYA4acQ=".toCharArray());
        u.setRank(User.Rank.ADMIN);
        u.setProfilePicture(null);
        uRepo.saveAndFlush(u);
        importImages();
        importQuestions(u);
        bindImagesToQuestions();
        SpringApplication.exit(context);
    }

    private void importQuestions(User u) {
        qRepo.deleteAll();
        try (FileReader fr = new FileReader("importdata/content.json")) {
            JSONParser p = new JSONParser();
            JSONArray ja = (JSONArray) p.parse(fr);
            int count = 0;
            for (Object i : ja) {
                JSONObject jo = (JSONObject) i;
                String filename = (String) jo.get("filename");
                String title = (String) jo.get("title");
                String content = String.join("\n", Files.readAllLines(Paths.get("importdata/files/" + filename), StandardCharsets.UTF_8));
                Question q = new Question();
                q.setTitle(title);
                q.setMdbody(content);
                q.setOwner(null);
                qRepo.save(q);
                count++;
                if (count % BATCH_SIZE == 0) {
                    count = 0;
                    qRepo.flush();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        qRepo.flush();
    }

    private void importImages() {
        iRepo.deleteAll();
        File imageDir = new File("importdata/images");
        if (imageDir.isDirectory() && imageDir.listFiles() != null) {
            int count = 0;
            for (File i : Objects.requireNonNull(imageDir.listFiles())) {
                Image image = new Image();
                image.setName(i.getName());
                try {
                    image.setContent(Files.readAllBytes(Paths.get(i.getPath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                iRepo.save(image);
                count++;
                if (count % BATCH_SIZE == 0) {
                    iRepo.flush();
                }
            }
        }
        iRepo.flush();
    }

    private void bindImagesToQuestions() {
        List<Image> images = iRepo.findAll();
        List<Image> found = new ArrayList<>();
        for (Question i : qRepo.findAll()) {
            String bodyInLowerCase = i.getMdbody().toLowerCase();
            for (Image j : images) {
                if (bodyInLowerCase.contains("](" + j.getName().toLowerCase() + "){")) {
                    j.setQuestion(i);
                    found.add(j);
                    iRepo.saveAndFlush(j);
                }
            }
            images.removeAll(found);
            found.clear();
        }
    }
}
