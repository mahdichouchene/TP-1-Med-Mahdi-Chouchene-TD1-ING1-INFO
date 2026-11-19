
package com.example.tp11;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "showSession", value = "/ShowSession")
public class showSession extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession();
        Integer activeSessions = (Integer) req.getServletContext().getAttribute("activeSessions");

        String name = (String) session.getAttribute("name");
        String birthday = (String) session.getAttribute("birthday");

        out.println("<html><body>");
        out.println("<p>Currently active sessions: "
                + (activeSessions == null ? 0 : activeSessions) + "</p>");

        if (name == null || birthday == null) {

            out.println("<h2>Welcome! Please enter your information</h2>");

            out.println("<form method='post' action='ShowSession'>");

            out.println("Full Name: ");
            out.println("<input type='text' name='name' required><br><br>");

            out.println("Date of Birth: ");
            out.println("<input type='date' name='birthday' required><br><br>");

            out.println("<button type='submit'>Submit</button>");
            out.println("</form>");

        } else {

            LocalDate birthDate = LocalDate.parse(birthday);
            LocalDate today = LocalDate.now();

            LocalDate nextBirthday = birthDate.withYear(today.getYear());

            if (nextBirthday.isBefore(today)) {
                nextBirthday = birthDate.withYear(today.getYear() + 1);
            }

            long days = ChronoUnit.DAYS.between(today, nextBirthday);

            out.println("<h2>Hi, " + escapeHtml(name) + ".</h2>");
            out.println("<p>There are " + days
                    + " days to your birthday.</p>");
        }

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
            throws IOException, ServletException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("fn") + " " + req.getParameter("ln");
        String birthday = req.getParameter("birthday");

        if (name == null || name.trim().isEmpty()
                || birthday == null || birthday.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Name and birthday are required.");
            return;
        }

        try {
            LocalDate birthDate = LocalDate.parse(birthday);

            if (birthDate.isAfter(LocalDate.now())) {
                res.sendError(400, "Invalid date of birth.");
                return;
            }
        } catch (java.time.format.DateTimeParseException e) {
            res.sendError(400, "Invalid date format.");
            return;
        }

        HttpSession session = req.getSession();

        session.setAttribute("name", name);
        session.setAttribute("birthday", birthday);

        res.sendRedirect(req.getContextPath() + "/ShowSession");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
