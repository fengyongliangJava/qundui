package com.ruoyi.project.system.yx.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.yx.domain.YxYue;
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
	public int YxYueCountWorkType1(YxYue YxYue) {
		return charMMMapper.YxYueCountWorkType1(YxYue);
	}
	@Override
	public BigDecimal YxYueSumWorkType1(YxYue YxYue) {
		return charMMMapper.YxYueSumWorkType1(YxYue);
	}
	
	
	@Override
	public int YxYueCountWorkType2(YxYue YxYue) {
		return charMMMapper.YxYueCountWorkType2(YxYue);
	}
	@Override
	public BigDecimal YxYueSumWorkType2(YxYue YxYue) {
		return charMMMapper.YxYueSumWorkType2(YxYue);
	}
//workType	
	
	
	
//workClass	
	@Override
	public int YxYueCountWorkClass1(YxYue YxYue) {
		return charMMMapper.YxYueCountWorkClass1(YxYue);
	}
	@Override
	public BigDecimal YxYueSumWorkClass1(YxYue YxYue) {
		return charMMMapper.YxYueSumWorkClass1(YxYue);
	}
	
	
	@Override
	public int YxYueCountWorkClass2(YxYue YxYue) {
		return charMMMapper.YxYueCountWorkClass2(YxYue);
	}
	@Override
	public BigDecimal YxYueSumWorkClass2(YxYue YxYue) {
		return charMMMapper.YxYueSumWorkClass2(YxYue);
	}
	
	
	@Override
	public int YxYueCountWorkClass3(YxYue YxYue) {
		return charMMMapper.YxYueCountWorkClass3(YxYue);
	}
	@Override
	public BigDecimal YxYueSumWorkClass3(YxYue YxYue) {
		return charMMMapper.YxYueSumWorkClass3(YxYue);
	}
//workClass

   

}
