package com.pabloam.projects.googleauth.api.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthExceptionFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthExceptionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest  req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("Error in '{}', {}", req.getRequestURI(), e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {

    }
}
