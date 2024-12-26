package com.example.foodshoptranganh.controller;

import com.example.foodshoptranganh.model.Cart;
import com.example.foodshoptranganh.model.Food;
import com.example.foodshoptranganh.service.FoodService;
import com.example.foodshoptranganh.service.IFoodService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    public IFoodService foodService = new FoodService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        HttpSession session = request.getSession();
        List<Cart> cart = (List<Cart>) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        switch (action) {
            case "addToCart":
                addToCart(request, response, cart);
                break;

        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response, List<Cart> cart) throws IOException {
        int idFood = Integer.parseInt(request.getParameter("id"));
        Food food = foodService.getFoodById(idFood);
        boolean exist = false;
        for (Cart cartItem : cart) {
            if (cartItem.getId() == idFood) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                exist = true;
                break;
            }
        }
        if (!exist) {
            Cart cart1 = new Cart(idFood, food.getImage(), food.getName(), food.getPrice(), 1);
            cart.add(cart1);
        }
        request.getSession().setAttribute("cart", cart);
        response.sendRedirect("/user");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showCart":
                showCart(request, response);
                break;

        }
    }


    public void showCart(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/cart.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
