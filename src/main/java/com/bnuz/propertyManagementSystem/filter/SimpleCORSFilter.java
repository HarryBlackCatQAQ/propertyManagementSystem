//package com.bnuz.propertyManagementSystem.filter;
//
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextImpl;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class SimpleCORSFilter implements Filter {
//
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
//            ServletException {
//        HttpServletResponse response = (HttpServletResponse) res;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//
////        System.err.println(((HttpServletRequest)req).getSession().getId());
//
//        chain.doFilter(req, res);
//    }
//
//    public void init(FilterConfig filterConfig) {
//
//    }
//
//    public void destroy() {
//
//    }
//
//}