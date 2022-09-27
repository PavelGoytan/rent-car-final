<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../css/links_to_bootstrap.jsp"%>

</head>
<body>
<%@include file="../include/navbar.jsp"%>
<h1>REGISTRATION</h1>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="registration">
    <label for="first_name"> First Name:
        <c:if test="${requestScope.firstName!=null}">
            <input type="text" name="first_name" id="first_name" value="${requestScope.firstName}">
        </c:if>
        <c:if test="${requestScope.firstName==null}">
            <input type="text" name="first_name" id="first_name">
        </c:if>

    </label>
    <br>
    <c:if test="${requestScope.errorFName==1}">
        <div style="color: red">
            <span>First Name is not correct</span>
        </div>
        <br>
    </c:if>

    <label for="last_name"> Last Name:
        <c:if test="${requestScope.lastName!=null}">
            <input type="text" name="last_name" id="last_name" value="${requestScope.lastName}">
        </c:if>
        <c:if test="${requestScope.lastName==null}">
            <input type="text" name="last_name" id="last_name">
        </c:if>

    </label>
    <br>
    <c:if test="${requestScope.errorLName==1}">
        <div style="color: red">
            <span>Last Name is not correct</span>
        </div>
        <br>
    </c:if>

    <label for="email"> EMAIL:
        <c:if test="${requestScope.email!=null}">
            <input type="text" name="email" id="email" value="${requestScope.email}">
        </c:if>
        <c:if test="${requestScope.email==null}">
            <input type="text" name="email" id="email">
        </c:if>

    </label>
    <br>
    <c:if test="${requestScope.errorEmail==1}">
        <div style="color: red">
            <span>EMAIL is not correct</span>
        </div>
        <br>
    </c:if>
    <label for="password"> PASSWORD:
        <input type="password" name="password" id="password">
    </label>
    <br>

    <c:if test="${requestScope.errorPas==1}">
        <div style="color: red">
            <span>Password is not correct</span>
        </div>
        <br>
    </c:if>

<%--    <label for="role"> ROLE:--%>
<%--        <select name="role" id="role">--%>
<%--            <c:forEach var="role" items="${requestScope.roles}">--%>
<%--                <option value="${role}">${role}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>

<%--    </label>--%>
<%--    <br>--%>

<%--    <label for="status">--%>
<%--        <c:forEach var="statuses" items="${requestScope.statuses}">--%>
<%--            <input type="radio" name="status" id="status" value="${statuses}">${statuses}--%>
<%--            <br>--%>
<%--        </c:forEach>--%>

<%--    </label>--%>
<%--    <br>--%>

    <label for="phone"> Phone:
        <c:if test="${requestScope.phone!=null}">
            <input type="text" name="phone" id="phone" value="${requestScope.phone}">
        </c:if>
        <c:if test="${requestScope.phone==null}">
            <input type="text" name="phone" id="phone">
        </c:if>

    </label>
    <br>
    <c:if test="${requestScope.errorPhone==1}">
        <div style="color: red">
            <span>Phone is not correct</span>
        </div>
        <br>
    </c:if>
    <button type="submit">Send</button>
    <br>
</form>
<%@include file="go_to_home.jsp"%>
</body>
</html>
