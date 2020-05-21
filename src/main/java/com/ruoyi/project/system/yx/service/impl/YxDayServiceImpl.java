package com.ruoyi.project.system.yx.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.domain.YxUpload;
import com.ruoyi.project.system.yx.domain.YxUser;
import com.ruoyi.project.system.yx.mapper.YxDayMapper;
import com.ruoyi.project.system.yx.service.IYxDayService;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class YxDayServiceImpl implements IYxDayService 
{
	@Autowired
    private YxDayMapper yxDayMapper;

    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    @Override
    public YxDay selectYxDayById(Long id)
    {
        return yxDayMapper.selectYxDayById(id);
    }

    /**
     * 查询牙星公司列表
     * 
     * @param yxDay 牙星公司
     * @return 牙星公司
     */
    @Override
    public List<YxDay> selectYxDayList(YxDay yxDay)
    {
    	//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	//formatter.format.();
	   	 yxDay.setCreateBy(ShiroUtils.getSysUser().getLoginName());
	   	 yxDay.setUpdateTime(DateUtils.getNowDate());
	   	 yxDay.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
        return yxDayMapper.selectYxDayList(yxDay);
    }
    
    
    public List<YxDay> selectCountMMList(YxDay yxDay)
    {
        return yxDayMapper.selectCountMMList(yxDay);
    }
    /**
     * 查询牙星公司列表
     * 
     * @param yxDay 牙星公司
     * @return 牙星公司
     */
    @Override
    public List<YxDay> selectYxKHList(YxDay yxDay)
    {
        return yxDayMapper.selectYxKHList(yxDay);
    }

    /**
     * 新增牙星公司
     * 
     * @param yxDay 牙星公司
     * @return 结果
     */
    @Override
    public int insertYxDay(YxDay yxDay)
    {
/*      	 yxDay.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	 yxDay.setUpdateTime(DateUtils.getNowDate());
    	 yxDay.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxDayMapper.insertYxDay(yxDay);
    }
    
    /**
     * 新增牙星公司
     * 
     * @param yx 牙星公司
     * @return 结果
     */
    @Override
    public int insertYxUpload(YxUpload yxupload)
    {
    	
    	yxupload.setUpdateTime(DateUtils.getNowDate());
    	
    	Map<String, String> selectYx = yxDayMapper.selectYx(yxupload.getUserId());
    	
    	if(!(selectYx == null || selectYx.isEmpty())) {
         yxupload.setSex(selectYx.get("sex"));
	   	 yxupload.setTell(selectYx.get("tell"));
	   	 yxupload.setCard(selectYx.get("card"));
	   	 yxupload.setAddress(selectYx.get("address"));
	   	 yxupload.setUserOrg(selectYx.get("userOrg"));
	   	 yxupload.setUserGroup(selectYx.get("userGroup"));
	   	 yxupload.setUserArea(selectYx.get("userArea"));
	   	 yxupload.setUserClass(selectYx.get("userClass"));
	   	 yxupload.setStation(selectYx.get("userClass"));
	   	 yxupload.setWorkType(selectYx.get("workType"));
	   	 yxupload.setWorkClass(selectYx.get("workClass"));
	   	 yxupload.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	 yxupload.setUpdateTime(DateUtils.getNowDate());
    	 yxupload.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
	       return yxDayMapper.insertYxUpload(yxupload);
    	}
    	return  0;
    }
    
    
    
    
    
    /**
     * 新增牙星公司
     * 
     * @param yx 牙星公司
     * @return 结果
     */
    @Override
    public int insertYxUser(YxUser yxuser)
    {
/*    	yxuser.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	yxuser.setUpdateTime(DateUtils.getNowDate());
    	yxuser.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxDayMapper.insertYxUser(yxuser);
    }


    /**
     * 修改牙星公司
     * 
     * @param yxDay 牙星公司
     * @return 结果
     */
    @Override
    public int updateYxDay(YxDay yxDay)
    {
/*    	yxDay.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	yxDay.setUpdateTime(DateUtils.getNowDate());
    	yxDay.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxDayMapper.updateYxDay(yxDay);
    }

    /**
     * 删除牙星公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYxDayByIds(String ids)
    {
        return yxDayMapper.deleteYxDayByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牙星公司信息
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    @Override
    public int deleteYxDayById(Long id)
    {
        return yxDayMapper.deleteYxDayById(id);
    }

    /**
     * 查询部门管理树
     *
     * @param dept 部门信息
     * @return 所有部门信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectDeptTree(Dept dept)
    {
        List<Dept> deptList = yxDayMapper.selectDeptList(dept);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }
    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList)
    {
        return initZtree(deptList, null);
    }

    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList, List<String> roleDeptList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (Dept dept : deptList)
        {
            if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(dept.getDeptId());
                ztree.setpId(dept.getParentId());
                ztree.setName(dept.getDeptName());
                ztree.setTitle(dept.getDeptName());
                if (isCheck)
                {
                    ztree.setChecked(roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }
    
    
    
	@Override
	public String findUserOrgExize(String userOrg, String userId,String userName ) {
		return yxDayMapper.findUserOrgExize(userOrg,userId,userName);
	}
}
    
    
    
