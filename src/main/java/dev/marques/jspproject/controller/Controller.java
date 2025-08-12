package dev.marques.jspproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dev.marques.jspproject.model.DAO;

import java.io.IOException;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert"})
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    DAO dao = new DAO();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action.equals("/main")) {
            contatos(request, response);
        } else if (action.equals("/insert")) {
            novoContato(request, response);
        }else{
            response.sendRedirect("index.html");
        }
    }

    protected void novoContato(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("nome"));
        System.out.println(request.getParameter("fone"));
        System.out.println(request.getParameter("email"));
    }

    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("agenda.jsp");
    }
}
