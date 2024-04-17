package com.qdb.qdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class QdbApplication {
    public static void main(String[] args) {
        File tempFilesFolder = new File("tempfiles");
        QdbApplication.cleanup(tempFilesFolder);
        tempFilesFolder.mkdir();
        SpringApplication.run(QdbApplication.class, args);
    }

    public static void cleanup(File file) {
        if (file.exists()) {
            File[] content = file.listFiles();
            if (content != null) {
                for (File i : content) {
                    if (i.isDirectory()) {
                        QdbApplication.cleanup(i);
                    } else {
                        i.delete();
                    }
                }
            }
            if (file.isDirectory()) {
                file.delete();
            }
        }
    }
}
