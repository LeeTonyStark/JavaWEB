package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lifeng
 * @create 2022-09-27 1:17
 */
@WebFilter("/*")
public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //过滤所有请求，将编码设置为utf-8
        request.setCharacterEncoding("utf-8");
        //放行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
