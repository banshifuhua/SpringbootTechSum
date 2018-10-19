package com.eamon.securitysimple.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author: eamon
 * @date: 2018/10/19 10:14
 * @description: 权限表
 */
@Entity
@Table(name = "sys_permission")
public class SysPermissionEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "url")
    private String url;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "pid")
    private String pid;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_permission_role",
            joinColumns = {@JoinColumn(name = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<SysRoleEntity> sysRoleEntityList;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<SysRoleEntity> getSysRoleEntityList() {
        return sysRoleEntityList;
    }

    public void setSysRoleEntityList(List<SysRoleEntity> sysRoleEntityList) {
        this.sysRoleEntityList = sysRoleEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysPermissionEntity that = (SysPermissionEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(description, that.description) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(sysRoleEntityList, that.sysRoleEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, description, pid, sysRoleEntityList);
    }
}
