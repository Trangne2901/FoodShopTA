package com.example.foodshoptranganh.service;

import com.example.foodshoptranganh.model.User;

import javax.servlet.http.HttpServletRequest;


public interface IUserService {
    User loginUser(HttpServletRequest req, String email, String password);
    void registerUser(User user);
}
