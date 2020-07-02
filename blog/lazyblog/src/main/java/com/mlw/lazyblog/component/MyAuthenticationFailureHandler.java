package com.mlw.lazyblog.component;

import com.mlw.lazyblog.common.enums.LoginExceptionEnum;
import com.mlw.lazyblog.common.enums.ResultCodeEnum;
import com.mlw.lazyblog.common.vo.ResultVO;
import com.mlw.lazyblog.common.responseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oRuol
 * @Date 2020/6/23 19:42
 * 认证失败处理器的实现
 */
@Slf4j
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("认证失败---------------");
        responseOutput
                .responJson(new ResultVO(LoginExceptionEnum.FAILED), response);
    }
}
