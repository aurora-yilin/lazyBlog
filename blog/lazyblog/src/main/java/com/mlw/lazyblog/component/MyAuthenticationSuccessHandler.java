package com.mlw.lazyblog.component;

import com.mlw.lazyblog.common.enums.CommonEnum;
import com.mlw.lazyblog.common.vo.ResultVO;
import com.mlw.lazyblog.common.responseOutput;
import com.mlw.lazyblog.common.entity.User;
import com.mlw.lazyblog.common.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author oRuol
 * @Date 2020/6/23 19:26
 * 认证成功处理器的实现
 */
@Slf4j
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User principal = (User)authentication.getPrincipal();
        log.info("认证成功------------" + authentication.getName());
        UserVo userVo = new UserVo();
        userVo.setUserName(principal.getUserName());
        userVo.setEmail(principal.getEmail());
        userVo.setHeadImage(principal.getHeadImage());
        userVo.setUserAuthority((ArrayList) principal.getAuthorities());
        responseOutput.responJson(new ResultVO<UserVo>(CommonEnum.SUCCESS.getCode(),"登录成功",userVo), response);
    }

}
