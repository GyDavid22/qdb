package com.qdb.qdb.configuration;

import com.qdb.qdb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class DeleteOrphanImages {
    @Autowired
    private final ImageService service;

    public DeleteOrphanImages(ImageService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 7200000)
    public void performDelete() {
        service.deleteOrphanImagesWithExpiredTimeout();
    }
}
