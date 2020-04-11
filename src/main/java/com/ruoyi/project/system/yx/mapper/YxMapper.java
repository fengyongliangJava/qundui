package com.ruoyi.project.system.yx.mapper;

import java.util.List;

import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.yx.domain.Yx;

/**
 * 牙星公司Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public interface YxMapper 
{
    /**
     * 查询牙星公司
     * 
     * @param id 牙星公司ID
     * @return 牙星公司
     */
    public Yx selectYxById(Long id);

    /**
     * 查询牙星公司列表
     * 
     * @param yx 牙星公司
     * @return 牙星公司集合
     */
    public List<Yx> selectYxList(Yx yx);

    /**
     * 新增牙星公司
     * 
     * @param yx 牙星公司
     * @return 结果
     */
    public int insertYx(Yx yx);

    /**
     * 修改牙星公司
     * 
     * @param yx 牙星公司
     * @return 结果
     */
    public int updateYx(Yx yx);

    /**
     * 删除牙星公司
     * 
     * @param id 牙星公司ID
     * @return 结果
     */
    public int deleteYxById(Long id);

    /**
     * 批量删除牙星公司
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYxByIds(String[] ids);


    Dept selectDeptById();

    List<Ztree> selectDeptTree(Dept dept);

    List<Dept> selectDeptList(Dept dept);
}
