<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-09-28
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form action="/Welcome">
        <s:textfield name="username" label="Username"/>
        <s:password name="password" label="Password"/>
        <s:submit/>
    </s:form>
</body>
</html>
