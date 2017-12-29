
<% if(session.getAttribute("level") == "master"){ %>
 
<h3>Ini Menu Admin Master</h3>
<ul>
    <li>Home</li>
    <li>Master Data</li>
    <li><a href="${pageContext.request.contextPath}/input/staff">Input Admin Staff</a></li>
    <li><a href="${pageContext.request.contextPath}/home/logout" onclick="return confirm('Yakin Logout ?')">Logout</a></li>
</ul>

<% } else { %>

<h3>Ini Menu Admin Staff</h3>
<ul>
    <li>Home</li>
    <li><a href="${pageContext.request.contextPath}/input/pengiriman">Input Pengiriman</a></li>
    <li><a href="${pageContext.request.contextPath}/update/pengiriman">Update Status Pengiriman</a></li>
    <li><a href="${pageContext.request.contextPath}/home/logout" onclick="return confirm('Yakin Logout ?')">Logout</a></li>
</ul>

<% } %>