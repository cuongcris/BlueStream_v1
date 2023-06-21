<%-- 
    Document   : Favourite
    Created on : Jun 17, 2023, 2:20:07 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Head.jsp" %>
<!DOCTYPE html>
<html>
    <%@include file="Header.jsp" %>
    <head>
        <title>Blue Stream - Favorite</title>
    </head>
    <body>
        <section class="section-products">
            <div class="container">
                <div class="row justify-content-center text-center">
                    <div class="col-md-8 col-lg-6">
                        <div style="background-color: #0b0c2a;" class="header">
                            <h3 >Blue Stream Anime</h3>
                            <h2>Your Favorite</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <!-- Single Product -->
                    <c:set var="list" value ="${requestScope.listFavorite}" />
                    <c:forEach var="dto" items ="${list}" >
                        <div class="col-md-6 col-lg-4 col-xl-3">
                            <div id="product-1" class="single-product">
                                <div style="background : url(${dto.movieBanner});border-radius:5%;background-repeat: no-repeat; background-position: center;background-size: cover;border: 2px solid white;transition: all 0.3s;" no-repeat center" class="part-1">
                                    <ul>
                                        <li><a id="center_icon" href="DetailAnime?id=${dto.movieID}"><i class="fa-solid fa-film"></i></a></li>
                                        <li><a id="center_icon" class="delete-link" href="#" data-movie-id="${dto.movieID}"><i class="fa-solid fa-trash-can"></i></a></li>
                                        <li><a id="center_icon" href="#"><i class="fa-brands fa-facebook"></i></a></li>
                                    </ul>
                                </div>
                                <div class="part-2">
                                    <h3 class="product-title">${dto.movieName}</h3>
                                    <h4 style="color:white;" class="product-price">${dto.favDate}</h4>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:if test="${empty list}">
                        <h2>History Empty :3</h2>
                    </c:if>
                    <!-- Single Product -->
                </div>
            </div>
        </section>     
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var deleteLinks = document.querySelectorAll('.delete-link');
                deleteLinks.forEach(function (link) {
                    link.addEventListener('click', function (event) {
                        event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>

                        var movieID = link.getAttribute('data-movie-id');
                        if (confirm("Do you want to delete?")) {
                            var form = document.createElement('form');
                            form.method = 'POST';
                            form.action = 'DeleteFavorite';
                            var movieIDInput = document.createElement('input');
                            movieIDInput.type = 'hidden';
                            movieIDInput.name = 'movieID';
                            movieIDInput.value = movieID;
                            form.appendChild(movieIDInput);
                            document.body.appendChild(form);
                            form.submit();
                        }
                    });
                });
            });
        </script>
    </body>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

        body {
            font-family: "Poppins", sans-serif;
            color: #444444;
        }
        #center_icon {
            display: flex;
            justify-content: center; /* Căn giữa ngang */
            align-items: center; /* Căn giữa dọc */
        }
        a,
        a:hover {
            text-decoration: none;
            color: inherit;
        }

        .section-products {
            padding: 30px 0 54px;
        }

        .section-products .header {
            margin-bottom: 100px;
        }

        .section-products .header h3 {
            font-size: 1.2rem;
            color: #fe302f;
            font-weight: 500;
        }

        .section-products .header h2 {
            font-size:2.2rem;
            font-weight: 400;
            color: white;

        }

        .section-products .single-product {
            margin-bottom: 26px;
        }

        .section-products .single-product .part-1 {
            position: relative;
            height: 290px;
            max-height: 290px;
            margin-bottom: 20px;
            overflow: hidden;
        }

        .section-products .single-product .part-1::before {
            position: absolute;
            content: "";
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1;
            transition: all 0.3s;
        }

        .section-products .single-product:hover .part-1::before {
            transform: scale(1.2,1.2) rotate(5deg);
        }

        .section-products #product-1 .part-1::before {
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            border: 2px solid #000;
            transition: all 0.3s;
        }

        .section-products #product-2 .part-1::before {
            background: url("https://i.ibb.co/cLnZjnS/2.jpg") no-repeat center;
            background-size: cover;
        }

        .section-products #product-3 .part-1::before {
            background: url("https://i.ibb.co/L8Nrb7p/1.jpg") no-repeat center;
            background-size: cover;
        }

        .section-products #product-4 .part-1::before {
            background: url("https://i.ibb.co/cLnZjnS/2.jpg") no-repeat center;
            background-size: cover;
        }

        .section-products .single-product .part-1 .discount,
        .section-products .single-product .part-1 .new {
            position: absolute;
            top: 15px;
            left: 20px;
            color: #ffffff;
            background-color: #fe302f;
            padding: 2px 8px;
            text-transform: uppercase;
            font-size: 0.85rem;
        }

        .section-products .single-product .part-1 .new {
            left: 0;
            background-color: #444444;
        }

        .section-products .single-product .part-1 ul {
            position: absolute;
            bottom: -41px;
            left: 20px;
            margin: 0;
            padding: 0;
            list-style: none;
            opacity: 0;
            transition: bottom 0.5s, opacity 0.5s;
        }

        .section-products .single-product:hover .part-1 ul {
            bottom: 30px;
            opacity: 1;
        }

        .section-products .single-product .part-1 ul li {
            display: inline-block;
            margin-right: 4px;
        }

        .section-products .single-product .part-1 ul li a {
            display: inline-block;
            width: 40px;
            height: 40px;
            line-height: 40px;
            background-color: #ffffff;
            color: #444444;
            text-align: center;
            box-shadow: 0 2px 20px rgb(50 50 50 / 10%);
            transition: color 0.2s;
        }

        .section-products .single-product .part-1 ul li a:hover {
            color: #fe302f;
        }

        .section-products .single-product .part-2 .product-title {
            color:white;
            font-size: 1rem;
        }

        .section-products .single-product .part-2 h4 {
            display: inline-block;
            font-size: 1rem;
        }

        .section-products .single-product .part-2 .product-old-price {
            color:white;
            position: relative;
            padding: 0 7px;
            margin-right: 2px;
            opacity: 0.6;
        }

        /*.section-products .single-product .part-2 .product-old-price::after {
            
            position: absolute;
            content: "";
            top: 50%;
            left: 0;
            width: 100%;
            height: 1px;
            background-color: #444444;
            transform: translateY(-50%);
        }*/
    </style>

</html>
