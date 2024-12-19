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
                int price = resultSet.getInt("price");
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
            pre.setString(2, food.getImage());
            pre.setDouble(3, food.getPrice());
            pre.setString(4, food.getDescription());
            pre.setString(5, food.getType());
            pre.execute();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in addUser", e);
        }

    }

    @Override
    public void updateFood(int foodItemID, Food food) {
        String sql = "UPDATE food SET name = ?, price = ?, description = ?, image = ?, type = ?, stock = ? WHERE foodItemID = ?";
        try (Connection connection = connectJDBC.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, food.getName());
            pre.setDouble(2, food.getPrice());
            pre.setString(3, food.getDescription());
            pre.setString(4, food.getImage());
            pre.setString(5, food.getType());
            pre.setBoolean(6, food.isStock());
            pre.setInt(7, food.getFoodItemID());
            pre.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    @Override
//    public void deleteFood(int foodItemID) {
//        String sql = "DELETE FROM food WHERE foodItemID = ?";
//        try (Connection connection = connectJDBC.getConnection();
//             PreparedStatement pre = connection.prepareStatement(sql)) {
//            pre.setInt(1, foodItemID);
//            int rowsAffected = pre.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("Món ăn đã được xóa thành công.");
//            } else {
//                System.out.println("Không tìm thấy món ăn với ID đã cho.");
//            }
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "Lỗi khi xóa món ăn", e);
//        }
//    }

    @Override
    public Food getFoodById(int foodItemID) {
        String sql = "select * from food where foodItemID = ?";
        Food food = null;
        try (Connection conn = connectJDBC.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, foodItemID);
            try (ResultSet resultSet = pre.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    String description = resultSet.getString("description");
                    String image = resultSet.getString("image");
                    String type = resultSet.getString("type");
                    boolean stock =resultSet.getBoolean("stock");
                     food = new Food(foodItemID, name, price, description, image, type, stock);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error in getUserById", e);
        }
        return food;
    }

}