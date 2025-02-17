package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class ToDoServlet extends HttpServlet {
    private static ArrayList<String> todoList = new ArrayList<>();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titolo       = request.getParameter("titolo");
        String descrizione  = request.getParameter("descrizione");
        
        todoList.add("Titolo : " + titolo + " - Descrizione: " + descrizione);
        
        response.sendRedirect("ViewToDoServlet");
    }
    public static ArrayList<String> getTodoList() {
        return todoList;
    }
}
