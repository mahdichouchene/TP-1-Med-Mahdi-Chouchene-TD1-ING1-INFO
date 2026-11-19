package com.example.tp11;
 import jakarta.servlet.*;
 import jakarta.servlet.http.*;
 import java.io.IOException;
 import java.util.logging.Logger;

 public class  LoggingFilter implements Filter{

     private Logger logger = Logger.getLogger(LoggingFilter.class.getName());

     @Override
     public void init(FilterConfig filterConfig) throws ServletException {
         System.out.println("initialisation");
     }

     @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
             throws IOException, ServletException {
         HttpServletRequest httpRequest = (HttpServletRequest) request;
         logger.info("Incoming request: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());
         System.out.println("LoggingFilter: before chain.doFilter()");
         chain.doFilter(request, response);
         System.out.println("LoggingFilter: after chain.doFilter()");
     }

     @Override
     public void destroy() {
         System.out.println("destroy");
     }
 }
