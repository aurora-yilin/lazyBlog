package com.mlw.lazyblog.component;

import com.mlw.lazyblog.common.enums.LoginExceptionEnum;
import com.mlw.lazyblog.common.vo.ResultVO;
import com.mlw.lazyblog.common.responseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oRuol
 * @Date 2020/6/23 19:52
 *
 * 处理匿名用户访问无权限资源时的异常
 */
@Slf4j
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("未认证，无权访问------------------");
        responseOutput
                .responJson(new ResultVO(LoginExceptionEnum.NLOGIN),response);
    }
}
