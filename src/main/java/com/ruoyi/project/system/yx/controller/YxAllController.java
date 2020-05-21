package com.ruoyi.project.system.yx.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.service.IYxYueService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/system/yxAll")
public class YxAllController extends BaseController
{
    private String prefix = "system/yx/yxAll";
    
    @Autowired
    private IYxYueService yxYueService;

    @RequiresPermissions("system:yxAll:view")
    @GetMapping()
    public String yxYue()
    {
        return prefix + "/yxAll";
    }

    /**
     * 查询牙星公司列表
     */
    @RequiresPermissions("system:yxAll:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YxYue yxYue)
    {
        startPage();
        List<YxYue> list = yxYueService.selectYxAllList(yxYue);
        return getDataTable(list);
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
    @RequiresPermissions("system:yxYue:add")
    @Log(title = "牙星公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YxYue yxYue)
    {
        return toAjax(yxYueService.insertYxYue(yxYue));
    }

    /**
              * 修改牙星公司
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        YxYue yxYue = yxYueService.selectYxYueById(id);
        mmap.put("yxYue", yxYue);
        return prefix + "/edit";
    }

    /**
     * 修改保存牙星公司
     */
    @RequiresPermissions("system:yxYue:edit")
    @Log(title = "牙星公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YxYue yxYue)
    {
    	
        return toAjax(yxYueService.updateYxYue(yxYue));
    }

    /**
              * 删除牙星公司
     */
    @RequiresPermissions("system:yxYue:remove")
    @Log(title = "牙星公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yxYueService.deleteYxYueByIds(ids));
    }
    
    
    
    
    
   
}
