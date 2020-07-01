package com.mlw.lazyblog.entity;

/**
 * @author oRuol
 * @Date 2020/7/1 16:50
 */
public class ArticleEntity {
    private int articleLabelId;
    private int articleCategoryId;
    private String articleContent;
    private String articleTitle;
    private String articleSynopsis;
    private String articleImage;

    public int getArticleLabelId() {
        return articleLabelId;
    }

    public void setArticleLabelId(int articleLabelId) {
        this.articleLabelId = articleLabelId;
    }

    public int getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(int articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSynopsis() {
        return articleSynopsis;
    }

    public void setArticleSynopsis(String articleSynopsis) {
        this.articleSynopsis = articleSynopsis;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }
}
