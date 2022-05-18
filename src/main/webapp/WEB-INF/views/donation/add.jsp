<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../header.jsp" %>

<link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>"/>



<%--<form:form method="post" modelAttribute="donation">--%>
<%--    <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id" />--%>
<%--    <form:select path="institution" items="${institutions}" itemLabel="name" itemValue="id"/>--%>
<%--    zipCode<form:input path="zipCode" />--%>
<%--    street<form:input path="street" />--%>
<%--    city<form:input path="city"/>--%>
<%--    quantity<form:input path="quantity"/>--%>
<%--    pickUpComment<form:textarea path="pickUpComment"/>--%>
<%--    pickedUpDate<form:input type="date" path="pickedUpDate"/>--%>
<%--    pickedUpTime<form:input type="time" path="pickedUpTime" />--%>

<%--    <input type="submit" value="add donation" class="btn btn-primary">--%>
<%--</form:form>--%>




    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <form:form method="post" modelAttribute="donation">
        <form action="form-confirmation.html" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
                <div class="form-group form-group--checkbox">
<%--            <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id" />--%>
                </div>

<%--                <form:checkboxes path="categories" items="${categories}"/>--%>
<%--                </form:checkboxes>--%>

                    <c:forEach items="${categories}" var="category">
                        <div class="form-group form-group--checkbox">
                            <label>
<%--                                <input--%>
<%--                                    type="checkbox"--%>
<%--                                    name="categories"--%>
<%--                                    value="clothes-useless"--%>
<%--                                />--%>

    <%--                            <form:checkbox path="categories" items="${categories}"/>--%>
                                <form:checkbox path="categories" value="${category.id}"/>
<%--                                <form:checkbox path="categories" value="${category.id}" label="${category.name}"/>--%>


                                <span class="checkbox"></span>
                                <span class="description">${category.name}</span>

                            </label>
                        </div>
                    </c:forEach>
<%--                </form:checkboxes>--%>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 2 -->
                <div data-step="2">
                    <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                    <div class="form-group form-group--inline">
                        <label>
                            Liczba 60l worków:
<%--                            <input type="number" name="bags" step="1" min="1" />--%>
                            <form:input type="number" step="1" min="1" path="quantity"/>

                        </label>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>



                <!-- STEP 4 -->
                <div data-step="3">
                    <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="organization" value="old" />
                            <span class="checkbox radio"></span>
                            <span class="description">
                      <div class="title">Fundacja “Bez domu”</div>
                      <div class="subtitle">
                        Cel i misja: Pomoc dla osób nie posiadających miejsca
                        zamieszkania
                      </div>
                    </span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="organization" value="old" />
                            <span class="checkbox radio"></span>
                            <span class="description">
                      <div class="title">Fundacja “Dla dzieci"</div>
                      <div class="subtitle">
                        Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji
                        życiowej.
                      </div>
                    </span>
                        </label>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 5 -->
                <div data-step="4">
                    <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru</h4>
                            <div class="form-group form-group--inline">
                                    <label> Ulica  <form:input path="street" /> </label>
<%--                                <label> Ulica <input type="text" name="address" /> </label>--%>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Miasto <form:input path="city"/> </label>
<%--                                <label> Miasto <input type="text" name="city" /> </label>--%>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Kod pocztowy <form:input path="zipCode" />
                                </label>
<%--                                <label>--%>
<%--                                    Kod pocztowy <input type="text" name="postcode" />--%>
<%--                                </label>--%>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Numer telefonu <input type="phone" name="phone" />
                                </label>
                            </div>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru</h4>
                            <div class="form-group form-group--inline">
                                <label> Data <form:input type="date" path="pickedUpDate"/> </label>
<%--                                <label> Data <input type="date" name="data" /> </label>--%>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Godzina <form:input type="time" path="pickedUpTime" /> </label>
<%--                                <label> Godzina <input type="time" name="time" /> </label>--%>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Uwagi dla kuriera
                                    <form:textarea path="pickUpComment"/>
                                </label>

<%--                                <label>--%>
<%--                                    Uwagi dla kuriera--%>
<%--                                    <textarea name="more_info" rows="5"></textarea>--%>
<%--                                </label>--%>
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 6 -->
                <div data-step="5">
                    <h3>Podsumowanie Twojej darowizny</h3>

                    <div class="summary">
                        <div class="form-section">
                            <h4>Oddajesz:</h4>
                            <ul>
                                <li>
                                    <span class="icon icon-bag"></span>
                                    <span class="summary--text"
                                    >${donation.getCity()}4 worki ubrań w dobrym stanie dla dzieci</span
                                    >
                                </li>

                                <li>
                                    <span class="icon icon-hand"></span>
                                    <span class="summary--text"
                                    >Dla fundacji "Mam marzenie" w Warszawie</span
                                    >
                                </li>
                            </ul>
                        </div>

                        <div class="form-section form-section--columns">
                            <div class="form-section--column">
                                <h4>Adres odbioru:</h4>
                                <ul>
                                    <li>Prosta 51</li>
                                    <li>Warszawa</li>
                                    <li>99-098</li>
                                    <li>123 456 789</li>
                                </ul>
                            </div>

                            <div class="form-section--column">
                                <h4>Termin odbioru:</h4>
                                <ul>
                                    <li>13/12/2018</li>
                                    <li>15:40</li>
                                    <li>Brak uwag</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="submit" class="btn">Potwierdzam</button>
                        </form:form>
                    </div>
                </div>
            </form>
        </div>
    </section>

    <footer>
        <div class="contact">
            <h2>Skontaktuj się z nami</h2>
            <h3>Formularz kontaktowy</h3>
            <form class="form--contact">
                <div class="form-group form-group--50">
                    <input type="text" name="name" placeholder="Imię" />
                </div>
                <div class="form-group form-group--50">
                    <input type="text" name="surname" placeholder="Nazwisko" />
                </div>

                <div class="form-group">
                <textarea
                        name="message"
                        placeholder="Wiadomość"
                        rows="1"
                ></textarea>
                </div>

                <button class="btn" type="submit">Wyślij</button>
            </form>
        </div>
        <div class="bottom-line">
            <span class="bottom-line--copy">Copyright &copy; 2018</span>
            <div class="bottom-line--icons">
                <a href="#" class="btn btn--small"
                ><img src="images/icon-facebook.svg"
                /></a>
                <a href="#" class="btn btn--small"
                ><img src="images/icon-instagram.svg"
                /></a>
            </div>
        </div>
    </footer>

    <script src="js/app.js"></script>
    </body>
    </html>

    <script src="<c:url value="../../../resources/js/app.js"/>"></script>

    <%@ include file="../footer.jsp" %>