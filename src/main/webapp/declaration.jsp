<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07/11/2026
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! private int numEntries = 10;
    private int randomInt(int range) {
        return(1 + ((int)(Math.random() * range)));
    } %>
<h1>A random list from 1 to 100:</h1>
<ul>
    <% for(int i=0; i<numEntries; i++) {
        out.println("<li>" + randomInt(100));
    } %>
</ul>
</body>
</html>
