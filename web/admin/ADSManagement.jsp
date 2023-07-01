

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Head.jsp" %>
    </head>
    <body id="reportsPage">
        <nav class="navbar navbar-expand-xl">
            <%@include file="Header.jsp" %>
        </nav>
        <div class="input-group mt-5 col-xl-12">
            <h1 style="color: white; margin-left: 33%;">Advertisement Management</h1>
        </div>


        <div class="container mt-3">
            <div class="row tm-content-row">
                <div class="col-xl-12">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="tm-product-table-container">
                            <table class="table table-hover tm-table-small tm-product-table">
                                <thead>
                                    <tr>
                                        <th scope="col">ADS ID</th>
                                        <th scope="col">Owner's Email</th>
                                        <th scope="col">ADS Type</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">StartDate</th>
                                        <th scope="col">EndDate</th>
                                        <th scope="col">&nbsp;</th>
                                        <th scope="col">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="ADSList" value ="${requestScope.ADSList}" />
                                    <c:forEach var="dto" items ="${ADSList}">
                                        <tr>
                                            <th scope="row">${dto.id}</th>
                                            <td>${dto.ownerEmail}</td>
                                            <td>${dto.type}</td>
                                            <td>${dto.price}</td>
                                            <td>${dto.dayStart}</td>
                                            <td>${dto.dayEnd}</td>
                                            <td>
                                                <a href="UpdateAds?update_id=${dto.id}" >
                                                    <span class="material-symbols-outlined" style="color: #fff;">
                                                        edit
                                                    </span>                                               
                                                </a>
                                            </td>
                                            <td>
                                                <a>
                                                    <button type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#deleteModal"
                                                            style="background: transparent; border: none; margin: 0px 0px 5px -2px"
                                                            onclick="delecteCheck('${dto.id}')">
                                                        <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                                    </button>
                                                </a>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- table container -->
                        <a href="AddAds" class="btn btn-primary btn-block text-uppercase mb-3">Add new ADS</a>
                    </div>
                </div>
            </div>
        </div>
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; <b>2018</b> All rights reserved. Design:
                    <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p>
            </div>
        </footer>

        ${sessionScope.errorUpdate}

        <%
            request.getSession().removeAttribute("errorUpdate");
        %>
        
        ${sessionScope.errorMessage}

        <%
            request.getSession().removeAttribute("errorMessage");
        %>

        ${sessionScope.deleteMess}

        <%
            request.getSession().removeAttribute("deleteMess");
        %>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>
                                                                $(function () {
                                                                    $(".tm-product-name").on("click", function () {
                                                                        window.location.href = "edit-product.html";
                                                                    });
                                                                });
        </script>

        <script>
            function delecteCheck(id) {
                if (confirm("Are you want to delete this comment " + id)) {
                    window.location.href = 'DeleteAds?del_id=' + id;
                }
            }
        </script>
    </body>
</html>
