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
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.service.IYxYueService;
import com.ruoyi.project.system.yx.service.IcharMMService;

/**
    * 牙星公司Controller
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/charMM")
public class YxcharMMController extends BaseController
{
    private String prefix = "system/yx/charMM";

    @Autowired
    private IYxYueService YxYueService;
    
    
    @Autowired
    private IcharMMService charMMService;
    

    @RequiresPermissions("system:yx:charMM:view")
    @GetMapping()
    public String yxTableMM()
    {
        return prefix + "/yx";
    }

    
    @ResponseBody
    @PostMapping("/charWorkType")
    public Map<String,Object> charWorkType(YxYue YxYue) {
  	  
  	    Map<String,Object> map = new HashMap<>();
  	  
  		int YxYueCountWorkType1 = charMMService.YxYueCountWorkType1(YxYue);
  		BigDecimal YxYueSumWorkType1 = charMMService.YxYueSumWorkType1(YxYue);
  		int YxYueCountWorkType2 = charMMService.YxYueCountWorkType2(YxYue);
  		BigDecimal YxYueSumWorkType2 = charMMService.YxYueSumWorkType2(YxYue);

  		int totalCount = YxYueCountWorkType1 + YxYueCountWorkType2 ;
  		BigDecimal totalSum = YxYueSumWorkType1.add(YxYueSumWorkType2);
  		
  		map.put("YxYueCountWorkType1",YxYueCountWorkType1);
  		map.put("YxYueSumWorkType1",YxYueSumWorkType1);
  		map.put("YxYueCountWorkType2",YxYueCountWorkType2);
  		map.put("YxYueSumWorkType2",YxYueSumWorkType2);
  		
		map.put("totalCount",totalCount);
  		map.put("totalSum",totalSum);
  		
  	    return map;
  	
  		
    }
    

    @ResponseBody
    @PostMapping("/charWorkClass")
    public Map<String,Object> charWorkClass(YxYue YxYue) {
  	  
  	    Map<String,Object> map = new HashMap<>();
  		
  		int YxYueCountWorkClass1 = charMMService.YxYueCountWorkClass1(YxYue);
  		BigDecimal YxYueSumWorkClass1 = charMMService.YxYueSumWorkClass1(YxYue);
  		int YxYueCountWorkClass2 = charMMService.YxYueCountWorkClass2(YxYue);
  		BigDecimal YxYueSumWorkClass2 = charMMService.YxYueSumWorkClass2(YxYue);
  		int YxYueCountWorkClass3 = charMMService.YxYueCountWorkClass3(YxYue);
  		BigDecimal YxYueSumWorkClass3 = charMMService.YxYueSumWorkClass3(YxYue);

  		int totalCount = YxYueCountWorkClass1 + YxYueCountWorkClass2 + YxYueCountWorkClass3  ;
  		BigDecimal totalSum = (YxYueSumWorkClass1.add(YxYueSumWorkClass2)).add(YxYueSumWorkClass3);
  		
  		map.put("YxYueCountWorkClass1",YxYueCountWorkClass1);
  		map.put("YxYueSumWorkClass1",YxYueSumWorkClass1);
  		map.put("YxYueCountWorkClass2",YxYueCountWorkClass2);
  		map.put("YxYueSumWorkClass2",YxYueSumWorkClass2);
  		map.put("YxYueCountWorkClass3",YxYueCountWorkClass3);
  		map.put("YxYueSumWorkClass3",YxYueSumWorkClass3);
  		
		map.put("totalCount",totalCount);
  		map.put("totalSum",totalSum);
  		
  		
  	    return map;
  	
  		
    }
    

  
    @PostMapping("/exportExcel")
    @ResponseBody
    public AjaxResult exportExcel(YxYue YxYue)
    {
        List<YxYue> list = YxYueService.selectYxList(YxYue);
        ExcelUtil<YxYue> util = new ExcelUtil<YxYue>(YxYue.class);
        return util.exportExcel(list, "YxYue");
    }

  
}
