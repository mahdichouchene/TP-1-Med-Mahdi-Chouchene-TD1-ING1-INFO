<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person born after 1990</title>
</head>
<body>
<jsp:useBean id="person" scope="request" type="lab.mvc.model.Person" />
<h1>Person born after 1990</h1>
<p>First name: <jsp:getProperty name="person" property="firstName" /></p>
<p>Last name: <jsp:getProperty name="person" property="lastName" /></p>
<p>Birth date: <jsp:getProperty name="person" property="birthDay" /></p>
<p>Sex: <jsp:getProperty name="person" property="sex" /></p>
</body>
</html>
