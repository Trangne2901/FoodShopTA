package com.example.foodshoptranganh.service;

import com.example.foodshoptranganh.model.Food;

import java.sql.SQLException;
import java.util.List;

public interface IFoodService {
    List<Food> getAllFoodItems();
    void addFood(Food food);
    void updateFood(int foodItemID,Food food);
    void deleteFood(int foodItemID) ;
    Food getFoodById(int foodItemID);
}