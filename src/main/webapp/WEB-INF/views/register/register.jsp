<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../header.jsp" %>
<body>
    <header>
        <nav class="container container--70">
            <ul class="nav--actions">
                <sec:authorize access="isAnonymous()">
                    <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                    <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
                </sec:authorize>
            </ul>

            <ul>
                <li><a href="/" class="btn btn--without-border active">Start</a></li>
                <li><a href="/#slogan" class="btn btn--without-border">O co chodzi?</a></li>
                <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
                <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
                <li><a href="/user/donation/add" class="btn btn--without-border">Przekaż dary</a></li>
                <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="user/donations" class="btn btn--without-border active">Moje zbiórki </a></li>
                </sec:authorize>
            </ul>
        </nav>
    </header>


    <section class="login-page">
        <h2>Załóż konto</h2>
        <form:form modelAttribute="user" method="post">

            <div class="form-group">
                <div class="form-label"> Email</div>
                <div class="alert-form">
                    <form:errors path="username"/>
                </div>
                <form:input path="username"/>
            </div>

            <div class="form-group">
                <div class="form-label"> Imię:</div>
                <div class="alert-form">
                    <form:errors path="name"/>
                </div>
                <form:input path="name" required="true"/>
            </div>

            <div class="form-group">
                <div class="form-label"> Nazwisko:</div>

                <div class="alert-form">
                    <form:errors path="lastname"/>
                </div>

                <form:input path="lastname" required="true"/>
            </div>

            <div class="form-group">
                <div class="form-label"> Numer Telefonu(opcjonalnie):</div>
                <div class="alert-form">
                    <form:errors path="phone"/>
                </div>
                <form:input path="phone"/>
            </div>

            <div class="form-group">
                <div class="form-label">Password:  </div>
                <div class="alert-form">
                    <form:errors path="password"/>
                </div>
                <form:input path="password" type="password" required="true" placeholder="Hasło" value="Hasło" />

            </div>

            <div class="form-group">
                <div class="form-label">Powtórz hasło:  </div>
                <input id="password2" type="password" required="true" name="password2" placeholder="Powtórz hasło" />
            </div>

            <div class="form-group form-group--buttons">
                <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
                <button id="submitBtn" class="btn" type="submit">Załóż konto</button>
            </div>
        </form:form>
    </section>

    <script src="../../../resources/js/jquery-3.6.0.js"></script>
    <script src="../../../resources/js/data-verify.js"></script>
    <%@ include file="../footer.jsp" %>

</body>
</html>
