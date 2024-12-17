package com.example.foodshoptranganh.controller;

import com.example.foodshoptranganh.model.User;
import com.example.foodshoptranganh.service.IUserService;
import com.example.foodshoptranganh.service.UserService;
import sun.rmi.server.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.loginUser(req,email,password);
        if(user == null){
            System.out.println("Loi");
        }else {
            if(user.getRole().equals("Admin")){
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/home.jsp");
                dispatcher.forward(req,resp);
            }else if (user.getRole().equals("User")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/home.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");
        System.out.println(action);
        if(action == null){
            action = "";
        }
        switch (action){
            case "login":
                userLogin(req,resp);
                break;
        }
    }

}
