package com.ruoyi.project.system.yx.controller;

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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.service.IYxDayService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/selectYY")
public class YxselectYYController extends BaseController
{
    private String prefix = "system/yx/selectYY";

    @Autowired
    private IYxDayService yxDayService;

    @RequiresPermissions("system:yx:selectYY:view")
    @GetMapping()
    public String yx()
    {
        return prefix + "/yx";
    }

    
    
    /**
     * 查询牙星公司列表
     */
    @RequiresPermissions("system:yx:selectYY:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YxDay yxDay)
    {
        startPage();
        List<YxDay> list = yxDayService.selectYxDayList(yxDay);
        return getDataTable(list);
    }

    /**
     * 导出牙星公司列表
     */
    @RequiresPermissions("system:yx:selectYY:export")
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
    @RequiresPermissions("system:yx:selectYY:add")
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
    @RequiresPermissions("system:yx:selectYY:edit")
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
    @RequiresPermissions("system:yx:selectYY:remove")
    @Log(title = "牙星公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yxDayService.deleteYxDayByIds(ids));
    }
}
