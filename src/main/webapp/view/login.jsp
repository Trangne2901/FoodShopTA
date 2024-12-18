<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
<div class="login-container">
    <div class="login-header">
    </div>
    <div class = "login-form">
        <form action="/user?action=login" method="post">
            <div class="form-group">
                <label for="username">Tên người dùng</label>
                <input type="text" id="username" name="email" placeholder="Nhập email người dùng" required>
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
            </div>
            <button type = "submit">Đăng nhập</button>
            <br>
        </form>
        <a href="/user?action=register">Chưa có tài khoản? Đăng ký</a>

    </div>

</div>
</body>