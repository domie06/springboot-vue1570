/**
 * Supplier.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-14 09:52:04
 **/
package com.design.framework.supplier.model;

/**
 * supplier 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-14 09:52:04
 **/
public class Supplier {

    private Integer s_id;
    private String s_name;
    private Integer ext1_int;
    private String ect2_varchar;

    /**
     * 获取  字段:supplier.s_id
     *
     * @return  supplier.s_id
     */
    public Integer getS_id() {
        return s_id;
    }

    /**
     * 设置  字段:supplier.s_id
     *
     * @param s_id  supplier.s_id
     */
    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    /**
     * 获取  字段:supplier.s_name
     *
     * @return  supplier.s_name
     */
    public String getS_name() {
        return s_name;
    }

    /**
     * 设置  字段:supplier.s_name
     *
     * @param s_name  supplier.s_name
     */
    public void setS_name(String s_name) {
        this.s_name = s_name == null ? null : s_name.trim();
    }

    /**
     * 获取  字段:supplier.ext1_int
     *
     * @return  supplier.ext1_int
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置  字段:supplier.ext1_int
     *
     * @param ext1_int  supplier.ext1_int
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取  字段:supplier.ect2_varchar
     *
     * @return  supplier.ect2_varchar
     */
    public String getEct2_varchar() {
        return ect2_varchar;
    }

    /**
     * 设置  字段:supplier.ect2_varchar
     *
     * @param ect2_varchar  supplier.ect2_varchar
     */
    public void setEct2_varchar(String ect2_varchar) {
        this.ect2_varchar = ect2_varchar == null ? null : ect2_varchar.trim();
    }
}