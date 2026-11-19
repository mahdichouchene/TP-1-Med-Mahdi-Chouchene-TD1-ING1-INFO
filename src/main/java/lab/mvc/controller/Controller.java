package lab.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab.mvc.model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet(name = "Controller", urlPatterns = "/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        if (isBlank(firstName) || isBlank(lastName) || isBlank(birthDay) || isBlank(sex)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required.");
            return;
        }

        final LocalDate dateOfBirth;
        try {
            dateOfBirth = LocalDate.parse(birthDay);
        } catch (DateTimeParseException exception) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Birth date must be a valid date.");
            return;
        }

        Person person = new Person(firstName, lastName, birthDay, sex);
        request.setAttribute("person", person);

        String destination = dateOfBirth.getYear() < 1990 ? "/jsp/old.jsp" : "/jsp/young.jsp";
        request.getRequestDispatcher(destination).include(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
