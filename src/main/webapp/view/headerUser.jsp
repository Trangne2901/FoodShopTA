<%--
  Created by IntelliJ IDEA.
  User: tranz_quyzn
  Date: 26/12/2024
  Time: 11:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://fonts.googleapis.com/css2?family=Arima&family=Cookie&family=Dancing+Script&family=EB+Garamond:ital,wght@1,500&family=Open+Sans:wght@300&display=swap"
      rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/userpage.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<script src="js/userpage.js"></script>
<body>


<header>
    <h3>Mỳ cay Trang Anh</h3>
    <nav>
        <ul>

            <li><a href="#menu">Thực Đơn</a></li>
            <%--            <li><a href="#about">Về Chúng Tôi</a></li>--%>
            <li><a href="#orders">Đặt Hàng Trực Tuyến</a></li>
            <li><a href="#contact">Liên Hệ</a></li>

        </ul>
    </nav>
    <div class="header-icons" style="display: flex; align-items: center; transform: translate(-230px,-7px);">
        <div style="position: relative; margin-right: 10px;">
            <i class="fas fa-search" style="position: absolute; left: 10px; top: 50%; transform: translateY(-50%);"></i>
            <input type="text" placeholder="Search..." style="padding-left: 30px; height: 30px; width: 200px;">
        </div>
        <a href="cart?action=showCart" style="margin-right: 20px;">
            <i class="fas fa-shopping-cart"></i>
        </a>
        <img src="https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2020/8/21/829850/Bat-Cuoi-Truoc-Nhung-07.jpg" class="avatar" alt="User Avatar">
    </div>

    <button class="hamburger">
        <i class="menuIcon material-icons">menu</i>
        <i class="closeIcon material-icons">close</i>
    </button>
</header>
</body>
</html>
