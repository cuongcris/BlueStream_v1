<!DOCTYPE html>
<html lang="zxx">

    <head>
        <%@include file="Head.jsp" %>
        <title>Blue Stream | Categories</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="
      https://cdn.jsdelivr.net/npm/@icon/elegant-icons@0.0.1-alpha.4/elegant-icons.min.css
      " rel="stylesheet">


    </head>
   
    <body>
        <!-- Page Preloder -->
<!--        <div id="preloder">
            <div class="loader"></div>
        </div>-->
        
        <%@include file="Header.jsp" %>

        <!-- Breadcrumb Begin -->
        <div class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcrumb__links">
                            <a href="home"><i class="fa fa-home"></i> Home</a>
                            <a href="AllMovie">Categories</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->
    <Center>
        <div class="search-bar">
            <div class="search-group">
                <input type="text" name="txtSearch" id="search-bar"  placeholder="Search Movie here...">
                <button type="submit" title="Search"><i class="fas fa-search"></i></button>
            </div>
        </div>
    </Center>
    <!-- Product Section Begin -->
        <section class="product-page spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="product__page__content">
                            <div class="product__page__title">
                                <div class="row">
                                    <div class="col-lg-6 col-md-8 col-sm-6">
                                        <div class="section-title">
                                            <h4>General Anime </h4>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-2 col-sm-3 ">
                                        <div class="product__page__filter">
                                            <select id="nameFilter" onchange="filter(1)">
                                                <option disabled selected value="">Name</option>
                                                <option value="asc">A-Z</option>
                                                <option value="desc">Z-A</option>
                                            </select>
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-3 col-md-2 col-sm-3">
                                        <div class="product__page__filter">
                                            <select id="viewFilter" onchange="filter(1)">
                                                <option disabled selected value="">View</option>
                                                <option value="asc">Ascending</option>
                                                <option value="desc">Descending</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row product-container-list">
                                <c:set var="list" value ="${requestScope.Category}" />
                                <c:forEach var="dto" items ="${list}" begin="0" end="14" >

                                    <div class="col-lg-4 col-md-6 col-sm-6 ">
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
                                    <div class="">
                                            <div class="paging">
                                                <button type="button" class="paging-btn" id="paging-prev" disabled><i class="fas fa-angle-left"></i></button>
                                                <input type="number" step="1" min="1" class="paging-num" value="1" name="page" readonly>
                                                <span>/ <fmt:formatNumber pattern="#" value="${Math.ceil(list.size() / 12)}"/></span>
                                                <button type="button" class="paging-btn" id="paging-prev" onclick="filter(2)"><i class="fas fa-angle-right"></i></button>
                                            </div>
                                    </div>    
                            </div>
                              
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
                                    <div class="ep">${dto.movieStatus}</div>
                                    <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                    <h5><a href="#">Boruto: Naruto next generations</a></h5>
                                </div>
                                <div class="product__sidebar__view__item set-bg mix month week"
                                     data-setbg="img/sidebar/tv-2.jpg">
                                    <div class="ep">${dto.movieStatus}</div>
                                    <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                    <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                                </div>
                                <div class="product__sidebar__view__item set-bg mix week years"
                                     data-setbg="img/sidebar/tv-3.jpg">
                                    <div class="ep">${dto.movieStatus}</div>
                                    <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                    <h5><a href="#">Sword art online alicization war of underworld</a></h5>
                                </div>
                                <div class="product__sidebar__view__item set-bg mix years month"
                                     data-setbg="img/sidebar/tv-4.jpg">
                                    <div class="ep">${dto.movieStatus}</div>
                                    <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                    <h5><a href="#">Fate/stay night: Heaven's Feel I. presage flower</a></h5>
                                </div>
                                <div class="product__sidebar__view__item set-bg mix day"
                                     data-setbg="img/sidebar/tv-5.jpg">
                                    <div class="ep">${dto.movieStatus}</div>
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

   <%@include file="Footer.jsp" %>
    <script src="js/jsFolder/filterAjax.js"></script>
        
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/js/bootstrap.min.js" integrity="sha512-1/RvZTcCDEUjY/CypiMz+iqqtaoQfAITmNSJY17Myp4Ms5mdxPS5UV7iOfdZoxcGhzFbOm6sntTKJppjvuhg4g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- LessCSS -->
    <!--<script src="https://cdn.jsdelivr.net/npm/less"></script>-->
    <!-- JQuery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

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

  .search-bar {
  display: flex;
  justify-content: center;
}

.search-group {
  display: flex;
  align-items: center;
  background-color: #f1f1f1;
  border-radius: 10px;
  padding: 5px;
  margin-top:25px;
}

#search-bar {
  border: none;
  background-color: transparent;
  padding: 5px;
  width: 450px;
}

button[type="submit"] {
  background-color: transparent;
  border: none;
  cursor: pointer;
  padding: 5px;
}

button[type="submit"]:focus {
  outline: none;
}

.fa-search {
  color: #555;
}

.product__page__title {
	border-bottom: 2px solid rgba(255, 255, 255, 0.2);
	padding-bottom: 10px;
	margin-bottom: 30px;
}

.product__page__title .section-title {
	margin-bottom: 0;
}

.product__page__title .product__page__filter {
	text-align: right;
}

.product__page__title .product__page__filter p {
	color: #ffffff;
	display: inline-block;
	margin-bottom: 0;
	margin-right: 16px;
}

.product__page__title .product__page__filter .nice-select {
	float: none;
	display: inline-block;
	font-size: 15px;
	color: #3d3d3d;
	font-weight: 700;
	border-radius: 0;
	padding-left: 15px;
	padding-right: 40px;
	height: 32px;
	line-height: 32px;
}

.product__page__title .product__page__filter .nice-select:after {
	border-bottom: 2px solid #111;
	border-right: 2px solid #111;
	height: 8px;
	top: 47%;
	width: 8px;
	right: 15px;
}

.product__page__title .product__page__filter .nice-select .list {
	margin-top: 0;
	border-radius: 0;
}

.product__item {
	margin-bottom: 30px;
}

.product__item__pic {
	height: 325px;
	position: relative;
	border-radius: 5px;
}

.product__item__pic .ep {
	font-size: 13px;
	color: #ffffff;
	background: #e53637;
	display: inline-block;
	padding: 2px 12px;
	border-radius: 4px;
	position: absolute;
	left: 10px;
	top: 10px;
}

.product__item__pic .comment {
	font-size: 13px;
	color: #ffffff;
	background: #3d3d3d;
	display: inline-block;
	padding: 2px 10px;
	border-radius: 4px;
	position: absolute;
	left: 10px;
	bottom: 10px;
}

.product__item__pic .view {
	font-size: 13px;
	color: #ffffff;
	background: #3d3d3d;
	display: inline-block;
	padding: 2px 10px;
	border-radius: 4px;
	position: absolute;
	right: 10px;
	bottom: 10px;
}

.product__item__text {
	padding-top: 20px;
}

.product__item__text ul {
	margin-bottom: 10px;
}

.product__item__text ul li {
	list-style: none;
	font-size: 10px;
	color: #ffffff;
	font-weight: 700;
	padding: 1px 10px;
	background: rgba(255, 255, 255, 0.2);
	border-radius: 50px;
	display: inline-block;
}

.product__item__text h5 a {
	color: #ffffff;
	font-weight: 700;
	line-height: 26px;
}

    }
</style>
</html>