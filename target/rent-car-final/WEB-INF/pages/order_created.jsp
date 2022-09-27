
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <%@include file="../css/links_to_bootstrap.jsp"%>

</head>
<body>
<div class="grid text-center">
<%@include file="../include/navbar.jsp"%>
${sessionScope.login} Ваш заказ:
${sessionScope.order}
<br>
<form  action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="pay_is_correct">
    <input type="hidden" name="orderID" value="${sessionScope.order.id}">
    <div  class="mb-3">
        <label for="first_name" class="form-label"> FIRST NAME:
            <input type="text" class="form-control" name="first_name" id="first_name" size="55">
        </label>
    </div>
    <br>
    <div  class="mb-3">
        <label for="last_name" class="form-label"> LAST NAME:
            <input type="text" class="form-control" name="last_name" id="last_name" size="55">
        </label>
    </div>
    <br>
    <div  class="mb-3">
        <label for="card_number" class="form-label"> CARD NUMBER:
            <input type="text" class="form-control" name="card_number" id="card_number" size="55">
        </label>
    </div>
    <br>
    <div  class="mb-3">
        <label for="date_card" class="form-label"> CARD DATE:
            <input type="date" class="form-control" name="date_card" id="date_card" size="55" min="${sessionScope.today}">
        </label>
    </div>
    <br>
    <c:if test="${requestScope.massage!=null}">
        <div style="color: red">
            <span>${requestScope.massage}</span>
        </div>
    </c:if>
    <button type="submit" class="btn btn-primary">PAY</button>
</form>
    <a href="${pageContext.request.contextPath}/controller?command=go_to_home_page"><button class="btn btn-primary">CANCEL</button></a>
</div>
</body>
</html>
