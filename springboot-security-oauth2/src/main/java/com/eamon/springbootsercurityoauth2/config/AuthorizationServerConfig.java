package com.eamon.springbootsercurityoauth2.config;

import com.eamon.springbootsercurityoauth2.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author: eamon
 * @date: 2018/10/19 17:21
 * @description: 配置认证服务器 @EnableAuthorizationServer 这个注解告诉 Spring 这个应用是 OAuth2 的授权服务器
 * 提供/oauth/authorize,/oauth/token,/oauth/check_token,/oauth/confirm_access,/oauth/error
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    DataSource dataSource;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Bean
    public TokenStore tokenStore() {
//        return new InMemoryTokenStore(); //使用内存中的 token store
        // 使用jdbc的tokenstore
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                // 允许表单登录
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource)
                .withClient("client")
                .secret(new BCryptPasswordEncoder().encode("123456"))
                //允许授权范围
                .authorizedGrantTypes("password", "refresh_token")
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .scopes("read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(7200);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(customUserDetailService);
    }
}
