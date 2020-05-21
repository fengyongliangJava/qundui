package com.ruoyi.project.system.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.mapper.countDDMapper;
import com.ruoyi.project.system.yx.service.IcountDDService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class countDDServiceImpl implements IcountDDService {
	
    @Autowired
    private countDDMapper countDDMapper;

	@Override
	public List countDD(YxDay YxDay) {
		return countDDMapper.countDD(YxDay);
	}


}
