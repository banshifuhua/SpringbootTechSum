# springboot-security-oauth2.0

本模块是在 springboot-security-simple模块的基础上修改而来

- 实现了基本的 oauth 功能（密码模式、客户端模式）

- 获取token：http://localhost:8082/oauth/token?username=admin&password=admin&grant_type=password&client_id=client&client_secret=123456&grant_type=refresh_token
- 刷新token：http://localhost:8082/oauth/token?grant_type=refresh_token&client_id=client&client_secret=123456&refresh_token=ca0d41c8-d808-4211-8cab-5da5bfe6c6db