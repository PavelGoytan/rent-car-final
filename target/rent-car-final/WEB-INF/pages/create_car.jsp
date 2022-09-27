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
<c:if test="${requestScope.carID==null}">
    <h1>ADD CAR</h1>
</c:if>
<c:if test="${requestScope.carID!=null}">
    <h1>UPDATE CAR ${requestScope.car}</h1>
</c:if>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <c:if test="${requestScope.carID==null}">
        <input type="hidden" name="command" value="create_car">
    </c:if>
    <c:if test="${requestScope.carID!=null}">
        <input type="hidden" name="command" value="update_car">
        <input type="hidden" name="carID" value="${requestScope.carID}">
    </c:if>
    <label for="registration_number">REGISTRATION NUMBER:
        <c:if test="${requestScope.registrationNumber!=null}">
            <input type="text" name="registration_number" id="registration_number" value="${requestScope.registrationNumber}">
        </c:if>
        <c:if test="${requestScope.registrationNumber==null}">
            <input type="text" name="registration_number" id="registration_number">
        </c:if>
    </label>
    <br>
    <c:if test="${requestScope.errorRNumber==1}">
        <div style="color: red">
            <span>REGISTRATION NUMBER is not correct</span>
        </div>
        <br>
    </c:if>
    <label for="cost">COST:
        <input type="text" name="cost" id="cost">
    </label>
    <br>
    <label for="model">MODEL:
        <c:if test="${requestScope.model!=null}">
            <input type="text" name="model" id="model" value="${requestScope.model}">
        </c:if>
        <c:if test="${requestScope.model==null}">
            <input type="text" name="model" id="model">
        </c:if>
    </label>
    <br>
    <c:if test="${requestScope.errorModel==1}">
        <div style="color: red">
            <span>MODEL is not correct</span>
        </div>
        <br>
    </c:if>
    <label for="car_status">CAR STATUS: >
        <select name="car_status" id="car_status">
            <c:forEach var="carStatus" items="${requestScope.car_statuses}">
                <option value="${carStatus}">${carStatus}</option>
            </c:forEach>
        </select>
    </label>
    <br>
    <c:if test="${requestScope.carID==null}">
        <button type="submit">CREATE</button>
    </c:if>
    <c:if test="${requestScope.carID!=null}">
        <button type="submit">UPDATE</button>
    </c:if>

</form>

</body>
</html>
