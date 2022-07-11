<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Użytkownicy</h1>
    </div>

    <div class="row">

        <!-- Area Chart -->
        <div class="col-xl-8 col-lg-7">
            <div class="card shadow mb-4">

                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Aktywni użytkownicy </h6>
                </div>


                <div class="card-body">
                    <p> Przegląd </p>
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Login</th>
                                <th>Name</th>
                                <th>LastName</th>
                                <th>phone</th>
                                <th>Edit</th>
                                <th>Disable</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Login</th>
                                <th>Name</th>
                                <th>LastName</th>
                                <th>phone</th>
                                <th>Edit</th>
                                <th>Disable</th>
                                <th>Delete</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${enabledUsers}" var="user" varStatus="counter">
                                <tr>
                                    <td>${counter.index + 1}</td>
                                    <td>${user.username}</td>
                                    <td>${user.name}</td>
                                    <td>${user.lastname}</td>
                                    <td>${user.phone}</td>
                                    <td>
                                        <a href="/admin/user/edit/${user.id}" class="d-none d-sm-inline-block btn btn-sm btn-dark shadow-sm">
                                            edit</a>
                                    </td>
                                    <td>
                                        <a href="/admin/user/disable/${user.id}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm"> disable</a>
                                    </td>
                                    <td>
                                        <a href="/admin/user/delete/${user.id}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm"> delete</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <%--                                </div>--%>

                </div>
            </div>
        </div>

        <div class="col-xl-4 col-lg-5">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Zablokowani użytkownicy</h6>

                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <p> Przegląd </p>
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Login</th>
                                <th>Name</th>
                                <th>LastName</th>
                                <th>phone</th>
                                <th>Edit</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Login</th>
                                <th>Name</th>
                                <th>LastName</th>
                                <th>phone</th>
                                <th>Edit</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${disabledUsers}" var="user" varStatus="counter">
                                <tr>
                                    <td>${counter.index + 1}</td>
                                    <td>${user.username}</td>
                                    <td>${user.name}</td>
                                    <td>${user.lastname}</td>
                                    <td>${user.phone}</td>
                                    <td>
                                        <a href="/admin/user/edit/${user.id}" class="d-none d-sm-inline-block btn btn-sm btn-dark shadow-sm">
                                            edit</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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