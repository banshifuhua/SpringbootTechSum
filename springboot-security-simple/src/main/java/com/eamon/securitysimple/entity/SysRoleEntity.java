package com.eamon.securitysimple.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author: eamon
 * @date: 2018/10/19 10:12
 * @description: 角色表
 */
@Entity
@Table(name = "sys_role")
public class SysRoleEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_user",
            joinColumns = {@JoinColumn(name = "sys_role_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_user_id")})
    private Set<SysUserEntity> userEntityList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_permission_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<SysPermissionEntity> sysPermissionEntityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SysUserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(Set<SysUserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public Set<SysPermissionEntity> getSysPermissionEntityList() {
        return sysPermissionEntityList;
    }

    public void setSysPermissionEntityList(Set<SysPermissionEntity> sysPermissionEntityList) {
        this.sysPermissionEntityList = sysPermissionEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleEntity that = (SysRoleEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(userEntityList, that.userEntityList) &&
                Objects.equals(sysPermissionEntityList, that.sysPermissionEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userEntityList, sysPermissionEntityList);
    }
}
