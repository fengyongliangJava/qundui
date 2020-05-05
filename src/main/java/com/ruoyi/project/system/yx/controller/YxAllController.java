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
import com.ruoyi.project.system.yx.domain.YxAll;
import com.ruoyi.project.system.yx.service.IYxAllService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-05-02
 */
@Controller
@RequestMapping("/system/all")
public class YxAllController extends BaseController
{
    private String prefix = "/system/yx/all";

    @Autowired
    private IYxAllService yxAllService;

    @RequiresPermissions("system:all:view")
    @GetMapping()
    public String all()
    {
        return prefix + "/all";
    }

    /**
     * 查询牙星公司列表
     */
    @RequiresPermissions("system:all:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YxAll yxAll)
    {
        startPage();
        List<YxAll> list = yxAllService.selectYxAllList(yxAll);
        return getDataTable(list);
    }

    /**
     * 导出牙星公司列表
     */
    @RequiresPermissions("system:all:export")
    @Log(title = "牙星公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YxAll yxAll)
    {
        List<YxAll> list = yxAllService.selectYxAllList(yxAll);
        ExcelUtil<YxAll> util = new ExcelUtil<YxAll>(YxAll.class);
        return util.exportExcel(list, "all");
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
    @RequiresPermissions("system:all:add")
    @Log(title = "牙星公司", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YxAll yxAll)
    {
        return toAjax(yxAllService.insertYxAll(yxAll));
    }

    /**
     * 修改牙星公司
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        YxAll yxAll = yxAllService.selectYxAllById(id);
        mmap.put("yxAll", yxAll);
        return prefix + "/edit";
    }

    /**
     * 修改保存牙星公司
     */
    @RequiresPermissions("system:all:edit")
    @Log(title = "牙星公司", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YxAll yxAll)
    {
        return toAjax(yxAllService.updateYxAll(yxAll));
    }

    /**
     * 删除牙星公司
     */
    @RequiresPermissions("system:all:remove")
    @Log(title = "牙星公司", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yxAllService.deleteYxAllByIds(ids));
    }
}
