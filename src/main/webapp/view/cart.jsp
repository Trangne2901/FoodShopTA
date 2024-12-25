<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mỳ Cay Trang Anh Cart</title>
    <link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
<h1>Mỳ Cay Trang Anh Cart</h1>
<div class="shopping-cart">
    <div class="column-labels">
        <label class="product-image">Image</label>
        <label class="product-details">Product</label>
        <label class="product-price">Price</label>
        <label class="product-quantity">Quantity</label>
        <label class="product-removal">Remove</label>
        <label class="product-line-price">Total</label>
    </div>
    <div class="product">
        <div class="product-image">
            <img src="https://food.ibin.vn/images/data/product/mi-kim-chi-bo/mi-kim-chi-bo-001.jpg">
        </div>
        <div class="product-details">
            <div class="product-title">Mì Cay Bò</div>
            <p class="product-description">Mì cay với thịt bò tươi mềm và nước dùng cay đậm đà</p>
        </div>
        <div class="product-price">52.000</div>
        <div class="product-quantity">
            <input type="number" value="2" min="1">
        </div>
        <div class="product-removal">
            <button class="remove-product">Remove</button>
        </div>
        <div class="product-line-price">52.000</div>
    </div>
    <div class="product">
        <div class="product-image">
            <img src="https://food.ibin.vn/images/data/product/mi-kim-chi-bo/mi-kim-chi-bo-001.jpg">
        </div>
        <div class="product-details">
            <div class="product-title">Mì Cay Sườn Non</div>
            <p class="product-description">Mì cay với sườn non mềm, nước dùng cay nồng</p>
        </div>
        <div class="product-price">45.000</div>
        <div class="product-quantity">
            <input type="number" value="1" min="1">
        </div>
        <div class="product-removal">
            <button class="remove-product">Remove</button>
        </div>
        <div class="product-line-price">45.000</div>
    </div>
    <div class="totals">
        <div class="totals-item">
            <label>Subtotal</label>
            <div class="totals-value" id="cart-subtotal">71.970</div>
        </div>
        <div class="totals-item">
            <label>Tax (5%)</label>
            <div class="totals-value" id="cart-tax">3.600</div>
        </div>
        <div class="totals-item">
            <label>Shipping</label>
            <div class="totals-value" id="cart-shipping">15.000</div>
        </div>
        <div class="totals-item totals-item-total">
            <label>Grand Total</label>
            <div class="totals-value" id="cart-total">90.570</div>
        </div>
    </div>
    <button class="checkout">Checkout</button>
</div>
<script src="js/cart.js"></script>
</body>
</html>
