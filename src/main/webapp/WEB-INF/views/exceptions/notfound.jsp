<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header-sb-admin.jsp" %>

<h1>Error Page</h1>
<p>Application has encountered an error. Please contact support on ...</p>

Failed URL: ${url}
Exception:  ${exception.message}
<c:forEach items="${exception.stackTrace}" var="ste">
    ${ste}
</c:forEach>

<%@ include file="../footer-sb-admin.jsp" %>