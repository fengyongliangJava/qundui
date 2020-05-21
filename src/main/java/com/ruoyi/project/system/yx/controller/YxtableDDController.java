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
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.service.IYxDayService;
import com.ruoyi.project.system.yx.service.ItableDDService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/tableDD")
public class YxtableDDController extends BaseController
{
    private String prefix = "system/yx/tableDD";

    @Autowired
    private IYxDayService yxDayService;
    
    @Autowired
    private ItableDDService tableDDService;

    
    @RequiresPermissions("system:yx:tableDD:view")
    @GetMapping()
    public String yxTableDD()
    {
        return prefix + "/yx";
    }
    
    

    @ResponseBody
    @PostMapping("/YxtableDD")
    public Map<String,Object> tableDDCount(YxDay YxDay) {
    	
  	    Map<String,Object> map = new HashMap<>();
 
  	    	YxDay.setWorkClass("一线工资");
  	    	Map data1 = tableDDService.YxtableDD(YxDay);
  			Long userId1 = (Long)data1.get("userId");
  			Long workStart1 = (Long)data1.get("workStart");
  			BigDecimal workNumber1 = (BigDecimal)data1.get("workNumber");
  			BigDecimal workSum1 = (BigDecimal)data1.get("workSum");
  			BigDecimal workHuo1 = (BigDecimal)data1.get("workHuo");
  			BigDecimal workDan1 = (BigDecimal)data1.get("workDan");
			BigDecimal userCost1 = (BigDecimal)data1.get("userCost");
  	    		
			
  	    	YxDay.setWorkClass("二线工资");
  	    	Map data2 = tableDDService.YxtableDD(YxDay);
  			Long userId2 = (Long)data2.get("userId");
  			Long workStart2 = (Long)data2.get("workStart");
  			BigDecimal workNumber2 = (BigDecimal)data2.get("workNumber");
  			BigDecimal workSum2 = (BigDecimal)data2.get("workSum");
  			BigDecimal workHuo2 = (BigDecimal)data2.get("workHuo");
  			BigDecimal workDan2 = (BigDecimal)data2.get("workDan");
			BigDecimal userCost2 = (BigDecimal)data2.get("userCost");
  			
			
  	    	YxDay.setWorkClass("三线工资");
  	    	Map data3 = tableDDService.YxtableDD(YxDay);
  			Long userId3 = (Long)data3.get("userId");
  			Long workStart3 = (Long)data3.get("workStart");
  			BigDecimal workNumber3 = (BigDecimal)data3.get("workNumber");
  			BigDecimal workSum3 = (BigDecimal)data3.get("workSum");
  			BigDecimal workHuo3 = (BigDecimal)data3.get("workHuo");
  			BigDecimal workDan3 = (BigDecimal)data3.get("workDan");
			BigDecimal userCost3 = (BigDecimal)data3.get("userCost");
			
			Long userId =  userId1 + userId2 + userId3;
			Long workStart =  workStart1 + workStart2 + workStart3;
  			BigDecimal workNumber = (workNumber1.add(workNumber2)).add(workNumber3);
  			BigDecimal workSum = (workSum1.add(workSum2)).add(workSum3);
  			BigDecimal workHuo = (workHuo1.add(workHuo2)).add(workHuo3);
  			BigDecimal workDan = (workDan1.add(workDan2)).add(workDan3);
			BigDecimal userCost = (userCost1.add(userCost2)).add(userCost3);
  	    		
  	    		map.put("userId1",userId1);
  	    		map.put("userId2",userId2);
  	    		map.put("userId3",userId3);
 	    		map.put("userId",userId);
  	    		
  	    		map.put("workStart1",workStart1);
  	    		map.put("workStart2",workStart2);
  	    		map.put("workStart3",workStart3);
  	    		map.put("workStart",workStart);
  	    		
  	    		map.put("workNumber1",workNumber1);
  	    		map.put("workNumber2",workNumber2);
  	    		map.put("workNumber3",workNumber3);
  	    		map.put("workNumber",workNumber);
  	    		
  	    		map.put("workSum1",workSum1);
  	    		map.put("workSum2",workSum2);
  	    		map.put("workSum3",workSum3);
  	    		map.put("workSum",workSum);
  	    		
  	    		map.put("workHuo1",workHuo1);
  	    		map.put("workHuo2",workHuo2);
  	    		map.put("workHuo3",workHuo3);
  	    		map.put("workHuo",workHuo);
  	    		
  	    		map.put("workDan1",workDan1);
  	    		map.put("workDan2",workDan2);
  	    		map.put("workDan3",workDan3);
  	    		map.put("workDan",workDan);
  	    		
  	    		map.put("userCost1",userCost1);
  	    		map.put("userCost2",userCost2);
  	    		map.put("userCost3",userCost3);
  	    		map.put("userCost",userCost);
  		
  	    return map;
  	
  		
    }
    

    
    

    /**
                * 导出牙星公司列表
     */
    @PostMapping("/exportExcel")
    @ResponseBody
    public AjaxResult export(YxDay yxDay)
    {
        List<YxDay> list = yxDayService.selectYxDayList(yxDay);
        ExcelUtil<YxDay> util = new ExcelUtil<YxDay>(YxDay.class);
        return util.exportExcel(list, "yxDay");
    }

  
    
    
    
}
