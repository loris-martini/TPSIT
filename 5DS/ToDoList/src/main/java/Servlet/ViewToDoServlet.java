package Servlet;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@WebServlet("/Servlet")
public class ViewToDoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> todoList = ToDoServlet.getTodoList();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Lista delle Attività</h1>");

        for (int i = 0; i < todoList.size(); i++) {
            String activity = todoList.get(i);
            out.println("<p>" + activity + " <a href='DeleteToDoServlet?id=" + i + "'>Rimuovi</a></p>");
        }

        out.println("<br><a href='index.html'>Aggiungi Nuova Attività</a>");
        out.println("</body></html>");
    }
}
