package com.ruoyi.project.system.yx.service;

import java.util.List;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.domain.YxUpload;
import com.ruoyi.project.system.yx.domain.YxUser;

/**
 * 牙星公司Service接口
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public interface IYxDayService 
{
    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    public YxDay selectYxDayById(Long id);

    /**
     * 查询牙星公司列表
     * 
     * @param yxDay 牙星公司
     * @return 牙星公司集合
     */
    public List<YxDay> selectYxDayList(YxDay yxDay);
    
    /**
     * 查询牙星公司列表
     * 
     * @param yxDay 牙星公司
     * @return 牙星公司集合
     */
    public List<YxDay> selectCountMMList(YxDay yxDay);
    
    
    /**
     * 查询牙星公司列表
     * 
     * @param yxDay 牙星公司
     * @return 牙星公司集合
     */
    public List<YxDay> selectYxKHList(YxDay yxDay);


    /**
     * 新增牙星公司
     * 
     * @param yxDay 牙星公司
     * @return 结果
     */
    public int insertYxDay(YxDay yxDay);
    
    /**
     * 新增牙星公司用户
     * 
     * @param yx 牙星公司
     * @return 结果
     */
	public int insertYxUser(YxUser yxuser);
	
    /**
     * 新增牙星公司用户
     * @param yx 牙星公司
     * @return 结果
     */
	public int insertYxUpload(YxUpload yxupload);

    /**
     * 修改牙星公司
     * 
     * @param yxDay 牙星公司
     * @return 结果
     */
    public int updateYxDay(YxDay yxDay);

    /**
     * 批量删除牙星公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxDayByIds(String ids);

    /**
     * 删除牙星公司信息
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    public int deleteYxDayById(Long id);

    List<Ztree> selectDeptTree(Dept dept);

    //string ni这返回的是一个string对象啊，三个字段返回怎么可能是一个shring
    //现在就返回string 就行，返回之后拿 string.split("-")

	public String findUserOrgExize(String userOrg, String userId, String userName);
}
