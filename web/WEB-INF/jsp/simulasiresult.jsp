
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simulasi - JavaExpress</title>
        <link rel="icon" href="https://cdn3.iconfinder.com/data/icons/purchases-and-sales/512/transpo.png">
        <link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
        <style type="text/css">
            input[type=text] {
                width: 200px;
                box-sizing: border-box;
                border: 2px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
                background-color: white;
                background-image: url('searchicon.png');
                background-position: 30px 10px; 
                background-repeat: no-repeat;
                padding: 12px 20px 12px 40px;
                -webkit-transition: width 6s ease-in-out;
                transition: width 0.90s ease-in-out;
            }

            input[type=text]:focus {
                width: 70%;
            }
        </style>

    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="container">
            <p>Simulasi</p>
            <form>
                <input type="text" name="search" placeholder="Kota Asal">
            </form>
            <form>
                <input type="text" name="search" placeholder="Kota Tujuan">
            </form>
            <form>
                <input type="text" name="search" placeholder="Berat">
            </form>

            <button type="submit"><i class="fa fa-search"></i></button> <br><br>
            
            <div class="row">
                <div class="col-md-4 p-4">
                    <img class="#">
                    <!--<img class="img-fluid d-block rounded-circle mx-auto" src="https://pingendo.github.io/templates/sections/assets/test_meow.jpg">-->
                    <p><b>Reguler</b>
                        <br>Estimation : <b>3 - 4 Days</b></p>
                    <p class="my-4">Estimasi harga dengan berat sesuai input</p>
                </div>
                <div class="col-md-4 p-4">
                    <img class="#">
                    <!--<img class="img-fluid d-block rounded-circle mx-auto" src="https://pingendo.github.io/templates/sections/assets/test_fish.jpg">-->
                    <p><b>Express</b>
                        <br>Estimation : <b>1 - 2 Days</b></p>
                    <p class="my-4">Estimasi harga dengan berat sesuai input</p>
                </div>
                <div class="col-md-4 p-4">
                    <img class="#">
                    <!--<img class="img-fluid d-block rounded-circle mx-auto" src="https://pingendo.github.io/templates/sections/assets/test_carlito.jpg">-->
                    <p><b>One Day Service (ONS)</b>
                        <br>Estimation : <b>1 Day</b></p>
                    <p class="my-4">Estimasi harga dengan berat sesuai input</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 p-4">
                    <img class="#">
                    <!--<img class="img-fluid d-block rounded-circle mx-auto" src="https://pingendo.github.io/templates/sections/assets/test_meow.jpg">-->
                    <p><b>Same Day Service (SDS)</b>
                        <br>Estimation : <b>0 - 1 Day</b></p>
                    <p class="my-4">Estimasi harga dengan berat sesuai input</p>
                </div>
                <div class="col-md-4 p-4">
                    <img class="#">
                    <!--<img class="img-fluid d-block rounded-circle mx-auto" src="https://pingendo.github.io/templates/sections/assets/test_carlito.jpg">-->
                    <p><b>Holiday Service (HDS)</b>
                        <br>Estimation : <b>1 - 2 Days</b></p>
                    <p class="my-4">Estimasi harga dengan berat sesuai input</p>                
                </div>
            </div>            
            
        </div>

        <jsp:include page="footer.jsp"/>
    </body>
</html>
