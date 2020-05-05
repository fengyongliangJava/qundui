package com.ruoyi.project.system.yx.mapper;

import java.math.BigDecimal;

import com.ruoyi.project.system.yx.domain.YxDay;

/**
 * 牙星公司Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public interface charDDMapper {
	
	

//workType
	
	int YxCountWorkType1 (YxDay yxDay);
	BigDecimal YxSumWorkType1 (YxDay yxDay);
	int YxCountWorkType2 (YxDay yxDay);
	BigDecimal YxSumWorkType2 (YxDay yxDay);
	int YxCountWorkType3 (YxDay yxDay);
	BigDecimal YxSumWorkType3 (YxDay yxDay);
	
//workType	
	
//workClass
	
	int YxCountWorkClass1 (YxDay yxDay);
	BigDecimal YxSumWorkClass1 (YxDay yxDay);
	int YxCountWorkClass2 (YxDay yxDay);
	BigDecimal YxSumWorkClass2 (YxDay yxDay);
	int YxCountWorkClass3 (YxDay yxDay);
	BigDecimal YxSumWorkClass3 (YxDay yxDay);
		
//workClass	
	

}
