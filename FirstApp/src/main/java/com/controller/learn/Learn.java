package com.controller.learn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/learn"})
public class Learn extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.getWriter().println("Minh tuan hello\n");
        response.getWriter().println("Minh tuan hello\n");
        response.getWriter().println("Minh tuan 20119383 ute");
        response.getWriter().println("Minh tuan 20119383 ute");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
