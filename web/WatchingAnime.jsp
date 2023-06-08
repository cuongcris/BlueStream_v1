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

                            <c:if test="${account == null || sessionScope.account.role == 2}">

                                <a href="https://fb88x.site/?gclid=Cj0KCQjwj_ajBhCqARIsAA37s0wo2iVTVcskTHMTtyusV5JaYw4VG_pO_e9JETCcNmmgfeiWzfeJHYAaAm0-EALw_wcB"
                                   target="_blank">
                                    <video id="video1" width="1100" height="620"
                                           src="https://scontent-vie1-1.xx.fbcdn.net/v/t39.25447-2/350788547_1262244478019535_8667585203368458079_n.mp4?_nc_cat=100&vs=b1eb9d89cd42a050&_nc_vs=HBksFQAYJEdNT2I2QlRQWjdzeEFYd0VBRjkzTmRQUmNrbDRibWRqQUFBRhUAAsgBABUAGCRHQnVSMGhUdy1tQTZpVzhGQU9KZ0s4TFBhSmtOYnJGcUFBQUYVAgLIAQBLB4gScHJvZ3Jlc3NpdmVfcmVjaXBlATENc3Vic2FtcGxlX2ZwcwAQdm1hZl9lbmFibGVfbnN1YgAgbWVhc3VyZV9vcmlnaW5hbF9yZXNvbHV0aW9uX3NzaW0AKGNvbXB1dGVfc3NpbV9vbmx5X2F0X29yaWdpbmFsX3Jlc29sdXRpb24AHXVzZV9sYW5jem9zX2Zvcl92cW1fdXBzY2FsaW5nABFkaXNhYmxlX3Bvc3RfcHZxcwAVACUAHIwXQAAAAAAAAAAREQAAACaQgoXPvbucAxUCKAJDMxgLdnRzX3ByZXZpZXccF0BMCp%2B%2Bdsi0GClkYXNoX2k0bGl0ZWJhc2ljXzVzZWNnb3BfaHEyX2ZyYWdfMl92aWRlbxIAGBh2aWRlb3MudnRzLmNhbGxiYWNrLnByb2Q4ElZJREVPX1ZJRVdfUkVRVUVTVBsKiBVvZW1fdGFyZ2V0X2VuY29kZV90YWcGb2VwX2hkE29lbV9yZXF1ZXN0X3RpbWVfbXMBMAxvZW1fY2ZnX3J1bGUHdW5tdXRlZBNvZW1fcm9pX3JlYWNoX2NvdW50AjM3EW9lbV9pc19leHBlcmltZW50AAxvZW1fdmlkZW9faWQPOTMxOTM0ODgxMzYzMTQxEm9lbV92aWRlb19hc3NldF9pZA8yNjY4ODI0MzI1MTMwODcVb2VtX3ZpZGVvX3Jlc291cmNlX2lkDzkwNzAxOTQ2MzcyOTI4OBxvZW1fc291cmNlX3ZpZGVvX2VuY29kaW5nX2lkEDE1MDY0MDcyMjY1NTU3NTAOdnRzX3JlcXVlc3RfaWQAJQIcACXEARsHiAFzBDIwMTUCY2QKMjAyMy0wNS0zMANyY2IBMANhcHAFVmlkZW8CY3QZQ09OVEFJTkVEX1BPU1RfQVRUQUNITUVOVBNvcmlnaW5hbF9kdXJhdGlvbl9zBjU2LjEwNgJ0cxVwcm9ncmVzc2l2ZV9lbmNvZGluZ3MA&ccb=1-7&_nc_sid=41a7d5&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=61-YQJM_Yz0AX-BtOEd&_nc_ht=scontent-vie1-1.xx&edm=APRAPSkEAAAA&oh=00_AfBWHHdqBCyiJeX-zK66BqlLyHZ6lxHFS2DdwgEl8RtFhw&oe=6482ECFE&_nc_rid=054302324458105"
                                           controls autoplay>
                                    </video>
                                </a>

                                <button id="skip-button" style="display: none;">Skip</button>
                                <div id="countdown" style="display: none;"></div>

                                <iframe id="video2"
                                        width="1100" height="620" src="${episode.movieLink}" frameborder="0" 
                                        allow="accelerometer; autoplay; 
                                        clipboard-write; encrypted-media; gyroscope; 
                                        picture-in-picture; web-share" 
                                        allowfullscreen>
                                </iframe>
                            </c:if>

                            <c:if test="${account != null || sessionScope.account.role == 0 || sessionScope.account.role == 0}">
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
                                <h5>Reviews ${totalEp}</h5>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__pic">
                                    <img src="img/anime/review-1.jpg" alt="">
                                </div>
                                <div class="anime__review__item__text">
                                    <h6>Chris Curry - <span>1 Hour ago</span></h6>
                                    <p> hello</p>
                                </div>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__pic">
                                    <img src="img/anime/review-2.jpg" alt="">
                                </div>
                                <div class="anime__review__item__text">
                                    <h6>Lewis Mann - <span>5 Hour ago</span></h6>
                                    <p>Finally it came out ages ago</p>
                                </div>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__pic">
                                    <img src="img/anime/review-3.jpg" alt="">
                                </div>
                                <div class="anime__review__item__text">
                                    <h6>Admin - <span>20 Hour ago</span></h6>
                                    <p>Where is the episode 15 ? Slow update! Tch</p>
                                </div>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__pic">
                                    <img src="img/anime/review-4.jpg" alt="">
                                </div>
                                <div class="anime__review__item__text">
                                    <h6>Chris Curry - <span>1 Hour ago</span></h6>
                                    <p>whachikan Just noticed that someone categorized this as belonging to the genre
                                        "demons" LOL</p>
                                </div>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__pic">
                                    <img src="img/anime/review-5.jpg" alt="">
                                </div>
                                <div class="anime__review__item__text">
                                    <h6>Lewis Mann - <span>5 Hour ago</span></h6>
                                    <p>Finally it came out ages ago</p>
                                </div>
                            </div>
                            <div class="anime__review__item">
                                <div class="anime__review__item__pic">
                                    <img src="img/anime/review-6.jpg" alt="">
                                </div>
                                <div class="anime__review__item__text">
                                    <h6>Louis Tyler - <span>20 Hour ago</span></h6>
                                    <p>Where is the episode 15 ? Slow update! Tch</p>
                                </div>
                            </div>
                        </div>
                        <div class="anime__details__form">
                            <div class="section-title">
                                <h5>Your Comment</h5>
                            </div>
                            <form action="#">
                                <textarea placeholder="Your Comment"></textarea>
                                <button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
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
    <style>
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
            background-color: rgb(248 247 247 / 10%);
            padding: 5px 21px;
            border-radius: 10px;
            font-weight: 800px;
        }
    </style>

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
                                background-color: rgb(248 247 247 / 10%); padding: 5px 21px; border-radius: 10px;'
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
</html>