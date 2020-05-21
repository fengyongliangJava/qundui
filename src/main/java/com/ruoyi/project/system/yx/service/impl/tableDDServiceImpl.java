package com.ruoyi.project.system.yx.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.mapper.tableDDMapper;
import com.ruoyi.project.system.yx.service.ItableDDService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class tableDDServiceImpl implements ItableDDService {
	
    @Autowired
    private tableDDMapper tableDDMapper;

	@Override
	public Map YxtableDD(YxDay YxDay) {
		return tableDDMapper.YxtableDD(YxDay);
	}


}
