package com.ruoyi.project.system.yx.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;

/**
 * 牙星公司对象 yx_log
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public class YxLog
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

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String tell;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String card;

    /** 户籍所在地 */
    @Excel(name = "户籍所在地")
    private String address;

    /** 单位 */
    @Excel(name = "单位")
    private String userOrg;

    /** 科室 */
    @Excel(name = "科室")
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

    /** 出勤天数 */
    @Excel(name = "出勤天数")
    private Integer countDay;

    /** 计件工资 */
    @Excel(name = "计件工资")
    private BigDecimal workSum;

    /** 零活工资 */
    @Excel(name = "零活工资")
    private BigDecimal workHuo;

    /** 考核 */
    @Excel(name = "考核")
    private Integer kaohe;

    /** 煤质考核 */
    @Excel(name = "煤质考核")
    private Integer meiKaohe;

    /** 早会 */
    @Excel(name = "早会")
    private Integer meeting;

    /** 年休假天数 */
    @Excel(name = "年休假天数")
    private Integer yearsHolidays;

    /** 年休假工资 */
    @Excel(name = "年休假工资")
    private Integer yearsCost;

    /** 春节休假天数 */
    @Excel(name = "春节休假天数")
    private Integer yearDay;

    /** 春节休假工资 */
    @Excel(name = "春节休假工资")
    private Integer yearCost;

    /** 春节上班 */
    @Excel(name = "春节上班")
    private Integer yearWork;

    /** 春节上班工资 */
    @Excel(name = "春节上班工资")
    private Integer yearSum;

    /** 春节值班天数 */
    @Excel(name = "春节值班天数")
    private Integer yearPlus;

    /** 春节值班工资 */
    @Excel(name = "春节值班工资")
    private Integer yearDuty;

    /** 加班天数 */
    @Excel(name = "加班天数")
    private Integer workPlus;

    /** 加班工资 */
    @Excel(name = "加班工资")
    private Integer workCost;

    /** 法定天数 */
    @Excel(name = "法定天数")
    private Integer lawDay;

    /** 法定工资 */
    @Excel(name = "法定工资")
    private Integer lawCost;

    /** 公休天数 */
    @Excel(name = "公休天数")
    private Integer busDay;

    /** 公休工资 */
    @Excel(name = "公休工资")
    private Integer busCost;

    /** 延时加班工资 */
    @Excel(name = "延时加班工资")
    private Integer busPlus;

    /** 女工费 */
    @Excel(name = "女工费")
    private Integer woman;

    /** 入井费 */
    @Excel(name = "入井费")
    private Integer run;

    /** 夜班补助 */
    @Excel(name = "夜班补助")
    private Integer ye;

    /** 矿井处罚 */
    @Excel(name = "矿井处罚")
    private Integer kuangji;

    /** 护理假天数 */
    @Excel(name = "护理假天数")
    private Integer huliDay;

    /** 护理假工资 */
    @Excel(name = "护理假工资")
    private Integer huliCost;

    /** 工伤假天数 */
    @Excel(name = "工伤假天数")
    private Integer gsDay;

    /** 工伤假工资 */
    @Excel(name = "工伤假工资")
    private Integer gsCost;

    /** 探亲假天数 */
    @Excel(name = "探亲假天数")
    private Integer tqDay;

    /** 探亲工资 */
    @Excel(name = "探亲工资")
    private Integer tqCost;

    /** 病假天数 */
    @Excel(name = "病假天数")
    private Integer bingDay;

    /** 病假工资 */
    @Excel(name = "病假工资")
    private Integer bingCost;

    /** 丧假天数 */
    @Excel(name = "丧假天数")
    private Integer sangDay;

    /** 丧假工资 */
    @Excel(name = "丧假工资")
    private Integer sangCost;

    /** 事假天数 */
    @Excel(name = "事假天数")
    private Integer sjDay;

    /** 旷工天数 */
    @Excel(name = "旷工天数")
    private Integer kgDay;

    /** 待岗天数 */
    @Excel(name = "待岗天数")
    private Integer dgDay;

    /** 其它补助 */
    @Excel(name = "其它补助")
    private Integer other;

    /** 计算工资 */
    @Excel(name = "计算工资")
    private BigDecimal userCost;

    /** 浮动比例 */
    @Excel(name = "浮动比例")
    private BigDecimal fu;

    /** 实发工资 */
    @Excel(name = "实发工资")
    private BigDecimal userMoney;

    
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
    public void setCountDay(Integer countDay) 
    {
        this.countDay = countDay;
    }

    public Integer getCountDay() 
    {
        return countDay;
    }
    
    public BigDecimal getWorkSum() {
		return workSum;
	}

	public void setWorkSum(BigDecimal workSum) {
		this.workSum = workSum;
	}

	public BigDecimal getWorkHuo() {
		return workHuo;
	}

	public void setWorkHuo(BigDecimal workHuo) {
		this.workHuo = workHuo;
	}

	public void setKaohe(Integer kaohe) 
    {
        this.kaohe = kaohe;
    }

    public Integer getKaohe() 
    {
        return kaohe;
    }
    public void setMeiKaohe(Integer meiKaohe) 
    {
        this.meiKaohe = meiKaohe;
    }

    public Integer getMeiKaohe() 
    {
        return meiKaohe;
    }
    public void setMeeting(Integer meeting) 
    {
        this.meeting = meeting;
    }

    public Integer getMeeting() 
    {
        return meeting;
    }
    public void setYearsHolidays(Integer yearsHolidays) 
    {
        this.yearsHolidays = yearsHolidays;
    }

    public Integer getYearsHolidays() 
    {
        return yearsHolidays;
    }
    public void setYearsCost(Integer yearsCost) 
    {
        this.yearsCost = yearsCost;
    }

    public Integer getYearsCost() 
    {
        return yearsCost;
    }
    public void setYearDay(Integer yearDay) 
    {
        this.yearDay = yearDay;
    }

    public Integer getYearDay() 
    {
        return yearDay;
    }
    public void setYearCost(Integer yearCost) 
    {
        this.yearCost = yearCost;
    }

    public Integer getYearCost() 
    {
        return yearCost;
    }
    public void setYearWork(Integer yearWork) 
    {
        this.yearWork = yearWork;
    }

    public Integer getYearWork() 
    {
        return yearWork;
    }
    public void setYearSum(Integer yearSum) 
    {
        this.yearSum = yearSum;
    }

    public Integer getYearSum() 
    {
        return yearSum;
    }
    public void setYearPlus(Integer yearPlus) 
    {
        this.yearPlus = yearPlus;
    }

    public Integer getYearPlus() 
    {
        return yearPlus;
    }
    public void setYearDuty(Integer yearDuty) 
    {
        this.yearDuty = yearDuty;
    }

    public Integer getYearDuty() 
    {
        return yearDuty;
    }
    public void setWorkPlus(Integer workPlus) 
    {
        this.workPlus = workPlus;
    }

    public Integer getWorkPlus() 
    {
        return workPlus;
    }
    public void setWorkCost(Integer workCost) 
    {
        this.workCost = workCost;
    }

    public Integer getWorkCost() 
    {
        return workCost;
    }
    public void setLawDay(Integer lawDay) 
    {
        this.lawDay = lawDay;
    }

    public Integer getLawDay() 
    {
        return lawDay;
    }
    public void setLawCost(Integer lawCost) 
    {
        this.lawCost = lawCost;
    }

    public Integer getLawCost() 
    {
        return lawCost;
    }
    public void setBusDay(Integer busDay) 
    {
        this.busDay = busDay;
    }

    public Integer getBusDay() 
    {
        return busDay;
    }
    public void setBusCost(Integer busCost) 
    {
        this.busCost = busCost;
    }

    public Integer getBusCost() 
    {
        return busCost;
    }
    public void setBusPlus(Integer busPlus) 
    {
        this.busPlus = busPlus;
    }

    public Integer getBusPlus() 
    {
        return busPlus;
    }
    public void setWoman(Integer woman) 
    {
        this.woman = woman;
    }

    public Integer getWoman() 
    {
        return woman;
    }
    public void setRun(Integer run) 
    {
        this.run = run;
    }

    public Integer getRun() 
    {
        return run;
    }
    public void setYe(Integer ye) 
    {
        this.ye = ye;
    }

    public Integer getYe() 
    {
        return ye;
    }
    public void setKuangji(Integer kuangji) 
    {
        this.kuangji = kuangji;
    }

    public Integer getKuangji() 
    {
        return kuangji;
    }
    public void setHuliDay(Integer huliDay) 
    {
        this.huliDay = huliDay;
    }

    public Integer getHuliDay() 
    {
        return huliDay;
    }
    public void setHuliCost(Integer huliCost) 
    {
        this.huliCost = huliCost;
    }

    public Integer getHuliCost() 
    {
        return huliCost;
    }
    public void setGsDay(Integer gsDay) 
    {
        this.gsDay = gsDay;
    }

    public Integer getGsDay() 
    {
        return gsDay;
    }
    public void setGsCost(Integer gsCost) 
    {
        this.gsCost = gsCost;
    }

    public Integer getGsCost() 
    {
        return gsCost;
    }
    public void setTqDay(Integer tqDay) 
    {
        this.tqDay = tqDay;
    }

    public Integer getTqDay() 
    {
        return tqDay;
    }
    public void setTqCost(Integer tqCost) 
    {
        this.tqCost = tqCost;
    }

    public Integer getTqCost() 
    {
        return tqCost;
    }
    public void setBingDay(Integer bingDay) 
    {
        this.bingDay = bingDay;
    }

    public Integer getBingDay() 
    {
        return bingDay;
    }
    public void setBingCost(Integer bingCost) 
    {
        this.bingCost = bingCost;
    }

    public Integer getBingCost() 
    {
        return bingCost;
    }
    public void setSangDay(Integer sangDay) 
    {
        this.sangDay = sangDay;
    }

    public Integer getSangDay() 
    {
        return sangDay;
    }
    public void setSangCost(Integer sangCost) 
    {
        this.sangCost = sangCost;
    }

    public Integer getSangCost() 
    {
        return sangCost;
    }
    public void setSjDay(Integer sjDay) 
    {
        this.sjDay = sjDay;
    }

    public Integer getSjDay() 
    {
        return sjDay;
    }
    public void setKgDay(Integer kgDay) 
    {
        this.kgDay = kgDay;
    }

    public Integer getKgDay() 
    {
        return kgDay;
    }
    public void setDgDay(Integer dgDay) 
    {
        this.dgDay = dgDay;
    }

    public Integer getDgDay() 
    {
        return dgDay;
    }
    public void setOther(Integer other) 
    {
        this.other = other;
    }

    public Integer getOther() 
    {
        return other;
    }
    
    public BigDecimal getUserCost() {
		return userCost;
	}

	public void setUserCost(BigDecimal userCost) {
		this.userCost = userCost;
	}

	public BigDecimal getFu() {
		return fu;
	}

	public void setFu(BigDecimal fu) {
		this.fu = fu;
	}

	public BigDecimal getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(BigDecimal userMoney) {
		this.userMoney = userMoney;
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
            .append("workSum", getWorkSum())
            .append("workHuo", getWorkHuo())
            .append("kaohe", getKaohe())
            .append("meiKaohe", getMeiKaohe())
            .append("meeting", getMeeting())
            .append("yearsHolidays", getYearsHolidays())
            .append("yearsCost", getYearsCost())
            .append("yearDay", getYearDay())
            .append("yearCost", getYearCost())
            .append("yearWork", getYearWork())
            .append("yearSum", getYearSum())
            .append("yearPlus", getYearPlus())
            .append("yearDuty", getYearDuty())
            .append("workPlus", getWorkPlus())
            .append("workCost", getWorkCost())
            .append("lawDay", getLawDay())
            .append("lawCost", getLawCost())
            .append("busDay", getBusDay())
            .append("busCost", getBusCost())
            .append("busPlus", getBusPlus())
            .append("woman", getWoman())
            .append("run", getRun())
            .append("ye", getYe())
            .append("kuangji", getKuangji())
            .append("huliDay", getHuliDay())
            .append("huliCost", getHuliCost())
            .append("gsDay", getGsDay())
            .append("gsCost", getGsCost())
            .append("tqDay", getTqDay())
            .append("tqCost", getTqCost())
            .append("bingDay", getBingDay())
            .append("bingCost", getBingCost())
            .append("sangDay", getSangDay())
            .append("sangCost", getSangCost())
            .append("sjDay", getSjDay())
            .append("kgDay", getKgDay())
            .append("dgDay", getDgDay())
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
