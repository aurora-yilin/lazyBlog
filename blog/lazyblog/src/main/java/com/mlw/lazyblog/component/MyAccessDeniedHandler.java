package com.mlw.lazyblog.component;

import com.mlw.lazyblog.common.ResultCode;
import com.mlw.lazyblog.common.ResultVO;
import com.mlw.lazyblog.common.responseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oRuol
 * @Date 2020/6/23 19:49
 *
 * 处理认证过的用户无权访问资源时的异常
 */
@Slf4j
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("已认证但是无权访问---------------");
        responseOutput
                .responJson(new ResultVO(ResultCode.INSPER),response);
    }
}
