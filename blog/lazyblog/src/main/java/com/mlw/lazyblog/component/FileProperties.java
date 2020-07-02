package com.mlw.lazyblog.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author oRuol
 * @Date 2020/7/2 14:29
 */
@Component
@ConfigurationProperties(prefix = "mlw.lazyblog")
public class FileProperties {
    private String fileLocations;
    private String filePattern;

    public String getFileLocations() {
        return fileLocations;
    }

    public void setFileLocations(String fileLocations) {
        this.fileLocations = fileLocations;
    }

    public String getFilePattern() {
        return filePattern;
    }

    public void setFilePattern(String filePattern) {
        this.filePattern = filePattern;
    }
}
