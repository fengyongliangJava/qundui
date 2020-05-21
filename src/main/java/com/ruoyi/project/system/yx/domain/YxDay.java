package com.ruoyi.project.system.yx.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

/**
 * 牙星公司对象 yx
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public class YxDay 
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 员工工号 */
    @Excel(name = "员工工号")
    private String userId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String userName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String tell;

    /** 身份证 */
    @Excel(name = "身份证")
    private String card;

    /** 户籍所在地 */
    @Excel(name = "户籍所在地")
    private String address;

    /** 单位 */
    @Excel(name = "单位")
    private String userOrg;

    /** 部门 */
    @Excel(name = "部门")
    private String userArea;

    /** 区队 */
    @Excel(name = "区队")
    private String userGroup;

    /** 班组 */
    @Excel(name = "班组")
    private String userClass;

    /** 岗位 */
    @Excel(name = "岗位")
    private String station;

    /** 工资种类 */
    @Excel(name = "工资种类")
    private String workType;

    /** 工资类型 */
    @Excel(name = "工资类型")
    private String workClass;

	/** 出勤状态 */
    @Excel(name = "出勤状态")
    private String workStart;
    
	/** 出勤状态 */
    @Excel(name = "班次")
    private String sanClass;
    
    /** 产量 */
    @Excel(name = "产量")
    private Integer workNumber;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal workPrice;

    /** 总工分 */
    @Excel(name = "总工分")
    private Integer workAll;

    /** 工分 */
    @Excel(name = "工分")
    private Integer workFen;

   /** 计件工资*/
    @Excel(name = "计件工资")
    private BigDecimal workSum;
    
    /** 零活工资*/
    @Excel(name = "零活工资")
    private BigDecimal workHuo;
    
    /** 单项工程*/
    @Excel(name = "单项工程")
    private BigDecimal workDan; 
    
   /** 计算工资*/
    @Excel(name = "计划工资")
    private BigDecimal userCost;

    
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

    /** 备注 */
    @Excel(name = "备注")
    private String remark;
    

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
   public void setTell(String tell) 
    {
        this.tell = tell;
    }

    public String getTell() 
    {
        return tell;
    }
    public void setCard(String card) 
    {
        this.card = card;
    }

    public String getCard() 
    {
        return card;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setUserOrg(String userOrg) 
    {
        this.userOrg = userOrg;
    }

    public String getUserOrg() 
    {
        return userOrg;
    }
    public void setUserArea(String userArea) 
    {
        this.userArea = userArea;
    }

    public String getUserArea() 
    {
        return userArea;
    }
    public void setUserGroup(String userGroup) 
    {
        this.userGroup = userGroup;
    }

    public String getUserGroup() 
    {
        return userGroup;
    }
    public void setUserClass(String userClass) 
    {
        this.userClass = userClass;
    }

    public String getUserClass() 
    {
        return userClass;
    }
    public void setStation(String station) 
    {
        this.station = station;
    }

    public String getStation() 
    {
        return station;
    }
    public void setWorkType(String workType) 
    {
        this.workType = workType;
    }

    public String getWorkType() 
    {
        return workType;
    }
    public void setWorkClass(String workClass) 
    {
        this.workClass = workClass;
    }

    public String getWorkClass() 
    {
        return workClass;
    }
    
    public void setWorkStart(String workStart) 
    {
        this.workStart = workStart;
    }

    public String getWorkStart() 
    {
        return workStart;
    }
    
    public void setSanClass(String sanClass) 
    {
        this.sanClass = sanClass;
    }

    public String getSanClass() 
    {
        return sanClass;
    }
    
    public void setWorkNumber(Integer workNumber) 
    {
        this.workNumber = workNumber;
    }

    public Integer getWorkNumber() 
    {
        return workNumber;
    }
    public void setWorkPrice(BigDecimal workPrice) 
    {
        this.workPrice = workPrice;
    }

    public BigDecimal getWorkPrice() 
    {
        return workPrice;
    }
    public void setWorkAll(Integer workAll) 
    {
        this.workAll = workAll;
    }

    public Integer getWorkAll() 
    {
        return workAll;
    }
    public void setWorkFen(Integer workFen) 
    {
        this.workFen = workFen;
    }

    public Integer getWorkFen() 
    {
        return workFen;
    }
    public void setWorkSum(BigDecimal workSum) 
    {
        this.workSum = workSum;
    }

    public BigDecimal getWorkSum() 
    {
        return workSum;
    }
    public void setWorkHuo(BigDecimal workHuo) 
    {
        this.workHuo = workHuo;
    }

    public BigDecimal getWorkHuo() 
    {
        return workHuo;
    }
    
    public void setWorkDan(BigDecimal workDan) 
    {
        this.workDan = workDan;
    }

    public BigDecimal getWorkDan() 
    {
        return workDan;
    }


    public void setUserCost(BigDecimal userCost) 
    {
        this.userCost = userCost;
    }

    public BigDecimal getUserCost() 
    {
        return userCost;
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("sex", getSex())
            .append("tell", getTell())
            .append("card", getCard())
            .append("address", getAddress())
            .append("userOrg", getUserOrg())
            .append("userArea", getUserArea())
            .append("userGroup", getUserGroup())
            .append("userClass", getUserClass())
            .append("station", getStation())
            .append("workType", getWorkType())
            .append("workClass", getWorkClass())
            .append("workStart", getWorkStart())
            .append("sanClass", getSanClass())
            .append("workNumber", getWorkNumber())
            .append("workPrice", getWorkPrice())
            .append("workAll", getWorkAll())
            .append("workFen", getWorkFen())
            .append("workSum", getWorkSum())
            .append("workHuo", getWorkHuo())
            .append("workHuo", getWorkDan())
            .append("userCost", getUserCost())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
    
    
    
    
}
