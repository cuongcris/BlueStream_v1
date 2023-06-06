<%@page import="java.util.*"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>

<html lang="zxx">

    <head>
        <%@include file="Head.jsp" %>
        <title>Blue Stream | Watching Anime</title>

        <%@include file="Advertisement.jsp" %>
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <%@include file="Header.jsp" %>

        <!-- Breadcrumb Begin -->
        <div class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__links">
                            <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                            <a href="./categories.html">Categories</a>
                            <a href="#">Romance</a>
                            <span>Fate Stay Night: Unlimited Blade</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Anime Section Begin -->
        <section class="anime-details spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="anime__video__player">

                            <iframe width="1100" height="620" src="${episode.movieLink}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

                        </div>

                        <div class="anime__details__episodes">
                            <div class="section-title">
                                <h5>Episode:</h5>
                            </div>

                            <c:forEach var="i" begin="1" end="${totalEp}">


                                <c:if test="${Integer.parseInt(epNumShow) == i}">
                                    <a href="WatchAnime?id=${episode.movieId}&epNum=${i}" style="background: #e61b1b; font-weight: 900;">
                                        ${i}
                                    </a>
                                </c:if>

                                <c:if test="${Integer.parseInt(epNumShow) != i}">
                                    <a href="WatchAnime?id=${episode.movieId}&epNum=${i}" style="font-weight: 900;">
                                        ${i}
                                    </a>
                                </c:if>
                            </c:forEach>

                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8">
                        <div class="anime__details__review">
                            <div class="section-title">
                                <h5>Reviews ${totalEp}</h5>
                            </div>

                            <c:set var="list" value ="${commentList}" />
                            <c:forEach var="dto" items ="${commentList}" >
                                <div class="anime__review__item">
                                    <div class="anime__review__item__pic">
                                        <c:if test="${dao.getAvatarByID(dto.useID) == null}">
                                            <img src="https://nhadepso.com/wp-content/uploads/2023/03/cap-nhat-50-hinh-anh-dai-dien-facebook-mac-dinh-dep-doc-la_17.jpg" alt="">
                                        </c:if>

                                        <c:if test="${dao.getAvatarByID(dto.useID) != null}">
                                            <img src="${dao.getAvatarByID(dto.useID)}" alt="">
                                        </c:if>
                                    </div>
                                    <div class="anime__review__item__text">
                                        <h6>${dao.getUseNameByID(dto.useID)} - <span>${dto.time}</span>
                                        </h6>
                                        <p> ${dto.commentContent}</p>
                                    </div>
                                </div>
                            </c:forEach>

                            <c:if test="${commentList == null}">
                                <h2>No record is matched!!!</h2>
                            </c:if>
                        </div>
                        <div class="anime__details__form">
                            <div class="section-title">
                                <h5>Your Comment</h5>
                            </div>
                            <form action="addComment" method="post">
                                <input hidden name="id" value="${sessionScope.movieID}"/>
                                <input hidden name="epNum" value="${sessionScope.epNum}"/>
                                <c:if test="${sessionScope.account!=null }"> 

                                    <textarea placeholder="Your Comment" name="content"></textarea>
                                    <button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
                                </c:if>

                                <c:if test="${sessionScope.account == null }"> 

                                    <textarea placeholder="Your Comment"></textarea>
                                    <button type="button" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-location-arrow"></i> Review</button>
                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Error</h5>                                            
                                                </div>
                                                <div class="modal-body">
                                                    You need to be logged in to comment!
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <button onclick="window.location = 'Login.jsp'" type="button" class="btn btn-primary">Login</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>                              
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Anime Section End -->

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