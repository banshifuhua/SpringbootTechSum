package com.eamon.springbootsercurityoauth2.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author: eamon
 * @date: 2018/10/19 10:06
 * @description: 用户表
 */
@Entity
@Table(name = "sys_user", schema = "oauth")
public class SysUserEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_user",
            joinColumns = {@JoinColumn(name = "Sys_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_role_id")})
    private List<SysRoleEntity> roleEntityList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRoleEntity> getRoleEntityList() {
        return roleEntityList;
    }

    public void setRoleEntityList(List<SysRoleEntity> roleEntityList) {
        this.roleEntityList = roleEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserEntity that = (SysUserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(roleEntityList, that.roleEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, roleEntityList);
    }
}
