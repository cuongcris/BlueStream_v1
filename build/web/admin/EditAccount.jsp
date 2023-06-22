<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                                <h2 class="tm-block-title d-inline-block">Edit Account</h2>
                            </div>
                        </div>
                        <form action="AddMovie" method="post" class="tm-edit-product-form"> 
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-6 col-lg-6 col-md-12">

                                    <div class="form-group mb-3">
                                        <label for="movieID">User ID
                                        </label>
                                        <input id="userID" name="userID" type="text" class="form-control validate" readonly style="background-color: #54657d" />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="userName">User Name
                                        </label>
                                        <input id="movieName" name="userName" type="text" class="form-control validate" readonly style="background-color: #54657d"/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="password">Password</label>
                                        <input id="password" name="password" type="text" class="form-control validate" readonly style="background-color: #54657d"/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="email">Email</label>
                                        <input id="email" name="email" type="text" class="form-control validate" readonly style="background-color: #54657d"/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="fullName">Full Name</label>
                                        <input id="fullName" name="fullName" type="text" class="form-control validate" readonly style="background-color: #54657d"/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label>Role</label>
                                        <select class="custom-select tm-select-accounts" id="role" name="role">
                                            <option selected>Select Role</option>
                                            <option value="0">Admin</option>
                                            <option value="1">Premium User</option>
                                            <option value="2">User</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                    <div class="tm-product-img-dummy mx-auto">
                                        <i class="fas fa-cloud-upload-alt tm-upload-icon"
                                           onclick="document.getElementById('fileInput').click();"></i>
                                    </div>
                                    <div class="custom-file mt-3 mb-3">
                                        <input id="fileInput" type="" style="display:none;" />
                                        <input name="image" type="text" class="form-control validate mx-auto" placeholder="Upload Movie Image"
                                               style="color: #fff;">

                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mt-auto">
                                            <label for="expire_date">Release Date
                                            </label>
                                            <input  name="releaseDate" type="date" class="form-control validate"
                                                    data-large-mode="true" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mt-4">
                                            <label for="stock">Author
                                            </label>
                                            <input id="stock" name="author" type="text" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mx-auto">
                                            <label for="stock">Movie Status
                                            </label>
                                            <input id="stock" name="movieStatus" type="text" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mx-auto">
                                            <label for="stock">Movie Season
                                            </label>
                                            <input id="stock" name="movieSeason" type="text" class="form-control validate" required />
                                        </div>

                                    </div>
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase">Add Movie Now</button>
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

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>

        </script>
        ${errorMessage}
    </body>

</html>