<%-- 
    Document   : dataStaff
    Created on : Dec 29, 2017, 4:57:26 PM
    Author     : user
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Staff</title>
    </head>
    <body>
        <h1>Data Staff</h1>
        <jsp:include page="menu.jsp"></jsp:include>
        <table>
            <thead>
                <tr>
                    <th>No</th>
                    <th>Nama Staff</th>
                    <th>Option</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach varStatus="no" var="s" items="${staff}">
                    <tr>
                        <td>${no.count}</td>
                        <td>${s.getNamaLengkap()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/home/edit/staff/${s.getIdAdmin()}">Edit</a>
                            <a href="${pageContext.request.contextPath}/home/hapus/staff/${s.getIdAdmin()}">Hapus</a>
                        </td>
                    </tr>
                    
                 </c:forEach>
               
            </tbody>
        </table>
        
    </body>
</html>
