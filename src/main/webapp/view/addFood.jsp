<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Món Ăn</title>
    <link rel="stylesheet" href="/css/addFood.css">

</head>
<body>
<div class="container">
    <h1>Thêm Món Ăn</h1>
    <form action="/homeAdmin?action=addFood" method="post" >
        <label for="name">Tên món ăn:</label>
        <input type="text" id="name" name="name" required>

        <label for="price">Giá (VND):</label>
        <input type="number" step="any" id="price" name="price" required>

        <label for="description">Mô tả:</label>
        <textarea id="description" name="description" rows="4" required></textarea>

        <label for="image">Hình ảnh:</label>
        <input type="text" id="image" name="image" >

        <label for="type">Loai</label>
        <input type="text" id="type" name="type" required>

        <button type="submit">Thêm Món Ăn</button>
        <a href="/homeAdmin">
            <button type="button" class="cancel-btn">Hủy</button>
        </a>    </form>
</div>
</body>
</html>
