package com.crossoverJie.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Content implements Serializable {
    private Integer contentId;
    private String contentName ;
    private String content ;
    private String createDate ;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
