<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Edycja danych</h1>
    </div>

    <div class="row">

        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Edytuj: </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                <form:form cssClass="user" method="post" modelAttribute="user">
                                    <form:hidden path="username"/>
                                    <div>
                                        <form:hidden path="password"/>
                                    </div>

                                    <form:hidden path="enabled"/>

                                    <div>
                                        <form:hidden path="roles"/>
                                    </div>

                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <form:input path="name" class="form-control form-control-user" id="name" />
                                    </div>

                                    <div class="form-group">
                                        <label for="lastname">Lastame</label>
                                        <form:input path="lastname" class="form-control form-control-user" id="lastname" />
                                    </div>

                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <form:input path="email" type="email" class="form-control form-control-user" id="email" />
                                    </div>

                                    <div class="form-group">
                                        <label for="phone">Phone</label>
                                        <form:input path="phone" class="form-control form-control-user" id="phone" />
                                    </div>

                                    <form:hidden path="id"/>
                                    <input type="submit" value="Update" class="btn btn-secondary">
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

<%@ include file="../footer-sb-admin.jsp" %>