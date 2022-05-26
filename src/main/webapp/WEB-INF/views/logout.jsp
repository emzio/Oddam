<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
</header>

<section class="login-page">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group form-group--buttons">
            <input class="fa fa-id-badge" type="submit" value="Wyloguj">
            <%--            <button class="btn" type="submit">Załóż konto</button>--%>
        </div>
    </form>
</section>

<%@ include file="footer.jsp" %>
<%--<form action="<c:url value="/logout"/>" method="post">--%>
<%--    <input class="fa fa-id-badge" type="submit" value="Wyloguj">--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--</form>--%>