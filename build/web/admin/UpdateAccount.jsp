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
                                <h2 class="tm-block-title d-inline-block">Update Account</h2>
                            </div>
                        </div>
                        <form action="EditAccount" method="post" class="tm-edit-product-form"> 
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-12 col-lg-12 col-md-12">
                                    <c:set var="acc" value ="${requestScope.account_update}" />
                                    <div class="form-group mb-3" >
                                        <label>User ID
                                        </label>
                                        <input id="adsID" name="userID" type="text" class="form-control validate" 
                                               style="background-color: #54657d;"
                                               value = "${acc.userID}"
                                               readonly/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label>User Name
                                        </label>
                                        <input id="adsEmail" name="adsEmail" type="email" class="form-control validate"
                                               value = "${acc.userName}"
                                               style="background-color: #54657d;"
                                               readonly />
                                    </div>

                                    <div class="form-group mb-3">
                                        <label>Password
                                        </label>
                                        <input id="adsEmail" name="adsEmail" type="email" class="form-control validate"
                                               value = "${acc.password}"
                                               style="background-color: #54657d;"
                                               readonly />
                                    </div>

                                    <div class="form-group mb-3">
                                        <label>GoogleID
                                        </label>
                                        <input id="adsEmail" name="adsEmail" type="email" class="form-control validate"
                                               value = "${acc.user_id_google}"
                                               style="background-color: #54657d;"
                                               readonly />
                                    </div>
                                    <div class="form-group col-12 mb-3"
                                         style="display: inline-block; padding: 0;">
                                        <label for="mainCategory" style="color: white;">Role</label>

                                        <select class="custom-select tm-select-accounts" id="account_role" name="account_role" required>
                                            <option value="0"  ${acc.role == 0 ? "Selected" : ""}>Admin</option>
                                            <option value="1" ${acc.role == 1 ? "Selected" : ""}>Premium User</option>
                                            <option value="2" ${acc.role == 2 ? "Selected" : ""} >User</option>
                                        </select>
                                    </div>

                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary btn-block text-uppercase">Update Account</button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>

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