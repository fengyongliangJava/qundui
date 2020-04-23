package com.ruoyi.project.system.yx.mapper;

import java.util.List;

import com.ruoyi.project.system.yx.domain.YxLog;

/**
 * 牙星公司Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public interface YxLogMapper 
{
    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    public YxLog selectYxLogById(Long id);

    /**
     * 查询牙星公司列表
     * 
     * @param yxLog 牙星公司
     * @return 牙星公司集合
     */
    public List<YxLog> selectYxLogList(YxLog yxLog);

    /**
     * 新增牙星公司
     * 
     * @param yxLog 牙星公司
     * @return 结果
     */
    public int insertYxLog(YxLog yxLog);

    /**
     * 修改牙星公司
     * 
     * @param yxLog 牙星公司
     * @return 结果
     */
    public int updateYxLog(YxLog yxLog);

    /**
     * 删除牙星公司
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    public int deleteYxLogById(Long id);

    /**
     * 批量删除牙星公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxLogByIds(String[] ids);
}
