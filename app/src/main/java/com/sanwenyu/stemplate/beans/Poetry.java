package com.sanwenyu.stemplate.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;


@Entity
public class Poetry {
    @Id(autoincrement = true)
    long id;
    long poetryId;
    long sxId;
    String title;
    String author;
    String dynasty;
    String content;

    @Generated(hash = 623785428)
    public Poetry(long id, long poetryId, long sxId, String title, String author,
                  String dynasty, String content) {
        this.id = id;
        this.poetryId = poetryId;
        this.sxId = sxId;
        this.title = title;
        this.author = author;
        this.dynasty = dynasty;
        this.content = content;
    }

    @Generated(hash = 1973469202)
    public Poetry() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(long poetryId) {
        this.poetryId = poetryId;
    }

    public long getSxId() {
        return sxId;
    }

    public void setSxId(long sxId) {
        this.sxId = sxId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

