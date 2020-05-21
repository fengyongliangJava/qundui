package com.ruoyi.project.system.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.mapper.countMMMapper;
import com.ruoyi.project.system.yx.service.IcountMMService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class countMMServiceImpl implements IcountMMService {
	
    @Autowired
    private countMMMapper countMMMapper;

	@Override
	public List countMM(YxDay YxDay) {
		return countMMMapper.countMM(YxDay);
	}


}
