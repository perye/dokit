package com.perye.dokit.config;

import com.perye.dokit.utils.DoKitConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileProperties {

    /** 文件大小限制 */
    private Long maxSize;

    /** 头像大小限制 */
    private Long avatarMaxSize;

    private Path mac;

    private Path linux;

    private Path windows;

    public Path getPath(){
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith(DoKitConstant.WIN)) {
            return windows;
        } else if(os.toLowerCase().startsWith(DoKitConstant.MAC)){
            return mac;
        }
        return linux;
    }

    @Data
    public static class Path{

        private String path;

        private String avatar;
    }
}