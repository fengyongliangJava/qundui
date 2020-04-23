package com.ruoyi.project.system.yx.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.ruoyi.project.system.yx.domain.Yx;
import com.ruoyi.project.system.yx.service.IYxService;

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
    private String prefix = "system/yx/selectKH";

    @Autowired
    private IYxService yxService;

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
        List<Ztree> ztrees = yxService.selectDeptTree(new Dept());
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
    public TableDataInfo list(Yx yx)
    {
        startPage();
        List<Yx> list = yxService.selectYxKHList(yx);
        return getDataTable(list);
    }

    
    
    
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
		
       new Yx().setCreateTime(LocalDate.now().format(formatter));
    	
     //  List<Yx> KHList = yxService.selectYxKHList(yx);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }
    

    
/*    @PostMapping("/countMoney")
    @ResponseBody
    public TableDataInfo countMoney(Yx yx)
    {
        List<Yx> KHList = yxService.selectYxKHList(yx);
        return getDataTable(list);
    }*/

    

    
    
    
    
    /**
     * 导出牙星公司列表
     */
    @RequiresPermissions("system:yx:selectKH:export")
    @Log(title = "牙星公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Yx yx)
    {
        List<Yx> list = yxService.selectYxList(yx);
        ExcelUtil<Yx> util = new ExcelUtil<Yx>(Yx.class);
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
    public AjaxResult addSave(Yx yx)
    {
        return toAjax(yxService.insertYx(yx));
    }

    /**
     * 修改牙星公司
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Yx yx = yxService.selectYxById(id);
        mmap.put("yx", yx);
        return prefix + "/edit";
    }

    /**
     * 修改保存牙星公司
     */
    @RequiresPermissions("system:yx:selectKH:edit")
    @Log(title = "牙星公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Yx yx)
    {
        return toAjax(yxService.updateYx(yx));
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
        return toAjax(yxService.deleteYxByIds(ids));
    }
}
