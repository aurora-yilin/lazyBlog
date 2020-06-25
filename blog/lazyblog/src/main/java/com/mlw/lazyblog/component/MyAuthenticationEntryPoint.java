package com.mlw.lazyblog.component;

import com.mlw.lazyblog.common.ResultCode;
import com.mlw.lazyblog.common.ResultVO;
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
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        responseOutput
                .responJson(new ResultVO(ResultCode.NLOGIN),response);
    }
}
