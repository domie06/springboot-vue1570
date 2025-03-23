/**
 * Customer.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-14 09:51:27
 **/
package com.design.framework.customer.model;

/**
 * customer 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-14 09:51:27
 **/
public class Customer {

    private Integer c_id;
    private String c_name;
    private Integer sex;
    private String diagnosis;
    private String notes;
    private Integer ext1_int;
    private String ect2_varchar;

    /**
     * 获取  字段:customer.c_id
     *
     * @return  customer.c_id
     */
    public Integer getC_id() {
        return c_id;
    }

    /**
     * 设置  字段:customer.c_id
     *
     * @param c_id  customer.c_id
     */
    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    /**
     * 获取  字段:customer.c_name
     *
     * @return  customer.c_name
     */
    public String getC_name() {
        return c_name;
    }

    /**
     * 设置  字段:customer.c_name
     *
     * @param c_name  customer.c_name
     */
    public void setC_name(String c_name) {
        this.c_name = c_name == null ? null : c_name.trim();
    }

    /**
     * 获取  字段:customer.sex
     *
     * @return  customer.sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置  字段:customer.sex
     *
     * @param sex  customer.sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取  字段:customer.diagnosis
     *
     * @return  customer.diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * 设置  字段:customer.diagnosis
     *
     * @param diagnosis  customer.diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    /**
     * 获取  字段:customer.notes
     *
     * @return  customer.notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置  字段:customer.notes
     *
     * @param notes  customer.notes
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * 获取  字段:customer.ext1_int
     *
     * @return  customer.ext1_int
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置  字段:customer.ext1_int
     *
     * @param ext1_int  customer.ext1_int
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取  字段:customer.ect2_varchar
     *
     * @return  customer.ect2_varchar
     */
    public String getEct2_varchar() {
        return ect2_varchar;
    }

    /**
     * 设置  字段:customer.ect2_varchar
     *
     * @param ect2_varchar  customer.ect2_varchar
     */
    public void setEct2_varchar(String ect2_varchar) {
        this.ect2_varchar = ect2_varchar == null ? null : ect2_varchar.trim();
    }
}