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


<div style="margin:50px;">

    <form action="<spring:url value="/register" />" method="post">
        <div class="control-group">
            <label class="control-label">نام </label>

            <div class="controls">
                <input type="text" maxlength="50" name="name" required/>

                <p class="help-block"></p>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">نام خانوادگی </label>

            <div class="controls">
                <input type="text" name="lastName" required/>

                <p class="help-block"></p>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">آدرس ایمیل</label>

            <div class="controls">
                <input type="email" name="email" required/>

                <p class="help-block"></p>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label"> تاریخ تولد</label>

            <div class="controls">
                <div class="input-append date"  id="dp3" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
                    <input readonly='true' name="birthDate" class="span2" size="16" type="text" value="12-02-2012">
                    <span class="add-on"><i class=" icon-calendar"></i></span>
                </div>
                <p class="help-block"></p>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">تحصیلات </label>

            <div class="controls">
                <select name="grade">
                    <c:forEach items="${grades}" var="grade">
                        <option value="${grade}"><spring:message code="${grade}"></spring:message></option>

                    </c:forEach>
                </select>

                <p class="help-block"></p>
            </div>
        </div>


        <br/>
        <input type="submit"/>
    </form>

</div>