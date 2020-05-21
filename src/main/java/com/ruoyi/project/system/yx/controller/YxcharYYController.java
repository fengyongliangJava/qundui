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
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.service.IYxYueService;
import com.ruoyi.project.system.yx.service.IcharYYService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/charYY")
public class YxcharYYController extends BaseController
{
    private String prefix = "system/yx/charYY";

    @Autowired
    private IcharYYService charYYService;
    
    @Autowired
    private IYxYueService yxYueService;

    @RequiresPermissions("system:yx:charYY:view")
    @GetMapping()
    public String yxTableYY()
    {
        return prefix + "/yx";
    }

    
    

    @ResponseBody
    @PostMapping("/charWorkType")
    public Map<String,Object> charWorkType(YxYue YxYue) {
  	  
  	  
  	    Map<String,Object> map = new HashMap<>();
  	  
  		
  		int YxCountWorkType1yue1 = charYYService.YxCountWorkType1yue1(YxYue);
  		BigDecimal YxSumWorkType1yue1 = charYYService.YxSumWorkType1yue1(YxYue);
  		int YxCountWorkType1yue2 = charYYService.YxCountWorkType1yue2(YxYue);
  		BigDecimal YxSumWorkType1yue2 = charYYService.YxSumWorkType1yue2(YxYue);
  		int YxCountWorkType1yue3 = charYYService.YxCountWorkType1yue3(YxYue);
  		BigDecimal YxSumWorkType1yue3 = charYYService.YxSumWorkType1yue3(YxYue);
  		int YxCountWorkType1yue4 = charYYService.YxCountWorkType1yue4(YxYue);
  		BigDecimal YxSumWorkType1yue4 = charYYService.YxSumWorkType1yue4(YxYue);	
  		int YxCountWorkType1yue5 = charYYService.YxCountWorkType1yue5(YxYue);
  		BigDecimal YxSumWorkType1yue5 = charYYService.YxSumWorkType1yue5(YxYue);
  		int YxCountWorkType1yue6 = charYYService.YxCountWorkType1yue6(YxYue);
  		BigDecimal YxSumWorkType1yue6 = charYYService.YxSumWorkType1yue6(YxYue);
  		int YxCountWorkType1yue7 = charYYService.YxCountWorkType1yue7(YxYue);
  		BigDecimal YxSumWorkType1yue7 = charYYService.YxSumWorkType1yue7(YxYue);
  		int YxCountWorkType1yue8 = charYYService.YxCountWorkType1yue8(YxYue);
  		BigDecimal YxSumWorkType1yue8 = charYYService.YxSumWorkType1yue8(YxYue);	
  		int YxCountWorkType1yue9 = charYYService.YxCountWorkType1yue9(YxYue);
  		BigDecimal YxSumWorkType1yue9 = charYYService.YxSumWorkType1yue9(YxYue);
  		int YxCountWorkType1yue10 = charYYService.YxCountWorkType1yue10(YxYue);
  		BigDecimal YxSumWorkType1yue10 = charYYService.YxSumWorkType1yue10(YxYue);	
  		int YxCountWorkType1yue11 = charYYService.YxCountWorkType1yue11(YxYue);
  		BigDecimal YxSumWorkType1yue11 = charYYService.YxSumWorkType1yue11(YxYue);	
  		int YxCountWorkType1yue12 = charYYService.YxCountWorkType1yue12(YxYue);
  		BigDecimal YxSumWorkType1yue12 = charYYService.YxSumWorkType1yue12(YxYue);	
  		
  		
  		
  		int YxCountWorkType2yue1 = charYYService.YxCountWorkType2yue1(YxYue);
  		BigDecimal YxSumWorkType2yue1 = charYYService.YxSumWorkType2yue1(YxYue);
  		int YxCountWorkType2yue2 = charYYService.YxCountWorkType2yue2(YxYue);
  		BigDecimal YxSumWorkType2yue2 = charYYService.YxSumWorkType2yue2(YxYue);
  		int YxCountWorkType2yue3 = charYYService.YxCountWorkType2yue3(YxYue);
  		BigDecimal YxSumWorkType2yue3 = charYYService.YxSumWorkType2yue3(YxYue);
  		int YxCountWorkType2yue4 = charYYService.YxCountWorkType2yue4(YxYue);
  		BigDecimal YxSumWorkType2yue4 = charYYService.YxSumWorkType2yue4(YxYue);	
  		int YxCountWorkType2yue5 = charYYService.YxCountWorkType2yue5(YxYue);
  		BigDecimal YxSumWorkType2yue5 = charYYService.YxSumWorkType2yue5(YxYue);
  		int YxCountWorkType2yue6 = charYYService.YxCountWorkType2yue6(YxYue);
  		BigDecimal YxSumWorkType2yue6 = charYYService.YxSumWorkType2yue6(YxYue);
  		int YxCountWorkType2yue7 = charYYService.YxCountWorkType2yue7(YxYue);
  		BigDecimal YxSumWorkType2yue7 = charYYService.YxSumWorkType2yue7(YxYue);
  		int YxCountWorkType2yue8 = charYYService.YxCountWorkType2yue8(YxYue);
  		BigDecimal YxSumWorkType2yue8 = charYYService.YxSumWorkType2yue8(YxYue);	
  		int YxCountWorkType2yue9 = charYYService.YxCountWorkType2yue9(YxYue);
  		BigDecimal YxSumWorkType2yue9 = charYYService.YxSumWorkType2yue9(YxYue);
  		int YxCountWorkType2yue10 = charYYService.YxCountWorkType2yue10(YxYue);
  		BigDecimal YxSumWorkType2yue10 = charYYService.YxSumWorkType2yue10(YxYue);	
  		int YxCountWorkType2yue11 = charYYService.YxCountWorkType2yue11(YxYue);
  		BigDecimal YxSumWorkType2yue11 = charYYService.YxSumWorkType2yue11(YxYue);	
  		int YxCountWorkType2yue12 = charYYService.YxCountWorkType2yue12(YxYue);
  		BigDecimal YxSumWorkType2yue12 = charYYService.YxSumWorkType2yue12(YxYue);	
  		
  		
  		
  		

  		
  		
  		
  		map.put("YxCountWorkType1yue1",YxCountWorkType1yue1);
  		map.put("YxSumWorkType1yue1",YxSumWorkType1yue1);
  		map.put("YxCountWorkType1yue2",YxCountWorkType1yue2);
  		map.put("YxSumWorkType1yue2",YxSumWorkType1yue2);
  		map.put("YxCountWorkType1yue3",YxCountWorkType1yue3);
  		map.put("YxSumWorkType1yue3",YxSumWorkType1yue3);
  		map.put("YxCountWorkType1yue4",YxCountWorkType1yue4);
  		map.put("YxSumWorkType1yue4",YxSumWorkType1yue4);
  		map.put("YxCountWorkType1yue5",YxCountWorkType1yue5);
  		map.put("YxSumWorkType1yue5",YxSumWorkType1yue5);
  		map.put("YxCountWorkType1yue6",YxCountWorkType1yue6);
  		map.put("YxSumWorkType1yue6",YxSumWorkType1yue6);
  		map.put("YxCountWorkType1yue7",YxCountWorkType1yue7);
  		map.put("YxSumWorkType1yue7",YxSumWorkType1yue7);
  		map.put("YxCountWorkType1yue8",YxCountWorkType1yue8);
  		map.put("YxSumWorkType1yue8",YxSumWorkType1yue8);
  		map.put("YxCountWorkType1yue9",YxCountWorkType1yue9);
  		map.put("YxSumWorkType1yue9",YxSumWorkType1yue9);
  		map.put("YxCountWorkType1yue10",YxCountWorkType1yue10);
  		map.put("YxSumWorkType1yue10",YxSumWorkType1yue10);
  		map.put("YxCountWorkType1yue11",YxCountWorkType1yue11);
  		map.put("YxSumWorkType1yue11",YxSumWorkType1yue11);
  		map.put("YxCountWorkType1yue12",YxCountWorkType1yue12);
  		map.put("YxSumWorkType1yue12",YxSumWorkType1yue12);
  		
  		
  		
  		
  		map.put("YxCountWorkType2yue1",YxCountWorkType2yue1);
  		map.put("YxSumWorkType2yue1",YxSumWorkType2yue1);
  		map.put("YxCountWorkType2yue2",YxCountWorkType2yue2);
  		map.put("YxSumWorkType2yue2",YxSumWorkType2yue2);
  		map.put("YxCountWorkType2yue3",YxCountWorkType2yue3);
  		map.put("YxSumWorkType2yue3",YxSumWorkType2yue3);
  		map.put("YxCountWorkType2yue4",YxCountWorkType2yue4);
  		map.put("YxSumWorkType2yue4",YxSumWorkType2yue4);
  		map.put("YxCountWorkType2yue5",YxCountWorkType2yue5);
  		map.put("YxSumWorkType2yue5",YxSumWorkType2yue5);
  		map.put("YxCountWorkType2yue6",YxCountWorkType2yue6);
  		map.put("YxSumWorkType2yue6",YxSumWorkType2yue6);
  		map.put("YxCountWorkType2yue7",YxCountWorkType2yue7);
  		map.put("YxSumWorkType2yue7",YxSumWorkType2yue7);
  		map.put("YxCountWorkType2yue8",YxCountWorkType2yue8);
  		map.put("YxSumWorkType2yue8",YxSumWorkType2yue8);
  		map.put("YxCountWorkType2yue9",YxCountWorkType2yue9);
  		map.put("YxSumWorkType2yue9",YxSumWorkType2yue9);
  		map.put("YxCountWorkType2yue10",YxCountWorkType2yue10);
  		map.put("YxSumWorkType2yue10",YxSumWorkType2yue10);
  		map.put("YxCountWorkType2yue11",YxCountWorkType2yue11);
  		map.put("YxSumWorkType2yue11",YxSumWorkType2yue11);
  		map.put("YxCountWorkType2yue12",YxCountWorkType2yue12);
  		map.put("YxSumWorkType2yue12",YxSumWorkType2yue12);
  		
  		
  		
  		

  		
  		
  		
 	
       int totalCount  = YxCountWorkType1yue1 + YxCountWorkType1yue2 + YxCountWorkType1yue3 + YxCountWorkType1yue4 + YxCountWorkType1yue5 + YxCountWorkType1yue6 + YxCountWorkType1yue7 + YxCountWorkType1yue8 + YxCountWorkType1yue9 + YxCountWorkType1yue10 + YxCountWorkType1yue11 +YxCountWorkType1yue12;
       int totalCount2 = YxCountWorkType2yue1 + YxCountWorkType2yue2 + YxCountWorkType2yue3 + YxCountWorkType2yue4 + YxCountWorkType2yue5 + YxCountWorkType2yue6 + YxCountWorkType2yue7 + YxCountWorkType2yue8 + YxCountWorkType2yue9 + YxCountWorkType2yue10 + YxCountWorkType2yue11 +YxCountWorkType2yue12;
       
      
       /**       
  		BigDecimal totalSum = (YxSumWorkType1.add(YxSumWorkType3)).add(YxSumWorkType3);
		map.put("totalCount",totalCount);
  		map.put("totalSum",totalSum);
  		*/
  	    return map;
  	
  		
    }
    
    
    
    
    @ResponseBody
    @PostMapping("/charWorkClass")
    public Map<String,Object> charWorkClass(YxYue YxYue) {
  	  
  	  
  	    Map<String,Object> map = new HashMap<>();
  	  
  		
  		int YxCountWorkClass1yue1 = charYYService.YxCountWorkClass1yue1(YxYue);
  		BigDecimal YxSumWorkClass1yue1 = charYYService.YxSumWorkClass1yue1(YxYue);
  		int YxCountWorkClass1yue2 = charYYService.YxCountWorkClass1yue2(YxYue);
  		BigDecimal YxSumWorkClass1yue2 = charYYService.YxSumWorkClass1yue2(YxYue);
  		int YxCountWorkClass1yue3 = charYYService.YxCountWorkClass1yue3(YxYue);
  		BigDecimal YxSumWorkClass1yue3 = charYYService.YxSumWorkClass1yue3(YxYue);
  		int YxCountWorkClass1yue4 = charYYService.YxCountWorkClass1yue4(YxYue);
  		BigDecimal YxSumWorkClass1yue4 = charYYService.YxSumWorkClass1yue4(YxYue);	
  		int YxCountWorkClass1yue5 = charYYService.YxCountWorkClass1yue5(YxYue);
  		BigDecimal YxSumWorkClass1yue5 = charYYService.YxSumWorkClass1yue5(YxYue);
  		int YxCountWorkClass1yue6 = charYYService.YxCountWorkClass1yue6(YxYue);
  		BigDecimal YxSumWorkClass1yue6 = charYYService.YxSumWorkClass1yue6(YxYue);
  		int YxCountWorkClass1yue7 = charYYService.YxCountWorkClass1yue7(YxYue);
  		BigDecimal YxSumWorkClass1yue7 = charYYService.YxSumWorkClass1yue7(YxYue);
  		int YxCountWorkClass1yue8 = charYYService.YxCountWorkClass1yue8(YxYue);
  		BigDecimal YxSumWorkClass1yue8 = charYYService.YxSumWorkClass1yue8(YxYue);	
  		int YxCountWorkClass1yue9 = charYYService.YxCountWorkClass1yue9(YxYue);
  		BigDecimal YxSumWorkClass1yue9 = charYYService.YxSumWorkClass1yue9(YxYue);
  		int YxCountWorkClass1yue10 = charYYService.YxCountWorkClass1yue10(YxYue);
  		BigDecimal YxSumWorkClass1yue10 = charYYService.YxSumWorkClass1yue10(YxYue);	
  		int YxCountWorkClass1yue11 = charYYService.YxCountWorkClass1yue11(YxYue);
  		BigDecimal YxSumWorkClass1yue11 = charYYService.YxSumWorkClass1yue11(YxYue);	
  		int YxCountWorkClass1yue12 = charYYService.YxCountWorkClass1yue12(YxYue);
  		BigDecimal YxSumWorkClass1yue12 = charYYService.YxSumWorkClass1yue12(YxYue);	
  		
  		
  		
  		int YxCountWorkClass2yue1 = charYYService.YxCountWorkClass2yue1(YxYue);
  		BigDecimal YxSumWorkClass2yue1 = charYYService.YxSumWorkClass2yue1(YxYue);
  		int YxCountWorkClass2yue2 = charYYService.YxCountWorkClass2yue2(YxYue);
  		BigDecimal YxSumWorkClass2yue2 = charYYService.YxSumWorkClass2yue2(YxYue);
  		int YxCountWorkClass2yue3 = charYYService.YxCountWorkClass2yue3(YxYue);
  		BigDecimal YxSumWorkClass2yue3 = charYYService.YxSumWorkClass2yue3(YxYue);
  		int YxCountWorkClass2yue4 = charYYService.YxCountWorkClass2yue4(YxYue);
  		BigDecimal YxSumWorkClass2yue4 = charYYService.YxSumWorkClass2yue4(YxYue);	
  		int YxCountWorkClass2yue5 = charYYService.YxCountWorkClass2yue5(YxYue);
  		BigDecimal YxSumWorkClass2yue5 = charYYService.YxSumWorkClass2yue5(YxYue);
  		int YxCountWorkClass2yue6 = charYYService.YxCountWorkClass2yue6(YxYue);
  		BigDecimal YxSumWorkClass2yue6 = charYYService.YxSumWorkClass2yue6(YxYue);
  		int YxCountWorkClass2yue7 = charYYService.YxCountWorkClass2yue7(YxYue);
  		BigDecimal YxSumWorkClass2yue7 = charYYService.YxSumWorkClass2yue7(YxYue);
  		int YxCountWorkClass2yue8 = charYYService.YxCountWorkClass2yue8(YxYue);
  		BigDecimal YxSumWorkClass2yue8 = charYYService.YxSumWorkClass2yue8(YxYue);	
  		int YxCountWorkClass2yue9 = charYYService.YxCountWorkClass2yue9(YxYue);
  		BigDecimal YxSumWorkClass2yue9 = charYYService.YxSumWorkClass2yue9(YxYue);
  		int YxCountWorkClass2yue10 = charYYService.YxCountWorkClass2yue10(YxYue);
  		BigDecimal YxSumWorkClass2yue10 = charYYService.YxSumWorkClass2yue10(YxYue);	
  		int YxCountWorkClass2yue11 = charYYService.YxCountWorkClass2yue11(YxYue);
  		BigDecimal YxSumWorkClass2yue11 = charYYService.YxSumWorkClass2yue11(YxYue);	
  		int YxCountWorkClass2yue12 = charYYService.YxCountWorkClass2yue12(YxYue);
  		BigDecimal YxSumWorkClass2yue12 = charYYService.YxSumWorkClass2yue12(YxYue);	
  		
  		
  		
  		
  		int YxCountWorkClass3yue1 = charYYService.YxCountWorkClass3yue1(YxYue);
  		BigDecimal YxSumWorkClass3yue1 = charYYService.YxSumWorkClass3yue1(YxYue);
  		int YxCountWorkClass3yue2 = charYYService.YxCountWorkClass3yue2(YxYue);
  		BigDecimal YxSumWorkClass3yue2 = charYYService.YxSumWorkClass3yue2(YxYue);
  		int YxCountWorkClass3yue3 = charYYService.YxCountWorkClass3yue3(YxYue);
  		BigDecimal YxSumWorkClass3yue3 = charYYService.YxSumWorkClass3yue3(YxYue);
  		int YxCountWorkClass3yue4 = charYYService.YxCountWorkClass3yue4(YxYue);
  		BigDecimal YxSumWorkClass3yue4 = charYYService.YxSumWorkClass3yue4(YxYue);	
  		int YxCountWorkClass3yue5 = charYYService.YxCountWorkClass3yue5(YxYue);
  		BigDecimal YxSumWorkClass3yue5 = charYYService.YxSumWorkClass3yue5(YxYue);
  		int YxCountWorkClass3yue6 = charYYService.YxCountWorkClass3yue6(YxYue);
  		BigDecimal YxSumWorkClass3yue6 = charYYService.YxSumWorkClass3yue6(YxYue);
  		int YxCountWorkClass3yue7 = charYYService.YxCountWorkClass3yue7(YxYue);
  		BigDecimal YxSumWorkClass3yue7 = charYYService.YxSumWorkClass3yue7(YxYue);
  		int YxCountWorkClass3yue8 = charYYService.YxCountWorkClass3yue8(YxYue);
  		BigDecimal YxSumWorkClass3yue8 = charYYService.YxSumWorkClass3yue8(YxYue);	
  		int YxCountWorkClass3yue9 = charYYService.YxCountWorkClass3yue9(YxYue);
  		BigDecimal YxSumWorkClass3yue9 = charYYService.YxSumWorkClass3yue9(YxYue);
  		int YxCountWorkClass3yue10 = charYYService.YxCountWorkClass3yue10(YxYue);
  		BigDecimal YxSumWorkClass3yue10 = charYYService.YxSumWorkClass3yue10(YxYue);	
  		int YxCountWorkClass3yue11 = charYYService.YxCountWorkClass3yue11(YxYue);
  		BigDecimal YxSumWorkClass3yue11 = charYYService.YxSumWorkClass3yue11(YxYue);	
  		int YxCountWorkClass3yue12 = charYYService.YxCountWorkClass3yue12(YxYue);
  		BigDecimal YxSumWorkClass3yue12 = charYYService.YxSumWorkClass3yue12(YxYue);	
  		
  		
  		
  		map.put("YxCountWorkClass1yue1",YxCountWorkClass1yue1);
  		map.put("YxSumWorkClass1yue1",YxSumWorkClass1yue1);
  		map.put("YxCountWorkClass1yue2",YxCountWorkClass1yue2);
  		map.put("YxSumWorkClass1yue2",YxSumWorkClass1yue2);
  		map.put("YxCountWorkClass1yue3",YxCountWorkClass1yue3);
  		map.put("YxSumWorkClass1yue3",YxSumWorkClass1yue3);
  		map.put("YxCountWorkClass1yue4",YxCountWorkClass1yue4);
  		map.put("YxSumWorkClass1yue4",YxSumWorkClass1yue4);
  		map.put("YxCountWorkClass1yue5",YxCountWorkClass1yue5);
  		map.put("YxSumWorkClass1yue5",YxSumWorkClass1yue5);
  		map.put("YxCountWorkClass1yue6",YxCountWorkClass1yue6);
  		map.put("YxSumWorkClass1yue6",YxSumWorkClass1yue6);
  		map.put("YxCountWorkClass1yue7",YxCountWorkClass1yue7);
  		map.put("YxSumWorkClass1yue7",YxSumWorkClass1yue7);
  		map.put("YxCountWorkClass1yue8",YxCountWorkClass1yue8);
  		map.put("YxSumWorkClass1yue8",YxSumWorkClass1yue8);
  		map.put("YxCountWorkClass1yue9",YxCountWorkClass1yue9);
  		map.put("YxSumWorkClass1yue9",YxSumWorkClass1yue9);
  		map.put("YxCountWorkClass1yue10",YxCountWorkClass1yue10);
  		map.put("YxSumWorkClass1yue10",YxSumWorkClass1yue10);
  		map.put("YxCountWorkClass1yue11",YxCountWorkClass1yue11);
  		map.put("YxSumWorkClass1yue11",YxSumWorkClass1yue11);
  		map.put("YxCountWorkClass1yue12",YxCountWorkClass1yue12);
  		map.put("YxSumWorkClass1yue12",YxSumWorkClass1yue12);
  		
  		
  		
  		
  		map.put("YxCountWorkClass2yue1",YxCountWorkClass2yue1);
  		map.put("YxSumWorkClass2yue1",YxSumWorkClass2yue1);
  		map.put("YxCountWorkClass2yue2",YxCountWorkClass2yue2);
  		map.put("YxSumWorkClass2yue2",YxSumWorkClass2yue2);
  		map.put("YxCountWorkClass2yue3",YxCountWorkClass2yue3);
  		map.put("YxSumWorkClass2yue3",YxSumWorkClass2yue3);
  		map.put("YxCountWorkClass2yue4",YxCountWorkClass2yue4);
  		map.put("YxSumWorkClass2yue4",YxSumWorkClass2yue4);
  		map.put("YxCountWorkClass2yue5",YxCountWorkClass2yue5);
  		map.put("YxSumWorkClass2yue5",YxSumWorkClass2yue5);
  		map.put("YxCountWorkClass2yue6",YxCountWorkClass2yue6);
  		map.put("YxSumWorkClass2yue6",YxSumWorkClass2yue6);
  		map.put("YxCountWorkClass2yue7",YxCountWorkClass2yue7);
  		map.put("YxSumWorkClass2yue7",YxSumWorkClass2yue7);
  		map.put("YxCountWorkClass2yue8",YxCountWorkClass2yue8);
  		map.put("YxSumWorkClass2yue8",YxSumWorkClass2yue8);
  		map.put("YxCountWorkClass2yue9",YxCountWorkClass2yue9);
  		map.put("YxSumWorkClass2yue9",YxSumWorkClass2yue9);
  		map.put("YxCountWorkClass2yue10",YxCountWorkClass2yue10);
  		map.put("YxSumWorkClass2yue10",YxSumWorkClass2yue10);
  		map.put("YxCountWorkClass2yue11",YxCountWorkClass2yue11);
  		map.put("YxSumWorkClass2yue11",YxSumWorkClass2yue11);
  		map.put("YxCountWorkClass2yue12",YxCountWorkClass2yue12);
  		map.put("YxSumWorkClass2yue12",YxSumWorkClass2yue12);
  		
  		
  		
  		
  		map.put("YxCountWorkClass3yue1",YxCountWorkClass3yue1);
  		map.put("YxSumWorkClass3yue1",YxSumWorkClass3yue1);
  		map.put("YxCountWorkClass3yue2",YxCountWorkClass3yue2);
  		map.put("YxSumWorkClass3yue2",YxSumWorkClass3yue2);
  		map.put("YxCountWorkClass3yue3",YxCountWorkClass3yue3);
  		map.put("YxSumWorkClass3yue3",YxSumWorkClass3yue3);
  		map.put("YxCountWorkClass3yue4",YxCountWorkClass3yue4);
  		map.put("YxSumWorkClass3yue4",YxSumWorkClass3yue4);
  		map.put("YxCountWorkClass3yue5",YxCountWorkClass3yue5);
  		map.put("YxSumWorkClass3yue5",YxSumWorkClass3yue5);
  		map.put("YxCountWorkClass3yue6",YxCountWorkClass3yue6);
  		map.put("YxSumWorkClass3yue6",YxSumWorkClass3yue6);
  		map.put("YxCountWorkClass3yue7",YxCountWorkClass3yue7);
  		map.put("YxSumWorkClass3yue7",YxSumWorkClass3yue7);
  		map.put("YxCountWorkClass3yue8",YxCountWorkClass3yue8);
  		map.put("YxSumWorkClass3yue8",YxSumWorkClass3yue8);
  		map.put("YxCountWorkClass3yue9",YxCountWorkClass3yue9);
  		map.put("YxSumWorkClass3yue9",YxSumWorkClass3yue9);
  		map.put("YxCountWorkClass3yue10",YxCountWorkClass3yue10);
  		map.put("YxSumWorkClass3yue10",YxSumWorkClass3yue10);
  		map.put("YxCountWorkClass3yue11",YxCountWorkClass3yue11);
  		map.put("YxSumWorkClass3yue11",YxSumWorkClass3yue11);
  		map.put("YxCountWorkClass3yue12",YxCountWorkClass3yue12);
  		map.put("YxSumWorkClass3yue12",YxSumWorkClass3yue12);
  		
  		
  		
/*  	
 * int totalCount = YxCountWorkType1 + YxCountWorkType3 + YxCountWorkType3 ;
  		BigDecimal totalSum = (YxSumWorkType1.add(YxSumWorkType3)).add(YxSumWorkType3);
		map.put("totalCount",totalCount);
  		map.put("totalSum",totalSum);
  		*/
  	    return map;
  	
  		
    }
    



    @PostMapping("/exportExcel")
    @ResponseBody
    public AjaxResult exportExcel(YxYue YxYue)
    {
        List<YxYue> list = yxYueService.selectYxList(YxYue);
        ExcelUtil<YxYue> util = new ExcelUtil<YxYue>(YxYue.class);
        return util.exportExcel(list, "yx");
    }

  
}
