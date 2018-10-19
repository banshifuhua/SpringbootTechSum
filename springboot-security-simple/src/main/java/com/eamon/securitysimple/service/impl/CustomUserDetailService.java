package com.eamon.securitysimple.service.impl;

import com.eamon.securitysimple.dao.SysUserDao;
import com.eamon.securitysimple.entity.SysPermissionEntity;
import com.eamon.securitysimple.entity.SysRoleEntity;
import com.eamon.securitysimple.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author: eamon
 * @date: 2018/10/19 15:39
 * @description:
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    SysUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity userEntity = userDao.findByName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        // 获取用户的角色信息
        List<SysRoleEntity> roleEntityList = userEntity.getRoleEntityList();
        for (SysRoleEntity roleEntity : roleEntityList) {
            // 获取用户的权限信息
            Set<SysPermissionEntity> permissionList = roleEntity.getSysPermissionEntityList();
            for (SysPermissionEntity permission : permissionList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + permission.getName());
                authorities.add(grantedAuthority);
            }
        }

        return new User(userEntity.getName(), userEntity.getPassword(), authorities);
    }
}
