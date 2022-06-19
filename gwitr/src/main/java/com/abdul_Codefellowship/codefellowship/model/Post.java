package com.abdul_Codefellowship.codefellowship.model;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
   String text;
   Date createdAt;



    @ManyToOne
    AppUser postAuthor;


    @OneToMany (mappedBy = "post", cascade = CascadeType.REMOVE)

    public List<Reply> replyList;


    public Post() {
    }

    public Post(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AppUser getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(AppUser postAuthor) {
        this.postAuthor = postAuthor;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
