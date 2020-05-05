package com.ruoyi.project.system.yx.service;

import java.util.List;
import com.ruoyi.project.system.yx.domain.YxUser;

/**
 * 牙星公司人员Service接口
 * 
 * @author ruoyi
 * @date 2020-04-25
 */
public interface IYxUserService 
{
    /**
     * 查询牙星公司人员
     * 
     * @param id 牙星公司人员ID
     * @return 牙星公司人员
     */
    public YxUser selectYxUserById(Long id);

    /**
     * 查询牙星公司人员列表
     * 
     * @param yxUser 牙星公司人员
     * @return 牙星公司人员集合
     */
    public List<YxUser> selectYxUserList(YxUser yxUser);

    /**
     * 新增牙星公司人员
     * 
     * @param yxUser 牙星公司人员
     * @return 结果
     */
    public int insertYxUser(YxUser yxUser);

    /**
     * 修改牙星公司人员
     * 
     * @param yxUser 牙星公司人员
     * @return 结果
     */
    public int updateYxUser(YxUser yxUser);

    /**
     * 批量删除牙星公司人员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxUserByIds(String ids);

    /**
     * 删除牙星公司人员信息
     * 
     * @param id 牙星公司人员ID
     * @return 结果
     */
    public int deleteYxUserById(Long id);
    
    
    
	public String findUserExize(String userOrg, String userId);
    
}
