<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Arima&family=Cookie&family=Dancing+Script&family=EB+Garamond:ital,wght@1,500&family=Open+Sans:wght@300&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/userpage.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Website</title>
</head>
<body>
<header>
    <h3>Mỳ cay Trang Anh</h3>
    <nav>
        <ul>
            <li><a href="#menu">Menu</a></li>
            <li><a href="#about">About Us</a></li>
            <li><a href="#orders">Online Orders</a></li>
            <li><a href="#contact">Contact</a></li>
        </ul>
    </nav>
    <div class="header-icons">
        <a href="www.google.com">
            <i class="fas fa-search"></i>
        </a>
        <a href="#cart">
            <i class="fas fa-shopping-cart"></i>
        </a>
    </div>
    <ul class="menu">
        <li><a class="menuItem" href="#menu">Menu</a></li>
        <li><a class="menuItem" href="#about">About Us</a></li>
        <li><a class="menuItem" href="#orders">Online Orders</a></li>
        <li><a class="menuItem" href="#contact">Contact</a></li>
        <li><a href="www.google.com">
            <i class="fas fa-search"></i>
        </a></li>
        <li><a href="#cart">
            <i class="fas fa-shopping-cart"></i>
        </a></li>
    </ul>
    <button class="hamburger">
        <i class="menuIcon material-icons">menu</i>
        <i class="closeIcon material-icons">close</i>
    </button>
</header>
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
            <div class="dish-one">
                <img src="https://food.ibin.vn/images/data/product/mi-kim-chi-bo/mi-kim-chi-bo-001.jpg"/>
                <div class="price">
                    <p class="dish">
                        DISH 1
                    </p>
                    <p class="cost">
                        $29.99
                    </p>
                </div>
                <p class="text">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia atque excepturi, qui cumque error
                    sequi!
                </p>
                <div class="icons">
                    <div class="clock">
                        <i class="fa fa-clock"></i><span>30 mins</span>
                    </div>
                </div>
                <button>Order Now</button>
            </div>
            <div class="dish-two">
                <img src="https://cdn.diemnhangroup.com/seoulacademy/2023/04/cach-lam-tra-tac-bang-tra-kho-1.jpg"/>
                <div class="price">
                    <p class="dish">
                        DISH 2
                    </p>
                    <p class="cost">
                        $30.00
                    </p>
                </div>
                <p class="text">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla voluptas recusandae, iusto fuga est
                    delectus.
                </p>
                <div class="icons">
                    <div class="clock">
                        <i class="fa fa-clock"></i><span>30 mins</span>
                    </div>
                </div>
                <button>Order Now</button>
            </div>
            <div class="dish-three">
                <img src="https://food.ibin.vn/images/data/product/mi-kim-chi-bo/mi-kim-chi-bo-001.jpg"/>
                <div class="price">
                    <p class="dish">
                    </p>
                    <p class="cost">
                        $25.87
                    </p>
                </div>
                <p class="text">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque unde quasi culpa quae in vero?
                </p>
                <div class="icons">
                    <div class="clock">
                        <i class="fa fa-clock"></i><span>30 mins</span>
                    </div>
                </div>
                <button>Order Now</button>
            </div>
            <div class="dish-four">
                <img src="https://food.ibin.vn/images/data/product/mi-kim-chi-bo/mi-kim-chi-bo-001.jpg"/>
                <div class="price">
                    <p class="dish">
                        DISH 4
                    </p>
                    <p class="cost">
                        $27.87
                    </p>
                </div>
                <p class="text">
                    Lorem ipsum dolor sit amet consectetur adipisicing elit
                </p>
                <div class="icons">
                    <div class="clock">
                        <i class="fa fa-clock"></i><span>30 mins</span>
                    </div>
                </div>
                <button>Order Now</button>
            </div>
            <div class="dish-five">
                <img src="https://food.ibin.vn/images/data/product/mi-dui-ga-kim-chi/mi-dui-ga-kim-chi-001.jpg"/>
                <div class="price">
                    <p class="dish">
                        Mì Cay Đùi Gà
                    </p>
                    <p class="cost">
                        60.000VNĐ
                    </p>
                </div>
                <p class="text">
                    Mì cay với thịt gà ngon, thấm gia vị
                </p>
                <div class="icons">
                    <div class="clock">
                        <i class="fa fa-clock"></i><span>30 mins</span>
                    </div>
                </div>
                <button>Order Now</button>
            </div>
            <div class="dish-six">
                <img src="https://food.ibin.vn/images/data/product/mi-kim-chi-bo/mi-kim-chi-bo-001.jpg"/>
                <div class="price">
                    <p class="dish">
                        Mỳ cay bò
                    </p>
                    <p class="cost">
                        65.000VNĐ
                    </p>
                </div>
                <p class="text">
                    Mì cay với thịt bò tươi mềm và nước dùng cay đậm đà
                </p>
                <div class="icons">
                    <div class="clock">
                        <i class="fa fa-clock"></i><span>30 mins</span>
                    </div>
                </div>
                <button>Order Now</button>
            </div>
        </div>
    </section>
</main>
<script src="js/userpage.js"></script>
</body>
</html>
