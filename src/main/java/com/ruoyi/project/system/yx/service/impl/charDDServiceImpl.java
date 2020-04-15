package com.ruoyi.project.system.yx.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.domain.Yx;
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
	public int YxCountWorkType1(Yx yx) {
		return charDDMapper.YxCountWorkType1(yx);
	}
	@Override
	public BigDecimal YxSumWorkType1(Yx yx) {
		return charDDMapper.YxSumWorkType1(yx);
	}
	
	
	@Override
	public int YxCountWorkType2(Yx yx) {
		return charDDMapper.YxCountWorkType2(yx);
	}
	@Override
	public BigDecimal YxSumWorkType2(Yx yx) {
		return charDDMapper.YxSumWorkType2(yx);
	}

	
	@Override
	public int YxCountWorkType3(Yx yx) {
		return charDDMapper.YxCountWorkType3(yx);
	}
	@Override
	public BigDecimal YxSumWorkType3(Yx yx) {
		return charDDMapper.YxSumWorkType3(yx);
	}
	
//workType

	
	
	
//workClass
    
	@Override
	public int YxCountWorkClass1(Yx yx) {
		return charDDMapper.YxCountWorkClass1(yx);
	}
	@Override
	public BigDecimal YxSumWorkClass1(Yx yx) {
		return charDDMapper.YxSumWorkClass1(yx);
	}
	
	
	@Override
	public int YxCountWorkClass2(Yx yx) {
		return charDDMapper.YxCountWorkClass2(yx);
	}
	@Override
	public BigDecimal YxSumWorkClass2(Yx yx) {
		return charDDMapper.YxSumWorkClass2(yx);
	}

	
	@Override
	public int YxCountWorkClass3(Yx yx) {
		return charDDMapper.YxCountWorkClass3(yx);
	}
	@Override
	public BigDecimal YxSumWorkClass3(Yx yx) {
		return charDDMapper.YxSumWorkClass3(yx);
	}
//workClass	
	


   

}
