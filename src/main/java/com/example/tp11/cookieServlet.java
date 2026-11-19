package com.example.tp11;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.Cookie;
@WebServlet(name = "cookieServlet", value = "/cookie-servlet")
public class cookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Cookie[] cookies= req.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if (cookie.getName().equals("Idea-1c6054dd")) {
                    continue;
                }
                out.println("<h1>"+cookie.getName()+" : "+cookie.getValue()+"</h1><br>");
            }
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        this.doGet(req, res);
    }
}