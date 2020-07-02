package com.mlw.lazyblog.interceptor;

import com.mlw.lazyblog.common.enums.ResultCodeEnum;
import com.mlw.lazyblog.common.vo.ResultVO;
import com.mlw.lazyblog.component.VerificationcodeBuilder;
import com.mlw.lazyblog.common.responseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author oRuol
 * @Date 2020/6/24 20:48
 */
@Slf4j
@Component("VerificationCodeInterceptor")
public class VerificationCodeInterceptor implements HandlerInterceptor {

    @Resource
    private VerificationcodeBuilder verificationcodeBuilder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        log.info(email,code);
        String verificationCode = (String)verificationcodeBuilder.getVerificationCode(email);
        try {
            if (verificationCode.equals(code)) {
                return true;
            } else {
                return false;
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            responseOutput
                    .responJson(new ResultVO(ResultCodeEnum.VALIDATE_FAILED.getCode(), "验证码错误"), response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("*****************");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("*****************");
    }
}
