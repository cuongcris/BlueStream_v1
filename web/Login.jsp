
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="zxx">

    <head>
        <%@include file="Head.jsp" %>
        <title>Blue Stream | Login</title>
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <%@include file="Header.jsp" %>

        <!-- Normal Breadcrumb Begin -->
        <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div class="normal__breadcrumb__text">
                            <h2>Login</h2>
                            <p>Welcome to the official Anime blog.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Normal Breadcrumb End -->
        <div class="welcome_mess">
            <center>
                ${regis_sucsess}
            </center>
        </div>
        <!-- Login Section Begin -->
        <section class="login spad">

            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="login__form">
                            <h3>Login</h3>
                            <h3 style="color: red">${requestScope.error}</h3>
                            <form action="login" method="post">
                                <div class="input__item">
                                    <input type="text" name="username" placeholder="User Name">
                                    <span ><i class="fa-regular fa-user"></i></span>
                                </div>
                                <div class="input__item">
                                    <input type="password" name="password" placeholder="Password" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$"
                                           title="Password must have a character and number." required>
                                    <span ><i class="fa-solid fa-lock"></i></span>
                                </div>
                                
                                <div class="input_remem">
                                    <input type="checkbox" id="id" name="remem" value="remem">
                                    <span>Remember me!</span>
                                </div>
                                <button type="submit" class="site-btn">Login Now</button>
                            </form>
                            <a href="#" class="forget_pass">Forgot Your Password?</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="login__register">
                            <h3>Dont't Have An Account?</h3>
                            <a href="SignUp.jsp" class="primary-btn">Register Now</a>
                        </div>
                    </div>
                </div>
                <div class="login__social">
                    <div class="row d-flex justify-content-center">
                        <div class="col-lg-6">
                            <div class="login__social__links">
                                <span>or</span>
                                <ul>
                                    <li><a href="#" class="facebook"><i class="fa fa-facebook"></i> Sign in With
                                            Facebook</a></li>
                                    <li>
                                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BlueFashion/login_google&response_type=code&client_id=1085960907273-f5tpll8a3qh7i9mg1pv9oq1djo4iqelk.apps.googleusercontent.com&approval_prompt=force" class="google">
                                            <i class="fa fa-google"></i> Sign in With Google</a></li>                               
                                    </li>            
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Login Section End -->

        <!-- Footer Section Begin -->
        <footer class="footer">
            <div class="page-up">
                <a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="footer__logo">
                            <a href="./index.html"><img src="img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="footer__nav">
                            <ul>
                                <li class="active"><a href="./index.html">Homepage</a></li>
                                <li><a href="./categories.html">Categories</a></li>
                                <li><a href="./blog.html">Our Blog</a></li>
                                <li><a href="#">Contacts</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>

                    </div>
                </div>
            </div>
        </footer>
        <!-- Footer Section End -->

        <!-- Search model Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch"><i class="icon_close"></i></div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search model end -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/player.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>


    </body>
    <style>

        .welcome_mess{
            margin-top: 30px;
        }
        .welcome_mess h2{
            color: #25ff00;
        }
        
        .input_remem{
            margin-left: 10px;
        }
        
        .input_remem #id{
            height: 15px;
            width: 15px;
        }
        
        .input_remem span{
            color: white;
            font-size: 16px;
            margin-left: 10px;
        }

    </style>
</html>

