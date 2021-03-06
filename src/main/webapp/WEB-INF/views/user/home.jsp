<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../header.jsp" %>

<body>
    <header class="header--main-page">
        <nav class="container container--70">

            <ul class="nav--actions">
                <sec:authorize access="isAuthenticated()">
                    <li class="logged-user">
                        Witaj <sec:authentication property="principal.username"/>
                        <ul class="dropdown">
                            <li><a href="/user/profile">Profil</a></li>
                            <li><a href="/user/donations">Moje zbiórki</a></li>
                            <li><a href="/logout">Wyloguj</a></li>
                        </ul>
                    </li>
                </sec:authorize>

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
                    <li><a href="user/profile" class="btn btn--without-border active">Profil</a></li>
                </sec:authorize>
            </ul>
        </nav>
        <div class="slogan container container--90" id="slogan">
            <div class="slogan--item">
                <h1>
                    Zacznij pomagać!<br/>
                    Oddaj niechciane rzeczy w zaufane ręce
                </h1>
            </div>
        </div>
    </header>

    <section class="stats" >
        <div class="container container--85">
            <div class="stats--item">
                <em>${totalQuantity}</em>

                <h3>Oddanych worków</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                    tempora!</p>
            </div>

            <div class="stats--item">
                <em>${numberOfDonations}</em>
                <h3>Przekazanych darów</h3>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                    quam.</p>
            </div>

        </div>
    </section>

    <section class="steps" id="steps">
        <h2>Wystarczą 4 proste kroki</h2>

        <div class="steps--container" >
            <div class="steps--item">
                <span class="icon icon--hands"></span>
                <h3>Wybierz rzeczy</h3>
                <p>ubrania, zabawki, sprzęt i inne</p>
            </div>
            <div class="steps--item">
                <span class="icon icon--arrow"></span>
                <h3>Spakuj je</h3>
                <p>skorzystaj z worków na śmieci</p>
            </div>
            <div class="steps--item">
                <span class="icon icon--glasses"></span>
                <h3>Zdecyduj komu chcesz pomóc</h3>
                <p>wybierz zaufane miejsce</p>
            </div>
            <div class="steps--item">
                <span class="icon icon--courier"></span>
                <h3>Zamów kuriera</h3>
                <p>kurier przyjedzie w dogodnym terminie</p>
            </div>
        </div>

        <a href="#" class="btn btn--large">Załóż konto</a>
    </section>

    <section class="about-us" id="about-us">
        <div class="about-us--text">
            <h2>O nas</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
                optio esse quisquam illo omnis.</p>
            <img src="<c:url value="../../../resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
        </div>
        <div class="about-us--image"><img src="<c:url value="../../../resources/images/about-us.jpg"/>" alt="People in circle"/>
        </div>
    </section>

    <section class="help" id="help">
        <h2>Komu pomagamy?</h2>

        <!-- SLIDE 1 -->
        <div class="help--slides active" data-id="1">
            <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
                Możesz sprawdzić czym się zajmują.</p>
            <!-- TODO  -->
            <ul class="help--slides-items">
                <c:forEach var="institution" items="${institutions}" varStatus="counter">
                    <c:choose>
                        <c:when test="${counter.index % 2 == 0}">
                            <li>
                            <div class="col">
                                <div class="title">${institution.getName()}</div>
                                <div class="subtitle">${institution.getDescription()}</div>
                            </div>
                            <c:choose>
                                <c:when test="${counter.last}">
                                    <div  style="background: transparent !important" class="col">
                                        <div  class="title"></div>
                                        <div class="subtitle"></div>
                                    </div>
                                    </li>
                                </c:when>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <div class="col">
                                <div class="title">${institution.getName()}</div>
                                <div class="subtitle">${institution.getDescription()}</div>
                            </div>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ul>
        </div>

    </section>


    <%@ include file="../footer.jsp" %>

</body>
</html>