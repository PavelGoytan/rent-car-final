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
<h1>
 ${requestScope.changedUser.firstName} ${requestScope.changedUser.emailLogin}
    IS CHANGED
</h1>

</body>
</html>

