package com.ruoyi.project.demo.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

public class UserOperateModel2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    
    
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
 
}