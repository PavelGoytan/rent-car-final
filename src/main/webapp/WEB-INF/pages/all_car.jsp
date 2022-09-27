
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
<c:forEach var="car" items="${sessionScope.cars}">
    <li>
        <c:if test="${sessionScope.isClient == true}">
            <a href="${pageContext.request.contextPath}/controller?command=go_to_create_order&cost=${car.cost}&id=${car.id}">${car}</a>
        </c:if>
        <c:if test="${sessionScope.isAdmin == true}">
            ${car}
            <a href="${pageContext.request.contextPath}/controller?command=go_to_update_car&id=${car.id}"><button>UPDATE</button></a>
            <a href="${pageContext.request.contextPath}/controller?command=go_to_delete_car&id=${car.id}"><button>DELETE</button></a>

        </c:if>
    </li>
</c:forEach>
<br>
<c:set var="previous" value="${sessionScope.page_number-1}"/>
<c:set var="next" value="${sessionScope.page_number+1}"/>
<c:if test="${sessionScope.page_number>1}">
    <a href="${pageContext.request.contextPath}/controller?command=go_to_find_all_car_by_limit&page_number=${previous}">&lt;&lt;previous</a>
</c:if>
<c:forEach var="pages" items="${sessionScope.pages}">
    <a href="${pageContext.request.contextPath}/controller?command=go_to_find_all_car_by_limit&page_number=${pages}">${pages}</a>
</c:forEach>
<c:if test="${sessionScope.page_number<sessionScope.max_page}">
    <a href="${pageContext.request.contextPath}/controller?command=go_to_find_all_car_by_limit&page_number=${next}">next&gt;&gt;</a>
</c:if>
</body>
</html>
