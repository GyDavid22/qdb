package com.qdb.qdb.configuration;

import com.qdb.qdb.entity.Image;
import com.qdb.qdb.entity.Question;
import com.qdb.qdb.entity.Tag;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.UnsupportedFileFormatException;
import com.qdb.qdb.exception.UserNotFoundException;
import com.qdb.qdb.repository.ImageRepository;
import com.qdb.qdb.repository.QuestionRepository;
import com.qdb.qdb.repository.TagRepository;
import com.qdb.qdb.repository.UserRepository;
import com.qdb.qdb.service.ImageService;
import com.qdb.qdb.service.QuestionService;
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
import org.springframework.http.MediaType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class to import and export data from the database if the application is launched with the corresponding command line argument.
 */
@Configuration
public class ImportExportData implements ApplicationRunner {
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
    @Autowired
    private final TagRepository tRepo;
    @Autowired
    private final ImageService iService;
    @Autowired
    private final QuestionService qService;

    public ImportExportData(ApplicationContext context, UserService uService, QuestionRepository qRepo, ImageRepository iRepo, UserRepository uRepo, TagRepository tRepo, ImageService iService, QuestionService qService) {
        this.context = context;
        this.uService = uService;
        this.qRepo = qRepo;
        this.iRepo = iRepo;
        this.uRepo = uRepo;
        this.tRepo = tRepo;
        this.iService = iService;
        this.qService = qService;
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

    private void exportData() {
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
                jo.put("profilepicture", "exportdata/profilepictures/" + u.getUserName() + "." + u.getProfilePicture().getFormat().toString().toLowerCase());
            } else {
                jo.put("profilepicture", null);
            }
            ja.add(jo);
        }
        try (FileWriter fw = new FileWriter("exportdata/users.json")) {
            fw.write(ja.toJSONString());
        }
    }

    private void exportQuestions() throws IOException {
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
            jo.put("owner", q.getOwner() == null ? null : q.getOwner().getUserName());
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

    private void importData() {
        importUsers();
        importQuestions();
        bindImagesToQuestions();
        SpringApplication.exit(context);
    }

    private void importUsers() {
        for (User u : uRepo.findAll()) {
            uService.deleteUser(u.getUserName());
        }
        try (FileReader fr = new FileReader("importdata/users.json")) {
            JSONParser p = new JSONParser();
            JSONArray users = (JSONArray) p.parse(fr);
            for (Object i : users) {
                JSONObject user = (JSONObject) i;
                String username = (String) user.get("username");
                String rank = (String) user.get("rank");
                String salt = (String) user.get("salt");
                String hashedpassword = (String) user.get("hashedpassword");
                String picturename = (String) user.get("profilepicture");
                User u = new User();
                u.setUserName(username);
                u.setRank(User.Rank.valueOf(rank));
                u.setSalt(salt.toCharArray());
                u.setHashedPassword(hashedpassword.toCharArray());
                u.setProfilePicture(null);
                uRepo.saveAndFlush(u);
                if (picturename != null) {
                    File pfp = new File("profilepictures/" + picturename);
                    if (pfp.exists()) {
                        byte[] content = Files.readAllBytes(Path.of(pfp.getPath()));
                        String type = picturename.toLowerCase().endsWith(".png") ? MediaType.IMAGE_PNG_VALUE : MediaType.IMAGE_JPEG_VALUE;
                        try {
                            uService.setProfilePicture(content, type, u.getUserName());
                        } catch (UserNotFoundException | UnsupportedFileFormatException ignored) {
                        }
                    }
                }
            }
        } catch (IOException | ParseException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    private void importQuestions() {
        iRepo.deleteAll();
        tRepo.deleteAll();
        qRepo.deleteAll();
        User mockUser = new User();
        mockUser.setRank(User.Rank.ADMIN);
        try (FileReader fr = new FileReader("importdata/questionsmetadata.json")) {
            JSONParser p = new JSONParser();
            JSONArray questions = (JSONArray) p.parse(fr);
            for (Object i : questions) {
                JSONObject question = (JSONObject) i;
                Question q = new Question();
                String owner = (String) question.get("owner");
                String title = (String) question.get("title");
                String body = (String) question.get("body");
                String bodyContent = String.join("\n", Files.readAllLines(Path.of("importdata/questions/" + body)));
                JSONArray images = (JSONArray) question.get("images");
                q.setImages(new ArrayList<>());
                JSONArray tags = (JSONArray) question.get("tags");
                q.setOwner(uService.getByUserName(owner, mockUser));
                q.setTitle(title);
                q.setMdbody(bodyContent);
                q.setTags(new ArrayList<>());
                qRepo.saveAndFlush(q);
                for (Object j : images) {
                    String imagename = (String) ((JSONObject) j).get("name");
                    byte[] content = Files.readAllBytes(Path.of("importdata/questions/" + imagename));
                    Image image = iService.addImage(content, imagename.toLowerCase().endsWith(".png") ? MediaType.IMAGE_PNG_VALUE : MediaType.IMAGE_JPEG_VALUE);
                    iService.bindImageToQuestion(image, q);
                    iRepo.saveAndFlush(image);
                }
                qService.updateTags(q, tags.stream().map(t -> (String) ((JSONObject) t).get("name")).toList(), mockUser);
                qRepo.flush();
            }
        } catch (IOException | ParseException | NoRightException | UnsupportedFileFormatException e) {
            e.printStackTrace();
        }
    }

    private void bindImagesToQuestions() {
        Collection<Image> images = iRepo.findByQuestionIsNull();
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
