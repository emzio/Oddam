<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<body>
    <header>
        <nav class="container container--70">
            <ul class="nav--actions">
                <li><a href="/login">Zaloguj</a></li>
                <li class="highlighted"><a href="/register">Załóż konto</a></li>
            </ul>

            <ul>
                <li><a href="/" class="btn btn--without-border active">Start</a></li>
                <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
                <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
            </ul>
        </nav>
    </header>

    <section class="login-page">
        <form action="<c:url value="/logout"/>" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div class="form-group form-group--buttons">
                <input class="fa fa-id-badge" type="submit" value="Wyloguj">
            </div>
        </form>
    </section>

    <%@ include file="footer.jsp" %>
</body>
</html>
