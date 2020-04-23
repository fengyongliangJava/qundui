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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.yx.domain.Yx;
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.service.IYxService;

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
	private IYxService yxService;

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
	public AjaxResult export(Yx yx) {
		List<Yx> list = yxService.selectYxList(yx);
		ExcelUtil<Yx> util = new ExcelUtil<Yx>(Yx.class);
		return util.exportExcel(list, "yx");
	}

	/**
	 * 月薪上传  
	 */
	@PostMapping("/importExcel")
	@ResponseBody
	public AjaxResult importExcel(MultipartFile file, boolean updateSupport, HttpServletRequest request)
			throws Exception {

		String createTime = request.getParameter("createTime");
		String userOrg = request.getParameter("userOrg");

		ExcelUtil<YxYue> util = new ExcelUtil<YxYue>(YxYue.class);
		List<YxYue> userList = util.importExcel(file.getInputStream());
		
		
		int i = 0;
		for (YxYue yxuser : userList) {
			i++;
			if (yxuser.getUserId().isEmpty() || yxuser.getUserName().isEmpty() || yxuser.getMoneyType() == null
					|| yxuser.getUserMoney() == null) {
				return AjaxResult.success("导入第" + i + "条有空数据");
			}
			
			
			
		}

		return AjaxResult.success("上传 " + createTime + "工资信息成功！！！");

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
