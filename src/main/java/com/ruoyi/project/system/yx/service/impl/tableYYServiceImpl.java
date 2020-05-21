package com.ruoyi.project.system.yx.service.impl;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.mapper.tableYYMapper;
import com.ruoyi.project.system.yx.service.ItableYYService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class tableYYServiceImpl implements ItableYYService {
	
    @Autowired
    private tableYYMapper tableYYMapper;
    

	@Override
	public Map YxtableYY(YxYue YxYue) {
		return tableYYMapper.YxtableYY(YxYue);
	}



}
