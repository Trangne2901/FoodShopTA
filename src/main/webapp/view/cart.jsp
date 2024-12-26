<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="pmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Mỳ Cay Trang Anh - Cart</title>
    <link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
<h1>Giỏ Hàng Của Bạn</h1>
<div class="shopping-cart">

    <c:if test="${empty cart}">
        <p>Giỏ hàng của bạn đang trống.</p>
    </c:if>

    <c:if test="${not empty cart}">
        <div class="column-labels">
            <label class="product-image">Image</label>
            <label class="product-details">Product</label>
            <label class="product-price">Price</label>
            <label class="product-quantity">Quantity</label>
            <label class="product-line-price">Total</label>
        </div>

        <c:forEach var="item" items="${cart}">
            <div class="product">
                <div class="product-image">
                    <img src="${item.image}" alt="${item.name}">
                </div>
                <div class="product-details">
                    <div class="product-title">${item.name}</div>
                </div>
                <div class="product-price"><pmt:formatNumber value="${item.price}"  type="currency" currencySymbol="VND"/></div>
                <div class="product-quantity">${item.quantity}</div>
                <div class="product-line-price"><pmt:formatNumber value="${item.price * item.quantity}"  type="currency" currencySymbol="VND"/></div>
            </div>
        </c:forEach>
        <div class="totals">
            <div class="totals-item">
                <label>Subtotal:</label>
                <div class="totals-value">
                    <c:set var="subtotal" value="0"/>
                    <c:forEach var="item" items="${cart}">
                        <c:set var="subtotal" value="${subtotal + (item.price * item.quantity)}"/>
                    </c:forEach>
<%--                        ${subtotal}--%>
                </div>
                <pmt:formatNumber value="${subtotal}"  type="currency" currencySymbol="VND"/>
            </div>
        </div>
        <button class="checkout">Checkout</button>
    </c:if>
</div>
</body>
</html>