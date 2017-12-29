<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucess Login</title>
    </head>
    <body>
        <h1>Hello : ${admin.getNamaLengkap()}</h1>
        <div name="menu">
            <jsp:include page="menu.jsp"></jsp:include>
        </div>
    </body>
</html>
