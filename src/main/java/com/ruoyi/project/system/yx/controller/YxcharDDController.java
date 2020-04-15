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
import com.ruoyi.project.system.yx.domain.Yx;
import com.ruoyi.project.system.yx.service.IYxService;
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
    private IYxService yxService;
    

    @RequiresPermissions("system:yx:charDD:view")
    @GetMapping()
    public String yxTableDD()
    {
        return prefix + "/yx";
    }

    
    
    @ResponseBody
    @PostMapping("/charWorkType")
    public Map<String,Object> charWorkType(Yx yx) {
  	  
  	  
  	    Map<String,Object> map = new HashMap<>();
  	  
  
  
  		
  		int YxCountWorkType1 = charDDService.YxCountWorkType1(yx);
  		BigDecimal YxSumWorkType1 = charDDService.YxSumWorkType1(yx);
  		int YxCountWorkType2 = charDDService.YxCountWorkType2(yx);
  		BigDecimal YxSumWorkType2 = charDDService.YxSumWorkType2(yx);
  		int YxCountWorkType3 = charDDService.YxCountWorkType3(yx);
  		BigDecimal YxSumWorkType3 = charDDService.YxSumWorkType3(yx);
  		
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
    public Map<String,Object> charWorkClass(Yx yx) {
  	  
  	  
  	    Map<String,Object> map = new HashMap<>();
  	  
  		
  		int YxCountWorkClass1 = charDDService.YxCountWorkClass1(yx);
  		BigDecimal YxSumWorkClass1 = charDDService.YxSumWorkClass1(yx);
  		int YxCountWorkClass2 = charDDService.YxCountWorkClass2(yx);
  		BigDecimal YxSumWorkClass2 = charDDService.YxSumWorkClass2(yx);
  		int YxCountWorkClass3 = charDDService.YxCountWorkClass3(yx);
  		BigDecimal YxSumWorkClass3 = charDDService.YxSumWorkClass3(yx);

  		map.put("YxCountWorkClass1",YxCountWorkClass1);
  		map.put("YxSumWorkClass1",YxSumWorkClass1);
  		map.put("YxCountWorkClass2",YxCountWorkClass2);
  		map.put("YxSumWorkClass2",YxSumWorkClass2);
  		map.put("YxCountWorkClass3",YxCountWorkClass3);
  		map.put("YxSumWorkClass3",YxSumWorkClass3);
  		
  		
  	    return map;
  	
  		
    }
    
     /**
                  * 导出牙星公司列表
      */
    @RequiresPermissions("system:yx:charDD:export")
    @Log(title = "牙星公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Yx yx){
        List<Yx> list = yxService.selectYxList(yx);
        ExcelUtil<Yx> util = new ExcelUtil<Yx>(Yx.class);
        return util.exportExcel(list, "yx");
    }

  
}
