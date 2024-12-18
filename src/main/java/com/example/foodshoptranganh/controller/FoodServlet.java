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
import java.util.List;

@WebServlet("/showFood")
public class FoodServlet extends HttpServlet {
    private FoodService foodService;

    public void init() {
        foodService = new FoodService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Food> foodList = foodService.getAllFoodItems();
        request.setAttribute("foodList", foodList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/userpage.jsp");
        dispatcher.forward(request, response);
    }
}
