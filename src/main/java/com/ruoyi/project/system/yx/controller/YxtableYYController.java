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
import com.ruoyi.project.system.yx.service.ItableYYService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/tableYY")
public class YxtableYYController extends BaseController
{
    private String prefix = "system/yx/tableYY";

    @Autowired
    private IYxYueService YxYueService;
    
    @Autowired
    private ItableYYService tableYYService;

    @RequiresPermissions("system:yx:tableYY:view")
    @GetMapping()
    public String yxTableYY()
    {
        return prefix + "/yx";
    }

    
    @ResponseBody
    @PostMapping("/YxtableYY")
    public Map<String,Object> tableDDCount(YxYue YxYue) {
    	
  	    Map<String,Object> map = new HashMap<>();
  	    
				String createTime = YxYue.getCreateTime();
				int year = Integer.parseInt(createTime) - 1;
				String PreYear = String.valueOf(year);
				
  	    		YxYue.setCreateTime(PreYear);
  	    		
  	    		YxYue.setWorkType("计件工资");
  	    		YxYue.setWorkClass("一线工资");
  	  	    	Map dataj1p = tableYYService.YxtableYY(YxYue);
  	  			Long userIdj1p = (Long)dataj1p.get("userId");
  	  			BigDecimal workNumberj1p = (BigDecimal)dataj1p.get("workNumber");
  				BigDecimal userCostj1p = (BigDecimal)dataj1p.get("userCost");
  
  				BigDecimal userSumj1p =	BigDecimal.ZERO;
  				if(userIdj1p>0) {
  					userSumj1p =	userCostj1p.divide(new BigDecimal(userIdj1p),2, BigDecimal.ROUND_HALF_UP);
  				}
  						
  	    		YxYue.setWorkClass("二线工资");
  	    	  	Map dataj2p = tableYYService.YxtableYY(YxYue);
  	  			Long userIdj2p = (Long)dataj2p.get("userId");
  	  			BigDecimal workNumberj2p = (BigDecimal)dataj2p.get("workNumber");
  				BigDecimal userCostj2p = (BigDecimal)dataj2p.get("userCost");
  				
  				BigDecimal userSumj2p =	BigDecimal.ZERO;
  				if(userIdj2p>0) {
  					userSumj2p =	userCostj2p.divide(new BigDecimal(userIdj2p),2, BigDecimal.ROUND_HALF_UP);
  				}

  	    		YxYue.setWorkClass("三线工资");
  	    	  	Map dataj3p = tableYYService.YxtableYY(YxYue);
  	  			Long userIdj3p = (Long)dataj3p.get("userId");
  	  			BigDecimal workNumberj3p = (BigDecimal)dataj3p.get("workNumber");
  				BigDecimal userCostj3p = (BigDecimal)dataj3p.get("userCost");
  				
  				BigDecimal userSumj3p =	BigDecimal.ZERO;
  				if(userIdj3p>0) {
  					userSumj3p =	userCostj3p.divide(new BigDecimal(userIdj3p),2, BigDecimal.ROUND_HALF_UP);
  				}
  				
  				map.put("userIdj1p",userIdj1p);
  	    		map.put("workNumberj1p",workNumberj1p);
  	    		map.put("userCostj1p",userCostj1p);
  	    		map.put("userSumj1p",userSumj1p);
  	    		
  				map.put("userIdj2p",userIdj2p);
  	    		map.put("workNumberj2p",workNumberj2p);
  	    		map.put("userCostj2p",userCostj2p);
	    		map.put("userSumj2p",userSumj2p);
  				
  				map.put("userIdj3p",userIdj3p);
  	    		map.put("workNumberj3p",workNumberj3p);
  	    		map.put("userCostj3p",userCostj3p);
  	    		map.put("userSumj3p",userSumj3p);
  	    		
  	    		
  				
  	    		YxYue.setWorkType("月薪水工资");
  	    		YxYue.setWorkClass("一线工资");
  	  	    	Map datay1p = tableYYService.YxtableYY(YxYue);
  	  			Long userIdy1p = (Long)datay1p.get("userId");
  	  			BigDecimal workNumbery1p = (BigDecimal)datay1p.get("workNumber");
  				BigDecimal userCosty1p = (BigDecimal)datay1p.get("userCost");
  				
  				BigDecimal userSumy1p =	BigDecimal.ZERO;
  				if(userIdy1p>0) {
  					userSumy1p =	userCosty1p.divide(new BigDecimal(userIdy1p),2, BigDecimal.ROUND_HALF_UP);
  				}
  				
  	    		YxYue.setWorkClass("二线工资");
  	        	Map datay2p = tableYYService.YxtableYY(YxYue);
  	  			Long userIdy2p = (Long)datay2p.get("userId");
  	  			BigDecimal workNumbery2p = (BigDecimal)datay2p.get("workNumber");
  				BigDecimal userCosty2p = (BigDecimal)datay2p.get("userCost");
  				
  				BigDecimal userSumy2p =	BigDecimal.ZERO;
  				if(userIdy2p>0) {
  					userSumy2p =	userCosty2p.divide(new BigDecimal(userIdy2p),2, BigDecimal.ROUND_HALF_UP);
  				}

  	    		YxYue.setWorkClass("三线工资");
  	      	    Map datay3p = tableYYService.YxtableYY(YxYue);
  	  			Long userIdy3p = (Long)datay3p.get("userId");
  	  			BigDecimal workNumbery3p = (BigDecimal)datay3p.get("workNumber");
  				BigDecimal userCosty3p = (BigDecimal)datay3p.get("userCost");
  				
  				BigDecimal userSumy3p =	BigDecimal.ZERO;
  				if(userIdy3p>0) {
  					userSumy3p =	userCosty3p.divide(new BigDecimal(userIdy3p),2, BigDecimal.ROUND_HALF_UP);
  				}

  				
  				map.put("userIdy1p",userIdy1p);
  	    		map.put("workNumbery1p",workNumbery1p);
  	    		map.put("userCosty1p",userCosty1p);
  	    		map.put("userSumy1p",userSumy1p);
  	    		
  				map.put("userIdy2p",userIdy2p);
  	    		map.put("workNumbery2p",workNumbery2p);
  	    		map.put("userCosty2p",userCosty2p);
  	  		    map.put("userSumy2p",userSumy2p);
  				
  				map.put("userIdy3p",userIdy3p);
  	    		map.put("workNumbery3p",workNumbery3p);
  	    		map.put("userCosty3p",userCosty3p);
  	  		    map.put("userSumy3p",userSumy3p);
  				
  	  		    
  	  		    
  	  		    
  	  		    
  	  		    
  	  		    
				YxYue.setCreateTime(createTime);
				
				
		
	    		YxYue.setWorkType("计件工资");
	    		YxYue.setWorkClass("一线工资");
	  	    	Map dataj1 = tableYYService.YxtableYY(YxYue);
	  			Long userIdj1 = (Long)dataj1.get("userId");
	  			BigDecimal workNumberj1 = (BigDecimal)dataj1.get("workNumber");
				BigDecimal userCostj1 = (BigDecimal)dataj1.get("userCost");
				
  				BigDecimal userSumj1 =	BigDecimal.ZERO;
  				if(userIdj1>0) {
  					userSumj1 =	userCostj1.divide(new BigDecimal(userIdj1),2, BigDecimal.ROUND_HALF_UP);
  				}

	    		YxYue.setWorkClass("二线工资");
	    	  	Map dataj2 = tableYYService.YxtableYY(YxYue);
	  			Long userIdj2 = (Long)dataj2.get("userId");
	  			BigDecimal workNumberj2 = (BigDecimal)dataj2.get("workNumber");
				BigDecimal userCostj2 = (BigDecimal)dataj2.get("userCost");
				
  				BigDecimal userSumj2 =	BigDecimal.ZERO;
  				if(userIdj2>0) {
  					userSumj2 =	userCostj2.divide(new BigDecimal(userIdj2),2, BigDecimal.ROUND_HALF_UP);
  				}

				
	    		YxYue.setWorkClass("三线工资");
	    	  	Map dataj3 = tableYYService.YxtableYY(YxYue);
	  			Long userIdj3 = (Long)dataj3.get("userId");
	  			BigDecimal workNumberj3 = (BigDecimal)dataj3.get("workNumber");
				BigDecimal userCostj3 = (BigDecimal)dataj3.get("userCost");
				
  				BigDecimal userSumj3 =	BigDecimal.ZERO;
  				if(userIdj3>0) {
  					userSumj3 =	userCostj3.divide(new BigDecimal(userIdj3),2, BigDecimal.ROUND_HALF_UP);
  				}
	    		
				map.put("userIdj1",userIdj1);
	    		map.put("workNumberj1",workNumberj1);
	    		map.put("userCostj1",userCostj1);
	    		map.put("userSumj1",userSumj1);
	    		
				map.put("userIdj2",userIdj2);
	    		map.put("workNumberj2",workNumberj2);
	    		map.put("userCostj2",userCostj2);
	    		map.put("userSumj2",userSumj2);
				
				map.put("userIdj3",userIdj3);
	    		map.put("workNumberj3",workNumberj3);
	    		map.put("userCostj3",userCostj3);
	    		map.put("userSumj3",userSumj3);
	    		
	    		
	    		
				
	    		YxYue.setWorkType("月新工资");
	    		YxYue.setWorkClass("一线工资");
	  	    	Map datay1 = tableYYService.YxtableYY(YxYue);
	  			Long userIdy1 = (Long)datay1.get("userId");
	  			BigDecimal workNumbery1 = (BigDecimal)datay1.get("workNumber");
				BigDecimal userCosty1 = (BigDecimal)datay1.get("userCost");
				
  				BigDecimal userSumy1 =	BigDecimal.ZERO;
  				if(userIdy1>0) {
  					userSumy1 =	userCosty1.divide(new BigDecimal(userIdy1),2, BigDecimal.ROUND_HALF_UP);
  				}
				
	    		YxYue.setWorkClass("二线工资");
	        	Map datay2 = tableYYService.YxtableYY(YxYue);
	  			Long userIdy2 = (Long)datay2.get("userId");
	  			BigDecimal workNumbery2 = (BigDecimal)datay2.get("workNumber");
				BigDecimal userCosty2 = (BigDecimal)datay2.get("userCost");
				
  				BigDecimal userSumy2 =	BigDecimal.ZERO;
  				if(userIdy2>0) {
  					userSumy2 =	userCosty2.divide(new BigDecimal(userIdy2),2, BigDecimal.ROUND_HALF_UP);
  				}

	    		YxYue.setWorkClass("三线工资");
	      	    Map datay3 = tableYYService.YxtableYY(YxYue);
	  			Long userIdy3 = (Long)datay3.get("userId");
	  			BigDecimal workNumbery3 = (BigDecimal)datay3.get("workNumber");
				BigDecimal userCosty3 = (BigDecimal)datay3.get("userCost");
				
  				BigDecimal userSumy3 =	BigDecimal.ZERO;
  				if(userIdy3>0) {
  					userSumy3 =	userCosty3.divide(new BigDecimal(userIdy3),2, BigDecimal.ROUND_HALF_UP);
  				}
				
				map.put("userIdy1",userIdy1);
	    		map.put("workNumbery1",workNumbery1);
	    		map.put("userCosty1",userCosty1);
	    		map.put("userSumy1",userSumy1);
	    		
				map.put("userIdy2",userIdy2);
	    		map.put("workNumbery2",workNumbery2);
	    		map.put("userCosty2",userCosty2);
	  		    map.put("userSumy2",userSumy2);
				
				map.put("userIdy3",userIdy3);
	    		map.put("workNumbery3",workNumbery3);
	    		map.put("userCosty3",userCosty3);
	  		    map.put("userSumy3",userSumy3);
				
  	  		    
  	  		    
	  		    BigDecimal	moneyChaj1	= userSumj1.subtract(userSumj1p);
  	     	    BigDecimal	moneyChaj2	= userSumj2.subtract(userSumj2p);
  	     	    BigDecimal	moneyChaj3	= userSumj3.subtract(userSumj3p);
  	     	    
  	     	    BigDecimal	moneyChay1	= userSumy1.subtract(userSumy1p);
  	     	    BigDecimal	moneyChay2	= userSumy2.subtract(userSumy2p);
  	     	    BigDecimal	moneyChay3	= userSumy3.subtract(userSumy3p);
  	    		
  	     	    BigDecimal	miChaj1	= workNumberj1.subtract(workNumberj1p);
  	     	    BigDecimal	miChaj2	= workNumberj2.subtract(workNumberj2p);
  	     	    BigDecimal	miChaj3	= workNumberj3.subtract(workNumberj3p);
  	     	    
  	     	    BigDecimal	miChay1	= workNumbery1.subtract(workNumbery1p);
  	     	    BigDecimal	miChay2	= workNumbery2.subtract(workNumbery2p);
  	     	    BigDecimal	miChay3	= workNumbery3.subtract(workNumbery3p);
  	     	    
  	     	    
				map.put("moneyChaj1",moneyChaj1);
				map.put("moneyChaj2",moneyChaj2);
				map.put("moneyChaj3",moneyChaj3);
				
				map.put("moneyChay1",moneyChay1);
				map.put("moneyChay2",moneyChay2);
				map.put("moneyChay3",moneyChay3);
				
				map.put("miChaj1",miChaj1);
				map.put("miChaj2",miChaj2);
				map.put("miChaj3",miChaj3);
				
				map.put("miChay1",miChay1);
				map.put("miChay2",miChay2);
				map.put("miChay3",miChay3);
				
 	     	    BigDecimal	userCostjpAll = (userCostj1p.add(userCostj2p)).add(userCostj3p);
  	     	    int     	userIdjpAll	=  (int) (userIdj1p + userIdj2p + userIdj3p);
  	     	    BigDecimal	userSumjpAll	= (userSumj1p.add(userSumj2p)).add(userSumj3p);
  	     	    BigDecimal  workNumberjpAll =  (workNumberj1p.add(workNumberj2p)).add(workNumberj3p);
  	     	    BigDecimal	moneyChajAll	= (moneyChaj1.add(moneyChaj2)).add(moneyChaj3);
  	     	    BigDecimal	miChajAll	= (miChaj1.add(miChaj2)).add(miChaj3);
  	     	    BigDecimal	userCostjAll = (userCostj1.add(userCostj2)).add(userCostj3);
  	     	    int     	userIdjAll	=  (int) (userIdj1 + userIdj2 + userIdj3);
  	     	    BigDecimal	userSumjAll	= (userSumj1.add(userSumj2)).add(userSumj3);
  	     	    BigDecimal  workNumberjAll =  (workNumberj1.add(workNumberj2)).add(workNumberj3);
  	     	    
  	     	    map.put("userCostjpAll",userCostjpAll);
  	     	    map.put("userIdjpAll",userIdjpAll);
  	     	    map.put("userSumjpAll",userSumjpAll);
  	     	    map.put("workNumberjpAll",workNumberjpAll);
  	     	    map.put("moneyChajAll",moneyChajAll);
  	     	    map.put("miChajAll",miChajAll);
 	     	    map.put("userCostjAll",userCostjAll);
  	     	    map.put("userIdjAll",userIdjAll);
 	     	    map.put("userSumjAll",userSumjAll);
  	     	    map.put("workNumberjAll",workNumberjAll);
  	     	    
  	     	    
 	     	    BigDecimal	userCostypAll = (userCosty1p.add(userCosty2p)).add(userCosty3p);
  	     	    int     	userIdypAll	=  (int) (userIdy1p + userIdy2p + userIdy3p);
  	     	    BigDecimal	userSumypAll	= (userSumy1p.add(userSumy2p)).add(userSumy3p);
  	     	    BigDecimal  workNumberypAll =  (workNumbery1p.add(workNumbery2p)).add(workNumbery3p);
  	     	    BigDecimal	moneyChayAll	= (moneyChay1.add(moneyChay2)).add(moneyChay3);
  	     	    BigDecimal	miChayAll	= (miChay1.add(miChay2)).add(miChay3);
  	     	    BigDecimal	userCostyAll = (userCosty1.add(userCosty2)).add(userCosty3);
  	     	    int     	userIdyAll	=  (int) (userIdy1 + userIdy2 + userIdy3);
  	     	    BigDecimal	userSumyAll	= (userSumy1.add(userSumy2)).add(userSumy3);
  	     	    BigDecimal  workNumberyAll =  (workNumbery1.add(workNumbery2)).add(workNumbery3);
  	     	    
  	     	    map.put("userCostypAll",userCostypAll);
  	     	    map.put("userIdypAll",userIdypAll);
  	     	    map.put("userSumypAll",userSumypAll);
  	     	    map.put("workNumberypAll",workNumberypAll);
  	     	    map.put("moneyChayAll",moneyChayAll);
  	     	    map.put("miChayAll",miChayAll);
 	     	    map.put("userCostyAll",userCostyAll);
  	     	    map.put("userIdyAll",userIdyAll);
 	     	    map.put("userSumyAll",userSumyAll);
  	     	    map.put("workNumberyAll",workNumberyAll);
  	     	    
 	     	    BigDecimal	userCostpAll = userCostjpAll.add(userCostypAll);
  	     	    int     	userIdpAll	=  (int) (userIdjpAll + userIdypAll);
  	     	    BigDecimal	userSumpAll	= userSumjpAll.add(userSumypAll);
  	     	    BigDecimal  workNumberpAll =  workNumberjpAll.add(workNumberypAll);
  	     	    BigDecimal	moneyChaAll	= moneyChajAll.add(moneyChayAll);
  	     	    BigDecimal	miChaAll	= miChajAll.add(miChayAll);
  	    	    BigDecimal	userCostAll = userCostjAll.add(userCostyAll);
  	     	    int     	userIdAll	=  (int) (userIdjAll + userIdyAll);
  	     	    BigDecimal	userSumAll	= userSumjAll.add(userSumyAll);
  	     	    BigDecimal  workNumberAll =  workNumberjAll.add(workNumberyAll);
  	     	    
  	     	    map.put("userCostpAll",userCostpAll);
  	     	    map.put("userIdpAll",userIdpAll);
  	     	    map.put("userSumpAll",userSumpAll);
  	     	    map.put("workNumberpAll",workNumberpAll);
  	     	    map.put("moneyChaAll",moneyChaAll);
  	     	    map.put("miChaAll",miChaAll);
 	     	    map.put("userCostAll",userCostAll);
  	     	    map.put("userIdAll",userIdAll);
 	     	    map.put("userSumAll",userSumAll);
  	     	    map.put("workNumberAll",workNumberAll);
  	     	    
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
