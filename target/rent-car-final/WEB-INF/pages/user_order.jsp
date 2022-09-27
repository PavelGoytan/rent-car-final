
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
    <h1>${sessionScope.user.firstName} ORDERS:</h1>

    <table class="table">
        <tr>
            <th>ORDER №</th>
            <th>CAR</th>
            <th>RENT DATE</th>
            <th>RETURN DATE</th>
            <th>STATUS ORDER</th>
            <th>PRISE</th>
            <th></th>
        </tr>
        <c:forEach var="order" items="${requestScope.userOrders}">
            <tr><td>${order.id}</td>
                <td>${requestScope.carModel.get(order.id)}</td>
                <td>${order.rentDateTime}</td>
                <td>${order.returnDateTime}</td>
                <td>${order.orderStatus}</td>
                <td>${order.price}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
</div>
<%@include file="go_to_home.jsp"%>
</body>
</html>

