package com.example.websiteqa.filter;

import com.example.websiteqa.model.Taikhoan;
import com.example.websiteqa.utils.SessionUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthorizationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        if(httpServletRequest.getRequestURI().contains("/admin")
                && !httpServletRequest.getRequestURI().contains("/login")
                && !httpServletRequest.getRequestURI().contains("/resources")
                && !httpServletRequest.getRequestURI().contains("decorators")) {
            Taikhoan item = (Taikhoan) SessionUtil.getInstance().getKey(httpServletRequest, "user");
            if (item != null) {
                if (item.getQuyen() == 1) {
                    filterChain.doFilter(httpServletRequest, httpServletResponse);
                } else {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/login");
                }
            } else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/login");
            }
        }else{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}