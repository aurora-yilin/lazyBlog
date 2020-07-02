package com.mlw.lazyblog.vo;

/**
 * @author oRuol
 * @Date 2020/7/2 14:57
 */
public class FileInfo {
    private String fileName;
    private String filePattern;

    public FileInfo() {
    }

    public FileInfo(String fileName, String filePattern) {
        this.fileName = fileName;
        this.filePattern = filePattern;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePattern() {
        return filePattern;
    }

    public void setFilePattern(String filePattern) {
        this.filePattern = filePattern;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", filePattern='" + filePattern + '\'' +
                '}';
    }
}
