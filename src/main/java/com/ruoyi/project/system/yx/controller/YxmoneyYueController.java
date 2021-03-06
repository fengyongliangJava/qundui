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
import com.ruoyi.project.system.yx.domain.YxAll;
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.service.IYxUserService;
import com.ruoyi.project.system.yx.service.IYxYueService;
import com.ruoyi.project.system.yx.service.IYxAllService;

/**
 * 牙星公司Controller
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Controller
@RequestMapping("/system/yx/moneyYue")
public class YxmoneyYueController extends BaseController {
	private String prefix = "system/yx/moneyYue";

	@Autowired
	private IYxUserService yxUserService;
	
	@Autowired
	private IYxYueService YxYueService;

	@RequiresPermissions("system:yx:moneyYue:view")
	@GetMapping()
	public String yxMoneyYue() {
		return prefix + "/yx";
	}

	/**
	 * 导出牙星公司列表
	 */
	@RequiresPermissions("system:yx:moneyYue:export")
	@Log(title = "牙星公司", businessType = BusinessType.EXPORT)
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(YxYue YxYue) {
		List<YxYue> list = YxYueService.selectYxYueList(YxYue);
		ExcelUtil<YxYue> util = new ExcelUtil<YxYue>(YxYue.class);
		return util.exportExcel(list, "YxYue");
	}

	 
    /**
     * 导入月薪月工资
     */
    @PostMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(MultipartFile file, boolean updateSupport,HttpServletRequest request) throws Exception{
    	
		 
		String createTime = request.getParameter("createTime");
		String userOrg = request.getParameter("userOrg");
        ExcelUtil<YxAll> util = new ExcelUtil<YxAll>(YxAll.class);
        List<YxAll> userList = util.importExcel(file.getInputStream());
        
        int i = 0;
        for(YxAll yxExcel : userList) {
        	i++;
        	if(yxExcel.getUserId().isEmpty() 
                || yxExcel.getUserName().isEmpty()
                || yxExcel.getCountDay() == null
                || yxExcel.getCountMoney() == null
                || yxExcel.getSumDay() == null
                || yxExcel.getWorkPlus() == null
                || yxExcel.getWorkCost() == null
                || yxExcel.getOther() == null) {
                   return AjaxResult.success("导入第"+i+"条有空数据");
                }
    		if(yxUserService.findUserExize(userOrg,yxExcel.getUserId(),yxExcel.getUserName()) == null) {
			    return AjaxResult.success(String.format("导入第%s条数据不匹配(当前部门未找到编号为【%s】 姓名为【%s】的员工)",i,yxExcel.getUserId(),yxExcel.getUserName()));
    		}
        }
        for(YxAll YxAll : userList) {
        	YxAll.setCreateTime(createTime);
    		YxAll.setUserOrg(userOrg);
    		YxAll.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    		YxAll.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
    		YxAll.setSumMoney(YxAll.getCountMoney().divide(new BigDecimal(YxAll.getCountDay()),2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(YxAll.getSumDay())));
    		
  /*  		if(YxAll.getOther() == null) {
    			YxAll.setOther(new BigDecimal(0));
    		}*/
    		YxAll.setUserCost(YxAll.getCountMoney().subtract(YxAll.getSumMoney()).add(YxAll.getWorkCost()).add(YxAll.getOther()));
    		YxYueService.insertYxAll(YxAll);
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
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("model/月薪上传模板.xlsx");
		int i = 0;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((i = is.read()) != -1) {
			baos.write(i);
		}
		
		String fileName = "月薪上传模板";
		fileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
		response.setContentType("application/ms-excel;charset=UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName+".xlsx");
		//response.setHeader("Content-disposition","attachment;filename=月薪上传模板" + UUID.randomUUID().toString() + ".xlsx");
		return baos.toByteArray();

	}

}
