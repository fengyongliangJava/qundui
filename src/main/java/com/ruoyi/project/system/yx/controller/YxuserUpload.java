package com.ruoyi.project.system.yx.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.yx.domain.YxUser;
import com.ruoyi.project.system.yx.service.IYxService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/userUpload")
public class YxuserUpload extends BaseController
{
    private String prefix = "system/yx/userUpload";

    @Autowired
    private IYxService yxService;

    @RequiresPermissions("system:yx:userUpload:view")
    @GetMapping()
    public String yxMoneyYue()
    {
        return prefix + "/yx";
    }


    /**
     * 导入数据
     */
    @PostMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(MultipartFile file, boolean updateSupport) throws Exception{
        ExcelUtil<YxUser> util = new ExcelUtil<YxUser>(YxUser.class);
        List<YxUser> userList = util.importExcel(file.getInputStream());
        
        System.out.print(userList);
        int i = 0;
        String message = null;
        boolean success = true;
        for(YxUser yxuser : userList) {
        	i++;
        	try {
        		yxService.insertYxUser(yxuser);
        	}catch (Exception e) {
        		message ="导入"+i+"条失败";
        		success = false;
        		break;
			}
        }
        if(success) {
        	message = "导出成功！！！";
        }
        return AjaxResult.success(message);
    }
}
    
