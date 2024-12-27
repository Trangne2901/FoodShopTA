<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Arima&family=Cookie&family=Dancing+Script&family=EB+Garamond:ital,wght@1,500&family=Open+Sans:wght@300&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/userpage.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <script src="js/userpage.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
</head>
<body>
<jsp:include page="/view/headerUser.jsp"></jsp:include>
<main>
    <section id="menu">
    </section>
    <section id="home">
        <p class="welcome">
            Welcome to
        </p>
        <h3>Mỳ cay Trang Anh</h3>
        <div id="texts">
            <div class="text-one">
                <p>
                    Mỳ cay Trang Anh là một thương hiệu nổi tiếng trong lĩnh vực ẩm thực Hàn Quốc. Sasin được ra mắt vào
                    năm 2016 với món ăn đặc trưng là mì cay 7 cấp độ có hương vị đậm đà, thơm ngon, đặc biệt là 7 cung
                    bật cay đã trở thành con sốt "mì cay" đối với giới trẻ lúc bấy giờ
                </p>
            </div>
            <div class="text-two">
                <p>
                    Mỳ cay Trang Anh đã trở thành một trong những lựa chọn hàng đầu của giới trẻ Việt Nam khi muốn
                    thưởng thức mì cay nói riêng và ẩm thực Hàn Quốc nói chung.
                </p>
            </div>
        </div>
        <button>Find Out More</button>
    </section>
    <section id="food">
        <h3>Our Dishes</h3>
        <div id="dishes">
            <c:forEach var="food" items="${foodList}">
                <form action="cart?action=addToCart&id=${food.foodItemID}" method="post">
                <div class="dish-item">
                    <img style="width: 280px;height: 280px" src="${food.image}" alt="${food.name}">
                    <div class="price">
                        <p class="dish">${food.name}</p>
                        <p class="cost"><fmt:formatNumber value="${food.price}"  type="currency" currencySymbol="VND"/></p>
                    </div>
                    <p class="text">${food.description}</p>
                    <div class="icons">
                        <div class="clock">
                            <i class="fa fa-clock"></i><span>30 mins</span>
                        </div>
                    </div>
                    <button type="submit">Order Now</button>
                </div>
                </form>
            </c:forEach>
        </div>
    </section>
    <footer> <!-- Thanh ngang không có nội dung --> </footer>
</main>
</body>
</html>