<%-- 
    Document   : MovieManagement
    Created on : Jun 17, 2023, 1:38:34 PM
    Author     : PC
--%>

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
            <h1 style="margin-left: 37%; color: white;">Account Management</h1>
        </div>

        <div class="container mt-3">
            <div class="row tm-content-row">
                <div class="col-xl-12">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="tm-product-table-container">
                            <table class="table table-hover tm-table-small tm-product-table">
                                <thead>
                                    <tr>
                                        <th scope="col">User ID</th>
                                        <th scope="col">User Name</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Full Name</th>
                                        <th scope="col">Role</th>
                                        <th scope="col">&nbsp;</th>
                                        <th scope="col">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listAcc}" var="o">
                                        <tr>
                                            <th scope="row">${o.userID}</th>
                                            <td><a href="" style="color: #fff;"> ${o.userName}</a></td>
                                            <td>${o.email}</td>
                                            <td>${o.fullName}</td>
                                            <c:if test="${o.role == 0}">
                                                <td>Admin</td>
                                            </c:if>
                                            <c:if test="${o.role == 1}">
                                                <td>Premium User</td>
                                            </c:if>
                                            <c:if test="${o.role == 2}">
                                                <td>User</td>
                                            </c:if>


                                            <td>
                                                <a href="EditAccount?update_id=${o.userID}" >
                                                    <span class="material-symbols-outlined" style="color: #fff;">
                                                        edit
                                                    </span>                                               
                                                </a>
                                            </td>
                                            <td>
                                                <a href="DeleteAccount?uid=${o.userID}" onclick="return confirm('Do you want to remove this movie?')">
                                                    <button type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#deleteModal"
                                                            style="background: transparent; border: none; margin: 0px 0px 5px -2px">
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
                        <!--<a href="add-movie" class="btn btn-primary btn-block text-uppercase mb-3">Add new product</a>-->
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





        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
