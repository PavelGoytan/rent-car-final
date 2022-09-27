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
<%@include file="../include/search_user.jsp"%>
<c:forEach var="user" items="${requestScope.users}">
    <li>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_change_role&id=${user.id}">${user.firstName}  ${user.id}</a>
        <a href="${pageContext.request.contextPath}/controller?command=go_to_delete_user&id=${user.id}"><button>DELETE</button></a>
    </li>
</c:forEach>
</body>
</html>

