package com.example.retrofitandroid.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    private final String bla_bla;
    private String text;
    private int userId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("postId")
    @Expose
    private String postId;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("userAvatar")
    @Expose
    private String userAvatar;
    @SerializedName("comment")
    @Expose
    private String comment;

    public Comment(String bla_bla) {
        this.bla_bla=bla_bla
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getComments() {
        return comment;
    }

    public void setComments(String comment) {
        this.comment = comment;
    }

}