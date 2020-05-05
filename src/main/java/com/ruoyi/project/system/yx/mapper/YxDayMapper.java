package com.ruoyi.project.system.yx.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.yx.domain.YxDay;
import com.ruoyi.project.system.yx.domain.YxUpload;
import com.ruoyi.project.system.yx.domain.YxUser;

/**
 * 牙星公司Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public interface YxDayMapper 
{
    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    public YxDay selectYxById(Long id);

    /**
     * 查询牙星公司列表
     * 
     * @param yxDay 牙星公司
     * @return 牙星公司集合
     */
    public List<YxDay> selectYxList(YxDay yxDay);
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
    public int insertYx(YxDay yxDay);
    /**
     * 新增牙星公司
     * 
     * @param yx 牙星公司
     * @return 结果
     */
    public int insertYxUser(YxUser yxuser);
    
    
    /**
     * 新增牙星公司
     * 
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
    public int updateYx(YxDay yxDay);

    /**
     * 删除牙星公司
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    public int deleteYxById(Long id);

    /**
     * 批量删除牙星公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxByIds(String[] ids);


    Dept selectDeptById();

    List<Ztree> selectDeptTree(Dept dept);

    List<Dept> selectDeptList(Dept dept);
    
    
	public String findUserOrgExize(@Param("userOrg")String userOrg, @Param("userId")String userId);

	public Map<String,String> selectYx(@Param("userId")String userId);

}
