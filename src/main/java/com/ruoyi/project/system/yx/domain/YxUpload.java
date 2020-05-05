package com.ruoyi.project.system.yx.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

/**
 * 牙星公司对象 yx
 * 
 * @author ruoyi
 * @date 2020-04-07
 */
public class YxUpload 
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

    /** 出勤状态 */
    @Excel(name = "出勤状态")
    private Integer workStart;

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
    @Excel(name = "个人工分")
    private Integer workFen;

    /** 零活工资*/
    @Excel(name = "零活工资")
    private BigDecimal workHuo;

  

    private BigDecimal workSum;
    private String createTimes;
    private String userOrg;

    private String sex;
    private String tell;
    private String card;
    private String address;
    private String userArea;
    private String userGroup;
    private String userClass;
    private String station;
    private String workType;
    private String workClass;
    
    private BigDecimal userCost;
    
    
    public BigDecimal getUserCost() {
		return userCost;
	}

	public void setUserCost(BigDecimal userCost) {
		this.userCost = userCost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
    
    
    
    
    
    public String getUserArea() {
		return userArea;
	}

	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	public String getCreateTimes() {
		return createTimes;
	}

	public void setCreateTimes(String createTimes) {
		this.createTimes = createTimes;
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


	public String getUserOrg() {
		return userOrg;
	}

	public void setUserOrg(String userOrg) {
		this.userOrg = userOrg;
	}

	public BigDecimal getWorkSum() {
		return workSum;
	}

	public void setWorkSum(BigDecimal workSum) {
		this.workSum = workSum;
	}

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
  
    
    
    
    
    public void setWorkStart(Integer workStart) 
    {
        this.workStart = workStart;
    }

    public Integer getWorkStart() 
    {
        return workStart;
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
   
    public void setWorkHuo(BigDecimal workHuo) 
    {
        this.workHuo = workHuo;
    }

    public BigDecimal getWorkHuo() 
    {
        return workHuo;
    }
    
    

    
	public String getCreateTime() {
		return createTimes;
	}

	public void setCreateTime(String createTime) {
		this.createTimes = createTime;
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
   
    

}
