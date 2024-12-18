package com.example.foodshoptranganh.service;

import com.example.foodshoptranganh.model.Food;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mysql.cj.conf.PropertyKey.logger;

public class FoodService implements IFoodService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Override
    public List<Food> getAllFoodItems() {
        List<Food> foodList = new ArrayList<>();
        String query = "SELECT * FROM food";

        try (Connection conn = connectJDBC.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                int foodItemID = resultSet.getInt("foodItemID");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                String type = resultSet.getString("type");
                boolean stock = resultSet.getBoolean("stock");
                foodList.add(new Food(foodItemID, name, price, description, image, type, stock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodList;
    }

    @Override
    public void addFood(Food food) {
        String sql = "insert into food(name,image,price,description,type) values(?,?,?,?,?)";
        try (Connection conn = connectJDBC.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, food.getName());
            pre.setString(2,food.getImage());
            pre.setDouble(3,food.getPrice());
            pre.setString(4,food.getDescription());
            pre.setString(5,food.getType());
            pre.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in addUser", e);
        }

    }

    @Override
    public void deleteFood(int foodItemID) throws SQLException {
        Connection connection = connectJDBC.getConnection();
        String sql = "delete from users where foodItemID = ?";
        try (PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setInt(1, foodItemID);
            pre.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in deleteUser", e);
        }
    }
}