package com.ruoyi.project.system.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.yx.mapper.YxUserMapper;
import com.ruoyi.project.system.yx.domain.YxUser;
import com.ruoyi.project.system.yx.service.IYxUserService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;

/**
 * 牙星公司人员Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-25
 */
@Service
public class YxUserServiceImpl implements IYxUserService 
{
    @Autowired
    private YxUserMapper yxUserMapper;

    /**
     * 查询牙星公司人员
     * 
     * @param id 牙星公司人员ID
     * @return 牙星公司人员
     */
    @Override
    public YxUser selectYxUserById(Long id)
    {
        return yxUserMapper.selectYxUserById(id);
    }

    /**
     * 查询牙星公司人员列表
     * 
     * @param yxUser 牙星公司人员
     * @return 牙星公司人员
     */
    @Override
    public List<YxUser> selectYxUserList(YxUser yxUser)
    {
        return yxUserMapper.selectYxUserList(yxUser);
    }

    /**
     * 新增牙星公司人员
     * 
     * @param yxUser 牙星公司人员
     * @return 结果
     */
    @Override
    public int insertYxUser(YxUser yxUser)
    {
    	yxUser.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	yxUser.setUpdateTime(DateUtils.getNowDate());
    	yxUser.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
        return yxUserMapper.insertYxUser(yxUser);
    }

    /**
     * 修改牙星公司人员
     * 
     * @param yxUser 牙星公司人员
     * @return 结果
     */
    @Override
    public int updateYxUser(YxUser yxUser)
    {
    	yxUser.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	yxUser.setUpdateTime(DateUtils.getNowDate());
    	yxUser.setUpdateBy(ShiroUtils.getSysUser().getLoginName());
        return yxUserMapper.updateYxUser(yxUser);
    }

    /**
     * 删除牙星公司人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYxUserByIds(String ids)
    {
        return yxUserMapper.deleteYxUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牙星公司人员信息
     * 
     * @param id 牙星公司人员ID
     * @return 结果
     */
    @Override
    public int deleteYxUserById(Long id)
    {
        return yxUserMapper.deleteYxUserById(id);
    }
    
    
	@Override
	public String findUserExize(String userOrg, String userId) {
		return yxUserMapper.findUserExize(userOrg,userId);
	}
    
    
}
