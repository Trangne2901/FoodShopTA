<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Món Ăn</title>
    <link rel="stylesheet" href="/css/edit.css">
</head>
<body>
<div class="container">
    <h1>Sửa Món Ăn</h1>
    <div class="content">
        <div class="image-section">
            <img id="foodImage" src="${food.image}" alt="Hình ảnh món ăn" />
        </div>
        <div class="info-section">
            <form action="/homeAdmin?action=editFood" method="post">
                <input type="hidden" id="foodItemID" name="foodItemID" value="${food.foodItemID}">

                <label for="name">Tên món ăn:</label>
                <input type="text" id="name" name="name" value="${food.name}" required>

                <label for="price">Giá (VND):</label>
                <input type="number" id="price" name="price" value="${food.price}" required>

                <label for="description">Mô tả:</label>
                <textarea id="description" name="description" rows="4" required>${food.description}</textarea>

                <label for="image">Link anh </label>
                <input type="text" id="image" name="image" value="${food.image}"/>

                <label for="type">Loại món ăn:</label>
                <input type="text" id="type" name="type" value="${food.type}" required>

                <label for="stock">Trạng thái:</label>
                <select id="stock" name="stock">
                    <option value="true" ${food.stock ? 'selected' : ''}>Còn hàng</option>
                    <option value="false" ${!food.stock ? 'selected' : ''}>Hết hàng</option>
                </select>

                <div class="buttons">
                    <button type="submit" class="save-btn">Lưu Thay Đổi</button>
                    <a href="/homeAdmin">
                        <button type="button" class="cancel-btn">Hủy</button>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
