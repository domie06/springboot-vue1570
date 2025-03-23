/**
 * LogDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-14 10:00:49
 **/
package com.design.framework.log.service;

import java.util.List;
import java.util.Map;

import com.design.framework.log.model.Log;

public interface LogService {
	
    int delete(Integer l_id);
    int add(Log log);
    Log load(Integer l_id);
    int update(Log log);
    List<Map<Object,Object>> boundList(Integer l_type);
    List<Map<Object,Object>> saleList(Integer l_type);
    List<Map<Object,Object>> saleChart();
}