package com.perye.dokit.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class MultipartConfig {

    /**
     * 文件上传临时路径
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = System.getProperty("user.home") + "/.dokit/file/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            if (!tmpFile.mkdirs()) {
                System.out.println("create was not successful.");
            }
        }
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }
}
