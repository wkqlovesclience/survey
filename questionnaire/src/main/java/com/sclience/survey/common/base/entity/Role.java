package com.sclience.survey.common.base.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-06 17:49:17
 */
@Entity
@Table(name = "t_role")
public class Role extends IdEntity{
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description" )
    private String description;
    @ManyToMany(targetEntity = User.class,mappedBy = "roles")//让user维护外键表
    @Cascade(CascadeType.ALL)
    private Set<User> users = new HashSet<User>();

    @ManyToMany(targetEntity = Permission.class)
    // 使用JoinTable来描述中间表，并描述中间表中外键与Student,Teacher的映射关系
    // joinColumns它是用来描述Student与中间表中的映射关系
    // inverseJoinColums它是用来描述Teacher与中间表中的映射关系
    @JoinTable(name = "t_role_permission",
            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id",referencedColumnName = "id")})
    private Set<Permission> permissions = new HashSet<Permission>();

    public Role() {
    }

    public Role(String roleName, String description, Set<User> users, Set<Permission> permissions) {
        this.roleName = roleName;
        this.description = description;
        this.users = users;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                '}';
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
