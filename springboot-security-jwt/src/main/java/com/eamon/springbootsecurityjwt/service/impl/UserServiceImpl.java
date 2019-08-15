package com.eamon.springbootsecurityjwt.service.impl;

import com.eamon.springbootsecurityjwt.dao.UserDao;
import com.eamon.springbootsecurityjwt.dto.LoginForm;
import com.eamon.springbootsecurityjwt.dto.RegisterForm;
import com.eamon.springbootsecurityjwt.dto.ViewData;
import com.eamon.springbootsecurityjwt.model.User;
import com.eamon.springbootsecurityjwt.service.UserService;
import com.eamon.springbootsecurityjwt.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author eamon
 * @date 2019/08/15 15:34
 **/
@Service
public class UserServiceImpl implements UserService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    UserDao userDao;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public ViewData register(RegisterForm registerForm) {
        ViewData<String> viewData = new ViewData<>();
        String username = registerForm.getUsername();
        String password = registerForm.getPassword();

        User exist = userDao.findByUsername(username);
        if (exist != null) {
            viewData.setCode(-1);
            viewData.setError("用户已存在！");
            return viewData;
        }
        String encodePassword = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodePassword);
        userDao.save(user);
        viewData.setCode(1);
        viewData.setData("注册成功！");
        return viewData;
    }

    @Override
    public ViewData login(LoginForm loginForm) {
        ViewData viewData = new ViewData();
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String detailsPassword = userDetails.getPassword();
        if (!passwordEncoder.matches(password, detailsPassword)) {
            throw new BadCredentialsException("密码不正确！");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        viewData.setCode(1);
        viewData.setData(tokenMap);
        return viewData;
    }
}
