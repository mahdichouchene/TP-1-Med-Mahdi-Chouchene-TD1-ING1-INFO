<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 24/10/2026
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    java.util.Date date = new java.util.Date();
    String ip=request.getRemoteHost().toString();
%>
    <p>the current time:<%=date%> </p>
    <p>the ip : <%=ip%></p>
</body>
</html>
