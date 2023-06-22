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
        <%@include file="Header.jsp" %>
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
        <%@include file="Footer.jsp" %>
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