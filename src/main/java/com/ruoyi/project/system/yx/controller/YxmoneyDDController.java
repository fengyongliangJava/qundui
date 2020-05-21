package com.ruoyi.project.system.yx.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.domain.YxUpload;
import com.ruoyi.project.system.yx.domain.YxUser;
import com.ruoyi.project.system.yx.service.IYxDayService;
import com.ruoyi.project.system.yx.service.IYxUserService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/moneyDD")
public class YxmoneyDDController extends BaseController
{
    private String prefix = "system/yx/moneyDD";

    @Autowired
    private IYxDayService yxDayService;
    
    @Autowired
    private IYxUserService yxUserService;

    @RequiresPermissions("system:yx:moneyDD:view")
    @GetMapping()
    public String yxMoney()
    {
        return prefix + "/yx";
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
               * 导入计件日工资
     */
    @PostMapping("/importMoneyDD")
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
     
    
    
    
    
    @GetMapping("/export")
    @ResponseBody
    public AjaxResult export(YxDay yxDay)
    {
        List<YxDay> list = yxDayService.selectYxDayList(yxDay);
        ExcelUtil<YxDay> util = new ExcelUtil<YxDay>(YxDay.class);
        return util.exportExcel(list, "yxDay");
    }


    
    
}
    
    
    
    
    
    
    
    
