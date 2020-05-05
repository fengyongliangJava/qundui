package com.ruoyi.project.system.yx.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.yx.mapper.YxAllMapper;
import com.ruoyi.project.system.yx.domain.YxAll;
import com.ruoyi.project.system.yx.service.IYxAllService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-02
 */
@Service
public class YxAllServiceImpl implements IYxAllService 
{
    @Autowired
    private YxAllMapper yxAllMapper;

    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    @Override
    public YxAll selectYxAllById(Long id)
    {
        return yxAllMapper.selectYxAllById(id);
    }

    /**
     * 查询牙星公司列表
     * 
     * @param yxAll 牙星公司
     * @return 牙星公司
     */
    @Override
    public List<YxAll> selectYxAllList(YxAll yxAll)
    {
        return yxAllMapper.selectYxAllList(yxAll);
    }

    /**
     * 新增牙星公司
     * 
     * @param yxAll 牙星公司
     * @return 结果
     */
    @Override
    public int insertYxAll(YxAll yxAll)
    {
       // yxAll.setCreateTime(DateUtils.getNowDate());
        return yxAllMapper.insertYxAll(yxAll);
    }

    /**
     * 修改牙星公司
     * 
     * @param yxAll 牙星公司
     * @return 结果
     */
    @Override
    public int updateYxAll(YxAll yxAll)
    {
        yxAll.setUpdateTime(DateUtils.getNowDate());
        return yxAllMapper.updateYxAll(yxAll);
    }

    /**
     * 删除牙星公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYxAllByIds(String ids)
    {
        return yxAllMapper.deleteYxAllByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牙星公司信息
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    @Override
    public int deleteYxAllById(Long id)
    {
        return yxAllMapper.deleteYxAllById(id);
    }
}
