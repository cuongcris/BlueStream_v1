<%-- 
    Document   : checkotp
    Created on : May 15, 2023, 3:32:54 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Verify</title>
        <link rel="stylesheet" href="css/styleOTP.css"/>
        
    </head>
    <body>
        <div class="form" style="text-align: center;">
            <h2>Verify Your Account</h2>
            <p>We emailed you the for digit otp code to Enter the code below to confirm your email address...</p>

            <form action="checkotpchangepass" method="Post" autocomplete="off">
                ${error_Code}
                <div class="fiedlds-input">
                    <input type="number" name="otp1" class="otp-field" placeholder="0" min="0" max="9" required onpaste="false">
                    <input type="number" name="otp2" class="otp-field" placeholder="0" min="0" max="9" required onpaste="false">
                    <input type="number" name="otp3" class="otp-field" placeholder="0" min="0" max="9" required onpaste="false">
                    <input type="number" name="otp4" class="otp-field" placeholder="0" min="0" max="9" required onpaste="false">
                    <input type="number" name="otp5" class="otp-field" placeholder="0" min="0" max="9" required onpaste="false">
                    <input type="number" name="otp6" class="otp-field" placeholder="0" min="0" max="9" required onpaste="false">

                </div>

                <div class="submit">
                    <input type="submit" value="Verify Now" class="button">
                </div>
            </form>


        </div>
        <script src="js/scriptOTP.js"></script>
    </body>

</html>
</html>
