package com.ruoyi.project.system.yx.service.impl;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.mapper.tableMMMapper;
import com.ruoyi.project.system.yx.service.ItableMMService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class tableMMServiceImpl implements ItableMMService {
	
    @Autowired
    private tableMMMapper tableMMMapper;
    
	@Override
	public Map YxtableMMPre(YxYue YxYue) {
		return tableMMMapper.YxtableMMPre(YxYue);
	}

	@Override
	public Map YxtableMM(YxYue YxYue) {
		return tableMMMapper.YxtableMM(YxYue);
	}



}
