<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Zmiana Hasła</h1>
    </div>

    <div class="row">

        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Wpisz nowe hasło ? </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                <form:form cssClass="user" method="post" modelAttribute="user">
                                    <form:hidden path="username" />

                                    <div class="form-group">
                                        <label for="password">Hasło</label>
                                        <div class="alert-warning">
                                            <form:errors path="password"/>
                                        </div>
                                        <form:input path="password" type="password" class="form-control form-control-user" id="password" />

                                    </div>
                                    <div class="form-group">
                                        <label for="password2">Powtórz</label>
                                        <input name="password2" type="password" class="form-control form-control-user" id="password2" />
                                    </div>

                                    <form:hidden path="registered"/>
                                    <form:hidden path="enabled"/>
                                    <form:hidden path="roles"/>
                                    <form:hidden path="name"/>
                                    <form:hidden path="lastname"/>
                                    <form:hidden path="phone"/>
                                    <form:hidden path="id"/>
                                    <input type="submit" value="Zmień" class="btn btn-danger" id="button">
                                    <a type="button" class="btn btn-secondary" onClick="history.go(-1)">Cofnij</a>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<script src="../../../resources/js/jquery-3.6.0.js"></script>
<script src="../../../resources/sb-admin/js/password-edit.js"></script>
<%@ include file="../footer-sb-admin.jsp" %>