package com.example.tp11;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

@WebServlet(name = "listItems", urlPatterns = {"/ListItems", "/list-items"})
public class listItems extends HttpServlet {

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession();

        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");

        if (items == null) {
            items = new ArrayList<String>();
        }

        String item = req.getParameter("newItem");

        if (item != null && !item.trim().isEmpty()) {
            items.add(item);
        }

        session.setAttribute("items", items);

        out.println("<html><body>");
        out.println("<h2>List of Items</h2>");

        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>Item</th><th>Number of times</th></tr>");

        ArrayList<String> displayed = new ArrayList<String>();

        for (String i : items) {
            if (!displayed.contains(i)) {
                int count = 0;
                for (String j : items) {
                    if (i.equals(j)) {
                        count++;
                    }
                }
                out.println("<tr>");
                out.println("<td>" + i + "</td>");
                out.println("<td>" + count + "</td>");
                out.println("</tr>");

                displayed.add(i);
            }
        }

        out.println("</table>");
        out.println("<br><a href='items.jsp'>Add another item</a>");
        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws IOException, ServletException {

        doPost(req, res);
    }
}