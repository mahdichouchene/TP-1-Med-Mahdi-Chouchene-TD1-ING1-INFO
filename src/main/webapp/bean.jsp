<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 07/11/2026
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="person" class="isimm.lab1.bean.person" scope="request"/>
<jsp:setProperty name="person" property="fn" param="fn"/>
<jsp:setProperty name="person" property="ln" param="ln"/>
<jsp:setProperty name="person" property="birthday" param="birthday"/>
<jsp:setProperty name="person" property="gender" param="gender"/>
<h1>Person Information</h1>
<p>First Name: <jsp:getProperty name="person" property="fn"/></p>
<p>Last Name: <jsp:getProperty name="person" property="ln"/></p>
<p>Birthdate: <jsp:getProperty name="person" property="birthday"/></p>
<p>Gender: <jsp:getProperty name="person" property="gender"/></p>
</body>
</html>
