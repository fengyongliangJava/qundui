package com.ruoyi.project.system.yx.service;

import java.util.List;

import com.ruoyi.project.system.yx.domain.YxKao;

/**
 * 部门Service接口
 * 
 * @author ruoyi
 * @date 2020-04-27
 */
public interface IYxKaoService 
{
    /**
     * 查询部门
     * 
     * @param deptId 部门ID
     * @return 部门
     */
    public YxKao selectYxKaoById(Long deptId);

    /**
     * 查询部门列表
     * 
     * @param yxKao 部门
     * @return 部门集合
     */
    public List<YxKao> selectYxKaoList(YxKao yxKao);

    
    
    public void insertYxKH (YxKao yxKao);
    
    
    
    /**
     * 新增部门
     * 
     * @param yxKao 部门
     * @return 结果
     */
    public int insertYxKao(YxKao yxKao);

    /**
     * 修改部门
     * 
     * @param yxKao 部门
     * @return 结果
     */
    public int updateYxKao(YxKao yxKao);
    
    /**
     * 修改部门
     * 
     * @param yxKao 部门
     * @return 结果
     */
    public int updateYxName(YxKao yxKao);

    /**
     * 批量删除部门
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxKaoByIds(String ids);

    /**
     * 删除部门信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteYxKaoById(Long deptId);
}
