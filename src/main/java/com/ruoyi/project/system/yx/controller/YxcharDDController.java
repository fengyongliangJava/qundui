package com.ruoyi.project.system.yx.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.service.IYxDayService;
import com.ruoyi.project.system.yx.service.IcharDDService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/charDD")
public class YxcharDDController extends BaseController{
	
    private String prefix = "system/yx/charDD";

    @Autowired
    private IcharDDService charDDService;
    
    @Autowired
    private IYxDayService yxDayService;
    

    @RequiresPermissions("system:yx:charDD:view")
    @GetMapping()
    public String yxTableDD()
    {
        return prefix + "/yx";
    }

    @ResponseBody
    @PostMapping("/charWorkType")
    public Map<String,Object> charWorkType(YxDay yxDay) {
  	  
  	    Map<String,Object> map = new HashMap<>();
  		
  		int YxCountWorkType1 = charDDService.YxCountWorkType1(yxDay);
  		BigDecimal YxSumWorkType1 = charDDService.YxSumWorkType1(yxDay);
  		int YxCountWorkType2 = charDDService.YxCountWorkType2(yxDay);
  		BigDecimal YxSumWorkType2 = charDDService.YxSumWorkType2(yxDay);
  		int YxCountWorkType3 = charDDService.YxCountWorkType3(yxDay);
  		BigDecimal YxSumWorkType3 = charDDService.YxSumWorkType3(yxDay);
  		
  		int totalCount = YxCountWorkType1 + YxCountWorkType2 + YxCountWorkType3;
  		BigDecimal totalSum = (YxSumWorkType1.add(YxSumWorkType2)).add(YxSumWorkType3);
  		
  		map.put("YxCountWorkType1",YxCountWorkType1);
  		map.put("YxSumWorkType1",YxSumWorkType1);
  		map.put("YxCountWorkType2",YxCountWorkType2);
  		map.put("YxSumWorkType2",YxSumWorkType2);
  		map.put("YxCountWorkType3",YxCountWorkType3);
  		map.put("YxSumWorkType3",YxSumWorkType3);
  		
		map.put("totalCount",totalCount);
  		map.put("totalSum",totalSum);
  		
  	    return map;
  	
  		
    }
    

    @ResponseBody
    @PostMapping("/charWorkClass")
    public Map<String,Object> charWorkClass(YxDay yxDay) {
  	  
  	  
  	    Map<String,Object> map = new HashMap<>();
  	  
  		
  		int YxCountWorkClass1 = charDDService.YxCountWorkClass1(yxDay);
  		BigDecimal YxSumWorkClass1 = charDDService.YxSumWorkClass1(yxDay);
  		int YxCountWorkClass2 = charDDService.YxCountWorkClass2(yxDay);
  		BigDecimal YxSumWorkClass2 = charDDService.YxSumWorkClass2(yxDay);
  		int YxCountWorkClass3 = charDDService.YxCountWorkClass3(yxDay);
  		BigDecimal YxSumWorkClass3 = charDDService.YxSumWorkClass3(yxDay);

  		map.put("YxCountWorkClass1",YxCountWorkClass1);
  		map.put("YxSumWorkClass1",YxSumWorkClass1);
  		map.put("YxCountWorkClass2",YxCountWorkClass2);
  		map.put("YxSumWorkClass2",YxSumWorkClass2);
  		map.put("YxCountWorkClass3",YxCountWorkClass3);
  		map.put("YxSumWorkClass3",YxSumWorkClass3);
  		
  		
  	    return map;
  	
  		
    }
    
    @PostMapping("/exportExcel")
    @ResponseBody
    public AjaxResult exportExcel(YxDay yxDay)
    {
        List<YxDay> list = yxDayService.selectYxDayList(yxDay);
        
        /*		int dataSize = list.size();
		for(int i = 0;i < dataSize ; i++ ) {
	
			if(list.get(i).getUpdateTime() != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String UpdateTime = formatter.format(list.get(i).getUpdateTime());
			    
			    list.get(i).setUpdateTime(UpdateTime);
			    
			}
			    
		}*/
        
        ExcelUtil<YxDay> util = new ExcelUtil<YxDay>(YxDay.class);
        return util.exportExcel(list, "yxDay");
    }


  
}
