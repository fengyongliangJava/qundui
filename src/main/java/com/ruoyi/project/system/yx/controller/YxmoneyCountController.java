package com.ruoyi.project.system.yx.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
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
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.yx.domain.Yx;
import com.ruoyi.project.system.yx.domain.YxUpload;
import com.ruoyi.project.system.yx.service.IYxService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/moneyCount")
public class YxmoneyCountController extends BaseController
{
    private String prefix = "system/yx/moneyCount";

    @Autowired
    private IYxService yxService;

    @RequiresPermissions("system:yx:moneyCount:view")
    @GetMapping()
    public String yxMoneyCount()
    {
        return prefix + "/yx";
    }


    /**
     * 导出牙星公司列表
     */
    @RequiresPermissions("system:yx:moneyCount:export")
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
     * 导入当日工资
     */
    @PostMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(MultipartFile file, boolean updateSupport,HttpServletRequest request) throws Exception{
    	
		 
		String createTime = request.getParameter("createTime");
		String userOrg = request.getParameter("userOrg");
    	
        ExcelUtil<YxUpload> util = new ExcelUtil<YxUpload>(YxUpload.class);
        List<YxUpload> userList = util.importExcel(file.getInputStream());
        
        int i = 0;
        for(YxUpload yxuser : userList) {
        	i++;
        	if(yxuser.getUserId().isEmpty() 
                || yxuser.getUserName().isEmpty()
                || yxuser.getWorkStart() == null
                || yxuser.getWorkNumber() == null
                || yxuser.getWorkPrice() == null
                || yxuser.getWorkAll() == null
                || yxuser.getWorkFen() == null) {
                   return AjaxResult.success("导入第"+i+"条有空数据");
                }
    		if(yxService.findUserOrgExize(userOrg,yxuser.getUserId()) == null) {
    			    return AjaxResult.success("导入第"+i+"条员工编号不匹配");
    		}
        }
        for(YxUpload yxuser : userList) {
        	yxuser.setCreateTime(createTime);
    		yxuser.setUserOrg(userOrg);
    		yxuser.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    		yxuser.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
    		yxuser.setWorkSum(new BigDecimal(yxuser.getWorkNumber()).multiply(yxuser.getWorkPrice()).divide(new BigDecimal(yxuser.getWorkAll()),3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(yxuser.getWorkFen())));
    		yxService.insertYxUpload(yxuser);
        }
       return AjaxResult.success("上传 "+createTime+"工资信息成功！！！");

    }
       

    
    
	/**
	 * 导出模板
	 */
	@GetMapping("/exprotModel")
	@ResponseBody
	public byte[] exprotModel(MultipartFile file, boolean updateSupport, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//加载模板流
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("model/计件上传模板.xlsx");
		int i = 0;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((i = is.read()) != -1) {
			baos.write(i);
		}
		String fileName = "计件上传模板";
		fileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
		response.setContentType("application/ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName+".xlsx");
		//response.setHeader("Content-disposition","attachment;filename=月薪上传模板" + UUID.randomUUID().toString() + ".xlsx");
		return baos.toByteArray();

	}


    
    
    
}
    
    
    
    
    
    
    
    
