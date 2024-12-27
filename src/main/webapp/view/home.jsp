<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Food</title>
    <link rel="stylesheet" href="/css/home.css">
</head>
<body>
<jsp:include page="/view/sidebar.jsp"></jsp:include>

<div class="content">
    <h1>Danh sách Món Ăn</h1>
    <div>
        <a href="/homeAdmin?action=addFood">
            <button style="margin-bottom: 10px; padding: 10px; background-color: #28a745; color: white; border: none; cursor: pointer;">
                ➕ Thêm Món Ăn
            </button>
        </a>
    </div>

    <table border="1" cellspacing="0" cellpadding="10">
        <thead>
        <tr>
            <th>Mã món ăn</th>
            <th>Hình ảnh</th>
            <th>Tên món</th>
            <th>Giá (VND)</th>
            <th>Mô tả</th>
            <th>Loại</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="food" items="${foodList}">
            <tr>
                <td>${food.foodItemID}</td>
                <td><img style="width: 100px;height:100px" src="${food.image}" alt="Anh"></td>
                <td>${food.name}</td>
                <td><fmt:formatNumber value="${food.price}" /></td>
                <td>${food.description}</td>
                <td>${food.type}</td>
                <td>${food.stock == true ? "Còn hàng" : "Hết hàng"}</td>
                <td>
                    <a href="/homeAdmin?action=edit&foodItemID=${food.foodItemID}">
                        <button style=" padding: 5px;margin-bottom: 5px; cursor: pointer;">✏️</button>
                    </a>
<%--                    <a href="/homeAdmin?action=delete&foodItemID=${food.foodItemID}" onclick="return confirm('Bạn có chắc muốn xóa món ăn này?');">--%>
<%--                        <button style="background-color: #dc3545; color: white; border: none; padding: 5px; cursor: pointer;">🗑️ Xóa</button>--%>
<%--                    </a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
