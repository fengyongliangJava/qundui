package com.ruoyi.project.system.yx.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.yx.mapper.YxKaoMapper;
import com.ruoyi.project.system.yx.domain.YxKao;
import com.ruoyi.project.system.yx.service.IYxKaoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 部门Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-27
 */
@Service
public class YxKaoServiceImpl implements IYxKaoService 
{
    @Autowired
    private YxKaoMapper yxKaoMapper;

    /**
     * 查询部门
     * 
     * @param deptId 部门ID
     * @return 部门
     */
    @Override
    public YxKao selectYxKaoById(Long deptId)
    {
        return yxKaoMapper.selectYxKaoById(deptId);
    }

    /**
     * 查询部门列表
     * 
     * @param yxKao 部门
     * @return 部门
     */
    @Override
    public List<YxKao> selectYxKaoList(YxKao yxKao)
    {
        return yxKaoMapper.selectYxKaoList(yxKao);
    }

    
    
    
	@Override
	public void insertYxKH(YxKao yxKao) {
		
/*	    	yxKao.setCreateBy(ShiroUtils.getSysUser().getLoginName());
	    	yxKao.setUpdateTime(DateUtils.getNowDate());
	    	yxKao.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
		   yxKaoMapper.insertYxKH(yxKao);
	}
    
    
    /**
     * 新增部门
     * 
     * @param yxKao 部门
     * @return 结果
     */
    @Override
    public int insertYxKao(YxKao yxKao)
    {
/*    	yxKao.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	yxKao.setUpdateTime(DateUtils.getNowDate());
    	yxKao.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxKaoMapper.insertYxKao(yxKao);
    }

    /**
     * 修改部门
     * 
     * @param yxKao 部门
     * @return 结果
     */
    @Override
    public int updateYxKao(YxKao yxKao)
    {
/*    	yxKao.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	yxKao.setUpdateTime(DateUtils.getNowDate());
    	yxKao.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxKaoMapper.updateYxKao(yxKao);
    }

    
    
    @Override
    public int updateYxName(YxKao yxKao)
    {
/*    	yxKao.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	yxKao.setUpdateTime(DateUtils.getNowDate());
    	yxKao.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxKaoMapper.updateYxName(yxKao);
    }
    /**
     * 删除部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYxKaoByIds(String ids)
    {
        return yxKaoMapper.deleteYxKaoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除部门信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    @Override
    public int deleteYxKaoById(Long deptId)
    {
        return yxKaoMapper.deleteYxKaoById(deptId);
    }


}
