package com.example.tp11;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        if (username == null || username.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/login.html");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", username.trim());

        response.setContentType("text/html;charset=UTF-8");
        String safeUsername = username.trim();
        response.getWriter().printf(
                "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\">" +
                        "<title>Login successful</title></head><body>" +
                        "<p>Welcome, %s. You are logged in.</p>" +
                        "<a href=\"%s/items.html\">Go to the items page</a>" +
                        "</body></html>",
                safeUsername, request.getContextPath());
    }


}
