package com.ruoyi.project.system.yx.controller;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import com.ruoyi.project.system.yx.service.IcountDDService;
import com.ruoyi.project.system.yx.service.ItableDDService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/countDD")
public class YxcountDDController extends BaseController
{
    private String prefix = "system/yx/countDD";

    @Autowired
    private IYxDayService yxDayService;
    
    @Autowired
    private IcountDDService countDDService;

    
    @RequiresPermissions("system:yx:countDD:view")
    @GetMapping()
    public String yxTableDD()
    {
        return prefix + "/yx";
    }
 
  

    @ResponseBody
    @PostMapping("/countDD")
    public Map<String,Object> tableDDCount(YxDay YxDay) {
    	
  	    Map<String,Object> map = new HashMap<>();
 
  	    BigDecimal sum = new BigDecimal("0");
 			List<YxDay> data = countDDService.countDD(YxDay);
 			for(YxDay day : data) {
 				sum = day.getUserCost().add(sum);
 			}
 			map.put("data", data);
 			map.put("sum", sum);//.setScale(2, BigDecimal.ROUND_HALF_UP));
 			
  	    return map;
  		
    }

    /**
               * 导出牙星公司列表
     */
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
