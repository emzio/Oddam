<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Test the rest ?</h1>
    </div>

    <div class="row">

        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Test the rest ? </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">

                                <button type="button" class="btn-danger">test the rest!</button>
                                <form method="post">
                                    <input type="hidden" value="2" id="id">
                                    <input type="text" name="email" placeholder="email" id="email">
                                    <input type="submit" class="btn-success" value="check email" id="submit">
                                </form>
<%--                                <button type="button" class="btn-danger"> email</button>--%>
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
<%--<script src="../../../resources/sb-admin/js/password-edit.js"></script>--%>
<script src="../../../resources/restTest/restTest.js"></script>


<%@ include file="../footer-sb-admin.jsp" %>

