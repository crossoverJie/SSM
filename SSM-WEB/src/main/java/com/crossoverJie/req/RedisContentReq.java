package com.crossoverJie.req;

/**
 * @author crossoverJie
 * Date: 2017/5/21 下午11:54
 * @since JDK 1.7
 */
public class RedisContentReq extends BaseRequest{
    private Integer id ;
    private String content ;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RedisContentReq{" +
                "id=" + id +
                ", content='" + content + '\'' +
                "} " + super.toString();
    }
}
