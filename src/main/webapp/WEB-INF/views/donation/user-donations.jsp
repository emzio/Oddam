<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Donacje</h1>
    </div>

    <div class="row">

        <!-- Area Chart -->
        <div class="col-xl-12 col-lg-12">
            <div class="card shadow mb-4">

                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Przekazane dary: </h6>
                </div>


                <div class="card-body">
                    <p> Przegląd </p>
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Odebrane</th>
                                <th>Data odbioru</th>
                                <th>Czas odbioru</th>
                                <th>Ilość</th>
                                <th>Instytucja</th>
                                <th>Potwierdź</th>
                                <th>Szczegóły</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Odebrane</th>
                                <th>Data odbioru</th>
                                <th>Czas odbioru</th>
                                <th>Ilość</th>
                                <th>Instytucja</th>
                                <th>Potwierdź</th>
                                <th>Szczegóły</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${donations}" var="single" varStatus="counter">
                                <tr>
                                    <td>${counter.index + 1}</td>
                                    <td>${single.pickedUp}</td>
                                    <td>${single.pickedUpDate}</td>
                                    <td>${single.pickedUpTime}</td>
                                    <td>${single.quantity}</td>
                                    <td>${single.institution.name}</td>
                                    <td>
                                        <c:if test="${single.pickedUp==false}">
                                        <a href="/user/donation/pickedup/${single.id}" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">
                                            potwierdź odbiór</a>
                                        </c:if>
                                        <c:if test="${single.pickedUp==true}">
                                            ODEBRANE
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="/user/donation/details/${single.id}" class="d-none d-sm-inline-block btn btn-sm btn-info shadow-sm"> szczegóły</a>
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