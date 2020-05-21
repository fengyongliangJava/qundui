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

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.yx.domain.YxUser;
import com.ruoyi.project.system.yx.domain.YxUpload;
import com.ruoyi.project.system.yx.service.IYxDayService;
import com.ruoyi.project.system.yx.service.IYxUserService;

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
    private IYxDayService yxDayService;
    
    @Autowired
    private IYxUserService yxUserService;

    @RequiresPermissions("system:yx:moneyCount:view")
    @GetMapping()
    public String yxMoneyCount()
    {
        return prefix + "/yx";
    }



    
    
    /**
               * 导入计件日工资
     */
    @PostMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(MultipartFile file, boolean updateSupport,HttpServletRequest request) throws Exception{
    	
		 
		String createTime = request.getParameter("createTime");
		String userOrg = request.getParameter("userOrg");
    	
        ExcelUtil<YxUpload> util = new ExcelUtil<YxUpload>(YxUpload.class);
        List<YxUpload> userList = util.importExcel(file.getInputStream());
        
        int i = 0;
        for(YxUpload yxExcel : userList) {
        	i++;
        	if(yxExcel.getUserId().isEmpty() 
                || yxExcel.getUserName().isEmpty()
                || yxExcel.getWorkStart() == null
                || yxExcel.getWorkNumber() == null
                || yxExcel.getWorkPrice() == null
                || yxExcel.getWorkAll() == null
                || yxExcel.getWorkFen() == null
                || yxExcel.getWorkHuo() == null 
        		|| yxExcel.getWorkDan() == null) {
                   return AjaxResult.success("导入第"+i+"条有空数据");
                }
        
    		if(yxDayService.findUserOrgExize(userOrg,yxExcel.getUserId(),yxExcel.getUserName())==null) {
    			    return AjaxResult.success(String.format("导入第%s条数据不匹配(当前部门未找到编号为【%s】 姓名为【%s】的员工)",i,yxExcel.getUserId(),yxExcel.getUserName()));
    		}
        }
        
        
       
        
        
        for(YxUpload yxuser : userList) {
        	yxuser.setCreateTime(createTime);
    		yxuser.setUserOrg(userOrg);
    		yxuser.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    		yxuser.setUpdateTime(DateUtils.getNowDate());
    		yxuser.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
    		
    		if(yxuser.getWorkNumber() != 0) {
        		yxuser.setWorkSum(new BigDecimal(yxuser.getWorkNumber()).multiply(yxuser.getWorkPrice()).divide(new BigDecimal(yxuser.getWorkAll()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(yxuser.getWorkFen())));
    		}

     		if(yxuser.getWorkSum() == null) {
     			yxuser.setWorkSum(new BigDecimal(0));
    		}
     		if(yxuser.getWorkHuo() == null) {
     			yxuser.setWorkHuo(new BigDecimal(0));
    		}
     		if(yxuser.getWorkDan() == null) {
     			yxuser.setWorkDan(new BigDecimal(0));
    		}
       		
    		yxuser.setUserCost(yxuser.getWorkSum().add(yxuser.getWorkHuo()).add(yxuser.getWorkDan()));
    		yxDayService.insertYxUpload(yxuser);
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
    
	
	
		/**
		     * 导出牙星公司列表
		 */
		@Log(title = "牙星公司", businessType = BusinessType.EXPORT)
		@PostMapping("/exportExcel")
		@ResponseBody
		public AjaxResult export(YxUser yxUser)
		{
		List<YxUser> list =  yxUserService.selectUserModel(yxUser);
		ExcelUtil<YxUser> util = new ExcelUtil<YxUser>(YxUser.class);
		return util.exportExcel(list, "YxUser");
		}
	
	
	
	
	
	
}
    
    
    
    
    
    
    
    
