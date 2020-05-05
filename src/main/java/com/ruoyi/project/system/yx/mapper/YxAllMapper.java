package com.ruoyi.project.system.yx.mapper;

import java.util.List;

import com.ruoyi.project.system.yx.domain.YxAll;

/**
 * 牙星公司Mapper接口
 * 
 * @author ruoyi
 * @date 2020-05-02
 */
public interface YxAllMapper 
{
    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    public YxAll selectYxAllById(Long id);

    /**
     * 查询牙星公司列表
     * 
     * @param yxAll 牙星公司
     * @return 牙星公司集合
     */
    public List<YxAll> selectYxAllList(YxAll yxAll);

    /**
     * 新增牙星公司
     * 
     * @param yxAll 牙星公司
     * @return 结果
     */
    public int insertYxAll(YxAll yxAll);

    /**
     * 修改牙星公司
     * 
     * @param yxAll 牙星公司
     * @return 结果
     */
    public int updateYxAll(YxAll yxAll);

    /**
     * 删除牙星公司
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    public int deleteYxAllById(Long id);

    /**
     * 批量删除牙星公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxAllByIds(String[] ids);
}
