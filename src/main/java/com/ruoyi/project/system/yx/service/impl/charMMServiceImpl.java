package com.ruoyi.project.system.yx.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.mapper.charMMMapper;
import com.ruoyi.project.system.yx.service.IcharMMService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class charMMServiceImpl implements IcharMMService {
	
    @Autowired
    private charMMMapper charMMMapper;

    
//workType
    
	@Override
	public int YxCountWorkType1(YxDay yxDay) {
		return charMMMapper.YxCountWorkType1(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkType1(YxDay yxDay) {
		return charMMMapper.YxSumWorkType1(yxDay);
	}
	
	
	@Override
	public int YxCountWorkType2(YxDay yxDay) {
		return charMMMapper.YxCountWorkType2(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkType2(YxDay yxDay) {
		return charMMMapper.YxSumWorkType2(yxDay);
	}

	
	@Override
	public int YxCountWorkType3(YxDay yxDay) {
		return charMMMapper.YxCountWorkType3(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkType3(YxDay yxDay) {
		return charMMMapper.YxSumWorkType3(yxDay);
	}
	
//workType

	
	
	
//workClass
    
	@Override
	public int YxCountWorkClass1(YxDay yxDay) {
		return charMMMapper.YxCountWorkClass1(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkClass1(YxDay yxDay) {
		return charMMMapper.YxSumWorkClass1(yxDay);
	}
	
	
	@Override
	public int YxCountWorkClass2(YxDay yxDay) {
		return charMMMapper.YxCountWorkClass2(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkClass2(YxDay yxDay) {
		return charMMMapper.YxSumWorkClass2(yxDay);
	}

	
	@Override
	public int YxCountWorkClass3(YxDay yxDay) {
		return charMMMapper.YxCountWorkClass3(yxDay);
	}
	@Override
	public BigDecimal YxSumWorkClass3(YxDay yxDay) {
		return charMMMapper.YxSumWorkClass3(yxDay);
	}
//workClass	
	


   

}
