package com.example.app_insta.model.model;

public class Post {
    private String postid;
    private String postimage;
    private String description;
    private String publisher;

    public Post(String postid, String postimage, String description , String publisher)
    {
        this.postid=postid;
        this.postimage=postimage;
        this.description=description;
        this.publisher=publisher;
    }

    public Post(){
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid() {
        this.postid=postid;
    }

    public String getPostimage(){
        return postimage;
    }

    public void setPostImage() {
        this.postimage=postimage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description=description;
    }
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher() {
        this.publisher=publisher;
    }

}
