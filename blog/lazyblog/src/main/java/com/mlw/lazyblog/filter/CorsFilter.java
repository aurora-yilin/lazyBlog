package com.mlw.lazyblog.filter;

import com.sun.mail.iap.Response;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oRuol
 * @Date 2020/6/29 15:39
 * 创建一个过滤器用来解决cors问题
 */
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse)response;
        // 指定允许其他域名访问
        res.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有
        // response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1, http://locahost"); // 允许白名单IP
        // 响应类型
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // 预检请求的结果缓存60分钟
        res.setHeader("Access-Control-Max-Age", "600");
        // 响应头设置
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(request, response);
    }
}
