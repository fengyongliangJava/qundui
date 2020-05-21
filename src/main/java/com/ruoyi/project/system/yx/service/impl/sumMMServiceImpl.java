package com.ruoyi.project.system.yx.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.mapper.sumMMMapper;
import com.ruoyi.project.system.yx.service.IsumMMService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class sumMMServiceImpl implements IsumMMService {
	
    @Autowired
    private sumMMMapper sumMMMapper;

	@Override
	public List sumMM(YxDay YxDay) {
		return sumMMMapper.sumMM(YxDay);
	}


}
