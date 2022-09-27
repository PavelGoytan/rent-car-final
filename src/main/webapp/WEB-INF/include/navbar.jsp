<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <c:if test="${sessionScope.user!=null}">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/controller?command=go_to_find_order_by_user_id&user_id=${sessionScope.user.id}">${sessionScope.user.firstName}</a>
        </c:if>
        <c:if test="${sessionScope.user==null}">
            <a class="navbar-brand" href="#">Guest</a>
        </c:if>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page"
                       href="${pageContext.request.contextPath}/controller?command=go_to_home_page">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=sing_in_page">Sing
                        in</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=registration_page">Registration</a>
                </li>
                <c:if test="${sessionScope.user!=null}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            Dropdown link
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/controller?command=sing_out">Sing out</a>
                            </li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/controller?command=go_to_create_order">Create
                                order</a></li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/controller?command=go_to_find_all_car_by_limit">Cars</a>
                            </li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/controller?command=go_to_find_car_by_model">Find</a>
                            </li>
                            <c:if test="${sessionScope.isManager == true||sessionScope.isAdmin==true}">
                                <li><a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/controller?command=go_to_find_all_user">Users</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.isManager == true||sessionScope.isAdmin==true}">
                                <li><a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/controller?command=go_to_create_car_page">ADD CAR</a>
                                </li>
                            </c:if>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
        <form class="d-flex" role="search" action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="find_car_by_model">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="model_car">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>

</nav>