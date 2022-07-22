<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Institutions</h1>
    </div>

    <div class="row">

        <!-- Area Chart -->
        <div class="col-xl-8 col-lg-7">
            <div class="card shadow mb-4">

                <!-- Card Header - Dropdown -->
                <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Kategorie</h6>
                    <a href="/admin/category/add" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">
                        Dodaj kategorię</a>
                </div>

                <!-- Card Body -->
                <div class="card-body">

                    <%--                                <div class="chart-area">--%>
                    <p> Przegląd </p>

                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${categories}" var="category" varStatus="counter">
                                        <tr>
                                            <td>${counter.index + 1}</td>
                                            <td>${category.name}</td>
                                            <td><a href="/admin/category/edit/${category.id}" class="d-none d-sm-inline-block btn btn-sm btn-dark shadow-sm">
                                                update</a></td>
                                            <td><a href="/admin/category/delete/${category.id}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm"> delete</a></td>
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