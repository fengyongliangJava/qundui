package com.ruoyi.project.system.yx.controller;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.project.system.yx.service.IYxUserService;

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
    private IYxUserService yxUserService;

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
        	if(yxuser.getUserId().isEmpty() 
                    || yxuser.getUserName().isEmpty()
                    || yxuser.getSex() == null
                    || yxuser.getTell() == null
                    || yxuser.getCard() == null
                    || yxuser.getAddress() == null
                    || yxuser.getUserOrg() == null
                    || yxuser.getUserArea() == null
                    || yxuser.getUserGroup() == null
                    || yxuser.getUserClass() == null
                    || yxuser.getStation() == null
                    || yxuser.getWorkType() == null
                    || yxuser.getWorkClass() == null 			
        			
        			) {
                       return AjaxResult.success("导入第"+i+"条有空数据");
                    }


        	
        	
        	try {
        		yxUserService.insertYxUser(yxuser);
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
    
    
    
	/**
	 * 导出模板
	 */
	@GetMapping("/exprotModel")
	@ResponseBody
	public byte[] exprotModel(MultipartFile file, boolean updateSupport, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//加载模板流
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("model/员工信息模板.xlsx");
		int i = 0;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((i = is.read()) != -1) {
			baos.write(i);
		}
		String fileName = "员工信息";
		fileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
		response.setContentType("application/ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName+".xlsx");
		//response.setHeader("Content-disposition","attachment;filename=月薪上传模板" + UUID.randomUUID().toString() + ".xlsx");
		return baos.toByteArray();

	}
    
    
    
}
    
