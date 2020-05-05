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
import com.ruoyi.project.system.yx.domain.YxUser;
import com.ruoyi.project.system.yx.service.IYxUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 牙星公司人员Controller
 * 
 * @author ruoyi
 * @date 2020-04-25
 */
@Controller
@RequestMapping("/system/yx/user")
public class YxUserController extends BaseController
{
    private String prefix = "system/yx/user";

    @Autowired
    private IYxUserService yxUserService;

    @RequiresPermissions("system:yx:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询牙星公司人员列表
     */
    @RequiresPermissions("system:yx:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YxUser yxUser)
    {
        startPage();
        List<YxUser> list = yxUserService.selectYxUserList(yxUser);
        return getDataTable(list);
    }

    /**
     * 导出牙星公司人员列表
     */
    @RequiresPermissions("system:yx:user:export")
    @Log(title = "牙星公司人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YxUser yxUser)
    {
        List<YxUser> list = yxUserService.selectYxUserList(yxUser);
        ExcelUtil<YxUser> util = new ExcelUtil<YxUser>(YxUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增牙星公司人员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存牙星公司人员
     */
    @RequiresPermissions("system:yx:user:add")
    @Log(title = "牙星公司人员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YxUser yxUser)
    {
        return toAjax(yxUserService.insertYxUser(yxUser));
    }

    /**
     * 修改牙星公司人员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        YxUser yxUser = yxUserService.selectYxUserById(id);
        mmap.put("yxUser", yxUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存牙星公司人员
     */
    @RequiresPermissions("system:yx:user:edit")
    @Log(title = "牙星公司人员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YxUser yxUser)
    {
        return toAjax(yxUserService.updateYxUser(yxUser));
    }

    /**
     * 删除牙星公司人员
     */
    @RequiresPermissions("system:yx:user:remove")
    @Log(title = "牙星公司人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yxUserService.deleteYxUserByIds(ids));
    }
}
