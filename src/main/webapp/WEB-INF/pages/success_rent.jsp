
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../css/links_to_bootstrap.jsp"%>

</head>
<body>
<%@include file="../include/navbar.jsp"%>
<div class="grid text-center">
    <p>${requestScope.massage}</p>
</div>
<%@include file="go_to_home.jsp"%>
</body>
</html>

