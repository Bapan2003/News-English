package com.example.newsenglish;

public class ModelClass {

    private  String author,title,description,url,urltoImage,publishedAt;


    public ModelClass(String author, String title, String description, String url, String urltoImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urltoImage = urltoImage;
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTile(String tile) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrltoImage() {
        return urltoImage;
    }

    public void setUrltoImage(String urltoImage) {
        this.urltoImage = urltoImage;
    }

    public String getPublishAt() {
        return publishedAt;
    }

    public void setPublishAt(String publishAt) {
        this.publishedAt = publishedAt;
    }
}
