package com.ruoyi.project.system.yx.mapper;

import java.util.List;

import com.ruoyi.project.system.yx.domain.YxAll;
import com.ruoyi.project.system.yx.domain.YxYue;

/**
 * 牙星公司Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public interface YxYueMapper 
{
    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    public YxYue selectYxYueById(Long id);

    /**
     * 查询牙星公司列表
     * 
     * @param yxYue 牙星公司
     * @return 牙星公司集合
     */
    public List<YxYue> selectYxYueList(YxYue yxYue);
    
    public List<YxYue> selectYxAllList(YxYue yxYue);
    
    public List<YxYue> selectYxList(YxYue yxYue);

    /**
     * 新增牙星公司
     * 
     * @param yxYue 牙星公司
     * @return 结果
     */
    public int insertYxYue(YxYue yxYue);
    
    
    public int insertYxAll(YxAll yxAll);

    /**
     * 修改牙星公司
     * 
     * @param yxYue 牙星公司
     * @return 结果
     */
    public int updateYxYue(YxYue yxYue);

    /**
     * 删除牙星公司
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    public int deleteYxYueById(Long id);

    /**
     * 批量删除牙星公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxYueByIds(String[] ids);
}
