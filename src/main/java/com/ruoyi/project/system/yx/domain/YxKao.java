package com.ruoyi.project.system.yx.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

/**
 * 部门对象 yx_kao
 * 
 * @author ruoyi
 * @date 2020-04-27
 */
public class YxKao 
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    private Long deptId;

    /** 父部门id */
    @Excel(name = "父部门id")
    private Long parentId;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Integer deptNum;

    /** 部门人数 */
    @Excel(name = "部门人数")
    private String userCost;

    /** 计划工资 */
    @Excel(name = "计划工资")
    private String userMoney;
    
    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createTime;
    
    /** 创建者 */
    @Excel(name = "创建者")
    private String createBy;
    
    /** 更新时间 */
    @Excel(name = "更新时间")
    private Date updateTime;
    
    /** 更新者 */
    @Excel(name = "更新者")
    private String updateBy;
    
    
    

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setAncestors(String ancestors) 
    {
        this.ancestors = ancestors;
    }

    public String getAncestors() 
    {
        return ancestors;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setDeptNum(Integer deptNum) 
    {
        this.deptNum = deptNum;
    }

    public Integer getDeptNum() 
    {
        return deptNum;
    }
    public void setUserCost(String userCost) 
    {
        this.userCost = userCost;
    }

    public String getUserCost() 
    {
        return userCost;
    }
    public void setUserMoney(String userMoney) 
    {
        this.userMoney = userMoney;
    }

    public String getUserMoney() 
    {
        return userMoney;
    }

   
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
    
    
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("deptName", getDeptName())
            .append("deptNum", getDeptNum())
            .append("userCost", getUserCost())
            .append("userMoney", getUserMoney())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }


}
