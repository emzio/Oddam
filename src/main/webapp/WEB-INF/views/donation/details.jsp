<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Przekazane dary:</h1>
    </div>

    <div class="row">

        <!-- Area Chart -->
        <div class="col-xl-12 col-lg-12">
            <div class="card shadow mb-4">

                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Szczegóły przekazanego daru</h6>
                    <a href="/user/donations" class="d-none d-sm-inline-block btn btn-sm btn-info shadow-sm"> lista darów</a>
                </div>


                <div class="card-body">
                    <p> Przegląd </p>
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>

                                <th>Data odbioru</th>
                                <th>Czas odbioru</th>
                                <th>Ilość</th>
                                <th>Instytucja</th>
                                <th>Kategorie</th>
                                <th>Miasto</th>
                                <th>Ulica</th>
                                <th>Kod pocztowy</th>
                                <th>Telefon</th>
                                <th>Odbiór</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>

                                <th>Data odbioru</th>
                                <th>Czas odbioru</th>
                                <th>Ilość</th>
                                <th>Instytucja</th>
                                <th>Kategorie</th>
                                <th>Miasto</th>
                                <th>Ulica</th>
                                <th>Kod pocztowy</th>
                                <th>Telefon</th>
                                <th>Odbiór</th>
                            </tr>
                            </tfoot>
                            <tbody>
                                <tr>
                                    <td>${donation.pickedUpDate}</td>
                                    <td>${donation.pickedUpTime}</td>
                                    <td>${donation.quantity}</td>
                                    <td>${donation.institution.name}</td>
                                    <td>
                                        <c:forEach items="${donation.categories}" var="single">
                                            ${single.name}
                                        </c:forEach>

                                    </td>
                                    <td>${donation.city}</td>
                                    <td>${donation.street} , </td>
                                    <td>${donation.zipCode}</td>
                                    <td>${donation.phone}</td>
                                    <td>
                                        <c:if test="${donation.pickedUp==false}">
                                            <a href="/user/donation/pickedup/${donation.id}" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">
                                                potwierdź odbiór</a>
                                        </c:if>
                                        <c:if test="${donation.pickedUp==true}">
                                            ODEBRANE
                                        </c:if>
                                    </td>
                                </tr>

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