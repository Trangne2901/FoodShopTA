<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
<div class="register-container">
    <div class="register-header">
    </div>
    <div class="register-form">
        <form action="/user?action=register" method="post">
            <div class="form-group">
                <label for="fullname">Họ và tên</label>
                <input type="text" id="fullname" name="fullname" placeholder="Nhập họ và tên" required>
            </div>
            <div class="form-group">
                <label for="phone">Số điện thoại</label>
                <input type="text" id="phone" name="phoneNumber" placeholder="Nhập số điện thoại" required>
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ</label>
                <input type="text" id="address" name="address" placeholder="Nhập địa chỉ" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Nhập email" required>
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
            </div>
            <div class="form-group">
                <label for="confirm-password">Nhập lại mật khẩu</label>
                <input type="password" id="confirm-password" name="confirm-password" placeholder="Nhập lại mật khẩu" required>
            </div>
            <div class="form-group">
                <label for="urlAvatar">Link ảnh đại diện</label>
                <input type="text" id="urlAvatar" name="urlAvatar" placeholder="Nhập link ảnh" required>
            </div>
            <button type="submit">Đăng ký</button>
            <br>
        </form>
    </div>
</div>
</body>
</html>
