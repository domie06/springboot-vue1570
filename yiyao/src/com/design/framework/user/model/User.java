/**
 * User.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-13 17:20:09
 **/
package com.design.framework.user.model;

/**
 * user 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-13 17:20:09
 **/
public class User {

    private Integer user_id;
    private String user_name;
    private String account;
    private String password;
    private String type;
    private Integer ext1_int;
    private String ext2_varchar;

    /**
     * 获取  字段:user.user_id
     *
     * @return  user.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * 设置  字段:user.user_id
     *
     * @param user_id  user.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取  字段:user.user_name
     *
     * @return  user.user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置  字段:user.user_name
     *
     * @param user_name  user.user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    /**
     * 获取  字段:user.account
     *
     * @return  user.account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置  字段:user.account
     *
     * @param account  user.account
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取  字段:user.password
     *
     * @return  user.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置  字段:user.password
     *
     * @param password  user.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取  字段:user.type
     *
     * @return  user.type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置  字段:user.type
     *
     * @param type  user.type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取  字段:user.ext1_int
     *
     * @return  user.ext1_int
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置  字段:user.ext1_int
     *
     * @param ext1_int  user.ext1_int
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取  字段:user.ext2_varchar
     *
     * @return  user.ext2_varchar
     */
    public String getExt2_varchar() {
        return ext2_varchar;
    }

    /**
     * 设置  字段:user.ext2_varchar
     *
     * @param ext2_varchar  user.ext2_varchar
     */
    public void setExt2_varchar(String ext2_varchar) {
        this.ext2_varchar = ext2_varchar == null ? null : ext2_varchar.trim();
    }
}