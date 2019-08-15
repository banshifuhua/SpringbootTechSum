package com.eamon.springbootsecurityjwt.controller;

import com.eamon.springbootsecurityjwt.dto.LoginForm;
import com.eamon.springbootsecurityjwt.dto.RegisterForm;
import com.eamon.springbootsecurityjwt.dto.ViewData;
import com.eamon.springbootsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eamon
 * @date 2019/08/15 15:32
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ViewData register(@RequestBody RegisterForm registerForm) {
        return userService.register(registerForm);
    }

    @PostMapping("/login")
    public ViewData login(@RequestBody LoginForm loginForm){
        return userService.login(loginForm);
    }



}
