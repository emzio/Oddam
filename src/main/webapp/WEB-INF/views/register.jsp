<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <c:if test="${not empty passRep}" ><h2>${passRep}</h2> </c:if>
    <form:form modelAttribute="user" method="post">
        <div class="form-group">
<%--            <input type="email" name="email" placeholder="Email" />--%>
            <div class="form-label">email:  </div>
            <form:input path="email" type="email" value="Email"/>
        </div>

        <div class="form-group">
            <div class="form-label"> Login:</div>
            <form:input path="username"/>
        </div>

        <div class="form-group">
            <div class="form-label"> Imię:</div>
            <form:input path="name"/>
        </div>

        <div class="form-group">
            <div class="form-label"> Nazwisko:</div>
            <form:input path="lastname"/>
        </div>

        <div class="form-group">
            <div class="form-label"> Numer Telefonu(opcjonalnie):</div>
            <form:input path="phone"/>
        </div>

        <div class="form-group">
                <%--            <input type="password" name="password" placeholder="Hasło" />--%>
            <div class="form-label">Password:  </div>
            <form:input path="password" type="password"  placeholder="Hasło" value="Hasło"/>
        </div>
        <div class="form-group">
            <div class="form-label">Powtórz hasło:  </div>
            <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>