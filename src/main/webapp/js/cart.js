/* Set rates + misc */
var taxRate = 0.05;
var shippingRate = 15.0;
var fadeTime = 300;

/* Assign actions */
document.querySelectorAll('.product-quantity input').forEach(function (input) {
    input.addEventListener('change', function () {
        updateQuantity(this);
    });
});

document.querySelectorAll('.product-removal button').forEach(function (button) {
    button.addEventListener('click', function () {
        removeItem(this);
    });
});

/* Recalculate cart */
function recalculateCart() {
    var subtotal = 0;

    /* Sum up row totals */
    document.querySelectorAll('.product').forEach(function (product) {
        subtotal += parseFloat(product.querySelector('.product-line-price').textContent);
    });

    /* Calculate totals */
    var tax = subtotal * taxRate;
    var shipping = subtotal > 0 ? shippingRate : 0;
    var total = subtotal + tax + shipping;

    /* Update totals display */
    document.getElementById('cart-subtotal').textContent = subtotal.toFixed(2);
    document.getElementById('cart-tax').textContent = tax.toFixed(2);
    document.getElementById('cart-shipping').textContent = shipping.toFixed(2);
    document.getElementById('cart-total').textContent = total.toFixed(2);

    if (total === 0) {
        document.querySelector('.checkout').style.display = 'none';
    } else {
        document.querySelector('.checkout').style.display = 'block';
    }
}

/* Update quantity */
function updateQuantity(quantityInput) {
    /* Calculate line price */
    var productRow = quantityInput.closest('.product');
    var price = parseFloat(productRow.querySelector('.product-price').textContent);
    var quantity = parseInt(quantityInput.value, 10);

    if (isNaN(quantity) || quantity <= 0) {
        quantity = 1;
        quantityInput.value = 1;
    }

    var linePrice = price * quantity;

    /* Update line price display without causing layout shift */
    var linePriceElement = productRow.querySelector('.product-line-price');
    linePriceElement.textContent = linePrice.toFixed(2);

    /* Recalculate cart totals */
    recalculateCart();
}

/* Remove item from cart */
function removeItem(removeButton) {
    /* Remove row from DOM and recalculate cart totals */
    var productRow = removeButton.closest('.product');
    productRow.remove();
    recalculateCart();
}
