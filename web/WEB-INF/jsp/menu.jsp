
<% if(session.getAttribute("level") == "master"){ %>
 
<h3>Ini Menu Admin Master</h3>
<ul>
    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/home/staff">Data Staff</a></li>
    <li><a href="${pageContext.request.contextPath}/home/input/staff">Input Admin Staff</a></li>
    <li><a href="${pageContext.request.contextPath}/home/logout" onclick="return confirm('Yakin Logout ?')">Logout</a></li>
</ul>

<% } else if(session.getAttribute("level") == "staff"){ %>

<h3>Ini Menu Admin Staff</h3>
<ul>
    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/input/pengiriman">Input Pengiriman</a></li>
    <li><a href="${pageContext.request.contextPath}/update/pengiriman">Update Status Pengiriman</a></li>
    <li><a href="${pageContext.request.contextPath}/home/logout" onclick="return confirm('Yakin Logout ?')">Logout</a></li>
</ul>

<% } %>