
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../css/links_to_bootstrap.jsp"%>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="find_user_by_id">
    <input type="search" placeholder="Search" name="user_id" >
    <button type="submit">Search</button>
</form>
</body>
</html>
