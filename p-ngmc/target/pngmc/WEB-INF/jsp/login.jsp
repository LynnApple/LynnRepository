<%--
  Created by IntelliJ IDEA.
  User: lynn
  Date: 2019/11/4
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<form action="${pageContext.request.contextPath}/test/login.do" method="post">
    <input type="text" name="userName"/><br/>
    <input type="text" name="password"/><br/>
    <input type="submit">
</form>
</body>
</html>
