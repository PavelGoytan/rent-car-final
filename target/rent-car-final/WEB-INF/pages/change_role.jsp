<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../css/links_to_bootstrap.jsp" %>
    <title>Title</title>
</head>
<body>
<%@include file="../include/navbar.jsp" %>
<h1>

</h1>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="change_role">
    <input type="hidden" name="idUser" value="${requestScope.idUser}">
    <c:if test="${sessionScope.isManager==true}">
        <label for="role"> ROLE:
            <select name="role" id="role">
                <c:forEach var="role" items="${requestScope.roles}">
                    <option value="${role}">${role}</option>
                </c:forEach>
            </select>

        </label>
        <br>
    </c:if>
    <label for="status">
        <c:forEach var="statuses" items="${requestScope.statuses}">
            <input type="radio" name="status" id="status" value="${statuses}">${statuses}
            <br>
        </c:forEach>
    </label>
    <br>
    <br>
    <button type="submit">Change</button>
    <br>
</form>
</body>
</html>
