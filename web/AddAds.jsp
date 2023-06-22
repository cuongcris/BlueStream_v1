<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="Head1.jsp" %>
    </head>

    <body>
        <nav class="navbar navbar-expand-xl">
            <%@include file="Header1.jsp" %>
        </nav>
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block">Add New ADS</h2>
                            </div>
                        </div>
                        <form action="add_ads" method="post" class="tm-edit-product-form"> 
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-12 col-lg-12 col-md-12">

                                    <div class="form-group mb-3" >
                                        <label>ADS ID
                                        </label>
                                        <input id="adsID" name="adsID" type="text" class="form-control validate" 
                                               style="background-color: #54657d;"
                                               value = "hello"
                                               readonly/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label>ADS Owner's Email
                                        </label>
                                        <input id="adsEmail" name="adsEmail" type="email" class="form-control validate" required />
                                    </div>
                                    <div class="form-group col-7 mb-3"
                                         style="display: inline-block; padding: 0;">
                                        <label for="mainCategory">ADS Type</label>

                                        <select class="custom-select tm-select-accounts" id="adsType" name="adsType" required>
                                            <option value="Video">Video</option>
                                            <option value="Gif">Gif</option>
                                            <option value="Invisible">Invisible</option>
                                            <option value="BottomPicture_Left">BottomPicture_Left</option>
                                            <option value="BottomPicture_Right">BottomPicture_Right</option>
                                        </select>
                                    </div>

                                    <div class="form-group col-4 mb-3"
                                         style="display: inline-block;">
                                        <label>ADS Price
                                        </label>
                                        <input id="adsPrice" name="adsPrice" type="text" pattern="[1-9][0-9]*" 
                                               title="Must enter number bigger than 0" class="form-control validate" required />
                                    </div>

                                    <div class="form-group mb-3">
                                        <label>ADS Link To
                                        </label>
                                        <input id="linkTo" name="linkTo" type="text" class="form-control validate" required />
                                    </div>

                                    <div class="form-group mb-3">
                                        <label>ADS Link Show
                                        </label>
                                        <input id="linkShow" name="linkShow" type="text" class="form-control validate" required />
                                    </div>

                                    <div class="form-group form-day col-5 mb-3" style="display: inline-block; padding: 0; margin-left: 10%;">
                                        <label>DayStart</label>
                                        <input id="DayStart" name="DayStart" type="date" class="form-control validate" required />
                                    </div>

                                    <div class="form-group col-5 mb-3" style="display: inline-block;">
                                        <label>DayEnd</label>
                                        <input id="DayEnd" name="DayEnd" type="date" class="form-control validate" required />
                                    </div>


                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary btn-block text-uppercase">ADD NEW ADS</button>
                                    </div>
                                </div>
                        </form>
                    </div>
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
            
            
            ${errorMessage}
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