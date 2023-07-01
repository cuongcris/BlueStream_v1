<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="Head.jsp" %>
    </head>

    <body>
        <nav class="navbar navbar-expand-xl">
            <%@include file="Header.jsp" %>
        </nav>
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block">Update ADS</h2>
                            </div>
                        </div>
                        <form action="UpdateAds" method="post" class="tm-edit-product-form"> 
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-12 col-lg-12 col-md-12">
                                    <c:set var="ads" value ="${requestScope.ads_update}" />

                                    <c:if test="${ads.type.equals('Video') == true}">
                                        <div style="width: 100%" >
                                            <video  
                                                src="${ads.linkShow}"
                                                controls 
                                                style="width: 100%">
                                            </video>
                                        </div>
                                    </c:if>

                                    <c:if test="${ads.type.equals('Gif') == true}">
                                        <div style="width: 100%;" >
                                            <img
                                                src="${ads.linkShow}"
                                                style="width: 50%; margin-left: 25%;
                                                border: 5px solid black"/>
                                        </div>
                                    </c:if>

                                    <c:if test="${ads.type.equals('BottomPicture_Left') == true}">
                                        <div style="width: 100%;" >
                                            <img
                                                src="${ads.linkShow}"
                                                style="width: 100%;
                                                border: 5px solid black"/>
                                        </div>
                                    </c:if>

                                    <c:if test="${ads.type.equals('BottomPicture_Right') == true}">
                                        <div style="width: 100%;" >
                                            <img
                                                src="${ads.linkShow}"
                                                style="width: 100%;
                                                border: 5px solid black"/>
                                        </div>
                                    </c:if>

                                    <div class="form-group mb-3" >
                                        <label>ADS ID
                                        </label>
                                        <input id="adsID" name="adsID" type="text" class="form-control validate" 
                                               style="background-color: #54657d;"
                                               value = "${ads.id}"
                                               readonly/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label>ADS Owner's Email
                                        </label>
                                        <input id="adsEmail" name="adsEmail" type="email" class="form-control validate"
                                               value = "${ads.ownerEmail}"
                                               required />
                                    </div>
                                    <div class="form-group col-7 mb-3"
                                         style="display: inline-block; padding: 0;">
                                        <label for="mainCategory">ADS Type</label>

                                        <select class="custom-select tm-select-accounts" id="adsType" name="adsType" required>
                                            <option value="Video"  ${ads.type.equals('Video') ? "Selected" : ""}>Video</option>
                                            <option value="Gif" ${ads.type.equals('Gif') ? "Selected" : ""}>Gif</option>
                                            <option value="Invisible" ${ads.type.equals('Invisible') ? "Selected" : ""} >Invisible</option>
                                            <option value="BottomPicture_Left" ${ads.type.equals('BottomPicture_Left') ? "Selected" : ""}>BottomPicture_Left</option>
                                            <option value="BottomPicture_Right" ${ads.type.equals('BottomPicture_Right') ? "Selected" : ""}>BottomPicture_Right</option>
                                        </select>
                                    </div>

                                    <div class="form-group col-4 mb-3"
                                         style="display: inline-block;">
                                        <label>ADS Price
                                        </label>
                                        <input id="adsPrice" name="adsPrice" type="text" pattern="[1-9][0-9]*" 
                                               title="Must enter number bigger than 0" class="form-control validate" 
                                               value = "${ads.price}"
                                               required />
                                    </div>

                                    <div class="form-group mb-3">
                                        <label>ADS Link To
                                        </label>
                                        <input id="linkTo" name="linkTo" type="text" class="form-control validate" 
                                               value = "${ads.linkTo}"
                                               required />
                                    </div>
                                    <c:if test="${ads.type.equals('Invisible') == true}">
                                        <div class="form-group mb-3">

                                            <label>ADS Link Show
                                            </label>

                                            <input id="linkShow" name="linkShow" type="text" class="form-control validate" 
                                                   value = "${ads.linkShow}"/>

                                        </div>
                                    </c:if>

                                    <c:if test="${ads.type.equals('Invisible') == false}">
                                        <div class="form-group mb-3">

                                            <label>ADS Link Show
                                            </label>

                                            <input id="linkShow" name="linkShow" type="text" class="form-control validate" 
                                                   value = "${ads.linkShow}"
                                                   required/>

                                        </div>
                                    </c:if>
                                    <div class="form-group form-day col-5 mb-3" style="display: inline-block; padding: 0; margin-left: 10%;">
                                        <label>DayStart</label>
                                        <input id="DayStart" name="DayStart" type="date" class="form-control validate" 
                                               value = "${ads.dayStart}"
                                               required />
                                    </div>

                                    <div class="form-group col-5 mb-3" style="display: inline-block;">
                                        <label>DayEnd</label>
                                        <input id="DayEnd" name="DayEnd" type="date" class="form-control validate" 
                                               value = "${ads.dayEnd}"
                                               required />
                                    </div>


                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary btn-block text-uppercase">Update ADS</button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <footer class="tm-footer row tm-mt-small">
                <div class="col-12 font-weight-light">
                    <p class="text-center text-white mb-0 px-4 small">
                        Copyright &copy; <b>2018</b> All rights reserved.

                        Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                    </p>
                </div>
            </footer>

            <script src="js/jquery-3.3.1.min.js"></script>
            <!-- https://jquery.com/download/ -->
            <script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
            <!-- https://jqueryui.com/download/ -->
            <script src="js/bootstrap.min.js"></script>
            <!-- https://getbootstrap.com/ -->
            <script>
                $(function () {
                    $("#expire_date").datepicker();
                });
            </script>

    </body>

</html>