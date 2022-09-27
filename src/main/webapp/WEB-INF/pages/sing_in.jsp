
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
<h1>SING IN</h1>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <div  class="mb-3">
        <input type="hidden" name="command" value="sing_in">
        <label for="email" class="form-label"> EMAIL:
            <input type="text" class="form-control" name="email" id="email" size="55">
        </label>
        <br>
    </div>
    <div  class="mb-3">
        <label for="password" class="form-label"> PASSWORD:
            <input type="password" class="form-control" name="password" id="password" size="55">
        </label>
        <br>
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Sing in</button>
        <a href="${pageContext.request.contextPath}/controller?command=registration_page">
            <button type="button" class="btn btn-primary">Registration</button>
        </a>
    </div>
    <c:if test="${sessionScope.error==1}">
        <div style="color: red">
            <span>EMAIL or PASSWORD is not correct</span>
        </div>
    </c:if>
</form>
    </div>
<%@include file="go_to_home.jsp"%>
</body>
</html>
