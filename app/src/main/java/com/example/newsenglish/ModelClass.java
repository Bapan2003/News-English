package com.example.newsenglish;

public class ModelClass {

    private  String author,tile,description,url,urltoImage,publishAt;


    public ModelClass(String author, String tile, String description, String url, String urltoImage, String publishAt) {
        this.author = author;
        this.tile = tile;
        this.description = description;
        this.url = url;
        this.urltoImage = urltoImage;
        this.publishAt = publishAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
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
        return publishAt;
    }

    public void setPublishAt(String publishAt) {
        this.publishAt = publishAt;
    }
}
