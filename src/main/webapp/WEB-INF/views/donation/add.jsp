<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../header.jsp" %>


<form:form method="post" modelAttribute="donation">
    <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id" />
    <form:select path="institution" items="${institutions}" itemLabel="name" itemValue="id"/>
    zipCode<form:input path="zipCode" />
    street<form:input path="street" />
    city<form:input path="city"/>
    quantity<form:input path="quantity"/>
    pickUpComment<form:textarea path="pickUpComment"/>
    pickedUpDate<form:input type="date" path="pickedUpDate"/>
    pickedUpTime<form:input type="time" path="pickedUpTime" />

    <input type="submit" value="add donation" class="btn btn-primary">
</form:form>

<%@ include file="../footer.jsp" %>