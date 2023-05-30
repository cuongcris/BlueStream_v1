<!DOCTYPE html>
<html lang="zxx">

    <head>

        <title>Blue Stream | Sign Up</title>
        <%@include file="Head.jsp" %>
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
                            <h2>Sign Up</h2>
                            <p>Welcome to the official Anime blog.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Normal Breadcrumb End -->

        <!-- Signup Section Begin -->
        <section class="signup spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="login__form">
                            <h3>Sign Up</h3>
                            <form action="signUp" method="Post">
                                <div class="input__item">
                                    <input type="email" name="email" placeholder="Email address"  value="${email_input}" required>
                                    <span class="icon_lock"><i class="fa-regular fa-envelope"></i></span>

                                </div>
                                ${error_email}
                                <div class="input__item">
                                    <input type="text" name="username" placeholder="UserName" value="${user_input}" required>
                                    <span class="icon_lock"><i class="fa-regular fa-user"></i></span>
                                </div>
                                ${error_username}  
                                <div class="input__item">
                                    <input type="password" name="password" placeholder="Password" 
                                           pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$"
                                           title="Password must have a character and number." required>
                                    <span class="icon_lock"><i class="fa-solid fa-lock"></i></span>
                                </div>
                                <div class="input__item">
                                    <input type="password" name="pass_confirm" placeholder="Confirm Password"   
                                           pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$"
                                           title="Password must have a character and number." required>
                                    <span class="icon_lock"><i class="fa-solid fa-key"></i></span>

                                </div>
                                ${error_pass}
                                <button type="submit" class="site-btn">SignUp Now</button>
                            </form>
                            <h5>Already have an account? <a href="Login.jsp">Log In!</a></h5>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="login__social__links">
                            <h3>Login With:</h3>
                            <ul>
                                <li><a href="#" class="facebook"><i class="fa fa-facebook"></i> Sign in With Facebook</a>
                                </li>
                                <li><a href="#" class="google"><i class="fa fa-google"></i> Sign in With Google</a></li>
                                <li><a href="#" class="twitter"><i class="fa fa-twitter"></i> Sign in With Twitter</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Signup Section End -->

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

</html>

<style>
    .error-text{
        color: red;
        padding: 4px 6px;
        font-size: 16px;
        text-align: center;
        width: 370px;
        border-radius: 3px;
        background: #efabb0;
        border: 1px solid #d0001a;
        margin-bottom: 12px;
    }
</style>