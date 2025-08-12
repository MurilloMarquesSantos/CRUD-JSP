package dev.marques.jspproject.controller;

import dev.marques.jspproject.model.JavaBeans;
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

    JavaBeans contato = new JavaBeans();
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

    protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        contato.setNome(request.getParameter("nome"));
        contato.setFone(request.getParameter("fone"));
        contato.setEmail(request.getParameter("email"));
        dao.inserirContato(contato);
        response.sendRedirect("main");
    }

    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("agenda.jsp");
        dao.getContatos();
    }
}
