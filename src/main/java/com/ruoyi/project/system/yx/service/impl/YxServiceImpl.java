package com.ruoyi.project.system.yx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.yx.mapper.YxMapper;
import com.ruoyi.project.system.yx.domain.Yx;
import com.ruoyi.project.system.yx.service.IYxService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
@Service
public class YxServiceImpl implements IYxService 
{
    @Autowired
    private YxMapper yxMapper;

    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    @Override
    public Yx selectYxById(Long id)
    {
        return yxMapper.selectYxById(id);
    }

    /**
     * 查询牙星公司列表
     * 
     * @param yx 牙星公司
     * @return 牙星公司
     */
    @Override
    public List<Yx> selectYxList(Yx yx)
    {
        return yxMapper.selectYxList(yx);
    }

    /**
     * 新增牙星公司
     * 
     * @param yx 牙星公司
     * @return 结果
     */
    @Override
    public int insertYx(Yx yx)
    {
        yx.setCreateTime(DateUtils.getNowDate());
        return yxMapper.insertYx(yx);
    }

    /**
     * 修改牙星公司
     * 
     * @param yx 牙星公司
     * @return 结果
     */
    @Override
    public int updateYx(Yx yx)
    {
        yx.setUpdateTime(DateUtils.getNowDate());
        return yxMapper.updateYx(yx);
    }

    /**
     * 删除牙星公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYxByIds(String ids)
    {
        return yxMapper.deleteYxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牙星公司信息
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    @Override
    public int deleteYxById(Long id)
    {
        return yxMapper.deleteYxById(id);
    }
}
