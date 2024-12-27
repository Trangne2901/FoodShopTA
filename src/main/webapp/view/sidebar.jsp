<%--
  Created by IntelliJ IDEA.
  User: tranz_quyzn
  Date: 27/12/2024
  Time: 8:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/home.css">

</head>
<body>
<div class="sidebar">
    <div style="text-align: center; margin-bottom: 20px;">
        <img src="/image/logo.png" alt="Logo" style="width: 200px; height: 200px">
    </div>
    <ul>
        <li><a href="#"><i class="icon">🏠</i> Home</a></li>
        <li><a href="#"><i class="icon">🍽️</i> Món ăn</a></li>
        <li><a href="#"><i class="icon">🧾</i> Hóa đơn</a></li>
        <li><a href="#"><i class="icon">📊</i> Doanh thu</a></li>
    </ul>
    <div class="logout">
        <a href="/user?action=logout"><i class="icon">🚪</i> Đăng xuất</a>
    </div>
</div>
</body>
</html>
