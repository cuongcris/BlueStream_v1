

<!-- Header Section Begin -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="controller.Format" %>
<jsp:useBean id="format" class="controller.Format" />
<%@page import="entity.Account" %>
<%@page import="dao.AccountDAO" %>


<%
    Cookie[] cookies = request.getCookies();  
        String user = "", pass = "";
        if (cookies != null) {
            for(Cookie cook: cookies){
                String uName_check = cook.getName();
                if(uName_check.equals("name")){
                    if(cook.getValue() != null){
                        user = cook.getValue();
                    }
                }
                if(uName_check.equals("pass")){
                    if(cook.getValue() != null){
                        pass = cook.getValue();
                    }
                }
            }
            if (!user.isEmpty() && !pass.isEmpty()) {
                AccountDAO accDAO = new AccountDAO();
                Account a = accDAO.CheckLogin(user, pass);
                
                request.getSession().setAttribute("account", a);
            }
        }
%>
<header class="header">
    <div class="container">
        <div class="row" style="width: 100%;">
            <div class="col-lg-2">
                <div class="header__logo">
                    <a href="home">
                        <img src="img/blueIcon.png" alt="" >
                    </a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="header__nav">
                    <nav class="header__menu mobile-menu">
                        <ul class="header_details">
                            <!--class="active" n?m trong th? li m?i tab mình ??i qua ?? có background ch? ??nh tab màu ??-->
                            <li ><a href="home">Homepage</a></li>
                            <li><a href="AllMovie">Anime </span></a>

                            </li>
                            <li><a href="./Blog.jsp">Our Blog</a></li>
                            <li><a href="#">Contacts</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="header__right" style="text-align: left;">
                    <c:if test="${account == null || sessionScope.account.role == 2}">
                        <span class="up_VIP_icon">
                            <a href="Premium.jsp" class="search-switc h">
                                <div class="left_icon">
                                    <i class="fa-solid fa-crown fa-fade"></i>
                                </div>

                                <div class="right_icon"> 

                                    <span>UPDATE</span>
                                    <span>PREMIUM</span>
                                </div>
                                <div class="try-free">
                                    <h4> <i class="fa-solid fa-crown" style="color: #f0dc00;"></i>
                                        Premium User Benefits

                                    </h4>
                                    <h6>
                                        Premium access includes unlimited anime no ads,
                                        and new episodes shortly after they air in Japan.
                                        Try it now!
                                    </h6>
                                </div>
                            </a>
                        </span>
                    </c:if>
                    <span class="donate_icon">
                        <c:choose>
                            <c:when test="${sessionScope.account == null}">
                                <a href="Login.jsp" class="search-switc h">
                                    <div class="mid_left_icon">
                                        <i class="fa-solid fa-hand-holding-dollar fa-fade"></i>
                                    </div>

                                    <div class="mid_right_icon">
                                        <span>Donate</span>
                                    </div>
                                    <div class="try-donate">
                                        <h4>  <i class="fa-solid fa-hand-holding-dollar fa-fade"></i>
                                            Donate For Us

                                        </h4>
                                        <h6>
                                            Donate now to improve our website experience. Your support matters!
                                        </h6>


                                    </div>
                                </a>
                            </c:when>
                            <c:when test="${sessionScope.account != null}">
                                <a href="NavigationDonate" class="search-switc h">
                                    <div class="mid_left_icon">
                                        <i class="fa-solid fa-hand-holding-dollar fa-fade"></i>
                                    </div>

                                    <div class="mid_right_icon">
                                        <span>Donate</span>
                                    </div>
                                    <div class="try-donate">
                                        <h4>  <i class="fa-solid fa-hand-holding-dollar fa-fade"></i>
                                            Donate For Us
                                        </h4>
                                        <h6>
                                            Donate now to improve our website experience. Your support matters!
                                        </h6>
                                    </div>
                                </a>
                            </c:when>
                        </c:choose>
                    </span>
                    <c:if test="${account == null}">
                        <span class="infor"> 
                            <a href="Login.jsp"><i class="fa-regular fa-user"></i> Login</a>

                        </span>

                    </c:if>

                    <c:if test="${account != null}">

                        <c:choose>
                            <c:when test="${sessionScope.account.role == 0}">
                                <span class="infor user-panel">

                                    <a style="color: red;">  ${sessionScope.account.userName.toUpperCase()}</a>    
                                    <div class="dropdown-user">

                                        <a href="profile.jsp"> 
                                            <i class="fa-solid fa-address-card"></i>
                                            Profile
                                        </a>

                                        <a href="ChangePass.jsp"> 
                                            <i class="fa-solid fa-lock"></i>
                                            Change Pass
                                        </a>

                                        <a href="Favorite">
                                            <i class="fa-solid fa-heart"></i>
                                            Favorite
                                        </a>
                                        <a href="History">
                                            <i class="fa-solid fa-clock-rotate-left"></i>
                                            History
                                        </a>

                                        <a href="AdminControl">
                                            <i class="fa-solid fa-screwdriver-wrench"></i>
                                            Admin Panel
                                        </a>

                                        <a href="logout"><i class="fa-solid fa-right-from-bracket"></i>
                                            Logout
                                        </a>
                                    </div>
                                </span>  
                            </c:when>

                            <c:when test="${sessionScope.account.role == 1}">
                                 <span class="infor user-panel">

                                    <a style="color: yellow;">  ${sessionScope.account.userName.toUpperCase()}</a>    
                                    <div class="dropdown-user">

                                        <a href="profile.jsp"> 
                                            <i class="fa-solid fa-address-card"></i>
                                            Profile
                                        </a>

                                        <a href="ChangePass.jsp"> 
                                            <i class="fa-solid fa-lock"></i>
                                            Change Pass
                                        </a>

                                        <a href="Favorite">
                                            <i class="fa-solid fa-heart"></i>
                                            Favorite
                                        </a>
                                        <a href="History">
                                            <i class="fa-solid fa-clock-rotate-left"></i>
                                            History
                                        </a>
                                        <a href="logout"><i class="fa-solid fa-right-from-bracket"></i>
                                            Logout
                                        </a>



                                    </div>
                                </span> 
                            </c:when>

                            <c:otherwise>
                                <span class="infor user-panel">
                                    <a>  ${sessionScope.account.userName.toUpperCase()}</a>   
                                    <div class="dropdown-user">

                                        <a href="profile.jsp"> <i class="fa-solid fa-address-card"></i>
                                            Profile
                                        </a>

                                        <a href="ChangePass.jsp"> 
                                            <i class="fa-solid fa-lock"></i>
                                            Change Pass
                                        </a>

                                        <a>
                                            <i class="fa-solid fa-heart"></i>
                                            Favorite
                                        </a>
                                        <a><i class="fa-solid fa-clock-rotate-left"></i>
                                            History
                                        </a>
                                        <a href="logout"><i class="fa-solid fa-right-from-bracket"></i>
                                            Logout
                                        </a>



                                    </div>
                                </span>   
                            </c:otherwise>
                        </c:choose>


                    </c:if>
                </div>
            </div>
        </div>

    </div>

    <style>
 /*profile*/


        .user-panel {
            display: inline-block;
            position: relative;
        }
        .dropdown-user{
            display: none;
            position: absolute;
            top: 45px;
            background-color: #E0E0E0;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 9999;
            left: -2.8%;
            border-radius: 5%;
        }
        .user-panel:hover .dropdown-user {
            display: block;
        }
        .dropdown-user:hover{
            display: block;
        }

        .dropdown-user a {
            text-align: left;
            margin-right: 0;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }
        .dropdown-user a:hover{
            background-color: black;
            color: white;
            cursor: pointer;
        }

        .col-lg-3{
            padding: 0;
        }

        .header__menu ul li a{
            font-size: 16px;
            padding: 24px;
        }

        .infor{
            color: white;
            margin-left: 5px;
            font-weight: 800;
            border-left: solid 2px rgb(245 241 241 / 50%);
            padding: 10px 0 10px 8px;
        }

        .infor a{
            font-size: 16px;
        }
        .infor i{
            margin-right: 3px;
        }

        .donate_icon,
        .up_VIP_icon {
            display: inline-block;
        }

        .donate_icon a,
        .up_VIP_icon a {
            display: flex;
            align-items: center;
            text-decoration: none;
        }

        .header__right{
            margin-left: 0;
        }

        .donate_icon i,
        .up_VIP_icon i{
            font-size: 22px;
        }

        .left_icon {
            margin-right: 5px;
            margin-left: 4px;
        }

        .fa-crown {
            color: gold;
        }

        .right_icon span {
            margin-right: 5px;
            font-size: 12px;
            text-align: center;
        }

        .right_icon{
            display: flex;
            flex-direction: column;
        }

        .infor:hover,
        .donate_icon:hover,
        .up_VIP_icon:hover{
            background-color: rgb(99 99 102);
            border-radius: 5px;
        }
        .mid_right_icon span{
            font-size: 14px;
        }

        .up_VIP_icon,
        .donate_icon{
            padding-left: 2px;
            padding: 7px 0 6px 12px;
        }
        .donate_icon{
            border-left: solid 2px rgb(245 241 241 / 50%);
        }
        .mid_left_icon{
            margin-right: 5px;
        }
        .up_VIP_icon:hover .try-free{
            display: block;
        }

        .up_VIP_icon{
            position: relative;
            display: inline-block;

        }
        .try-free {
            padding: 10px 20px;
            left: -120%;
            width: 360px;
            height: 156px;
            display: none;
            top : 50px;
            position: absolute;
            background-image: url('https://lh3.googleusercontent.com/u/0/drive-viewer/AFGJ81rGmhN0m5aQELCXy46sLUNm3FZdRndRF10t9WRriQ5IdMSkOtL-J8aJyrm8XuI8pfxCyuBFvDACZpT028cVLvTZ-x3q=w2560-h1321') ;
            background-size: cover;
            box-shadow: 5px 12px 16px 5px rgba(255,255 ,255,0.1);
            z-index: 99;

        }
        .try-free h4 ,
        .try-free h6{
            color: white !important;
            margin-top: 15px;
            text-align: center;
        }
        .try-free:hover{
            display: block;
        }

        /*donate*/
        .donate_icon:hover .try-donate{
            display: block;

        }

        .donate_icon{
            position: relative;
            display: inline-block;
        }
        .try-donate {
            padding: 10px 20px;
            left: -120%;
            width: 360px;
            height: 156px;
            display: none;
            top : 45px;
            position: absolute;
            background-image: url('https://lh3.googleusercontent.com/u/0/drive-viewer/AFGJ81rGmhN0m5aQELCXy46sLUNm3FZdRndRF10t9WRriQ5IdMSkOtL-J8aJyrm8XuI8pfxCyuBFvDACZpT028cVLvTZ-x3q=w2560-h1321') ;
            background-size: cover;
            box-shadow: 5px 12px 16px 5px rgba(255,255 ,255,0.1);
            z-index: 99;

        }
        .try-donate h4 ,
        .try-donate h6{
            color: white !important;
            margin-top: 15px;
            text-align: center;


        }
        .try-donate:hover{
            display: block;
        }s
    </style>
</header>
<!-- Header End -->
