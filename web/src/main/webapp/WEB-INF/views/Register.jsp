
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 3/15/13
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="<spring:url value="/register" />" method="post">
    <input type="text" name="name" />
    <br />
    <input type="text" name="lastName" />
    <br />
    <input type="text" name="email" />
    <br />
    <input type="text" name="birthDate" />
    <br />
    <select name="grade">
        <c:forEach items="${grades}" var="grade">
            <option value="${grade}">${grade}</option>
        </c:forEach>
    </select>
    <br />
    <input type="submit" />
</form>