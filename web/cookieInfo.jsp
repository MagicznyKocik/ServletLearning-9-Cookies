<%--
  Created by IntelliJ IDEA.
  User: azlup
  Date: 21.02.2019
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All cookies!</title>
</head>
<body>
    <%
        if(request.getCookies() != null)
            for(Cookie c: request.getCookies()) {
    %>
    <%= c.getName() + " > " + c.getValue() %>
    <br>
    <%
        }
%>
<a href="CookieServlet?cookie=print">Refresh page</a>
<br>
<a href="index.jsp">Homepage</a>
</body>
</html>
