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
public class YxYue 
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

    /** 月薪类型 */
    @Excel(name = "月薪类型")
    private Integer moneyType;

    /** 月薪 */
    @Excel(name = "月薪")
    private BigDecimal userMoney;


  

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
    private BigDecimal workSum;
    
    private String createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
    
    
    
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(Integer moneyType) {
		this.moneyType = moneyType;
	}
	public BigDecimal getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(BigDecimal userMoney) {
		this.userMoney = userMoney;
	}
	public String getUserOrg() {
		return userOrg;
	}
	public void setUserOrg(String userOrg) {
		this.userOrg = userOrg;
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
	public BigDecimal getWorkSum() {
		return workSum;
	}
	public void setWorkSum(BigDecimal workSum) {
		this.workSum = workSum;
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
    
    
    
    
   
    

}
