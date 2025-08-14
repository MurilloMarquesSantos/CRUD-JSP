package dev.marques.jspproject.controller;

import dev.marques.jspproject.model.DAO;
import dev.marques.jspproject.model.JavaBeans;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update"})
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
        } else if (action.equals("/select")) {
            listarContato(request, response);
        } else if (action.equals("/update")) {
            atualizarContato(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idcon = request.getParameter("idcon");
        contato.setIdcon(idcon);
        dao.getContatosById(contato);
        request.setAttribute("idcon", contato.getIdcon());
        request.setAttribute("nome", contato.getNome());
        request.setAttribute("email", contato.getEmail());
        request.setAttribute("fone", contato.getFone());

        RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
        dispatcher.forward(request, response);
    }

    protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        contato.setNome(request.getParameter("nome"));
        contato.setFone(request.getParameter("fone"));
        contato.setEmail(request.getParameter("email"));
        dao.inserirContato(contato);
        response.sendRedirect("main");
    }

    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JavaBeans> list = dao.getContatos();
        request.setAttribute("contatos", list);
        RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
        rd.forward(request, response);
    }

    protected void atualizarContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        contato.setIdcon(request.getParameter("idcon"));
        contato.setNome(request.getParameter("nome"));
        contato.setFone(request.getParameter("fone"));
        contato.setEmail(request.getParameter("email"));
        dao.atualizarContato(contato);
        response.sendRedirect("main");
    }

}
