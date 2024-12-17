package com.example.foodshoptranganh.service;

import com.example.foodshoptranganh.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService implements IUserService {
    @Override
    public User loginUser(HttpServletRequest req, String email, String password) {
        String query = "SELECT * FROM user WHERE email =? AND password =?";
        try (Connection connection = connectJDBC.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("userID");
                String fullName = rs.getString("fullName");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String role = rs.getString("role");
                boolean status = rs.getBoolean("status");
                String urlAvatar = rs.getString("urlAvatar");
                User user = new User(id, fullName, phoneNumber, address, email, password, role, status, urlAvatar);
                HttpSession session = req.getSession(true);
                if (status) {
                    session.setAttribute("userLoggedIn", user);
                    return user;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void registerUser(User user) {

    }
}
