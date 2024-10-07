<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/bootstrap.css">

    <link rel="stylesheet" href="/resources/vendors/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="/resources/vendors/bootstrap-icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/resources/css/app.css">
    <link rel="shortcut icon" href="/resources/images/favicon.svg" type="image/x-icon">
</head>

<body>

<div id="app">

    <%@ include file="/common/admin/header.jsp"%>

    <sitemesh:write property='body'></sitemesh:write>

</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/resources/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="/resources/js/bootstrap.bundle.min.js"></script>

<script src="/resources/js/mazer.js"></script>
<script src="/resources/js/delete.js"></script>
<script src="/resources/admin/api.js"></script>
<script src="/resources/vendors/apexcharts/apexcharts.js"></script>
<script src="/resources/js/pages/ui-apexchart.js"></script>
</body>

</html>

