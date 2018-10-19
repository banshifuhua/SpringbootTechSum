package com.eamon.springbootsercurityoauth2.dao;

import com.eamon.springbootsercurityoauth2.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: eamon
 * @date: 2018/10/19 13:37
 * @description:
 */
@Repository
public interface SysUserDao extends JpaRepository<SysUserEntity, Long> {

    /**
     * 通过用户名获取用户信息
     *
     * @param username
     * @return
     */
    SysUserEntity findByName(String username);
}
