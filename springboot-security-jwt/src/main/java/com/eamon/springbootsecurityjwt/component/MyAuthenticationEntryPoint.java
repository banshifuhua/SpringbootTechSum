package com.eamon.springbootsecurityjwt.component;

import com.eamon.springbootsecurityjwt.dto.ViewData;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 当未登录或token失效访问接口时，自定义返回结果
 *
 * @author eamon
 * @date 2019/08/15 16:46
 **/
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        ViewData viewData = new ViewData();
        viewData.setCode(-3);
        viewData.setError(authException.getLocalizedMessage());

        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().println(viewData);
        response.getWriter().close();
    }
}
