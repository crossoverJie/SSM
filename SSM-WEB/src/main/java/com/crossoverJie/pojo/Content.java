package com.crossoverJie.pojo;

public class Content {
    private Integer contentid;

    private String contentname;

    private String content;

    private String createdate;

    public Integer getContentid() {
        return contentid;
    }

    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    public String getContentname() {
        return contentname;
    }

    public void setContentname(String contentname) {
        this.contentname = contentname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentid=" + contentid +
                ", contentname='" + contentname + '\'' +
                ", content='" + content + '\'' +
                ", createdate='" + createdate + '\'' +
                '}';
    }
}