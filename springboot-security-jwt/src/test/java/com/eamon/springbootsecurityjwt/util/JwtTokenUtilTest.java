package com.eamon.springbootsecurityjwt.util;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author eamon
 * @date 2019/08/15 14:17
 **/
public class JwtTokenUtilTest {


    @Test
    public void testGenerate(){
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return "123";
            }

            @Override
            public String getUsername() {
                return "eamon";
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
        String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println(token);
    }

}