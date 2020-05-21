package com.ruoyi.project.system.yx.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.domain.YxKao;
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.service.IYxDayService;
import com.ruoyi.project.system.yx.service.IYxKaoService;
import com.ruoyi.project.system.yx.service.IYxYueService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller("YxLog")
@RequestMapping("/system/yx/selectKH")
public class YxselectKHController extends BaseController
{
	Logger log = LoggerFactory.getLogger(YxselectKHController.class);
	
    private String prefix = "system/yx/selectKH";

    @Autowired
    private IYxDayService yxDayService;
    
    @Autowired
    private IYxKaoService yxKaoService;


    @Autowired
    private IYxYueService yxYueService;

    @RequiresPermissions("system:yx:selectKH:view")
    @GetMapping()
    public String yx()
    {
        return prefix + "/yx";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = yxDayService.selectDeptTree(new Dept());
        return ztrees;
    }

    /**
     * 选择部门树
     */
    @GetMapping("/selectDeptTree")
    public String selectDeptTree(ModelMap mmap)
    {
        return prefix + "/tree";
    }
    /**
     * 查询牙星公司列表
     */
    @RequiresPermissions("system:yx:selectKH:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YxDay yxDay)
    {
        startPage();
        List<YxDay> list = yxDayService.selectYxKHList(yxDay);
        return getDataTable(list);
    }

    
    
    
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
		YxDay yxDay = new YxDay();
		yxDay.setCreateTime(LocalDate.now().format(formatter));
    	
       List<YxDay> KHList = yxDayService.selectYxKHList(yxDay);
       
       StringBuilder  ids = new StringBuilder();
       AtomicInteger idx=new AtomicInteger(0);
       KHList.parallelStream().forEach(e->{
    	   YxYue yxYue = new YxYue();
    	   BeanUtils.copyProperties(e, yxYue);
    	   ids.append(yxYue.getUserId()).append(",");
    	   yxYueService.insertYxYue(yxYue);
       });
       //invoke 
       /******************************************************/
       //select yxYue list
       YxYue yx = new YxYue();
       yx.setCreateTime(yxDay.getCreateTime());
       List<YxYue> list = yxYueService.selectYxYueList(yx);
       
       Map<String,AtomicInteger> map= new HashMap(16);
       Map<String,AtomicReference<BigDecimal>> sum= new HashMap(16);
       list.parallelStream().forEach(yxYue->{
    	   counter(yxYue.getUserClass(),map);
    	   counter(yxYue.getUserGroup(),map);
    	   counter(yxYue.getUserArea(),map);
    	   counter(yxYue.getUserOrg(),map);
    	   sum(yxYue.getUserClass(),sum,yxYue.getUserCost());
    	   sum(yxYue.getUserGroup(),sum,yxYue.getUserCost());
    	   sum(yxYue.getUserArea(),sum,yxYue.getUserCost());
    	   sum(yxYue.getUserOrg(),sum,yxYue.getUserCost());
       });
       
       YxKao kao = new YxKao();
       kao.setCreateBy(ids.substring(0,ids.length()-1));
       yxKaoService.insertYxKH(kao);
       //根据 depName  count  sum
       map.forEach((k,v)->{
    	   YxKao yxKao = new YxKao();
    	   yxKao.setDeptName(k);
    	   yxKao.setDeptNum(v.intValue());
    	   yxKao.setUserCost(sum.get(k).toString());
    	   yxKao.setCreateTime(yxDay.getCreateTime());
    	   
    	   yxKaoService.updateYxName(yxKao);
       });
       /*******************************************************/
    }
    
    public void sum(String key,Map<String,AtomicReference<BigDecimal>> map,BigDecimal salary) {
    	AtomicReference<BigDecimal> sum= map.get(key);
    	if(null==salary) {
    		salary=BigDecimal.ZERO;
    	}
   	   if(sum==null) {
   		   map.put(key, new AtomicReference<BigDecimal>(salary));
   	   }else {
   		   log.info("current {} sum:{}",key,map.get(key).accumulateAndGet(salary, (x,y)->x.add(y)));
   	   }
     }
    
    public void counter(String key,Map<String,AtomicInteger> map) {
       AtomicInteger counter = map.get(key);
  	   if(counter==null) {
  		   map.put(key, new AtomicInteger(1));
  	   }else {
  		   log.info("current {} counter:{}",key,map.get(key).incrementAndGet());
  	   }
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }
    

    
    
    /**
     * 导出牙星公司列表
     */
    @RequiresPermissions("system:yx:selectKH:export")
    @Log(title = "牙星公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YxDay yxDay)
    {
        List<YxDay> list = yxDayService.selectYxDayList(yxDay);
        ExcelUtil<YxDay> util = new ExcelUtil<YxDay>(YxDay.class);
        return util.exportExcel(list, "yx");
    }

    /**
     * 新增牙星公司
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存牙星公司
     */
    @RequiresPermissions("system:yx:selectKH:add")
    @Log(title = "牙星公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YxDay yxDay)
    {
        return toAjax(yxDayService.insertYxDay(yxDay));
    }

    /**
     * 修改牙星公司
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        YxDay yxDay = yxDayService.selectYxDayById(id);
        mmap.put("yx", yxDay);
        return prefix + "/edit";
    }

    /**
     * 修改保存牙星公司
     */
    @RequiresPermissions("system:yx:selectKH:edit")
    @Log(title = "牙星公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YxDay yxDay)
    {
        return toAjax(yxDayService.updateYxDay(yxDay));
    }

    /**
     * 删除牙星公司
     */
    @RequiresPermissions("system:yx:selectKH:remove")
    @Log(title = "牙星公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yxDayService.deleteYxDayByIds(ids));
    }
}
