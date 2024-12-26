package com.example.foodshoptranganh.controller;

import com.example.foodshoptranganh.model.User;
import com.example.foodshoptranganh.service.FoodService;
import com.example.foodshoptranganh.service.IFoodService;
import com.example.foodshoptranganh.service.IUserService;
import com.example.foodshoptranganh.service.UserService;
import sun.rmi.server.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();
    private IFoodService foodService = new FoodService();

    String fullNameRegex = "^[a-zA-ZÀ-ỹ\\s]{1,100}$";

    String numberPhoneRegex = "^((0|\\+84)[3-9]\\d{8})$";

    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    String addressRegex = "^[a-zA-Z0-9À-ỹ\\s,.-]{1,200}$";

    String urlAvatarRegex = "^(https?:\\/\\/.*\\.(?:jpg|jpeg|png|gif|bmp))$";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logout":
                resp.sendRedirect("/view/login.jsp");
                break;
            case "register":
                resp.sendRedirect("/view/register.jsp");
                break;

            default:
                req.setAttribute("foodList", foodService.getAllFoodItems());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/userpage.jsp");
                dispatcher.forward(req, resp);
                break;
        }
    }




    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.loginUser(req, email, password);
        if (user == null) {
            req.setAttribute("loginError", "Email hoặc mật khẩu không chính xác. Vui lòng thử lại.")
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("foodList", foodService.getAllFoodItems());

            if (user.getRole().equals("Admin")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("view/home.jsp");
                dispatcher.forward(req, resp);
            } else if (user.getRole().equals("User")) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/userpage.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }

    private void userRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String fullName = req.getParameter("fullName");
        String phoneNumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String urlAvatar = req.getParameter("urlAvatar");
        User newUser = new User(fullName, phoneNumber, address, email, password, urlAvatar);
        userService.registerUser(newUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/login.jsp");
        dispatcher.forward(req, resp);

        String confirmPassword = req.getParameter("confirm-password");
        String urlAvatar = req.getParameter("urlAvatar");
        
        req.setAttribute("fullName", fullName);
        req.setAttribute("phoneNumber", phoneNumber);
        req.setAttribute("address", address);
        req.setAttribute("urlAvatar", urlAvatar);
        req.setAttribute("email", email);

        if (isValid(fullName, fullNameRegex) == false) {
            req.setAttribute("fullNameError", "Chỉ chứa chữ cái, khoảng trắng, có thể có dấu.");
        } else if (isValid(phoneNumber, numberPhoneRegex) == false) {
            req.setAttribute("phoneNumberError", "Bắt đầu bằng 0 hoặc +84.\n" +
                    "Tiếp theo là một chữ số từ 3 đến 9.\n" +
                    "Sau đó là 8 chữ số bất kỳ.");
        } else if (isValid(password, passwordRegex) == false) {
            req.setAttribute("passwordError", "Tối thiểu 8 ký tự. Phải chứa ít nhất một chữ cái viết hoa, một chữ cái viết thường, và một chữ số.");
        } else if (!password.equals(confirmPassword)) {
            req.setAttribute("confirmPasswordError", "Mật khẩu không khớp nhau.");
        } else if (isValid(address, addressRegex) == false) {
            req.setAttribute("addressError", "Có thể chứa chữ cái, số, khoảng trắng, dấu phẩy, dấu chấm, và một số ký tự đặc biệt như - .");
        } else if (isValid(urlAvatar, urlAvatarRegex) == false) {
            req.setAttribute("urlAvatarError", "URL hợp lệ, bắt đầu với http hoặc https.");
        } else if (isValid(email, emailRegex) == false) {
            req.setAttribute("emailError", "Định dạng email chuẩn (username@domain.com).");
        } else {
            User newUser = new User(fullName, phoneNumber, address, email, password, urlAvatar);
            userService.registerUser(newUser);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/login.jsp");
            dispatcher.forward(req, resp);
            return; // Quan trọng để dừng xử lý sau khi chuyển hướng
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                userLogin(req, resp);
                break;
            case "register":
                try {
                    userRegister(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public static boolean isValid(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


}
