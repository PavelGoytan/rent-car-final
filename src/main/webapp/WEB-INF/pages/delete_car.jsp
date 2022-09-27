<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@include file="../css/links_to_bootstrap.jsp"%>
    <title>Title</title>
</head>
<body>
<%@include file="../include/navbar.jsp"%>
<h1>You are trying to delete ${requestScope.car}. Are you sure?</h1>
<a href="${pageContext.request.contextPath}/controller?command=delete_car&id=${requestScope.carID}"><button>DELETE</button></a>
</body>
</html>
