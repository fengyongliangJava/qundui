package com.ruoyi.project.system.yx.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.mapper.charDDMapper;
import com.ruoyi.project.system.yx.service.IcharDDService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class charDDServiceImpl implements IcharDDService {
	
    @Autowired
    private charDDMapper charDDMapper;

    
//workType
    
	@Override
	public int YxCountWorkType1(YxDay yxDay) {
		return charDDMapper.YxCountWorkType1(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkType1(YxDay yxDay) {
		return charDDMapper.YxSumWorkType1(yxDay);
	}
	
	
	@Override
	public int YxCountWorkType2(YxDay yxDay) {
		return charDDMapper.YxCountWorkType2(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkType2(YxDay yxDay) {
		return charDDMapper.YxSumWorkType2(yxDay);
	}

	
	@Override
	public int YxCountWorkType3(YxDay yxDay) {
		return charDDMapper.YxCountWorkType3(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkType3(YxDay yxDay) {
		return charDDMapper.YxSumWorkType3(yxDay);
	}
	
//workType

	
	
	
//workClass
    
	@Override
	public int YxCountWorkClass1(YxDay yxDay) {
		return charDDMapper.YxCountWorkClass1(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkClass1(YxDay yxDay) {
		return charDDMapper.YxSumWorkClass1(yxDay);
	}
	
	
	@Override
	public int YxCountWorkClass2(YxDay yxDay) {
		return charDDMapper.YxCountWorkClass2(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkClass2(YxDay yxDay) {
		return charDDMapper.YxSumWorkClass2(yxDay);
	}

	
	@Override
	public int YxCountWorkClass3(YxDay yxDay) {
		return charDDMapper.YxCountWorkClass3(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkClass3(YxDay yxDay) {
		return charDDMapper.YxSumWorkClass3(yxDay);
	}
//workClass	
	


   

}
