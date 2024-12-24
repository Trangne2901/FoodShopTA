document.addEventListener("DOMContentLoaded", function() {
    let priceElements = document.querySelectorAll('.cost');

    priceElements.forEach(function(el) {
        let text = el.textContent;
        let newText = text.replace("VND", "").trim(); // Loại bỏ VND
        el.textContent = newText + " VND"; // Thêm VND vào sau giá
    });
});
