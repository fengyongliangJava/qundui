package com.ruoyi.project.system.yx.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
import com.ruoyi.project.system.yx.service.IcountMMService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/countMM")
public class YxcountMMController extends BaseController
{
    private String prefix = "system/yx/countMM";

    @Autowired
    private IYxDayService yxDayService;
    
    @Autowired
    private IcountMMService countMMService;
    
    
    @RequiresPermissions("system:yx:countMM:view")
    @GetMapping()
    public String yxTableMM()
    {
        return prefix + "/yx";
    }

    

    @ResponseBody
    @PostMapping("countMM")
    public List tableMMCount(YxDay YxDay) {

		String createTime = YxDay.getCreateTime();
		//2020-05-25
		String  nowTime   = createTime+"-"+"25";
		
		 String[] arrObj = createTime.split("-");
		 //Month
		 arrObj[1] = String.valueOf(Integer.parseInt(arrObj[1]) - 1);

		 if((Integer.parseInt(arrObj[1]) - 1) < 1) {
			 // last year
			 arrObj[1] = "12";
			 arrObj[0] = String.valueOf(Integer.parseInt(arrObj[0]) - 1);
		 }
		 String preTime = null;
		 if((Integer.parseInt(arrObj[1])) >9) {
			 preTime = String.valueOf(arrObj[0])+"-"+String.valueOf(arrObj[1]);
		 }else {
			 preTime = String.valueOf(arrObj[0])+"-"+"0"+String.valueOf(arrObj[1]);
		 }
		 // 2020 -04 -26
		 preTime = preTime + "-26";
		 
  	    Map<String,Map<String,Object>> map = new HashMap<>();
  	    YxDay.setCreateTime(nowTime);
  	    YxDay.setUpdateBy(preTime);
  	   List<YxDay> all  = countMMService.countMM(YxDay);
  	    
  	    List<YxDay> list = new ArrayList();
  	    BigDecimal[] allSum = {BigDecimal.ZERO};
  	    String[] lastId = {""};
  	    Map<String,BigDecimal> costMap=new HashMap(list.size()/15);
  	    all.stream().forEach(day->{
  	    	Map<String,Object> dayMap = map.get(day.getUserId());
  	    	String time = day.getCreateTime().substring(8,10);
  	    	time="a"+time;
  	    	BigDecimal sum =  BigDecimal.ZERO;
  	    	//存在记录，累计金额
  	    	if(Objects.nonNull(dayMap)) {
  	    		dayMap.put(time, day.getUserCost());
  	    		sum = (BigDecimal) dayMap.get("sum");
  	    		sum = sum.add(day.getUserCost());
  	    	}else {
  	    		dayMap = new HashMap();
  	    		dayMap.put(time, day.getUserCost());
  	    		sum = sum.add(day.getUserCost());
  	    	}
  	    	//月总合计
	  	    allSum[0] = allSum[0].add(day.getUserCost()) ;
    		// 人员月合计
  	    	dayMap.put("sum", sum);
  	    	System.err.println(String.format("sum:%s--total:%s", sum,allSum[0]));
  	    	dayMap.put("userId", day.getUserId());
  	    	dayMap.put(time+"_number", null==day.getWorkNumber()?0:day.getWorkNumber());
  	    	dayMap.put("userName", day.getUserName());
  	    	dayMap.put("Station", day.getStation());
  	    	map.put(day.getUserId(),dayMap);
  	    });
  	    List retList = new ArrayList(map.size());
  	    map.forEach((k,v)->{
  	    	retList.add(v);
  	    });
  	    Map total = new HashMap(4);
  	    total.put("total", allSum[0]);
  	    retList.add(total);
  	    return retList;
  	
  		
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
