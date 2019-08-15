package com.eamon.springbootsecurityjwt.service;

import com.eamon.springbootsecurityjwt.dto.LoginForm;
import com.eamon.springbootsecurityjwt.dto.RegisterForm;
import com.eamon.springbootsecurityjwt.dto.ViewData;

/**
 * @author eamon
 * @date 2019/08/15 15:34
 **/
public interface UserService {
    /**
     * 注册
     *
     * @param registerForm
     * @return
     */
    ViewData register(RegisterForm registerForm);

    /**
     * 登录
     *
     * @param loginForm
     * @return
     */
    ViewData login(LoginForm loginForm);
}
