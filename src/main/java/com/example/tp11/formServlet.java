package com.example.tp11;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.Cookie;

@WebServlet(name = "formServlet", value = "/form-servlet")
public class formServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        String fname=req.getParameter("fn");
        String lname=req.getParameter("ln");
        String birthday=req.getParameter("birthday");
        String gender=req.getParameter("gender");

        Cookie firstname_cookie = new Cookie("firstname", fname);
        Cookie lastname_cookie = new Cookie("lastname", lname);
        Cookie birthday_cookie = new Cookie("birthday", birthday);
        Cookie gender_cookie = new Cookie("gender", gender);

        firstname_cookie.setMaxAge(60*60);
        lastname_cookie.setMaxAge(60*60);
        gender_cookie.setMaxAge(60*60);
        birthday_cookie.setMaxAge(60*60);


        res.addCookie(firstname_cookie);
        res.addCookie(lastname_cookie);
        res.addCookie(birthday_cookie);
        res.addCookie(gender_cookie);





        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Information Example</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h3>THE INFORMATIONS</h3>");

        out.println("<table border='1' cellpadding='10' cellspacing='0'>");

        out.println("<tr>");
        out.println("<th>Information</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>First Name</td>");
        out.println("<td>" + fname + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Last Name</td>");
        out.println("<td>" + lname + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Birth Date</td>");
        out.println("<td>" + birthday + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Gender</td>");
        out.println("<td>" + gender + "</td>");
        out.println("</tr>");

        out.println("</table>");


        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        doGet(req, res);
    }
}
