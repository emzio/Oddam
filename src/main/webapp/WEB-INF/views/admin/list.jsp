<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Admins</h1>
    </div>

    <div class="row">

        <!-- Area Chart -->
        <div class="col-xl-8 col-lg-7">
            <div class="card shadow mb-4">

                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Administratorzy: </h6>
                    <a href="/admin/add" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">
                        Dodaj administratora</a>
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
                                    <th>Remove admins permission</th>
                                    <th>Password edit</th>
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
                                    <th>Remove admins permission</th>
                                    <th>Password edit</th>
                                </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${admins}" var="admin" varStatus="counter">
                                <tr>
                                    <td>${counter.index + 1}</td>
                                    <td>${admin.username}</td>
                                    <td>${admin.name}</td>
                                    <td>${admin.lastname}</td>
                                    <td>${admin.phone}</td>
                                    <td>
                                        <c:if test="${admin.id != userToCompare.id && admin.enabled==true}">
                                        <a href="/admin/edit/${admin.id}" class="d-none d-sm-inline-block btn btn-sm btn-dark shadow-sm">
                                        edit</a>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${admin.id != userToCompare.id && admin.enabled==true}">
                                            <a href="/admin/delete/${admin.id}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm"> remove</a>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${admin.id != userToCompare.id && admin.enabled==true}">
                                            <a href="/admin/password/${admin.id}/admin" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm"> pass edit</a>
                                        </c:if>
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

    </div>



</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="../footer-sb-admin.jsp" %>