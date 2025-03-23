/**
 * MedicineType.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-09 01:06:29
 **/
package com.design.framework.medicineType.model;

/**
 * Medicinetype 类
 * @Description :
 *
 * @version 1.0
 * 文件创建于: 2017-04-09 01:06:29
 **/
public class MedicineType {

    /**id,所属表字段为 Medicinetype.mt_id  */
    private Integer mt_id;
    /**名称,所属表字段为 Medicinetype.mt_name  */
    private String mt_name;
    private Integer ext1_int;
    private String ect2_varchar;

    /**
     * 获取 id 字段:Medicinetype.mt_id
     *
     * @return  Medicinetype.mt_id  ,id
     */
    public Integer getMt_id() {
        return mt_id;
    }

    /**
     * 设置 id 字段:Medicinetype.mt_id
     *
     * @param mt_id  Medicinetype.mt_id,id
     */
    public void setMt_id(Integer mt_id) {
        this.mt_id = mt_id;
    }

    /**
     * 获取 名称 字段:Medicinetype.mt_name
     *
     * @return  Medicinetype.mt_name  ,名称
     */
    public String getMt_name() {
        return mt_name;
    }

    /**
     * 设置 名称 字段:Medicinetype.mt_name
     *
     * @param mt_name  Medicinetype.mt_name,名称
     */
    public void setMt_name(String mt_name) {
        this.mt_name = mt_name == null ? null : mt_name.trim();
    }

    /**
     * 获取  字段:Medicinetype.ext1_int
     *
     * @return  Medicinetype.ext1_int
     */
    public Integer getExt1_int() {
        return ext1_int;
    }

    /**
     * 设置  字段:Medicinetype.ext1_int
     *
     * @param ext1_int  Medicinetype.ext1_int
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }

    /**
     * 获取  字段:Medicinetype.ect2_varchar
     *
     * @return  Medicinetype.ect2_varchar
     */
    public String getEct2_varchar() {
        return ect2_varchar;
    }

    /**
     * 设置  字段:Medicinetype.ect2_varchar
     *
     * @param ect2_varchar  Medicinetype.ect2_varchar
     */
    public void setEct2_varchar(String ect2_varchar) {
        this.ect2_varchar = ect2_varchar == null ? null : ect2_varchar.trim();
    }
}