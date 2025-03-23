/**
 * Medicine.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-09 16:23:33
 **/
package com.design.framework.medicine.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.design.framework.medicineType.model.MedicineType;

/**
 * medicine 类
 * @Description :
 *
 * @version 1.0
 * 文件创建于: 2017-04-09 16:23:33
 **/
public class Medicine {
    
    private Integer m_id;
    /**名称,所属表字段为 medicine.m_name  */
    private String m_name;
    /**厂商,所属表字段为 medicine.manufacturer  */
    private String manufacturer;
    /**拼音码,所属表字段为 medicine.pinyin  */
    private String untis;
    /**有效期,所属表字段为 medicine.pov  */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pov;
    /**批号,所属表字段为 medicine.batch  */
    private String batch;
    /**进货价,所属表字段为 medicine.inprice  */
    private Float inprice;
    /**销售价,所属表字段为 medicine.outprice  */
    private Float outprice;
    /**备注,所属表字段为 medicine.notes  */
    private String notes;
    /**类别代码,所属表字段为 medicine.mt_id  */
    private Integer mt_id;
    private Integer ext1_int;
    private String ext2_varchar;

    private MedicineType medicineType;
    
    /**
     * 获取  字段:medicine.m_id
     *
     * @return  medicine.m_id
     */
    public Integer getM_id() {
        return m_id;
    }
    
    /**
     * 设置  字段:medicine.m_id
     *
     * @param m_id  medicine.m_id
     */
    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }
    
    /**
     * 获取 名称 字段:medicine.m_name
     *
     * @return  medicine.m_name  ,名称
     */
    public String getM_name() {
        return m_name;
    }
    
    /**
     * 设置 名称 字段:medicine.m_name
     *
     * @param m_name  medicine.m_name,名称
     */
    public void setM_name(String m_name) {
        this.m_name = m_name == null ? null : m_name.trim();
    }
    
    /**
     * 获取 厂商 字段:medicine.manufacturer
     *
     * @return  medicine.manufacturer  ,厂商
     */
    public String getManufacturer() {
        return manufacturer;
    }
    
    /**
     * 设置 厂商 字段:medicine.manufacturer
     *
     * @param manufacturer  medicine.manufacturer,厂商
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }
    
    /**
     * 获取 单位 字段:medicine.untis
     *
     * @return  medicine.untis  ,单位
     */
    public String getUntis() {
        return untis;
    }
    
    /**
     * 设置 单位 字段:medicine.untis
     *
     * @param untis  medicine.untis,单位
     */
    public void setUntis(String untis) {
        this.untis = untis == null ? null : untis.trim();
    }
    
    /**
     * 获取 有效期 字段:medicine.pov
     *
     * @return  medicine.pov  ,有效期
     */
    public Date getPov() {
        return pov;
    }
    
    /**
     * 设置 有效期 字段:medicine.pov
     *
     * @param pov  medicine.pov,有效期
     */
    public void setPov(Date pov) {
        this.pov = pov;
    }
    
    /**
     * 获取 批号 字段:medicine.batch
     *
     * @return  medicine.batch  ,批号
     */
    public String getBatch() {
        return batch;
    }
    
    /**
     * 设置 批号 字段:medicine.batch
     *
     * @param batch  medicine.batch,批号
     */
    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }
    
    /**
     * 获取 进货价 字段:medicine.inprice
     *
     * @return  medicine.inprice  ,进货价
     */
    public Float getInprice() {
        return inprice;
    }
    
    /**
     * 设置 进货价 字段:medicine.inprice
     *
     * @param inprice  medicine.inprice,进货价
     */
    public void setInprice(Float inprice) {
        this.inprice = inprice;
    }
    
    /**
     * 获取 销售价 字段:medicine.outprice
     *
     * @return  medicine.outprice  ,销售价
     */
    public Float getOutprice() {
        return outprice;
    }
    
    /**
     * 设置 销售价 字段:medicine.outprice
     *
     * @param outprice  medicine.outprice,销售价
     */
    public void setOutprice(Float outprice) {
        this.outprice = outprice;
    }
    
    /**
     * 获取 备注 字段:medicine.notes
     *
     * @return  medicine.notes  ,备注
     */
    public String getNotes() {
        return notes;
    }
    
    /**
     * 设置 备注 字段:medicine.notes
     *
     * @param notes  medicine.notes,备注
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }
    
    /**
     * 获取 类别代码 字段:medicine.mt_id
     *
     * @return  medicine.mt_id  ,类别代码
     */
    public Integer getMt_id() {
        return mt_id;
    }
    
    /**
     * 设置 类别代码 字段:medicine.mt_id
     *
     * @param mt_id  medicine.mt_id,类别代码
     */
    public void setMt_id(Integer mt_id) {
        this.mt_id = mt_id;
    }
    
    /**
     * 获取  字段:medicine.ext1_int
     *
     * @return  medicine.ext1_int
     */
    public Integer getExt1_int() {
        return ext1_int;
    }
    
    /**
     * 设置  字段:medicine.ext1_int
     *
     * @param ext1_int  medicine.ext1_int
     */
    public void setExt1_int(Integer ext1_int) {
        this.ext1_int = ext1_int;
    }
    
    /**
     * 获取  字段:medicine.ext2_varchar
     *
     * @return  medicine.ext2_varchar
     */
    public String getExt2_varchar() {
        return ext2_varchar;
    }
    
    /**
     * 设置  字段:medicine.ext2_varchar
     *
     * @param ext2_varchar  medicine.ext2_varchar
     */
    public void setExt2_varchar(String ext2_varchar) {
        this.ext2_varchar = ext2_varchar == null ? null : ext2_varchar.trim();
    }

    public MedicineType getMedicineType() {
        return this.medicineType;
    }

    public void setMedicineType(MedicineType medicineType ) {
        this.medicineType = medicineType;
    }
    
}