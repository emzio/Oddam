<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../header.jsp" %>
</header>

<section class="login-page">
    <h2>Zmiana hasła</h2>
<%--    <c:if test="${not empty passRep}" ><h2>${passRep}</h2> </c:if>--%>

    <form:form modelAttribute="user" method="post">

        <form:hidden path="email"/>
        <form:hidden path="username"/>
        <form:hidden path="name"/>
        <form:hidden path="lastname"/>
        <form:hidden path="phone"/>
        <form:hidden path="roles"/>
        <form:hidden path="enabled"/>
        <form:hidden path="registered"/>
        <form:hidden path="id"/>


        <div class="form-group">
            <div class="form-label">Podaj nowe hasło:  </div>
            <div class="text-danger">
                <form:errors path="password"/>
            </div>
            <form:input path="password" type="password"  placeholder="Hasło" value="Hasło"/>
        </div>

        <div class="form-group">
            <div class="form-label">Powtórz hasło:  </div>
            <input type="password" id="password2" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Ustaw hasło</button>
        </div>
    </form:form>

</section>

<script src="../../../resources/sb-admin/js/password-repeat.js"></script>

<%@ include file="../footer.jsp" %>
