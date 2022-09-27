<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../css/links_to_bootstrap.jsp" %>

</head>
<body>
<%@include file="../include/navbar.jsp" %>
<h1>ORDERED</h1>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="create_order">


    <c:if test="${sessionScope.car!=null}">
        <label for="price"> Cost: ${sessionScope.car.cost}
            <input type="hidden" name="price" id="price" value="${sessionScope.car.cost}">
        </label>
        <br>
    </c:if>

    <label for="rent_date"> rent_date:
        <input type="date" name="rent_date" id="rent_date" min="${sessionScope.today}">
    </label>
    <br>

    <label for="return_date"> return_date:
        <input type="date" name="return_date" id="return_date" min="${sessionScope.today}">
    </label>
    <br>
    <c:choose>
        <c:when test="${sessionScope.car!=null}">
            <label for="model"> MODEL: ${sessionScope.car.model}
                <input type="hidden" name="model" id="model" value="${sessionScope.car.model}">
                <input type="hidden" name="car_id" id="car_id" value="${sessionScope.car.id}">
            </label>
            <br>
            <label for="user_id"> USER: ${sessionScope.user.emailLogin}
                    <%--        <input type="text" name="user_name" id="user_name" value="${sessionScope.user.emailLogin}">--%>
                <input type="hidden" name="user_id" id="user_id" value="${sessionScope.user.id}">
            </label>
            <br>
        </c:when>
        <c:otherwise>
            <label for="car"> CAR:
                <select name="car" id="car">
                    <c:forEach var="car" items="${sessionScope.cars}">
                        <option value="${car.id}">${car}</option>
                    </c:forEach>
                </select>
            </label>
            <br>
        </c:otherwise>
    </c:choose>



    <%--    <label for="order_status"> order_status:--%>
    <%--        <select name="order_status" id="order_status">--%>
    <%--            <c:forEach var="orderStatus" items="${requestScope.order_statuses}">--%>
    <%--                <option value="${orderStatus}">${orderStatus}</option>--%>
    <%--            </c:forEach>--%>
    <%--        </select>--%>
    <%--    </label>--%>
    <%--    <br>--%>
    <button type="submit">Send</button>
    <br>
    <c:if test="${requestScope.isBooked==true}">
        <div style="color: red">
            <span>CAR IS BOOKED ON THIS DATE</span>
        </div>
    </c:if>
</form>

<c:choose>
    <c:when test="${requestScope.car!=null}">

    </c:when>
    <c:when test="${requestScope.car==null}">

    </c:when>
</c:choose>
</body>
</html>
