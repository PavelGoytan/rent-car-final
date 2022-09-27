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
<c:if test="${requestScope.massage!=null}">
    <h1>
            ${requestScope.massage}
    </h1>

</c:if>
<c:forEach var="car" items="${requestScope.cars}">

    <li>
        <c:if test="${sessionScope.isClient == true}">
            <a href="${pageContext.request.contextPath}/controller?command=go_to_create_order&cost=${car.cost}&id=${car.id}">${car}</a>
        </c:if>
        <c:if test="${sessionScope.isAdmin == true}">
            ${car}
            <a href="${pageContext.request.contextPath}/controller?command=go_to_update_car&id=${car.id}">
                <button>UPDATE</button>
            </a>
            <a href="${pageContext.request.contextPath}/controller?command=go_to_delete_car&id=${car.id}">
                <button>DELETE</button>
            </a>

        </c:if>
    </li>
</c:forEach>
<br>
</body>
</html>
