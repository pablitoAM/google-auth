package com.pabloam.projects.googleauth.api.security;

import com.pabloam.projects.googleauth.api.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.BiFunction;

public class AuthenticationFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);
    private final List<String> uriWhiteList;

    public AuthenticationFilter(final List<String> uriWhiteList) {
        this.uriWhiteList = uriWhiteList;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest  req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(!isInWhiteList.apply(req.getRequestURI(), uriWhiteList)){
            AuthService.redirect.apply("", res);
        } else {
            chain.doFilter(req, res);
        }

    }

    @Override
    public void destroy() {

    }

    private BiFunction<String, List<String>, Boolean> isInWhiteList = (uri, uriWhiteList) -> uriWhiteList.stream().anyMatch(uri::startsWith);
}
