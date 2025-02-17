package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DeleteToDoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            List<String> todoList = ToDoServlet.getTodoList();
            
            if (id >= 0 && id < todoList.size()) {
                // Rimuovi l'attività dalla lista
                todoList.remove(id);
            }
        }

        // Reindirizza alla pagina che visualizza la lista aggiornata
        response.sendRedirect("ViewToDoServlet");
    }
}
