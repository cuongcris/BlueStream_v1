<!DOCTYPE html>
<html lang="zxx">

    <head>
        <%@include file="Head.jsp" %>
        <title>Blue Stream | Categories</title>
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
                            <span>Romance</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Product Section Begin -->
        <section class="product-page spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="product__page__content">
                            <div class="product__page__title">
                                <div class="row">
                                    <div class="col-lg-8 col-md-8 col-sm-6">
                                        <div class="section-title">
                                            <h4>Romance</h4>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-6">
                                        <div class="product__page__filter">
                                            <p>Order by:</p>
                                            <select>
                                                <option value="">A-Z</option>
                                                <option value="">1-10</option>
                                                <option value="">10-50</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <c:set var="list" value ="${requestScope.Category}" />
                                <c:forEach var="dto" items ="${list}" begin="0" end="14" >

                                    <div class="col-lg-4 col-md-6 col-sm-6">
                                        <div class="product__item">
                                            <a href="DetailAnime?id=${dto.movieId}">
                                                <div style="cursor: pointer;" class="product__item__pic set-bg" data-setbg=${dto.movieBanner}>
                                                    <div class="ep">18 / 18</div>
                                                    <div class="comment"><i class="fa fa-comments"></i> 11</div>
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
                        <div class="product__pagination">
                            <c:if test="${currentPage == 1}">
                               
                                <a class="current-page" href="?page=${currentPage}">${currentPage}</a></li>
                                <a  href="?page=${currentPage + 1}">${currentPage + 1}</a>
                                <a  href="?page=${currentPage + 2}">${currentPage + 2}</a>
                                <a  href="?page=${totalPages}">End</a>
                            </c:if>
                            <c:if test="${currentPage > 1 && currentPage<totalPages}">
                                <a  href="?page=1">First</a>
                                <a  href="?page=${currentPage - 1}">${currentPage-1}</a>
                                <a class="current-page" href="?page=${currentPage}">${currentPage}</a></li>
                                <a  href="?page=${currentPage + 1}">${currentPage + 1}</a>
                                <a  href="?page=${totalPages}">End</a>
                            </c:if>

                            <c:if test="${currentPage == totalPages}">
                                <a  href="?page=1">First</a>
                                <a  href="?page=${currentPage - 2}">${currentPage - 2}</a>
                                <a  href="?page=${currentPage - 1}">${currentPage - 1}</a>
                                <a class="current-page" href="?page=${currentPage}">${currentPage}</a></li>

                            </c:if>

                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-8">
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
                                        <div class="ep">18 / ?</div>
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Boruto: Naruto next generations</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix month week"
                                         data-setbg="img/sidebar/tv-2.jpg">
                                        <div class="ep">18 / ?</div>
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix week years"
                                         data-setbg="img/sidebar/tv-3.jpg">
                                        <div class="ep">18 / ?</div>
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Sword art online alicization war of underworld</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix years month"
                                         data-setbg="img/sidebar/tv-4.jpg">
                                        <div class="ep">18 / ?</div>
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Fate/stay night: Heaven's Feel I. presage flower</a></h5>
                                    </div>
                                    <div class="product__sidebar__view__item set-bg mix day"
                                         data-setbg="img/sidebar/tv-5.jpg">
                                        <div class="ep">18 / ?</div>
                                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                        <h5><a href="#">Fate stay night unlimited blade works</a></h5>
                                    </div>
                                </div>
                            </div>
                            <div class="product__sidebar__comment">
                                <div class="section-title">
                                    <h5>New Comment</h5>
                                </div>
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
                                <div class="product__sidebar__comment__item">
                                    <div class="product__sidebar__comment__item__pic">
                                        <img src="img/sidebar/comment-2.jpg" alt="">
                                    </div>
                                    <div class="product__sidebar__comment__item__text">
                                        <ul>
                                            <li>Active</li>
                                            <li>Movie</li>
                                        </ul>
                                        <h5><a href="#">Shirogane Tamashii hen Kouhan sen</a></h5>
                                        <span><i class="fa fa-eye"></i> 19.141 Viewes</span>
                                    </div>
                                </div>
                                <div class="product__sidebar__comment__item">
                                    <div class="product__sidebar__comment__item__pic">
                                        <img src="img/sidebar/comment-3.jpg" alt="">
                                    </div>
                                    <div class="product__sidebar__comment__item__text">
                                        <ul>
                                            <li>Active</li>
                                            <li>Movie</li>
                                        </ul>
                                        <h5><a href="#">Kizumonogatari III: Reiket su-hen</a></h5>
                                        <span><i class="fa fa-eye"></i> 19.141 Viewes</span>
                                    </div>
                                </div>
                                <div class="product__sidebar__comment__item">
                                    <div class="product__sidebar__comment__item__pic">
                                        <img src="img/sidebar/comment-4.jpg" alt="">
                                    </div>
                                    <div class="product__sidebar__comment__item__text">
                                        <ul>
                                            <li>Active</li>
                                            <li>Movie</li>
                                        </ul>
                                        <h5><a href="#">Monogatari Series: Second Season</a></h5>
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
        .product__pagination a:hover {
            color: #ffffff;
            background-color: gray;

        }

        .product__pagination a.current-page {
            border: 2px solid #ffffff;
        }

        .product__pagination a  {
            color: #b7b7b7;
            font-size: 15px;
            font-weight: 700;
        }
    </style>
</html>