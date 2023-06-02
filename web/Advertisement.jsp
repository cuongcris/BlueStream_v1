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
                <div id="ad-content">
                    <!-- Nội dung quảng cáo -->
                    <a href="https://game24h.vn/tinh-diem/7-vien-ngoc-rong-4-c145g2653b16.html " target="_blank">
                        <img style="width: 578px; height: 90px;"
                             src="https://lh3.googleusercontent.com/qOpyFqNjcqD2y8rTlMnsSOvyDltR6IFDAjoErOxmpuAKYQrrTZWVztGTuV9-jPGwNOqI5GH5buyTkkDEO0zieY3ZPa6usQfjBipWYSX3goYNiFNEGQ9_p_Ufi976cg=s0"
                             alt="Quảng cáo">
                    </a>
                    <a href="https://www.fptca.net/p/fpt-ecustom-services.html" target="_blank">
                        <img style="width: 578px; height: 90px;"
                             src="https://lh3.googleusercontent.com/fife/APg5EOa-WdQYGIWswM-EXxwknVzV680XsFJStFlaOLgnVF86y3KOmjq9JVUsS2TGIMaqbarJDI1Jz32jnEbqLsj0YwkueWgSrSof3gwZ-vMvw4-N0dlEm7s5qcOFEmkKtqRgpVOdUkXH1LVMiycVrQQ7gpIWf4slEDwWMpiG4ctIFGkitS5JvZQI4HoYBBbwAcQfWsiRyAn2JS_VAtt6HOacEDmUXgCyUCMi0ME8jddkwZAgOfN7EvYNUjgcUWm7g0wxB0PmMt4dh5Igtf5uDs44uPJQgH8yRC6Hsq3xyAKECGL0KswFZPDKB-oiFMNxaXRy8GSFrV5SgKLH-B77pt2FQYSTsz2TNROnbOTgPyGE7KQUttqkdZo8VqT1C_4YLooSYHRWhKvH3bE8s2j1d99MnnLOCXPIxsXiGW2DpcRWegUs4RjQrGB_jSUz-aduzeGpVoYQgqsZknXrFGO2m0Yx8HYcqTDEwOwqbmQEtie4phc9t1im89fu3xaGkEaVhd24b3Ls7bpGfwYys-Q925fd7qnmQlA9DkAgtFPrU3rzw6ILvnI0bZq8xnX61plUTPoqysuod7KlWzjLTdirJvzRuTaGWQ8B7cvinjG8G31-dA-OPIYTo3flESq_Ea5mwsZtnutek2iAuZTocsfM00PFDlOVaxRJqWVKomMXarRWhcZJwimjSLKkCrxqLtdR94R7w8sqBuMCkLfP5MxFldmbVhcUpXSVC0-x-PDE3wg_Ef5NgYWK502JXRX8QsHdrXL0CYCD8n_AkDJmDbSvtKW4APzwT8d-mAdIbg7NOVvG_w3UNUQ2Khjl1n2ZgpwOsCaUvMI6QXgBMaRVfi4TxwxpHfajcSIwi27J0FEzAN4gFouNOoJiavXjyxSN22bholx-c6gVeRclIbIR-3GjvFan65mFGzzUUbWDpllwm1_YAVB86RtvhauMVXwxVqK0sk-8l2PvlSIQrqA4CXXuEr5ubjm5jfNx3lyiQ_8y0TICYM-oulOHE43rYT-RfNIQlsfqruYOi05-QYeDr0FUacfhEST9ClURgydTcAAKUHwqE76ztqavNmGYatOEhbhIASkGv-KDV85qjC-siLV16NlN46CH41WLVXYsd-gUaeioqJZ3brKNLRPhoJjazOl6nLln_LpFqSNr7NIPmnmcJB2ie0WFMeSNAFFrL3S_rylicwmk5ZqqGgVxMwNb3C6XlxrmKLzXqlr69EzbK77hIEjtgbUnFfAHn0qPgZoxHSJsR-qL7X2uBXJZpWy87eryMR3S2QSRjn8d_Z8e4J68C2Vb-8LEDvZagsq71zfHFYUtXhTr2M9WhomWWuo9PKsE_xkIFYqehRCjpt6yLTMHgtCU8ORsPKbzGQm1q5KaEi-3T1-oyvEiN5XSUUGbfET-pjMiYUzJIJjUjSC8Hq8n0C_Xv9mbmT4GYhp2f2fPzfIUsfwGLZvUp94s-vFRUAdNLdyCs7xbReUomH1yz3gnTbIptJ1_5LujnVAiMr0WrtmjTd6AHBR60aTZecoqiVhVg26qlohOK4Poe0S2FeK9gFgxgalT1SET8EOm8z_MbSctMuC0LSQZpF7c-xkaB7zGKPLRxtoOev1J4hy0nevx=w1920-h937"
                             alt="Quảng cáo">
                    </a>
                    <button id="close-button">&times;</button>
                </div>
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

        #ad-content {
            position: relative;
        }

        #close-button {
            position: absolute;
            right: -20px;
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
