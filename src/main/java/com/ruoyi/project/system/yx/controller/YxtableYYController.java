package com.ruoyi.project.system.yx.controller;

import java.util.List;

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
import com.ruoyi.project.system.yx.domain.Yx;
import com.ruoyi.project.system.yx.service.IYxService;

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
    private IYxService yxService;

    @RequiresPermissions("system:yx:tableYY:view")
    @GetMapping()
    public String yxTableYY()
    {
        return prefix + "/yx";
    }


    /**
     * 导出牙星公司列表
     */
    @RequiresPermissions("system:yx:tableYY:export")
    @Log(title = "牙星公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Yx yx)
    {
        List<Yx> list = yxService.selectYxList(yx);
        ExcelUtil<Yx> util = new ExcelUtil<Yx>(Yx.class);
        return util.exportExcel(list, "yx");
    }

  
}
