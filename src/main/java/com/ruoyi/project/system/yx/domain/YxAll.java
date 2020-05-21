package com.ruoyi.project.system.yx.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

/**
 * 牙星公司对象 yx_all
 * 
 * @author ruoyi
 * @date 2020-05-02
 */
public class YxAll 
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
    private String sex;

    /** 联系方式 */
    private String tell;

    /** 身份证 */
    private String card;

    /** 户籍所在地 */
    private String address;

    /** 单位 */
    private String userOrg;

    /** 部门 */
    private String userArea;

    /** 区队 */
    private String userGroup;

    /** 班组 */
    private String userClass;

    /** 岗位 */
    private String station;

    /** 工资种类 */
    private String workType;

    /** 工资类型 */
    private String workClass;

    
    

    /** 应出勤天数 */
    @Excel(name = "应出勤天数")
    private Integer countDay;

    /** 满勤工资 */
    @Excel(name = "满勤工资")
    private BigDecimal countMoney;

    /** 请假天数 */
    @Excel(name = "请假天数")
    private Integer sumDay;

    private BigDecimal sumMoney;
    private Integer allDay;
    
    @Excel(name = "加班天数")
    private Integer workPlus;
    
    @Excel(name = "加班工资")
    private BigDecimal workCost;
    
    @Excel(name = "其他补助")
    private BigDecimal other;
    
    
    
    private BigDecimal userCost;
    private BigDecimal fu;
    private BigDecimal userMoney;
    private String createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
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
        this.userName= userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    
    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserArea() {
		return userArea;
	}

	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkClass() {
		return workClass;
	}

	public void setWorkClass(String workClass) {
		this.workClass = workClass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserOrg() {
		return userOrg;
	}

	public void setUserOrg(String userOrg) {
		this.userOrg = userOrg;
	}
	
	public void setCountDay(Integer countDay) 
    {
        this.countDay = countDay;
    }

    public Integer getCountDay() 
    {
        return countDay;
    }
    public void setCountMoney(BigDecimal countMoney) 
    {
        this.countMoney = countMoney;
    }

    public BigDecimal getCountMoney() 
    {
        return countMoney;
    }
    public void setSumDay(Integer sumDay) 
    {
        this.sumDay = sumDay;
    }

    public Integer getSumDay() 
    {
        return sumDay;
    }
    public void setSumMoney(BigDecimal sumMoney) 
    {
        this.sumMoney = sumMoney;
    }

    public BigDecimal getSumMoney() 
    {
        return sumMoney;
    }
    public void setAllDay(Integer allDay) 
    {
        this.allDay = allDay;
    }

    public Integer getAllDay() 
    {
        return allDay;
    }
    public void setWorkPlus(Integer workPlus) 
    {
        this.workPlus = workPlus;
    }

    public Integer getWorkPlus() 
    {
        return workPlus;
    }
    public void setWorkCost(BigDecimal workCost) 
    {
        this.workCost = workCost;
    }

    public BigDecimal getWorkCost() 
    {
        return workCost;
    }
    public void setOther(BigDecimal other) 
    {
        this.other = other;
    }

    public BigDecimal getOther() 
    {
        return other;
    }
    public void setUserCost(BigDecimal userCost) 
    {
        this.userCost = userCost;
    }

    public BigDecimal getUserCost() 
    {
        return userCost;
    }
    public void setFu(BigDecimal fu) 
    {
        this.fu = fu;
    }

    public BigDecimal getFu() 
    {
        return fu;
    }
    public void setUserMoney(BigDecimal userMoney) 
    {
        this.userMoney = userMoney;
    }

    public BigDecimal getUserMoney() 
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
            .append("countDay", getCountDay())
            .append("countMoney", getCountMoney())
            .append("sumDay", getSumDay())
            .append("sumMoney", getSumMoney())
            .append("allDay", getAllDay())
            .append("workPlus", getWorkPlus())
            .append("workCost", getWorkCost())
            .append("other", getOther())
            .append("userCost", getUserCost())
            .append("fu", getFu())
            .append("userMoney", getUserMoney())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
