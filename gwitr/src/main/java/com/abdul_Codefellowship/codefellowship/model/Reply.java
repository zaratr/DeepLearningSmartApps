package com.abdul_Codefellowship.codefellowship.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reply {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

     String reply;
   Date replyDate;

    @ManyToOne @OnDelete( action = OnDeleteAction.CASCADE)
    Post post;

    @ManyToOne @OnDelete( action = OnDeleteAction.CASCADE)
    public AppUser postAuthor;

    public Reply() {
    }

    public Reply(String reply) {
        this.reply = reply;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public AppUser getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(AppUser postAuthor) {
        this.postAuthor = postAuthor;
    }
}
