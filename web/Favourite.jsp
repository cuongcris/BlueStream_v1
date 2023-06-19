<%-- 
    Document   : Favourite
    Created on : Jun 17, 2023, 2:20:07 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Head.jsp" %>
<!DOCTYPE html>
<html>
    <%@include file="Header.jsp" %>
    <head>

    </head>
    <body>
        <div class="container-favourite">
            <h2></h2>
            <p></p>

            <div>
                <table class="table table-bordered text-center">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="fvr-movie"> Movie</th>

                            <th>Category</th>
                            <th>Author</th>
                            <th>View</th>
                            <th>Edit</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="fvr-content"> 1</td>

                            <td  class="fvr-movie"><img width="15%" height="100%" src="https://lh3.googleusercontent.com/fife/APg5EOblgMeiRaDIsvQtFgCRWkRFKuLb_-6dVKgv7bOPv4XHb_-BGnXp1A6f8dKjjEOSDfl_YizWBxJUQIij9a9WvxlmtNDc68uaSkdf5omavohQHuqfAMG8fZLtXaibqnrXjgzLbsXWaU8U22KEHkRkueUA_NN9scwJeC7BvamlGKsXzsVw5-Kay8OlnMRnjy7f9xeiM35J-3u0hvgwnjvaVZe-952rXATPyZL8udxxqibOtZ_ouzP8Ecb4JvHTQQ7cMbH6g50RoVcuN9IwAFQaXMtCwX4wFCkI0u2qF63WPdBTWcQRcroNYELUzg9HlGzAdFrUdgVAqLQRGPxyOekkuokKD4zNWmHHQoivsZpSDf4h4_ZV2GIj4FYArLVQue7WEU0C-9gI5WM2aMv7S_Aqz4HONQVfh3ErnQszNDXRF4C1rWdN9vrWEMI2nz8D5OV6Y5UWOJTe1YDEUzA5TcXxoByE_apa4bku0XyA_LwomqnOpnR802CHS-hjl0AgeWIggBOcdGYRdAnsYWHqJOVPwPitb-5c_GxlrTx7vZc_EvNZyF5autx5YKkuBRhPe0NtbEW68v2J-3qpA7oFx7X_qoq8Zui_vE4ehhp4YPpY0heyAlmqzTeQ97MEJ3J8uSzGJtwkNJVO9txhLbZPJgOj7Iaytb00kfKtW-kfA6qEaCLp24jVBmUaFTPUDN1bgzja4rGuSStk4COMOJICq7GqB-KlhgrZNSmL2DRkzUiaOm0oC_cE92u1YI0cArDd8vi7mp7-DsGh2w4PPTse2F6s4_lsB6hdtgo5APGlDxkIIW2kPpOp5QhTUEntV-JAcaANuEcMdl0tjNHjN30v5h_P23doJ9CbTu1TygsuZPFMMr7bx6hYfeAU_CaSCNysQynhHe23U0458rNMc00Rvu2PGog_xEnw7NfIbDPdAwiGCOjMKzdxBPmt6Sw22eDapALqImOOGZuYmXwpkI4NMRjvAgnQJ2uJ7NhuagQ_OwMogur6fX7R-EetKSIPWRgwkzA585ISqR1-N4-NsDZ5mS9JBVXLelpr8B6HZUgpvbGmIn8dZHttYjD3-GbQ1TCBz1RABZy7A4-dhRU4KbgSU0wheVz-YN7Q_zHikS2mbrtEYtlO8DeBiIlqVpD6AKPGp7QGxfGa02CxuzJvDZGfIWyzf_47DqX731w0SHJsN6zpcimZ1qxCD_D1DY9qRnnL2TfEDbp2uPxi2tbaPu34_QIXYxs_rvaaSpWnGHC4jZjLkenXbtseRBNYdwTHU8hV_AkeulTyzpiRPQSMYkseiRhacu61d3siUuuGzX8XkLW__GQgYXVdDwtAm5GSXnoYpJF9f5_v9scbi5zYVLxJPzuUmoWCGnv_f_VL7yleFtqpIuwILeK47vWyN3m6kgnzgiVEXvjSB6QajKKNx-j0O_C8s6IxiQb2YksB0rqpPz5AMFyZb2a2dqi4FXCnwrJ5SJ6egIqqDbvU4njDE2d7mpjvoMtTb-cQ3CXhx-Olg3_70qM31-kBSQFxuAGcQ4L9ys5Rhxq3LQ=w1920-h961">  Anna </td>

                            <td class="fvr-content"> 35</td>
                            <td class="fvr-content"> New York</td>
                            <td class="fvr-content"> USA</td>
                            <td class="fvr-content"> <i class="fa-solid fa-trash"></i></td>
                        </tr>
                         <tr>
                            <td class="fvr-content"> 1</td>

                            <td  class="fvr-movie"><img width="15%" height="100%" src="https://lh3.googleusercontent.com/fife/APg5EOblgMeiRaDIsvQtFgCRWkRFKuLb_-6dVKgv7bOPv4XHb_-BGnXp1A6f8dKjjEOSDfl_YizWBxJUQIij9a9WvxlmtNDc68uaSkdf5omavohQHuqfAMG8fZLtXaibqnrXjgzLbsXWaU8U22KEHkRkueUA_NN9scwJeC7BvamlGKsXzsVw5-Kay8OlnMRnjy7f9xeiM35J-3u0hvgwnjvaVZe-952rXATPyZL8udxxqibOtZ_ouzP8Ecb4JvHTQQ7cMbH6g50RoVcuN9IwAFQaXMtCwX4wFCkI0u2qF63WPdBTWcQRcroNYELUzg9HlGzAdFrUdgVAqLQRGPxyOekkuokKD4zNWmHHQoivsZpSDf4h4_ZV2GIj4FYArLVQue7WEU0C-9gI5WM2aMv7S_Aqz4HONQVfh3ErnQszNDXRF4C1rWdN9vrWEMI2nz8D5OV6Y5UWOJTe1YDEUzA5TcXxoByE_apa4bku0XyA_LwomqnOpnR802CHS-hjl0AgeWIggBOcdGYRdAnsYWHqJOVPwPitb-5c_GxlrTx7vZc_EvNZyF5autx5YKkuBRhPe0NtbEW68v2J-3qpA7oFx7X_qoq8Zui_vE4ehhp4YPpY0heyAlmqzTeQ97MEJ3J8uSzGJtwkNJVO9txhLbZPJgOj7Iaytb00kfKtW-kfA6qEaCLp24jVBmUaFTPUDN1bgzja4rGuSStk4COMOJICq7GqB-KlhgrZNSmL2DRkzUiaOm0oC_cE92u1YI0cArDd8vi7mp7-DsGh2w4PPTse2F6s4_lsB6hdtgo5APGlDxkIIW2kPpOp5QhTUEntV-JAcaANuEcMdl0tjNHjN30v5h_P23doJ9CbTu1TygsuZPFMMr7bx6hYfeAU_CaSCNysQynhHe23U0458rNMc00Rvu2PGog_xEnw7NfIbDPdAwiGCOjMKzdxBPmt6Sw22eDapALqImOOGZuYmXwpkI4NMRjvAgnQJ2uJ7NhuagQ_OwMogur6fX7R-EetKSIPWRgwkzA585ISqR1-N4-NsDZ5mS9JBVXLelpr8B6HZUgpvbGmIn8dZHttYjD3-GbQ1TCBz1RABZy7A4-dhRU4KbgSU0wheVz-YN7Q_zHikS2mbrtEYtlO8DeBiIlqVpD6AKPGp7QGxfGa02CxuzJvDZGfIWyzf_47DqX731w0SHJsN6zpcimZ1qxCD_D1DY9qRnnL2TfEDbp2uPxi2tbaPu34_QIXYxs_rvaaSpWnGHC4jZjLkenXbtseRBNYdwTHU8hV_AkeulTyzpiRPQSMYkseiRhacu61d3siUuuGzX8XkLW__GQgYXVdDwtAm5GSXnoYpJF9f5_v9scbi5zYVLxJPzuUmoWCGnv_f_VL7yleFtqpIuwILeK47vWyN3m6kgnzgiVEXvjSB6QajKKNx-j0O_C8s6IxiQb2YksB0rqpPz5AMFyZb2a2dqi4FXCnwrJ5SJ6egIqqDbvU4njDE2d7mpjvoMtTb-cQ3CXhx-Olg3_70qM31-kBSQFxuAGcQ4L9ys5Rhxq3LQ=w1920-h961">  Anna </td>

                            <td class="fvr-content"> 35</td>
                            <td class="fvr-content"> New York</td>
                            <td class="fvr-content"> USA</td>
                            <td class="fvr-content"> <i class="fa-solid fa-trash"></i></td>
                        </tr>
                         <tr>
                            <td class="fvr-content"> 1</td>

                            <td  class="fvr-movie"><img width="15%" height="100%" src="https://lh3.googleusercontent.com/fife/APg5EOblgMeiRaDIsvQtFgCRWkRFKuLb_-6dVKgv7bOPv4XHb_-BGnXp1A6f8dKjjEOSDfl_YizWBxJUQIij9a9WvxlmtNDc68uaSkdf5omavohQHuqfAMG8fZLtXaibqnrXjgzLbsXWaU8U22KEHkRkueUA_NN9scwJeC7BvamlGKsXzsVw5-Kay8OlnMRnjy7f9xeiM35J-3u0hvgwnjvaVZe-952rXATPyZL8udxxqibOtZ_ouzP8Ecb4JvHTQQ7cMbH6g50RoVcuN9IwAFQaXMtCwX4wFCkI0u2qF63WPdBTWcQRcroNYELUzg9HlGzAdFrUdgVAqLQRGPxyOekkuokKD4zNWmHHQoivsZpSDf4h4_ZV2GIj4FYArLVQue7WEU0C-9gI5WM2aMv7S_Aqz4HONQVfh3ErnQszNDXRF4C1rWdN9vrWEMI2nz8D5OV6Y5UWOJTe1YDEUzA5TcXxoByE_apa4bku0XyA_LwomqnOpnR802CHS-hjl0AgeWIggBOcdGYRdAnsYWHqJOVPwPitb-5c_GxlrTx7vZc_EvNZyF5autx5YKkuBRhPe0NtbEW68v2J-3qpA7oFx7X_qoq8Zui_vE4ehhp4YPpY0heyAlmqzTeQ97MEJ3J8uSzGJtwkNJVO9txhLbZPJgOj7Iaytb00kfKtW-kfA6qEaCLp24jVBmUaFTPUDN1bgzja4rGuSStk4COMOJICq7GqB-KlhgrZNSmL2DRkzUiaOm0oC_cE92u1YI0cArDd8vi7mp7-DsGh2w4PPTse2F6s4_lsB6hdtgo5APGlDxkIIW2kPpOp5QhTUEntV-JAcaANuEcMdl0tjNHjN30v5h_P23doJ9CbTu1TygsuZPFMMr7bx6hYfeAU_CaSCNysQynhHe23U0458rNMc00Rvu2PGog_xEnw7NfIbDPdAwiGCOjMKzdxBPmt6Sw22eDapALqImOOGZuYmXwpkI4NMRjvAgnQJ2uJ7NhuagQ_OwMogur6fX7R-EetKSIPWRgwkzA585ISqR1-N4-NsDZ5mS9JBVXLelpr8B6HZUgpvbGmIn8dZHttYjD3-GbQ1TCBz1RABZy7A4-dhRU4KbgSU0wheVz-YN7Q_zHikS2mbrtEYtlO8DeBiIlqVpD6AKPGp7QGxfGa02CxuzJvDZGfIWyzf_47DqX731w0SHJsN6zpcimZ1qxCD_D1DY9qRnnL2TfEDbp2uPxi2tbaPu34_QIXYxs_rvaaSpWnGHC4jZjLkenXbtseRBNYdwTHU8hV_AkeulTyzpiRPQSMYkseiRhacu61d3siUuuGzX8XkLW__GQgYXVdDwtAm5GSXnoYpJF9f5_v9scbi5zYVLxJPzuUmoWCGnv_f_VL7yleFtqpIuwILeK47vWyN3m6kgnzgiVEXvjSB6QajKKNx-j0O_C8s6IxiQb2YksB0rqpPz5AMFyZb2a2dqi4FXCnwrJ5SJ6egIqqDbvU4njDE2d7mpjvoMtTb-cQ3CXhx-Olg3_70qM31-kBSQFxuAGcQ4L9ys5Rhxq3LQ=w1920-h961">  Anna </td>

                            <td class="fvr-content"> 35</td>
                            <td class="fvr-content"> New York</td>
                            <td class="fvr-content"> USA</td>
                            <td class="fvr-content"> <i class="fa-solid fa-trash"></i></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <style>
        .table{
            color: white !important;

        }
        .fvr-content{
            padding-top : 4.3% !important;

        }
        .fvr-movie{
            text-align: left !important;
            width: 40% !important;
        }
        .fvr-movie img{
            display: inline;
        }
        .table-responsive{
            width: 100%;
            text-align: center;
        }
        .container-favourite{
            margin: 70px 15%;
            
        }
        .table-bordered th,
        .table-bordered td{
            border: 0.1px solid #999999 !important;
            
        }
    </style>

</html>
