package com.controller.web;

import com.controller.model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("GET in web home");
        UserModel userModel = new UserModel();
        userModel.setFullName("Tuấn minh");
        request.setAttribute("userModel", userModel);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("POST in web home");

    }

}
