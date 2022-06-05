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
                    <h6 class="m-0 font-weight-bold text-primary">Instytucje</h6>
                    <a href="/admin/institution/add" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">
                        Dodaj Instytucje</a>
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
                                <th>Enabled</th>
                                <th>Description</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Enabled</th>
                                <th>Description</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${institutions}" var="institution" varStatus="counter">
                                <tr>
                                    <td>${counter.index + 1}</td>
                                    <td>${institution.name}</td>
                                    <td>${institution.enabled}</td>
                                    <td>${institution.description}</td>
                                    <td><a href="/admin/institution/edit/${institution.id}" class="d-none d-sm-inline-block btn btn-sm btn-dark shadow-sm">
                                         update</a></td>
                                    <td><a href="/admin/institution/delete/${institution.id}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm"> delete</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <%--                                </div>--%>
                </div>
            </div>
        </div>

        <!-- Pie Chart -->
        <div class="col-xl-4 col-lg-5">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Revenue Sources</h6>
<%--                    <div class="dropdown no-arrow">--%>
<%--                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"--%>
<%--                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>--%>
<%--                        </a>--%>
<%--                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"--%>
<%--                             aria-labelledby="dropdownMenuLink">--%>
<%--                            <div class="dropdown-header">Dropdown Header:</div>--%>
<%--                            <a class="dropdown-item" href="#">Action</a>--%>
<%--                            <a class="dropdown-item" href="#">Another action</a>--%>
<%--                            <div class="dropdown-divider"></div>--%>
<%--                            <a class="dropdown-item" href="#">Something else here</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <%--                                <div class="chart-pie pt-4 pb-2">--%>
                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce
                        CSS bloat and poor page performance. Custom CSS classes are used to create
                        custom components and custom utility classes.</p>
                    <p class="mb-0">Before working with this theme, you should become familiar with the
                        Bootstrap framework, especially the utility classes.</p>
                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce
                        CSS bloat and poor page performance. Custom CSS classes are used to create
                        custom components and custom utility classes.</p>
                    <%--                                </div>--%>
                </div>
            </div>
        </div>
    </div>

<%--    <div class="row">--%>

<%--        <!-- Area Chart -->--%>
<%--        <div class="col-xl-8 col-lg-7">--%>
<%--            <div class="card shadow mb-4">--%>
<%--                <!-- Card Header - Dropdown -->--%>
<%--                <div--%>
<%--                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">--%>
<%--                    <h6 class="m-0 font-weight-bold text-primary">Earnings Overview</h6>--%>
<%--&lt;%&ndash;                    <div class="dropdown no-arrow">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"&ndash;%&gt;--%>
<%--&lt;%&ndash;                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"&ndash;%&gt;--%>
<%--&lt;%&ndash;                             aria-labelledby="dropdownMenuLink">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <div class="dropdown-header">Dropdown Header:</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a class="dropdown-item" href="#">Action</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a class="dropdown-item" href="#">Another action</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <div class="dropdown-divider"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a class="dropdown-item" href="#">Something else here</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                </div>--%>
<%--                <!-- Card Body -->--%>
<%--                <div class="card-body">--%>
<%--                    &lt;%&ndash;                                <div class="chart-area">&ndash;%&gt;--%>
<%--                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce--%>
<%--                        CSS bloat and poor page performance. Custom CSS classes are used to create--%>
<%--                        custom components and custom utility classes.</p>--%>
<%--                    <p class="mb-0">Before working with this theme, you should become familiar with the--%>
<%--                        Bootstrap framework, especially the utility classes.</p>--%>
<%--                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce--%>
<%--                        CSS bloat and poor page performance. Custom CSS classes are used to create--%>
<%--                        custom components and custom utility classes.</p>--%>
<%--                    <p class="mb-0">Before working with this theme, you should become familiar with the--%>
<%--                        Bootstrap framework, especially the utility classes.</p>--%>
<%--                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce--%>
<%--                        CSS bloat and poor page performance. Custom CSS classes are used to create--%>
<%--                        custom components and custom utility classes.</p>--%>
<%--                    <p class="mb-0">Before working with this theme, you should become familiar with the--%>
<%--                        Bootstrap framework, especially the utility classes.</p>--%>
<%--                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce--%>
<%--                        CSS bloat and poor page performance. Custom CSS classes are used to create--%>
<%--                        custom components and custom utility classes.</p>--%>
<%--                    <p class="mb-0">Before working with this theme, you should become familiar with the--%>
<%--                        Bootstrap framework, especially the utility classes.</p>--%>
<%--                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce--%>
<%--                        CSS bloat and poor page performance. Custom CSS classes are used to create--%>
<%--                        custom components and custom utility classes.</p>--%>
<%--                    <p class="mb-0">Before working with this theme, you should become familiar with the--%>
<%--                        Bootstrap framework, especially the utility classes.</p>--%>
<%--                    &lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <!-- Pie Chart -->--%>
<%--        <div class="col-xl-4 col-lg-5">--%>
<%--            <div class="card shadow mb-4">--%>
<%--                <!-- Card Header - Dropdown -->--%>
<%--                <div--%>
<%--                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">--%>
<%--                    <h6 class="m-0 font-weight-bold text-primary">Revenue Sources</h6>--%>
<%--&lt;%&ndash;                    <div class="dropdown no-arrow">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"&ndash;%&gt;--%>
<%--&lt;%&ndash;                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"&ndash;%&gt;--%>
<%--&lt;%&ndash;                             aria-labelledby="dropdownMenuLink">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <div class="dropdown-header">Dropdown Header:</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a class="dropdown-item" href="#">Action</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a class="dropdown-item" href="#">Another action</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <div class="dropdown-divider"></div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a class="dropdown-item" href="#">Something else here</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                </div>--%>
<%--                <!-- Card Body -->--%>
<%--                <div class="card-body">--%>
<%--                    &lt;%&ndash;                                <div class="chart-pie pt-4 pb-2">&ndash;%&gt;--%>
<%--                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce--%>
<%--                        CSS bloat and poor page performance. Custom CSS classes are used to create--%>
<%--                        custom components and custom utility classes.</p>--%>
<%--                    <p class="mb-0">Before working with this theme, you should become familiar with the--%>
<%--                        Bootstrap framework, especially the utility classes.</p>--%>
<%--                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce--%>
<%--                        CSS bloat and poor page performance. Custom CSS classes are used to create--%>
<%--                        custom components and custom utility classes.</p>--%>
<%--                    &lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="../footer-sb-admin.jsp" %>