package com.ruoyi.project.system.yx.mapper;

import java.math.BigDecimal;

import com.ruoyi.project.system.yx.domain.YxYue;

/**
 * 牙星公司Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public interface charMMMapper {
	
	

//workType
	
	int YxYueCountWorkType1 (YxYue YxYue);
	BigDecimal YxYueSumWorkType1 (YxYue YxYue);
	int YxYueCountWorkType2 (YxYue YxYue);
	BigDecimal YxYueSumWorkType2 (YxYue YxYue);
	
//workType	
	
//workClass
	
	int YxYueCountWorkClass1 (YxYue YxYue);
	BigDecimal YxYueSumWorkClass1 (YxYue YxYue);
	int YxYueCountWorkClass2 (YxYue YxYue);
	BigDecimal YxYueSumWorkClass2 (YxYue YxYue);
	int YxYueCountWorkClass3 (YxYue YxYue);
	BigDecimal YxYueSumWorkClass3 (YxYue YxYue);
		
//workClass	
	

}
