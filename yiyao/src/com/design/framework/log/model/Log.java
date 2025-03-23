/**
 * Log.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-14 10:00:49
 **/
package com.design.framework.log.model;

import java.util.Date;

/**
 * log 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-04-14 10:00:49
 **/
public class Log {

    /**主键id,所属表字段为 log.l_id  */
    private Integer l_id;
    /**0销售 1销售退货 2入库 3入库退货,所属表字段为 log.l_type  */
    private Integer l_type;
    /**药品id,所属表字段为 log.m_id  */
    private Integer m_id;
    /**供货商id/患者id,所属表字段为 log.s_id  */
    private Integer s_id;
    /**药品数量,所属表字段为 log.m_num  */
    private Integer m_num;
    /**医生id,所属表字段为 log.u_id  */
    private Integer u_id;
    /**操作时间,所属表字段为 log.l_date  */
    private Date l_date;

    /**
     * 获取 主键id 字段:log.l_id
     *
     * @return  log.l_id  ,主键id
     */
    public Integer getL_id() {
        return l_id;
    }

    /**
     * 设置 主键id 字段:log.l_id
     *
     * @param l_id  log.l_id,主键id
     */
    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    /**
     * 获取 0销售 1销售退货 2入库 3入库退货 字段:log.l_type
     *
     * @return  log.l_type  ,0销售 1销售退货 2入库 3入库退货
     */
    public Integer getL_type() {
        return l_type;
    }

    /**
     * 设置 0销售 1销售退货 2入库 3入库退货 字段:log.l_type
     *
     * @param l_type  log.l_type,0销售 1销售退货 2入库 3入库退货
     */
    public void setL_type(Integer l_type) {
        this.l_type = l_type;
    }

    /**
     * 获取 药品id 字段:log.m_id
     *
     * @return  log.m_id  ,药品id
     */
    public Integer getM_id() {
        return m_id;
    }

    /**
     * 设置 药品id 字段:log.m_id
     *
     * @param m_id  log.m_id,药品id
     */
    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    /**
     * 获取 供货商id/患者id 字段:log.s_id
     *
     * @return  log.s_id  ,供货商id/患者id
     */
    public Integer getS_id() {
        return s_id;
    }

    /**
     * 设置 供货商id/患者id 字段:log.s_id
     *
     * @param s_id  log.s_id,供货商id/患者id
     */
    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    /**
     * 获取 药品数量 字段:log.m_num
     *
     * @return  log.m_num  ,药品数量
     */
    public Integer getM_num() {
        return m_num;
    }

    /**
     * 设置 药品数量 字段:log.m_num
     *
     * @param m_num  log.m_num,药品数量
     */
    public void setM_num(Integer m_num) {
        this.m_num = m_num;
    }

    /**
     * 获取 医生id 字段:log.u_id
     *
     * @return  log.u_id  ,医生id
     */
    public Integer getU_id() {
        return u_id;
    }

    /**
     * 设置 医生id 字段:log.u_id
     *
     * @param u_id  log.u_id,医生id
     */
    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    /**
     * 获取 操作时间 字段:log.l_date
     *
     * @return  log.l_date  ,操作时间
     */
    public Date getL_date() {
        return l_date;
    }

    /**
     * 设置 操作时间 字段:log.l_date
     *
     * @param l_date  log.l_date,操作时间
     */
    public void setL_date(Date l_date) {
        this.l_date = l_date;
    }
}