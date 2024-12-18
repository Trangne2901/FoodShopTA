package com.example.foodshoptranganh.controller;

import com.example.foodshoptranganh.model.User;
import com.example.foodshoptranganh.service.FoodService;
import com.example.foodshoptranganh.service.IFoodService;
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
import java.sql.SQLException;

@WebServlet(name="userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();
    private IFoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "logout":
                resp.sendRedirect("/view/login.jsp");
                break;
        }
    }

    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.loginUser(req,email,password);
        if(user == null){
            System.out.println("Loi");
        }else {
            if(user.getRole().equals("Admin")){
                req.setAttribute("foodList",foodService.getAllFoodItems());
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/home.jsp");
                dispatcher.forward(req,resp);
            }else if (user.getRole().equals("User")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/home.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }
    private void userRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String fullName=req.getParameter("fullname");
        String phoneNumber=req.getParameter("phoneNumber");
        String address=req.getParameter("address");
        String email= req.getParameter("email");
        String password=req.getParameter("password");
        String urlAvatar=req.getParameter("urlAvatar");
        User newUser= new User(fullName,phoneNumber,address,email,password,urlAvatar);
        userService.registerUser(newUser);
        RequestDispatcher dispatcher=req.getRequestDispatcher("view/login.jsp");
        dispatcher.forward(req,resp);
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
            case "register":
                try {
                    userRegister(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

}
