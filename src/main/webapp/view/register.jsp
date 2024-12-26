<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" type="text/css" href="/css/register.css">
</head>
<body>
<div class="register-container">
    <div class="register-header">
        <%--        <h1>Đăng ký tài khoản</h1>--%>
    </div>
    <div class="register-form">
        <form action="/user?action=register" method="post">
            <h2>Đăng ký tài khoản</h2>
            <div class="form-group">
                <label for="fullname">Họ và tên</label>
                <input type="text" id="fullname" name="fullName" placeholder="Nhập họ và tên" required
                       value="${fullName}">
                <span class="error" style="color: red;">
                    ${fullNameError}
                </span>
            </div>
            <div class="form-group">
                <label for="phone">Số điện thoại</label>
                <input type="text" id="phone" name="phoneNumber" placeholder="Nhập số điện thoại" required
                       value="${phoneNumber}">
                <span class="error" style="color: red;">
                    ${phoneNumberError}
                </span>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Nhập email" required value="${email}">
                <span class="error" style="color: red;">
                    ${emailError}
                </span>
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required
                       value="${password}">
                <span class="error" style="color: red;">
                    ${passwordError}
                </span>
            </div>
            <div class="form-group">
                <label for="confirm-password">Nhập lại mật khẩu</label>
                <input type="password" id="confirm-password" name="confirm-password" placeholder="Nhập lại mật khẩu"
                       required>
                <span class="error" style="color: red;">
                    ${confirmPasswordError}
                </span>
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ</label>
                <input type="text" id="address" name="address" placeholder="Nhập địa chỉ" required value="${address}">
                <span class="error" style="color: red;">
                    ${addressError}
                </span>
            </div>
            <div class="form-group">
                <label for="urlAvatar">Link ảnh đại diện</label>
                <input type="text" id="urlAvatar" name="urlAvatar" placeholder="Nhập link ảnh" required
                       value="${urlAvatar}">
                <span class="error" style="color: red;">
                    ${urlAvatarError}
                </span>
            </div>

            <button type="submit">Đăng ký</button>
        </form>
    </div>
</div>
</body>
</html>
