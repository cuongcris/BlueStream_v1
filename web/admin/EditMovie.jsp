<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <h2 class="tm-block-title d-inline-block">Add New Anime</h2>
                            </div>
                        </div>
                        <form action="EditMovie" method="post" class="tm-edit-product-form"> 
                            <div class="row tm-edit-product-row">
                                <div class="col-xl-6 col-lg-6 col-md-12">

                                    <div class="form-group mb-3">
                                        <label for="movieID">Movie ID
                                        </label>
                                        <input value="${detail.movieId}"id="movieID" name="movieID" type="text" style="background-color: #54657d" class="form-control validate" readonly />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="movieName">Movie Name
                                        </label>
                                        <input value="${detail.movieName}"id="movieName" name="movieName" type="text" class="form-control validate" required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="description">Description</label>
                                        <textarea class="form-control validate" rows="2" name="description" required>${detail.description}</textarea>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="mainCategory">Main Category</label>
                                        <select class="custom-select tm-select-accounts" id="category" name="mainCategory">
                                            <option value="Live Action" ${detail.category.get(0).equals("Live Action")?"selected" : ""}>Live Action</option>
                                            <option value="Adventure" ${detail.category.get(0).equals("Adventure")?"selected" : ""}>Adventure</option>
                                            <option value="Harem" ${detail.category.get(0).equals("Harem")?"selected" : ""}>Harem</option>
                                            <option value="Fantasy" ${detail.category.get(0).equals("Fantasy")?"selected" : ""}>Fantasy</option>
                                            <option value="Action" ${detail.category.get(0).equals("Action")?"selected" : ""}>Action</option>
                                            <option value="School" ${detail.category.get(0).equals("School")?"selected" : ""}>School</option>
                                        </select>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="subCategory">Sub Category</label>
                                        <select class="custom-select tm-select-accounts" id="category" name="subCategory">
                                            <option selected disabled>${detail.category.get(1)}</option>
                                            <option value="Super Power" ${detail.category.get(1).equals("Super Power")?"selected" : ""}>Super Power</option>
                                            <option value="Martial Arts" ${detail.category.get(1).equals("Martial Arts")?"selected" : ""}>Martial Arts</option>
                                            <option value="Ecchi" ${detail.category.get(1).equals("Ecchi")?"selected" : ""}>Ecchi</option>
                                            <option value="Parody" ${detail.category.get(1).equals("Parody")?"selected" : ""}>Parody</option>
                                            <option value="Shounen" ${detail.category.get(1).equals("Shounen")?"selected" : ""}>Shounen</option>

                                        </select>

                                    </div>
                                    <div class="form-group mb-3">
                                        <label>License</label>
                                        <select class="custom-select tm-select-accounts" id="category" name="license" required>

                                            <option value="1" ${detail.license.equals("1") ? "selected" : ""}>License</option>
                                            <option value="0" ${detail.license.equals("0") ? "selected" : ""}>No License</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">

                                    <div class="custom-file mt-3 mb-3" >

                                        <img style="width: 358px; height: 340px; margin: 0 0 14px 0" src="${detail.movieBanner}">

                                        <input value="${detail.movieBanner}"name="movieBanner" type="text" class="form-control validate mx-auto" placeholder="Upload Movie Image"
                                               style="color: #fff;">

                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mt-auto">
                                            <label for="expire_date">Release Date
                                            </label>
                                            <input value="${detail.releaseDate}" name="releaseDate" type="date" class="form-control validate"
                                                   data-large-mode="true" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mt-4">
                                            <label for="stock">Author
                                            </label>
                                            <input value="${detail.author}"id="stock" name="author" type="text" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mx-auto">
                                            <label for="stock">Movie Status
                                            </label>
                                            <input value="${detail.movieStatus}" id="stock" name="movieStatus" type="text"  pattern="[01]" class="form-control validate" required />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6 mx-auto">
                                            <label for="stock">Movie Season
                                            </label>
                                            <input value="${detail.movieSeason}"id="stock" name="movieSeason" type="text" class="form-control validate" required />
                                        </div>

                                    </div>
                                </div>
                                <div class="col-12">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase">Update Movie Now</button>
                                </div>
                            </div>
                        </form>
                        <div>
                            <c:forEach var="i" begin="1" end="${totalEp}">
                                <a href="EditEpisodes?mid=${detail.movieId}&epNum=${i}">
                                    <button class="btn  btn-primary mt-4">${i}</button>
                                </a>
                            </c:forEach>


                            <a href="AddEpisodes?mid=${detail.movieId}">
                                <button class="btn  btn-primary mt-4">+</button>
                            </a>
                        </div> 

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
            $(function () {
                $("#expire_date").datepicker();
            });
        </script>
    </body>

</html>