package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class PrimmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String eta = request.getParameter("eta");
        String indirizzo = request.getParameter("indirizzo");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Dati ricevuti:</h1>");
        response.getWriter().println("<p>Grazie " + nome + " " + cognome + ", abbiamo ricevuto i tuoi dati!</p>");
        response.getWriter().println("<p>Età: " + eta + "</p>");
        response.getWriter().println("<p>Indirizzo: " + indirizzo + "</p>");
    }
}

