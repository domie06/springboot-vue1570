/**
 * Inventory.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-09 22:02:43
 **/
package com.design.framework.inventory.model;

import com.design.framework.medicine.model.Medicine;

/**
 * inventory 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-04-09 22:02:43
 **/
public class Inventory {

    private Integer m_id;
    private Integer num;
    private Integer max_num;
    private Integer min_num;
    private Medicine medicine;
    /**
     * 获取  字段:inventory.m_id
     *
     * @return  inventory.m_id
     */
    public Integer getM_id() {
        return m_id;
    }

    /**
     * 设置  字段:inventory.m_id
     *
     * @param m_id  inventory.m_id
     */
    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    /**
     * 获取  字段:inventory.num
     *
     * @return  inventory.num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置  字段:inventory.num
     *
     * @param num  inventory.num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取  字段:inventory.max_num
     *
     * @return  inventory.max_num
     */
    public Integer getMax_num() {
        return max_num;
    }

    /**
     * 设置  字段:inventory.max_num
     *
     * @param max_num  inventory.max_num
     */
    public void setMax_num(Integer max_num) {
        this.max_num = max_num;
    }

    /**
     * 获取  字段:inventory.min_num
     *
     * @return  inventory.min_num
     */
    public Integer getMin_num() {
        return min_num;
    }

    /**
     * 设置  字段:inventory.min_num
     *
     * @param min_num  inventory.min_num
     */
    public void setMin_num(Integer min_num) {
        this.min_num = min_num;
    }
    
    public Medicine getMedicine() {
        return this.medicine;
    }
    
    public void setMedicine(Medicine medicine ) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Inventory [m_id=" + this.m_id + ", num=" + this.num + ", max_num=" + this.max_num + ", min_num="
                + this.min_num + "]";
    }

}