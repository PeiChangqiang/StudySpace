package com.pcq.web;

import javax.servlet.*;
import java.io.IOException;

public class AServlet implements Servlet {
    @Override
    //创建后只会执行一次
    public void init(ServletConfig servletConfig) throws ServletException {
        String servletName = servletConfig.getServletName();
        String v = servletConfig.getInitParameter("p1");
        System.out.println("init.......");
        System.out.println(servletName + ",p1 : " + v);
        init();
    }

    public void init() {

    }
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig.......");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.......");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo.......");
        return null;
    }

    @Override
    //服务器关闭时执行，对象临死前执行一次
    public void destroy() {
        System.out.println("destroy.......");
    }
}