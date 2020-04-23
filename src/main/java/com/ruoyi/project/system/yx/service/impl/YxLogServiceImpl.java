package com.ruoyi.project.system.yx.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.yx.mapper.YxLogMapper;
import com.ruoyi.project.system.yx.domain.YxLog;
import com.ruoyi.project.system.yx.service.IYxLogService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Service
public class YxLogServiceImpl implements IYxLogService 
{
    @Autowired
    private YxLogMapper yxLogMapper;

    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    @Override
    public YxLog selectYxLogById(Long id)
    {
        return yxLogMapper.selectYxLogById(id);
    }

    /**
     * 查询牙星公司列表
     * 
     * @param yxLog 牙星公司
     * @return 牙星公司
     */
    @Override
    public List<YxLog> selectYxLogList(YxLog yxLog)
    {
        return yxLogMapper.selectYxLogList(yxLog);
    }

    /**
     * 新增牙星公司
     * 
     * @param yxLog 牙星公司
     * @return 结果
     */
    @Override
    public int insertYxLog(YxLog yxLog)
    {
        yxLog.setCreateTime(DateUtils.getNowDate());
        return yxLogMapper.insertYxLog(yxLog);
    }

    /**
     * 修改牙星公司
     * 
     * @param yxLog 牙星公司
     * @return 结果
     */
    @Override
    public int updateYxLog(YxLog yxLog)
    {
        yxLog.setUpdateTime(DateUtils.getNowDate());
        return yxLogMapper.updateYxLog(yxLog);
    }

    /**
     * 删除牙星公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYxLogByIds(String ids)
    {
        return yxLogMapper.deleteYxLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牙星公司信息
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    @Override
    public int deleteYxLogById(Long id)
    {
        return yxLogMapper.deleteYxLogById(id);
    }
}
