

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://v40.pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css" type="text/css"> 
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

    <style>
        h5 {
            
            text-indent: 200px;
        }
        
    </style>
    
    <body>
        <nav class="navbar navbar-expand-md navbar-dark" style="background: royalblue">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
                    <i class="fa fa-home"></i> Home
                </a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/simulasi">
                                <i class="fa fa-truck" style="color:whitesmoke"></i> Simulasi
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Tracking">
                                <i class="fa fa-truck" style="color:whitesmoke"></i> Tracking
                                </a>
                            </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/service">
                                <i class="fa fa-truck" style="color:whitesmoke"></i> Service
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/contactus">
                                <i class="fa fa-phone" style="color:whitesmoke"></i> Contact us
                            </a>
                        </li>
                    </ul>
                    <form class="form-inline m-0">
                        <input class="form-control mr-2" type="text" placeholder="Search">
                        <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
        </nav>
                                <div class="jumbotron"  style="background-image: url(https://tech.co/wp-content/uploads/2014/12/shipping-logistics.jpg); 
         background-size: 50%;">

        <h1 align = "center" >JavaExpress</h1>

        <h5>We Deliver Stuffs Across Java</h5> 



    </div>

    </body>

</html>

