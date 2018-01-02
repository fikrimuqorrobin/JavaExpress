<%  if(session.getAttribute("admin") == null) { %>

    <jsp:forward page="login.jsp"></jsp:forward>

<%  } else { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Express</title>
    </head>

    <body>
        <h1>Home</h1>
        <div name="menu">
            <%  if(session.getAttribute("level").equals("master")){ %>
                <jsp:include page="menu_master.jsp"></jsp:include>
            <%  } else if(session.getAttribute("level").equals("staff")){ %>
                <jsp:include page="menu_staff.jsp"></jsp:include>
            <%  } %> 
        </div>
        <div name="container">
            <jsp:include flush="true" page="${file}"></jsp:include>
        </div>
    </body>
</html>

<% } %>