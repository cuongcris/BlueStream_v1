@@ -0,0 +1,115 @@
<%-- 
    Document   : Filterlogin
    Created on : Jun 21, 2023, 5:45:08 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="Head.jsp" %>
    <head>


    </head>
    <body>
        <%@include file="Header.jsp" %>
        <div class="container" >
            <div class="row d-flex justify-content-center" >  
                <div class="col-md-6 text-center left-page" >
                    <div style="font-size: 20rem"> <i class="fa-regular fa-face-frown" style="color: #ffffff;"></i>
                    </div>
                    <div>503  </div>
                    <div style="font-size : 2rem"> Page not found
                    </div>
                </div>
                <div class="col-md-6 text-center right-page" >
                    <div>
                        <span class="title">Oh Nooo</span>  
                    </div>
                    <div style="font-size: 5rem "> ${requestScope.ms}
                    </div>
                    <div class="row btn-redirect">

                        <div class="col-md-6 w-100"> 
                            <button class="button-64" role="button"><span class="text" onclick="window.location = 'home'">Homepage</span></button>
                        </div>
                        <div class="col-md-6 w-100"> 
                            <button class="button-64" role="button"><span class="text" onclick="window.location = 'Login.jsp'">Login</span></button>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>

    <style>
        .left-page{
            font-size: 7rem;
            color: white;
        }
        .right-page{
            font-size: 7rem;
            color: white;
            margin-top: 40px;
        }
        .title{
            border-bottom: solid #ffffff 10px;
            font-weight: bolder;
        }
        .btn-redirect{
            margin-top: 80px;
        }
        /* CSS */
        .button-64 {
            align-items: center;
            background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
            border: 0;
            border-radius: 8px;
            box-shadow: rgba(151, 65, 252, 0.2) 0 15px 30px -5px;
            box-sizing: border-box;
            color: #FFFFFF;
            display: flex;
            font-family: Phantomsans, sans-serif;
            font-size: 20px;
            justify-content: center;
            line-height: 1em;
            max-width: 100%;
            min-width: 140px;
            padding: 3px;
            text-decoration: none;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
            white-space: nowrap;
            cursor: pointer;
        }

        .button-64:active,
        .button-64:hover {
            outline: 0;
        }

        .button-64 span {
            background-color: rgb(5, 6, 45);
            padding: 16px 24px;
            border-radius: 6px;
            width: 100%;
            height: 100%;
            transition: 300ms;
        }

        .button-64:hover span {
            background: none;
        }

        @media (min-width: 768px) {
            .button-64 {
                font-size: 24px;
                min-width: 196px;
            }
        }
    </style>
</html>