
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="<spring:url value="/login" />" method="post">
    <input type="text" name="email" />
    <br />
    <input type="password" name="password" />
    <br />
    <input type="text" name="email" />
    <br />
    <input type="hidden" name="extra"/>
    <br />
    <input type="submit" />
</form>