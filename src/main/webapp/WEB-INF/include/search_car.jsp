
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../css/links_to_bootstrap.jsp"%>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="find_car_by_model">
    <input type="search" placeholder="Search" name="model_car" >
    <button type="submit">Search</button>
</form>

