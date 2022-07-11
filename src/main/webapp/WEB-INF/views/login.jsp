<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="../../resources/css/style.css" />
</head>

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
        <h2>Zaloguj się</h2>
        <form method="post">
            <div class="form-group">
                <label> Email: <input type="email" name="username"/> </label>
            </div>
            <div class="form-group">
                <label> Hasło: <input type="password" name="password"/> </label>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <a href="/password-recovery" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
            </div>

            <div class="form-group form-group--buttons">
                <a href="/register" class="btn btn--without-border">Załóż konto</a>
                <input class="btn" type="submit" value="Zaloguj się">
            </div>
        </form>
    </section>

    <%@ include file="footer.jsp" %>
</body>
</html>