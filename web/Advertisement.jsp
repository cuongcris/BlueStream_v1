<%-- 
    Document   : Advertisement
    Created on : May 31, 2023, 8:44:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${account == null || sessionScope.account.role == 2}">
            <div id="ad-container">
                <Center>

                    <div id="ad-content">
                        <!-- Nội dung quảng cáo -->
                        <c:forEach var="dto" items ="${sessionScope.ads_show}" >

                            <c:if test="${dto.type.equals('BottomPicture_Right')}">
                                <a href="${dto.linkTo} " target="_blank">
                                    <img style="width: 578px; height: 90px;"
                                         src="${dto.linkShow}"
                                         alt="Quảng cáo">
                                </a>
                            </c:if>

                            <c:if test="${dto.type.equals('BottomPicture_Left')}">
                                <a href="${dto.linkTo} " target="_blank">
                                    <img style="width: 578px; height: 90px;"
                                         src="${dto.linkShow}"
                                         alt="Quảng cáo">
                                </a>
                            </c:if>
                        </c:forEach>
                        <button id="close-button">&times;</button>
                    </div>
                </Center>
            </div>
        </c:if>


    </body>


    <style>
        #ad-container {
            position: fixed;
            bottom: 0;
            padding: 5px;
            display: none;
            margin-left: 10%;
            width: 80%;
            z-index: 9999;
        }

        #ad-content{
            position: relative;
        }
        #close-button {
            position: absolute;
            background: none;
            border: none;
            font-size: 20px;
            cursor: pointer;
            color: rgb(255, 255, 255);
            background-color: rgba(225, 9, 9, 0.8);
        }
    </style>

    <script>
        window.onload = function () {
            var adContainer = document.getElementById('ad-container');
            var closeButton = document.getElementById('close-button');

            // Hiển thị quảng cáo khi trang được tải
            adContainer.style.display = 'block';

            // Đóng quảng cáo khi bấm vào nút đóng
            closeButton.addEventListener('click', function () {
                adContainer.style.display = 'none';
            });

            // Duy chuyển quảng cáo theo khi lăn chuột
            window.addEventListener('scroll', function () {
                adContainer.style.bottom = '0';
            });
        };

    </script>

</html>
