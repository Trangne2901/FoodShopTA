package com.example.foodshoptranganh.service;

import com.example.foodshoptranganh.model.Food;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.mysql.cj.conf.PropertyKey.logger;

public class FoodService implements IFoodService {
    @Override
    public List<Food> getAllFoodItems() {
        List<Food> foodList = new ArrayList<>();
        String query = "SELECT * FROM food";

        try (Connection connection = connectJDBC.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next())  {
                int foodItemID = resultSet.getInt("foodItemID");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                String type = resultSet.getString("type");
                boolean stock = resultSet.getBoolean("stock");
                foodList.add(new Food(foodItemID, name, price, description,image,type,stock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodList;
    }
}