package com.example.foodshoptranganh.controller;
import com.example.foodshoptranganh.model.Food;
import com.example.foodshoptranganh.service.FoodService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/homeAdmin")
public class FoodServlet extends HttpServlet {
    private FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addFood":
                response.sendRedirect("/view/addFood.jsp");
                break;
            default:
                showAllFoodAction(request, response);
                break;
        }
    }

    private void showAllFoodAction(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Food> foodList = foodService.getAllFoodItems();
            request.setAttribute("foodList", foodList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/home.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addFood":
                adminAddFood(request, response);
                break;
            default:
                showAllFoodAction(request, response);
                break;
        }

    }

    private void adminAddFood(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        Food food = new Food(name, price, description, image, type);
        foodService.addFood(food);
        showAllFoodAction(request,response);
    }
}
