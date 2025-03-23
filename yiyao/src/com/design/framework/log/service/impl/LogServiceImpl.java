package com.design.framework.log.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.log.dao.LogDao;
import com.design.framework.log.model.Log;
import com.design.framework.log.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao; 
    
	@Override
	public int delete(Integer l_id) {
		return this.logDao.delete(l_id);
	}

	@Override
	public int add(Log log) {
		return this.logDao.add(log);
	}

	@Override
	public Log load(Integer l_id) {
		return this.load(l_id);
	}

	@Override
	public int update(Log log) {
		return this.logDao.update(log);
	}

	@Override
	public List<Map<Object, Object>> boundList(Integer l_type) {
		return this.logDao.boundList(l_type);
	}

	@Override
	public List<Map<Object, Object>> saleList(Integer l_type) {
		return this.logDao.saleList(l_type);
	}

	@Override
	public List<Map<Object, Object>> saleChart() {
		return this.logDao.saleChart();
	}

}
