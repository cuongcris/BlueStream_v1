

<!-- Header Section Begin -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="controller.Format" %>
<jsp:useBean id="format" class="controller.Format" />
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
                                <span class="infor">
                                    <a href="profile.jsp" style="color: red;">  ${sessionScope.account.userName.toUpperCase()}</a>      
                                </span> 
                            </c:when>

                            <c:when test="${sessionScope.account.role == 1}">
                                <span class="infor">
                                    <a href="profile.jsp" style="color: yellow;">  ${sessionScope.account.userName.toUpperCase()}</a>      
                                </span> 
                            </c:when>

                            <c:otherwise>
                                <span class="infor">
                                    <a href="profile.jsp">  ${sessionScope.account.userName.toUpperCase()}</a>      
                                </span>  
                            </c:otherwise>
                        </c:choose>


                    </c:if>
                </div>
            </div>
        </div>

    </div>

    <style>

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

    </style>
</header>
<!-- Header End -->
