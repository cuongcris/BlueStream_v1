<!DOCTYPE html>
<html lang="zxx">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <%@include file="Head.jsp" %>
         <%@include file="Header.jsp" %>
        <%@include file="Advertisement.jsp" %>
        <title>Blue Stream - Home</title>
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>


        <!-- Hero Section Begin -->
        <section class="hero">
            <div class="container">
                <div class="hero__slider owl-carousel">
                    <div class="hero__items set-bg" data-setbg="img/slideshow/cthcmovie0.jpg">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="hero__text">
                                    <div class="label">Fantasy</div>
                                    <div class="hero__text_details">
                                        <h2>Gekijouban Jujutsu Kaisen 0 (2021)</h2>
                                        <p>After 30 days of travel across the world...</p>
                                    </div>
                                    <a href="#"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="hero__items set-bg" data-setbg="img/slideshow/dslss2.jpg">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="hero__text">
                                    <div class="label">Adventure</div>
                                    <div class="hero__text_details">
                                        <h2 >Kimetsu no Yaiba-District Arc Special</h2>
                                        <p>Prior to the broadcast of Swordsmithing Village</p>
                                    </div>
                                    <a href="#"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hero__items set-bg" data-setbg="img/slideshow/aot4k.jpg">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="hero__text">
                                    <div class="label">Adventure</div>
                                    <div class="hero__text_details">
                                        <h2>SHINGEKI NO KYOJIN MOVIE 1: GUREN NO YUMIYA</h2>
                                        <p>The first installment of the film series...</p>
                                    </div>
                                    <a href="#"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hero__items set-bg" data-setbg="https://wallpapercave.com/wp/wp11601063.jpg">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="hero__text">
                                    <div class="label">Adventure</div>
                                    <div class="hero__text_details">
                                        <h2>SHINGEKI NO KYOJIN MOVIE 1: GUREN NO YUMIYA</h2>
                                        <p>The first installment of the film series...</p>
                                    </div>
                                    <a href="#"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">


                        <!------------------------trending product-------------------------------------->
                        <div class="trending__product">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-8">
                                    <div class="section-title">
                                        <h4>Trending Now</h4>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4">
                                    <div class="btn__all">
                                        <a href="AllMovie" class="primary-btn">View All <span class="arrow_right"></span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <c:set var="list" value ="${requestScope.TrendingMovie}" />
                                <c:forEach var="dto" items ="${list}" begin="0" end="5" >

                                    <div class="col-lg-4 col-md-6 col-sm-6">
                                        <div class="product__item">
                                            <a href="DetailAnime?id=${dto.movieId}">
                                                <div style="cursor: pointer;" class="product__item__pic set-bg" data-setbg=${dto.movieBanner}>
                                                    <div  class="ep">${dto.movieStatus}</div>
                                                    <div class="view"><i class="fa fa-eye"></i> ${format.formatNumber(dto.movieView)} </div>
                                                </div>
                                                <div class="product__item__text">
                                                    <ul>
                                                        <li> ${dto.category[0]}</li>
                                                        <li> ${dto.category[1]}</li>
                                                    </ul>
                                                        <h5 style="color:#79797980;"><a href="DetailAnime?id=${dto.movieId}">${format.nameStandardization(dto.movieName)}</a></h5>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:if test="${empty list}">
                                    <h2>No record is matched!!!</h2>
                                </c:if>
                            </div>
                        </div>

                        <!------------------------popular product------------------------------------->          

                        <div class="popular__product">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-8">
                                    <div class="section-title">
                                        <h4>Popular Shows</h4>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4">
                                    <div class="btn__all">
                                        <a href="AllMovie" class="primary-btn">View All <span class="arrow_right"></span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <c:set var="popularMovie" value ="${requestScope.popularMovie}" />
                                <c:forEach var="dto" items ="${popularMovie}" begin="0" end="5" >

                                    <div class="col-lg-4 col-md-6 col-sm-6">
                                        <div class="product__item">
                                            <a href="DetailAnime?id=${dto.movieId}">
                                                <div style="cursor: pointer;" class="product__item__pic set-bg" data-setbg=${dto.movieBanner}>
                                                    <div  class="ep">${dto.movieStatus}</div>
                                                    <div class="view"><i class="fa fa-eye"></i> ${format.formatNumber(dto.movieView)}</div>
                                                </div>
                                                <div class="product__item__text">
                                                    <ul>
                                                        <li> ${dto.category[0]}</li>
                                                        <li> ${dto.category[1]}</li>
                                                    </ul>
                                                    <h5><a href="DetailAnime?id=${dto.movieId}">${format.nameStandardization(dto.movieName)}</a></h5>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:if test="${empty list}">
                                    <h2>No record is matched!!!</h2>
                                </c:if>
                            </div>
                        </div>


                        <!----------------------new release---------------------------------------------> 

                        <div class="recent__product">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-8">
                                    <div class="section-title">
                                        <h4>New Release</h4>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4">
                                    <div class="btn__all">
                                        <a href="AllMovie" class="primary-btn">View All <span class="arrow_right"></span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <c:set var="newReleaseMovie" value ="${requestScope.newReleaseMovie}" />
                                <c:forEach var="dto" items ="${newReleaseMovie}" begin="0" end="5" >

                                    <div class="col-lg-4 col-md-6 col-sm-6">
                                        <div class="product__item">
                                            <a href="DetailAnime?id=${dto.movieId}">
                                                <div style="cursor: pointer;" class="product__item__pic set-bg" data-setbg=${dto.movieBanner}>
                                                    <div  class="ep">${dto.movieStatus}</div>
                                                    <div class="view"><i class="fa fa-eye"></i> ${format.formatNumber(dto.movieView)}</div>
                                                </div>
                                                <div class="product__item__text">
                                                    <ul>
                                                        <li> ${dto.category[0]}</li>
                                                        <li> ${dto.category[1]}</li>
                                                    </ul>
                                                    <h5><a href="DetailAnime?id=${dto.movieId}">${format.nameStandardization(dto.movieName)}</a></h5>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:if test="${empty list}">
                                    <h2>No record is matched!!!</h2>
                                </c:if>
                            </div>
                        </div>

                        <!--------------------------------live action----------------------------------->
                        <div class="live__product">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-8">
                                    <div class="section-title">
                                        <h4>Live Action</h4>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4">
                                    <div class="btn__all">
                                        <a href="AllMovie" class="primary-btn">View All <span class="arrow_right"></span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <c:set var="LiveActionMovie" value ="${requestScope.LiveActionMovie}" />
                                <c:forEach var="dto" items ="${LiveActionMovie}" begin="0" end="5" >

                                    <div class="col-lg-4 col-md-6 col-sm-6">
                                        <div class="product__item">
                                            <a href="DetailAnime?id=${dto.movieId}">
                                                <div style="cursor: pointer;" class="product__item__pic set-bg" data-setbg=${dto.movieBanner}>
                                                    <div  class="ep">${dto.movieStatus}</div>
                                                    <div class="comment"><i class="fa fa-comments"></i> 11</div>
                                                    <div class="view"><i class="fa fa-eye"></i> ${format.formatNumber(dto.movieView)}</div>
                                                </div>
                                                <div class="product__item__text">
                                                    <ul>
                                                        <li> ${dto.category[0]}</li>
                                                        <li> ${dto.category[1]}</li>
                                                    </ul>
                                                    <h5><a href="DetailAnime?id=${dto.movieId}">${format.nameStandardization(dto.movieName)}</a></h5>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:if test="${empty list}">
                                    <h2>No record is matched!!!</h2>
                                </c:if>
                            </div>
                        </div>

                    </div>
                    <!--end product load-->  

                    <!------------------------------------------------top view------------------->

                    <div class="col-lg-4 col-md-6 col-sm-8">
                        
                        <c:if test="${account == null || sessionScope.account.role == 2}">
                                
                                <c:forEach var="dto" items ="${sessionScope.ads_show}" >
                                    
                                    <c:if test="${dto.type.equals('Invisible')}">
                                        <div id="overlay" onclick="redirectToPage('${dto.linkTo}')"></div>
                                    </c:if>
                                        
                                    <c:if test="${dto.type.equals('Gif')}">
                                        <div class="product__sidebar__view">
                                            <a href="${dto.linkTo}" target="_blank"> 
                                                <img src="${dto.linkShow}" alt="alt"/>
                                            <a>
                                        </div>
                                    </c:if>
                                </c:forEach>
                        </c:if>
                        
                        <div class="product__sidebar">
                            <div class="product__sidebar__view">
                                <div class="section-title">
                                    <h5>Top Views</h5>
                                </div>
                                <ul class="filter__controls">
                                    <li class="active" data-filter="*">Day</li>
                                    <li data-filter=".week">Week</li>
                                    <li data-filter=".month">Month</li>
                                    <li data-filter=".years">Years</li>
                                </ul>
                                <div class="filter__gallery">
                                    <div class="product__sidebar__view__item set-bg mix day years"
                                         data-setbg="img/sidebar/tv-1.jpg">
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Boruto: Naruto next generations</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix month week"
                                         data-setbg="img/sidebar/tv-2.jpg">
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix week years"
                                         data-setbg="img/sidebar/tv-3.jpg">
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Sword art online alicization war of underworld</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix years month"
                                         data-setbg="img/sidebar/tv-4.jpg">
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Fate/stay night: Heaven's Feel I. presage flower</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix day"
                                         data-setbg="img/sidebar/tv-5.jpg">
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Fate stay night unlimited blade works</a></h5>
                                    </div>
                                </div>
                            </div>

                            <!---------------------recommend--------------------------------------------->
                            <div class="product__sidebar__comment">
                                <div class="section-title">
                                    <h5>New Recommend</h5>
                                </div>
                                <c:set var="randomMovie" value ="${requestScope.randomMovie}" />
                                <c:forEach var="dto" items ="${randomMovie}" begin="0" end="4" >
                                    <div class="product__sidebar__comment__item" >
                                        <div style="width: 90px ; height: 130px;" class="product__sidebar__comment__item__pic">
                                            <img src="${dto.movieBanner}" alt="">
                                        </div>
                                        <div class="product__sidebar__comment__item__text">
                                            <ul>
                                                <li> ${dto.category[0]}</li>
                                                <li> ${dto.category[1]}</li>
                                            </ul>
                                            <h5><a href="DetailAnime?id=${dto.movieId}">${format.nameStandardization(dto.movieName)}</a></h5>

                                            <span style="font-size:13px;"><i class="fa fa-eye"></i>${format.formatNumber(dto.movieView)} Views</span>
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:if test="${empty list}">
                                    <h2>No record is matched!!!</h2>
                                </c:if>
                                <div class="product__sidebar__comment__item">
                                    <div class="product__sidebar__comment__item__pic">
                                        <img src="img/sidebar/comment-1.jpg" alt="">
                                    </div>
                                    <div class="product__sidebar__comment__item__text">
                                        <ul>
                                            <li>Active</li>
                                            <li>Movie</li>
                                        </ul>
                                        <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                                        <span><i class="fa fa-eye"></i> 19.141 Viewes</span>
                                    </div>
                                </div>   
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

        <%@include file="Footer.jsp" %>

        <style>
        #overlay {
            position: fixed;
            top: 15%;
            left: 0;
            width: 100%;
            height: 90%;
            background-color: rgba(0, 0, 0, 0.00001);
            z-index: 9998;
            cursor: pointer;
        }
        
        .hero__text_details{
            background-color: rgb(86 86 86 / 40%);
        }
        .product__item:hover{
            transform: scale(1.01);
        }
        .hero__text_details h2,
        .hero__text_details p{
            padding-left: 10px;
        }
        </style>
        
        <script>
            function redirectToPage(link) {
                var overlay = document.getElementById("overlay");
                overlay.style.display = "none";
                var newTab = window.open(link, "_blank");
                newTab.focus();
            }
        </script>
    </body>

</html>