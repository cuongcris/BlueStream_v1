<%@page import="java.util.*"%>
<%@ page import="java.time.LocalDate" %>
<jsp:useBean id="com" class="dao.CommentDAO" />
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
                            <c:if test="${account == null || sessionScope.account.role == 2}">
                                <c:forEach var="dto" items ="${sessionScope.ads_show}" >
                                    <c:if test="${dto.type.equals('Video')}">
                                        <a href="${dto.linkTo}" target="_blank">
                                            <video id="video1" 
                                                   width="1100" height="620"
                                                   src="${dto.linkShow}"
                                                   controls >
                                            </video>
                                        </a>

                                        <button id="skip-button" style="display: none;">Skip</button>
                                        <div id="countdown" style="display: none;"></div>
                                    </c:if>

                                    <iframe id="video2"
                                            width="1100" height="620" 
                                            src="${episode.movieLink}" 
                                            frameborder="0" 
                                            allow="accelerometer; autoplay; 
                                            clipboard-write; encrypted-media; gyroscope; 
                                            picture-in-picture; web-share" 
                                            allowfullscreen>
                                    </iframe>
                                </c:forEach>
                            </c:if>

                            <c:if test="${account != null && sessionScope.account.role == 1 || account != null && sessionScope.account.role == 0}">
                                <iframe src="${episode.movieLink}"  
                                        width="1100" height="620" allow="accelerometer; autoplay; 
                                        clipboard-write; encrypted-media; gyroscope; 
                                        picture-in-picture; web-share" frameborder="0"
                                        allowfullscreen>
                                </iframe>
                            </c:if>
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
                                <h5>Reviews: </h5>
                            </div>

                            <c:set var="list" value ="${commentList}" />
                            <c:forEach var="dto" items ="${commentList}" >
                                <div class="anime__review__item">
                                    <div class="anime__review__item__pic">
                                        <c:if test="${dto.avatar == null}">
                                            <img src="https://nhadepso.com/wp-content/uploads/2023/03/cap-nhat-50-hinh-anh-dai-dien-facebook-mac-dinh-dep-doc-la_17.jpg" alt="">
                                        </c:if>

                                        <c:if test="${dto.avatar != null}">
                                            <img src="${dto.avatar}" alt="">
                                        </c:if>
                                    </div>
                                    <div class="anime__review__item__text">
                                        <c:choose>
                                            <c:when test="${dto.role == 0}">
                                                <h6 style="color: red">
                                                    ${dto.userName} - Admin <span style="color: #b7b7b7" > - 
                                                        ${com.printDiffDay(dto.time)} </span>

                                                </h6>
                                            </c:when>

                                            <c:when test="${dto.role == 1}">
                                                <h6 style="color: yellow">
                                                    ${dto.userName} - VIP User <span style="color: #b7b7b7" > - 
                                                        ${com.printDiffDay(dto.time)}</span>
                                                </h6>
                                            </c:when>

                                            <c:otherwise>
                                                <h6>
                                                    ${dto.userName}  <span > - 
                                                        ${com.printDiffDay(dto.time)}</span>
                                                </h6>
                                            </c:otherwise>
                                        </c:choose>
                                        <p> ${dto.commentContent}</p>

                                        <c:if test="${sessionScope.account.userName.equals(dto.userName) || sessionScope.account.role == 0}">
                                            <span class="delete_button"> 
                                                <a href="#" onclick="delecteCheck('${dto.commentID}')">
                                                    <i class="fa-solid fa-trash"></i>
                                                </a> 
                                            </span>
                                        </c:if>
                                    </div>
                                </div>
                            </c:forEach>



                            <c:if test="${commentList == null}">
                                <h2 style="color: white">No record is matched!!!</h2>
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

                                    <textarea placeholder="Your Comment" required=""></textarea>
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

        <script>
                                function delecteCheck(id) {
                                    if (confirm("Are you want to delete this comment")) {
                                        window.location.href = 'addComment?del_id=' + id;
                                    }
                                }
        </script>



        <script>
            var video1 = document.getElementById('video1');
            var video2 = document.getElementById('video2');
            var skipButton = document.getElementById('skip-button');
            var countdown = document.getElementById('countdown');

            var countdownDuration = 10;
            var countdownInterval;

            var timeLeft = countdownDuration;
            //Start the countdown and hide the original "Skip" button
            function startCountdown() {
                countdown.innerHTML = 'Ads are skippable after ' + timeLeft + ' seconds';
                countdown.style = 'display:block; color: white;  font-weight: 800px;\n\
                                   position: absolute; bottom: 100px; right: 45px;\n\
                                    background-color: rgb(49 47 47 / 80%); padding: 5px 21px; border-radius: 10px;'
                skipButton.style.display = 'none';

                countdownInterval = setInterval(function () {
                    timeLeft--;
                    countdown.innerHTML = 'Ads are skippable after ' + timeLeft + ' seconds';

                    if (timeLeft <= 0) {
                        clearInterval(countdownInterval);
                        countdown.style.display = 'none';
                        skipButton.innerHTML = 'Skip ads';
                        skipButton.style = 'display:block;';
                    }
                }, 1000);
            }

            // When press Skip button
            skipButton.addEventListener('click', function () {
                video1.pause();
                video1.style.display = 'none';
                skipButton.style.display = 'none';
                video2.style.display = 'block';
                video2.play();
            });

            // Start countdown when click play button
            video1.addEventListener('play', function () {

                startCountdown();

            });

        </script>


        <style>
            .anime__review__item__text{
                position: relative;
            }

            .delete_button{
                position: absolute;
                right: 20px;
                top: 10px;
            }

            .delete_button i{
                color: white;
            }

            .anime__video__player{
                position: relative;
            }

            #video2 {
                display: none;
            }

            #skip-button {
                position: absolute;
                bottom:  85px;
                right: 75px;
                background: none;
                border: none;
                font-size: 16px;
                cursor: pointer;
                color: white;
                background-color: rgb(49 47 47 / 80%);
                padding: 5px 21px;
                border-radius: 10px;
                font-weight: 800px;
            }

        </style>

    </body>

</html>