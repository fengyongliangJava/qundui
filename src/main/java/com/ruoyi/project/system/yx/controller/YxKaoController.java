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

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.yx.domain.YxKao;
import com.ruoyi.project.system.yx.service.IYxKaoService;

/**
 * 部门Controller
 * 
 * @author ruoyi
 * @date 2020-04-27
 */
@Controller
@RequestMapping("/system/kao")
public class YxKaoController extends BaseController
{
    private String prefix = "system/yx/yxkao";

    @Autowired
    private IYxKaoService yxKaoService;

    @RequiresPermissions("system:kao:view")
    @GetMapping()
    public String kao()
    {
        return prefix + "/kao";
    }

    /**
     * 查询部门列表
     * @return 
     */
    @RequiresPermissions("system:kao:list")
    @PostMapping("/list")
    @ResponseBody
    public List<YxKao> list(YxKao yxKao)
    {
        return yxKaoService.selectYxKaoList(yxKao);
    }

    /**
     * 导出部门列表
     */
    @RequiresPermissions("system:kao:export")
    @Log(title = "部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YxKao yxKao)
    {
        List<YxKao> list = yxKaoService.selectYxKaoList(yxKao);
        ExcelUtil<YxKao> util = new ExcelUtil<YxKao>(YxKao.class);
        return util.exportExcel(list, "kao");
    }

    /**
     * 新增部门
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存部门
     */
    @RequiresPermissions("system:kao:add")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YxKao yxKao)
    {
        return toAjax(yxKaoService.insertYxKao(yxKao));
    }

    /**
     * 修改部门
     */
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        YxKao yxKao = yxKaoService.selectYxKaoById(deptId);
        mmap.put("yxKao", yxKao);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门
     */
    @RequiresPermissions("system:kao:edit")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YxKao yxKao)
    {
        return toAjax(yxKaoService.updateYxKao(yxKao));
    }

    /**
     * 删除部门
     */
    @RequiresPermissions("system:kao:remove")
    @Log(title = "部门", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yxKaoService.deleteYxKaoByIds(ids));
    }
}
