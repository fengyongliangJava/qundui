package com.ruoyi.project.system.yx.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.project.system.yx.mapper.YxDayMapper;
import com.ruoyi.project.system.yx.mapper.YxYueMapper;
import com.ruoyi.project.system.yx.domain.YxAll;
import com.ruoyi.project.system.yx.domain.YxYue;
import com.ruoyi.project.system.yx.service.IYxYueService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 牙星公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Service
public class YxYueServiceImpl implements IYxYueService 
{
    @Autowired
    private YxYueMapper yxYueMapper;
    
	@Autowired
    private YxDayMapper yxDayMapper;

    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    @Override
    public YxYue selectYxYueById(Long id)
    {
        return yxYueMapper.selectYxYueById(id);
    }

    /**
     * 查询牙星公司列表
     * 
     * @param yxYue 牙星公司
     * @return 牙星公司
     */
    @Override
    public List<YxYue> selectYxYueList(YxYue yxYue)
    {
        return yxYueMapper.selectYxYueList(yxYue);
    }
    
    @Override
    public List<YxYue> selectYxAllList(YxYue yxYue)
    {
        return yxYueMapper.selectYxAllList(yxYue);
    }
    
    @Override
    public List<YxYue> selectYxList(YxYue yxYue)
    {
        return yxYueMapper.selectYxList(yxYue);
    }

    /**
     * 新增牙星公司
     * 
     * @param yxYue 牙星公司
     * @return 结果
     */
    @Override
    public int insertYxYue(YxYue yxYue)
    {
/*      	 yxYue.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	 yxYue.setUpdateTime(DateUtils.getNowDate());
    	 yxYue.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxYueMapper.insertYxYue(yxYue);
    }

    
    
    @Override
    public int insertYxAll(YxAll yxAll)
    {

    	 
    	 
     	Map<String, String> selectYx = yxDayMapper.selectYx(yxAll.getUserId());
    	
     	if(!(selectYx == null || selectYx.isEmpty())) {
          yxAll.setSex(selectYx.get("sex"));
 	   	 yxAll.setTell(selectYx.get("tell"));
 	   	 yxAll.setCard(selectYx.get("card"));
 	   	 yxAll.setAddress(selectYx.get("address"));
 	   	 yxAll.setUserOrg(selectYx.get("userOrg"));
 	   	 yxAll.setUserGroup(selectYx.get("userGroup"));
 	   	 yxAll.setUserArea(selectYx.get("userArea"));
 	   	 yxAll.setUserClass(selectYx.get("userClass"));
 	   	 yxAll.setStation(selectYx.get("userClass"));
 	   	 yxAll.setWorkType(selectYx.get("workType"));
 	   	 yxAll.setWorkClass(selectYx.get("workClass"));
/* 	   	 yxAll.setCreateBy(ShiroUtils.getSysUser().getLoginName());
     	 yxAll.setUpdateTime(DateUtils.getNowDate());
     	 yxAll.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
         return yxYueMapper.insertYxAll(yxAll);
     	}
     	return  0;
    	 
    	 
    	 
    	 
    	 
    
    }
    
    
    /**
     * 修改牙星公司
     * 
     * @param yxYue 牙星公司
     * @return 结果
     */
    @Override
    public int updateYxYue(YxYue yxYue)
    {
  /*    	 yxYue.setCreateBy(ShiroUtils.getSysUser().getLoginName());
    	 yxYue.setUpdateTime(DateUtils.getNowDate());
    	 yxYue.setUpdateBy(ShiroUtils.getSysUser().getLoginName());*/
        return yxYueMapper.updateYxYue(yxYue);
    }

    /**
     * 删除牙星公司对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYxYueByIds(String ids)
    {
        return yxYueMapper.deleteYxYueByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除牙星公司信息
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    @Override
    public int deleteYxYueById(Long id)
    {
        return yxYueMapper.deleteYxYueById(id);
    }
}
