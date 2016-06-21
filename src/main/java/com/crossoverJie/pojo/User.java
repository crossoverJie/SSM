package com.crossoverJie.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/21.
 */
public class User {
    private Integer id;
    private String email ;
    private String username;
    private String password;
    private String realname ;
    private String role_id ;
    private String remark ;
    private Date last_date ;
    private String sex ; //0:女        1：男
    private String img_id ;//对应的图片ID 用户的头像

    private Date register_date ;//注册时间
    private String star_news_id;//收藏的帖子ID

    /**用于显示格式化的日期**/
    private String parsedate ;

    /**角色名称**/
    private String rolename ;

    /**查询的活用用户数量**/
    private String post_user_count ;
    /**用户头像路径**/
    private String path ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLast_date() {
        return last_date;
    }

    public void setLast_date(Date last_date) {
        this.last_date = last_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getParsedate() {
        return parsedate;
    }

    public void setParsedate(String parsedate) {
        this.parsedate = parsedate;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {

        this.register_date = register_date;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String date = sm.format(register_date) ;

        this.setParsedate(date);
    }

    public String getStar_news_id() {
        return star_news_id;
    }

    public void setStar_news_id(String star_news_id) {
        this.star_news_id = star_news_id;
    }

    public String getPost_user_count() {
        return post_user_count;
    }

    public void setPost_user_count(String post_user_count) {
        this.post_user_count = post_user_count;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}