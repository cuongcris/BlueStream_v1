<!DOCTYPE html>
<html lang="zxx">

    <head>
        <%@include file="Head.jsp" %>
        <title>Blue Stream | Detail Anime</title>


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
                            <a href="home"><i class="fa fa-home"></i> Home</a>
                            <a href="./categories.html">Categories</a>
                            <span>${M.movieName}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Anime Section Begin -->
        <section class="anime-details spad">
            <div class="container">
                <div class="anime__details__content">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="anime__details__pic set-bg" data-setbg="${M.movieBanner}">
                                <div class="comment"><i class="fa fa-comments"></i> 11</div>
                                <div class="view"><i class="fa fa-eye"></i> ${format.formatNumber(M.movieView)}</div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="anime__details__text">
                                <div class="anime__details__title">
                                    <h3>${M.movieName}</h3>
                                    <span>${M.movieName}</span>
                                </div>

                                <p>${M.description}</p>
                                <div class="anime__details__widget">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <ul>


                                                <li><span>Date aired:</span>${M.releaseDate}</li>
                                                <li><span>License:</span> ${M.license}</li>
                                                <li><span>Genre:</span> ${M.category[0]},${M.category[1]}</li>
                                            </ul>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <ul>

                                                <li><span>Author:</span> ${M.author}</li>
                                                <li><span>Movie Status: </span> ${M.movieStatus}</li>
                                                <li><span>Views:</span> ${format.formatNumber(M.movieView)}</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="anime__details__btn">

                                    <!--admin 0 vip 1 user 2-->
                                    <!--already login-->

                                    <!--user v� guest, ko the favorite , va khong the coi phim co ban quyen--> 
                                    <c:if test="${sessionScope.account.role == 2 || sessionScope.account == null }">
                                        <c:if test=" ${sessionScope.account == null}">
                                            <a href="#" class="watch-btn" data-toggle="modal" data-target="#exampleModal">
                                                <span class="hover-button">
                                                    <span class="icon">
                                                        <i class="fa-solid fa-lock fa-fade"></i>
                                                    </span>
                                                    Favorite
                                                </span> 
                                            </a>
                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Hi friend</h5>                                            
                                                        </div>
                                                        <div class="modal-body">
                                                            You need to Login to Save this film !
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                            <button onclick="window.location = 'Login.jsp'" type="button" class="btn btn-primary">Go to Update</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test=" ${sessionScope.account.role == 2 }">
                                            <a href="#" class="watch-btn" data-toggle="modal" data-target="#exampleModal">
                                                <span class="hover-button">
                                                    <span class="icon">
                                                        <i class="fa-solid fa-lock fa-fade"></i>
                                                    </span>
                                                    Favorite
                                                </span> 
                                            </a>
                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Hi friend</h5>                                            
                                                        </div>
                                                        <div class="modal-body">
                                                            You need to Update to Premium User to save this film !
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                            <button onclick="window.location = ''" type="button" class="btn btn-primary">Go to Update</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${M.license.equals('License')}">

                                            <a href="#" class="watch-btn" data-toggle="modal" data-target="#exampleModal"><span class="hover-button">
                                                    <span class="icon">
                                                        <i class="fa-solid fa-lock fa-fade"></i>
                                                    </span>
                                                    Watch Now
                                                </span> </a>
                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Hi friend</h5>                                            
                                                        </div>
                                                        <div class="modal-body">
                                                            You need to update to Premium member in to watch this film !
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                            <button onclick="window.location = 'NavigationUpdateVip'" type="button" class="btn btn-primary">Go to Update</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>

                                        <c:if test="${M.license.equals('No License')}">
                                            <a href="WatchAnime?id=${M.movieId}&epNum=1" class="watch-btn">
                                                <span>
                                                    Watch Now
                                                </span>
                                            </a>
                                        </c:if>
                                    </c:if>

                                    <!--role vip or admin-->
                                    <c:if test="${sessionScope.account != null &&( sessionScope.account.role == 1 ||sessionScope.account.role == 0 )}">
                                        <a href="#" onclick="sendFavoriteRequest('${M.movieId}'); return false;"  class="watch-btn"></i> 
                                            <span > Favorite
                                            </span>
                                        </a>
                                        <a href="WatchAnime?id=${M.movieId}&epNum=1" class="watch-btn">

                                            <span >
                                                Watch Now
                                            </span>


                                        </a>
                                    </c:if>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <h3 style="color :white; margin-bottom: 10px;    ">Trailer</h3>

                <div id="success-message" style=" position: fixed;
                     top: 20px;
                     right: 20px;
                     padding: 10px;
                     background-color: #42b983;
                     color: #fff;
                     display: none;" class="notification">Save th�nh c�ng</div>


                <div class="row">

                    <c:choose>
                        <c:when test="${!trailerLink.isEmpty()}">
                            <div class="col-lg-8 col-md-8">
                                <iframe width="100%" height="498" src="${trailerLink}" title="My Happy Marriage | Official Trailer | Netflix" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                            </div>

                        </c:when>
                        <c:otherwise>
                            <div class="col-lg-8 col-md-8">
                                <h3 style="color:white">sorry my bad</h3>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="col-lg-4 col-md-4">
                        <div class="anime__details__sidebar">
                            <div class="section-title">
                                <h5>you might like...</h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="img/sidebar/tv-1.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">Boruto: Naruto next generations</a></h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="img/sidebar/tv-2.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="img/sidebar/tv-3.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">Sword art online alicization war of underworld</a></h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="img/sidebar/tv-4.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">Fate/stay night: Heaven's Feel I. presage flower</a></h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Anime Section End -->
        <script>
            function sendFavoriteRequest(movieId) {
                var form = document.createElement('form');
                form.method = 'post';
                form.action = 'DetailAnime';

                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'id';
                input.value = movieId;

                form.appendChild(input);
                document.body.appendChild(form);

                form.submit();
                showSuccessMessage();
            }
            function showSuccessMessage() {
                var message = document.getElementById('success-message');
                message.style.display = 'block';
                setTimeout(function () {
                    message.style.display = 'none';
                }, 3000);
            }
        </script>
        <%@include file="Footer.jsp" %>

        <style>
            .anime__details__btn .hover-button {
                position: relative;
                background-color: #f2f2f2;
                padding: 10px;
                border: none;
                cursor: pointer;
            }
            .anime__details__btn .watch-btn span {
                border-radius: 10px;
                margin-right: 10px;
            }

            .anime__details__btn .hover-button:hover{
                color: #444444;
                background-color:  #444444;
            }

            .anime__details__btn .hover-button:hover .icon {
                display: block;
                background-color:  #444444;
                font-size: 13px;
            }

            .anime__details__btn .watch-btn span .icon{
                display: none;
                height: 100%;
            }

            .anime__details__btn .watch-btn span .icon i{
                padding: 0;
                margin: 0;
                height: 100%;
                background-color:  #444444;
                font-size: 20px;

            }

            .icon {
                display: none;
                position: absolute;
                top: -0%;
                left: 50%;
                transform: translateX(-50%);
                color: #444444;
            }
        </style>
    </body>

</html>
