package com.sclience.survey.common.base.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-07 12:33:23
 */
@Entity
@Table(name = "t_permission")
public class Permission extends IdEntity{
    //权限名称
    @Column(name = "permission_name")
    private String permissionName;
    @Column(name = "validateurl",nullable = true)
    private String validateurl;

    @ManyToMany(targetEntity = Role.class,mappedBy = "permissions")//让Role维护外键表
    @Cascade(CascadeType.ALL)
    private Set<Role> roles = new HashSet<Role>();

    public Permission() {
    }

    public Permission(String permissionName, String validateurl, Set<Role> roles) {
        this.permissionName = permissionName;
        this.validateurl = validateurl;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionName='" + permissionName + '\'' +
                ", validateurl='" + validateurl + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getValidateurl() {
        return validateurl;
    }

    public void setValidateurl(String validateurl) {
        this.validateurl = validateurl;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
