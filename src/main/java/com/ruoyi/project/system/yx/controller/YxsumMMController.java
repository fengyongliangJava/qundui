package com.ruoyi.project.system.yx.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.ruoyi.project.system.yx.service.IsumMMService;


/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/sumMM")
public class YxsumMMController extends BaseController
{
    private String prefix = "system/yx/sumMM";

    @Autowired
    private IYxDayService yxDayService;
    
    @Autowired
    private IsumMMService sumMMService;
    
    
    @RequiresPermissions("system:yx:sumMM:view")
    @GetMapping()
    public String yxTableMM()
    {
        return prefix + "/yx";
    }


    @ResponseBody
    @PostMapping("/YxtableMM")
    public Map tableMMsum(YxDay YxDay) {
    	
    	String createTime = YxDay.getCreateTime();
		String  nowTime   = createTime+"-"+"25";
		 String[] arrObj = createTime.split("-");
		 arrObj[1] = String.valueOf(Integer.parseInt(arrObj[1]) - 1);

		 if((Integer.parseInt(arrObj[1]) - 1) < 1) {
			 arrObj[1] = "12";
			 arrObj[0] = String.valueOf(Integer.parseInt(arrObj[0]) - 1);
		 }
		 
		 if((Integer.parseInt(arrObj[1])) >9) {
			 String c = String.valueOf(arrObj[0])+"-"+String.valueOf(arrObj[1]);
			 String preTime = c;
		 }else {
			 String d = String.valueOf(arrObj[0])+"-"+"0"+String.valueOf(arrObj[1]);
			 String preTime = d;
		 }
    	
  	    Map<Long,Map<String,Object>> map = new HashMap<>();
  	    //query db
  	    
  	    
  	   List<YxDay> all  = sumMMService.sumMM(YxDay);
  	    
  	    List<YxDay> list = new ArrayList();
  	    
  	    list.stream().forEach(day->{
  	    	Map<String,Object> dayMap = map.get(day.getId());
  	    	String time = day.getCreateTime().substring(8,10);
  	    	if(Objects.nonNull(dayMap)) {
  	    		dayMap.put("sanClass", day.getUserCost());
  	    	}else {
  	    		dayMap = new HashMap();
  	    		dayMap.put("sanClass", day.getSanClass());
  	    	}
  	    	dayMap.put("workStart", day.getWorkStart());
  	    	map.put(day.getId(),dayMap);
  	    });

  	    return map;
    }

    /**
     * 导出牙星公司列表
     */
    @Log(title = "牙星公司", businessType = BusinessType.EXPORT)
    @PostMapping("/exportExcel")
    @ResponseBody
    public AjaxResult export(YxDay yxDay)
    {
		String createTime = yxDay.getCreateTime();
		String  nowTime   = createTime+"-"+"25";
		 String[] arrObj = createTime.split("-");
		 arrObj[1] = String.valueOf(Integer.parseInt(arrObj[1]) - 1);

		 if((Integer.parseInt(arrObj[1]) - 1) < 1) {
			 arrObj[1] = "12";
			 arrObj[0] = String.valueOf(Integer.parseInt(arrObj[0]) - 1);
		 }
		 String preTime = null;
		 if((Integer.parseInt(arrObj[1])) >9) {
			 preTime = String.valueOf(arrObj[0])+"-"+String.valueOf(arrObj[1]);
		 }else {
			 preTime = String.valueOf(arrObj[0])+"-"+"0"+String.valueOf(arrObj[1]);
		 }
		 preTime = preTime + "-26";
		 
	 	    yxDay.setCreateTime(nowTime);
	  	    yxDay.setUpdateBy(preTime);
	  	    
        List<YxDay> list = yxDayService.selectCountMMList(yxDay);
		
/*		int dataSize = list.size();
		for(int i = 0;i < dataSize ; i++ ) {
	
			if(list.get(i).getUpdateTime() != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String UpdateTime = formatter.format(list.get(i).getUpdateTime());
			    
			    list.get(i).setUpdateTime(UpdateTime);
			}
			    
		}*/
        
        ExcelUtil<YxDay> util = new ExcelUtil<YxDay>(YxDay.class);
        return util.exportExcel(list, "YxDay");
    }

  
}
