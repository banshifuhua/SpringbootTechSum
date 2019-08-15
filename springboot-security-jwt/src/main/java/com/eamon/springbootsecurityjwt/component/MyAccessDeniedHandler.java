package com.eamon.springbootsecurityjwt.component;

import com.eamon.springbootsecurityjwt.dto.ViewData;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 当访问接口没有权限时，自定义返回结果
 *
 * @author eamon
 * @date 2019/08/15 16:40
 **/
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ViewData viewData = new ViewData();
        viewData.setCode(-2);
        viewData.setError(accessDeniedException.getLocalizedMessage());

        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().println(viewData);
        response.getWriter().close();
    }
}
