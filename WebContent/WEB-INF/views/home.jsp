<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<title>HTML Tutorial</title>
<body>

    <h1>Home page</h1>
    <a href="order">order</a>
    <a href="product">product</a>
    <a href="fuel">fuel</a>
    <form:form action="${pageContext.request.contextPath}/logout"
        method="POST">
        <input type="submit" value="Logout" />
    </form:form>
</body>
</html>