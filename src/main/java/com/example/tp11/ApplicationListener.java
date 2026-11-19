package com.example.tp11;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("appName", "ING1 Web Application");
        System.out.println("ApplicationListener: application started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("ApplicationListener: application stopped.");
    }
}
