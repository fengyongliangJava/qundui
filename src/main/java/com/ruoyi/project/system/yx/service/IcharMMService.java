package com.ruoyi.project.system.yx.service;

import java.math.BigDecimal;

import com.ruoyi.project.system.yx.domain.Yx;

/**
 * 牙星公司Service接口
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public interface IcharMMService {

	//workType
		
		int YxCountWorkType1 (Yx yx);
		BigDecimal YxSumWorkType1 (Yx yx);
		int YxCountWorkType2 (Yx yx);
		BigDecimal YxSumWorkType2 (Yx yx);
		int YxCountWorkType3 (Yx yx);
		BigDecimal YxSumWorkType3 (Yx yx);
		
	//workType	
		
	//workClass
		
		int YxCountWorkClass1 (Yx yx);
		BigDecimal YxSumWorkClass1 (Yx yx);
		int YxCountWorkClass2 (Yx yx);
		BigDecimal YxSumWorkClass2 (Yx yx);
		int YxCountWorkClass3 (Yx yx);
		BigDecimal YxSumWorkClass3 (Yx yx);
			
	//workClass	
}
