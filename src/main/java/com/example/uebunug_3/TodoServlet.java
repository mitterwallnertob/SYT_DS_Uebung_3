package com.example.uebunug_3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        List<String> todoList = (List<String>) session.getAttribute("todoList");
        if (todoList == null) {
            todoList = new ArrayList<>();
            session.setAttribute("todoList", todoList);
        }

        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Todo List</title>");
        response.getWriter().println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='container'>");
        response.getWriter().println("<h1>Todo List</h1>");
        response.getWriter().println("<form action='/todo' method='post'>");
        response.getWriter().println("<div class='form-group'>");
        response.getWriter().println("<input type='text' class='form-control' name='todo' placeholder='Add Todo'>");
        response.getWriter().println("</div>");
        response.getWriter().println("<button type='submit' class='btn btn-primary'>Add</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("<ol>");
        for (String todo : todoList) {
            response.getWriter().println("<li>" + todo + "</li>");
        }
        response.getWriter().println("</ol>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String todo = request.getParameter("todo");
        if (todo != null && !todo.trim().equals("")) {
            HttpSession session = request.getSession();
            ArrayList<String> todoList = (ArrayList<String>) session.getAttribute("todoList");

            if (todoList == null) {
                todoList = new ArrayList<>();
            }
            todoList.add(todo);
            session.setAttribute("todoList", todoList);
            response.sendRedirect("todo");
        } else {
            response.sendRedirect("todo");
        }
    }
}

