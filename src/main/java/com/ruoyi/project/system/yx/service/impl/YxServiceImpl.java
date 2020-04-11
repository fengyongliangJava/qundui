package com.ruoyi.project.system.yx.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.system.dept.domain.Dept;
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

    /**
     * 查询部门管理树
     *
     * @param dept 部门信息
     * @return 所有部门信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectDeptTree(Dept dept)
    {
        List<Dept> deptList = yxMapper.selectDeptList(dept);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }
    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList)
    {
        return initZtree(deptList, null);
    }

    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList, List<String> roleDeptList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (Dept dept : deptList)
        {
            if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(dept.getDeptId());
                ztree.setpId(dept.getParentId());
                ztree.setName(dept.getDeptName());
                ztree.setTitle(dept.getDeptName());
                if (isCheck)
                {
                    ztree.setChecked(roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }


}
