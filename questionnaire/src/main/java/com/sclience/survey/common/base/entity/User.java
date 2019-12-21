package com.sclience.survey.common.base.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="T_USER")
public class User extends IdEntity {
    /**
     *  unique : 对应的是唯一性，唯一约束，
     *  name   : 对应的是数据库表对应的字段名
     *  nullable :  是否可以为空
     */
    @Column(name = "login_name",unique = true,nullable = false)
    private String loginName;
    @Column(name = "sha_password",nullable = false)
    private String shaPassword;
    //用户名
    @Column(name = "name",nullable = false)
    private String name;
    //邮箱
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    //出生年月
    @Column(name = "birthday")
    private Date birthday;
    //最高学历
    @Column(name = "edu_quali")
    private Integer eduQuali;
    //性别
    @Column(name = "sex")
    private Integer sex;

    //2激活 1未激活 0不可用
    @Column(name = "status")
    private Integer status=1;// 账号状态
    @Column(name = "version")
    private Integer version = 1;//1 默认 2测试
    @Column(name = "create_time")
    private Date createTime = new Date();
    @Column(name = "create_by")
    private String createBy = "";
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "cellphone",unique = true)
    private String cellphone;

    //激活账号CODE
    @Column(name = "activation_code")
    private String activationCode;
    //找回密码code   ""或null表示没有激活找回密码功能
    private String findPwdCode;
    //找回密码最后期限  默认设置一天之内
    @Column(name = "find_pwd_last_date")
    private Date findPwdLastDate;

    //加点盐
    @Column(name = "salt")
    private String salt;

    @ManyToMany(targetEntity = Role.class)
    // 使用JoinTabl来描述中间表，并描述中间表中外键与Student,Teacher的映射关系
    // joinColumns它是用来描述Student与中间表中的映射关系
    // inverseJoinColums它是用来描述Teacher与中间表中的映射关系
    @JoinTable(name = "t_user_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private Set<Role> roles = new HashSet<Role>();
    public User() {
    }

    public User(String loginName, String shaPassword, String name, String email, Date birthday, Integer eduQuali, Integer sex, Integer status, Integer version, Date createTime, String createBy, Date lastLoginTime, String cellphone, String activationCode, String findPwdCode, Date findPwdLastDate, String salt, Set<Role> roles) {
        this.loginName = loginName;
        this.shaPassword = shaPassword;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.eduQuali = eduQuali;
        this.sex = sex;
        this.status = status;
        this.version = version;
        this.createTime = createTime;
        this.createBy = createBy;
        this.lastLoginTime = lastLoginTime;
        this.cellphone = cellphone;
        this.activationCode = activationCode;
        this.findPwdCode = findPwdCode;
        this.findPwdLastDate = findPwdLastDate;
        this.salt = salt;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getShaPassword() {
        return shaPassword;
    }

    public void setShaPassword(String shaPassword) {
        this.shaPassword = shaPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getEduQuali() {
        return eduQuali;
    }

    public void setEduQuali(Integer eduQuali) {
        this.eduQuali = eduQuali;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getFindPwdCode() {
        return findPwdCode;
    }

    public void setFindPwdCode(String findPwdCode) {
        this.findPwdCode = findPwdCode;
    }

    public Date getFindPwdLastDate() {
        return findPwdLastDate;
    }

    public void setFindPwdLastDate(Date findPwdLastDate) {
        this.findPwdLastDate = findPwdLastDate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", shaPassword='" + shaPassword + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", eduQuali=" + eduQuali +
                ", sex=" + sex +
                ", status=" + status +
                ", version=" + version +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", cellphone='" + cellphone + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", findPwdCode='" + findPwdCode + '\'' +
                ", findPwdLastDate=" + findPwdLastDate +
                ", salt='" + salt + '\'' +
                ", roles=" + roles +
                '}';
    }
}
