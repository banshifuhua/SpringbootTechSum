package com.eamon.springbootsecurityjwt.dto;

import lombok.Data;

/**
 * @author eamon
 * @date 2019/08/15 17:27
 **/
@Data
public class LoginForm {
    private String username;
    private String password;
}
