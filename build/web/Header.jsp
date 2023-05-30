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
            <div class="col-lg-7">
                <div class="header__nav">
                    <nav class="header__menu mobile-menu">
                        <ul>
                            <!--class="active" n?m trong th? li m?i tab mình ??i qua ?? có background ch? ??nh tab màu ??-->
                            <li ><a href="home">Homepage</a></li>
                            <li><a href="./Categorys.jsp">Categories </span></a>
                                <!--                                    <ul class="dropdown">
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
            <div class="col-lg-3">
                <div class="header__right" style="text-align: left;">
                    <span>
                        <a href="#" class="search-switc h"><i class="fa-solid fa-magnifying-glass"></i></a>
                    </span>
                        <c:if test="${account == null}">
                        <span class="infor"> 
                            <a href="Login.jsp"><i class="fa-regular fa-user"></i> Login</a>
                            
                        </span>

                    </c:if>
                    <c:if test="${account != null}">
                        <span class="infor">
                            <a href="profile.jsp"><i class="fa-regular fa-user"></i>  ${sessionScope.account.userName.toUpperCase()}</a>
                            
                        </span>              
                    </c:if>
                </div>
            </div>
        </div>
        
    </div>
    
    <style> 
        .infor{
            color: white;
            margin-left: 30px;
            font-weight: 800;
        }
        .infor i{
            margin-right: 10px;
        }
    </style>
</header>
<!-- Header End -->
