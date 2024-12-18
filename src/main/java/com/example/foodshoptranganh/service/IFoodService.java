package com.example.foodshoptranganh.service;

import com.example.foodshoptranganh.model.Food;

import java.sql.SQLException;
import java.util.List;

public interface IFoodService {
    List<Food> getAllFoodItems();
    public void addFood(Food food);
    void deleteFood(int foodItemID) throws SQLException;
}