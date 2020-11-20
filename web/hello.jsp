<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/10
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/mytaglib" prefix="mm"%>
<html>
<head>
    <title>helloapp</title>
</head>
<body>
    <b><mm:hello/>: <%= request.getAttribute("USER")%></b>
</body>
</html>
