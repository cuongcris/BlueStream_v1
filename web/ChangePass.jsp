<html lang="en">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <%@include file="Head.jsp" %>

    </head>

    <body>
 <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>
        <header class="header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2">
                        <div class="header__logo">
                            <a href="./Home.jsp">
                                <img src="img/blueIcon.png" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="header__nav">
                            <nav class="header__menu mobile-menu">
                                <ul>
                                    <li><a href="home">Homepage</a></li>
                                    <li><a href="./Categorys.jsp">Categories <span class="arrow_carrot-down"></span></a>
<!--                                        <ul class="dropdown">
                                            <li><a href="./Categorys.jsp">Categories</a></li>
                                            <li><a href="./DetailAnime.jsp">Anime Details</a></li>
                                            <li><a href="./WatchingAnime.jsp">Anime Watching</a></li>
                                            <li><a href="./BlogDetail.jsp">Blog Details</a></li>
                                            <li><a href="./SignUp.jsp">Sign Up</a></li>
                                            <li><a href="./Login.jsp">Login</a></li>
                                        </ul>-->
                                    </li>
                                    <li><a href="./Blog.jsp">Our Blog</a></li>
                                    <li><a href="#">Contacts</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="header__right">
                            <a href="#" class="search-switch"><span class="icon_search"></span></a>
                            <a href="./Login.jsp"><span class="icon_profile"></span></a>
                        </div>
                    </div>
                </div>
                <div id="mobile-menu-wrap"></div>
            </div>
        </header>
        <div class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__links">
                            <a href="home"><i class="fa fa-home"></i> Home</a>
                            <a href="profile.jsp">Profile</a>
                                <a href="ChangePass.jsp">Change Password</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <section class="anime-details spad">
            <div class="container">
                <div class="anime__details__content">
                    <div class="row">
                        <div class="col-lg-3">

                            <div class="anime__details__pic set-bg">
                                <img style="width: 400px; height: 250px; border-radius: 1000px" src="${account.image}" alt="avatar"
                                     onerror="this.src = 'https://cdn.pixabay.com/photo/2017/02/12/21/29/false-2061131_1280.png';"
                                     />
                                <div class="infor_button">
                                    <form action="logout" method="post">
                                        <span><button type="submit" class="btn btn-primary btn-logout">Logout</button></span>
                                    </form>
                                    <form action="" method="post">
                                        <span><button type="submit" class="btn btn-primary btn-logout"><a href="profile.jsp" >Profile</a></button></span>
                                    </form>
                                </div>
                            </div>

                        </div>
                        <div class="col-lg-9">
                            <div class="anime__details__text">
                                <div class="anime__details__title">
                                    <h3>Change Password:</h3>
                                </div>
                                
                                ${finish_messe}
                                
                                <form action="changepass" method="Post">
                                    <div class="anime__details__widget">
                                        <div class="container">
                                            <div
                                                class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-12 col-xs-12 edit_information">
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-sm-6 col-xs-12">
                                                        <label class="profile_details_text">Username:</label>
                                                        <input type="text" name="fullname" class="form-control" value="${account.userName}"
                                                               readonly>
                                                    </div>

                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                        <label class="profile_details_text">Email Address:</label>
                                                        <input type="email" name="email" class="form-control" value="${account.email}" readonly>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                        <label class="profile_details_text">Current Password:</label>
                                                        <input type="password" name="cur_pass" class="form-control" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$"
                                                               title="Password must have a character and number." required="">

                                                    </div>
                                                </div>

                                                ${error_mess1}

                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                        <label class="profile_details_text">New Password:</label>
                                                        <input type="password" name="new_pass" class="form-control" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$"
                                                               title="Password must have a character and number."
                                                               required >
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                        <label class="profile_details_text">Confirm New Password: </label>
                                                        <input type="password" name="new_pass1" class="form-control"pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{4,}$"
                                                               title="Password must have a character and number." required="" >
                                                    </div>
                                                </div>

                                                ${error_mess}

                                                <div>
                                                    <div class="anime__details__btn">

                                                        <button type="submit" class="Save_btn">
                                                            <i class="fa fa-heart-o"></i> SAVE
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
        .profile_details_text{
            color: white;
        }

        .infor_button form{
            display: inline-block;
            margin-right:  5px;
        }

        .infor_button{
            margin-top: 30px;
            margin-left: 10px;
        }

        .infor_button .btn-logout:hover{
            background-color: orange;
        }

        .Save_btn{
            background: red;
            height: 40px;
            border-radius: 5px;
            color: white;
            margin-top: 20px;
            margin-left: 200px;
            border: 2px solid white;
        }
        
        .finish_mess h4{
            color: #16f716;
            font-weight: 800;
        }

        .Save_btn:hover{
            background: blue;
        }

        .profile_details_text{
            margin-top: 10px;
        }
        
        .infor_button a{
            color: white;
        }

        .Error{
            margin-top: 15px;
            background-color: #f34242;
            border-radius: 3px;
            text-align: center;
        }

        .Error p{
            color: white;
        }

    </style>
</html>