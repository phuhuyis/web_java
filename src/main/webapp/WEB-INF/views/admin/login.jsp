<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="/resources/css/login.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="wrapper">
    <div class="title">
        Đăng nhập
    </div>
    <form:form method="post" action="" modelAttribute="taikhoan">
        <div class="field">
            <form:input path="username"/>
            <form:label path="username">Tài khoản</form:label>
            <form:errors path="username" cssClass="text-danger"/>
        </div>
        <div class="field" style="margin-top: 40px">
            <form:input path="password" type="password"/>
            <form:label path="password">Mật khẩu</form:label>
            <form:errors path="password" cssClass="text-danger"/>
        </div>
        <div class="field" style="margin-top: 40px">
            <input type="submit" value="Đăng nhập">
        </div>
        <%--<div class="signup-link">
            Not a member? <a href="#">Signup now</a>
        </div>--%>
    </form:form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<c:if test="${success != null}">
    <script>
        alert("${success}");
        document.location.href = "/admin";
    </script>
</c:if>
<c:if test="${error != null}">
    <script>
        alert("${error}");
    </script>
</c:if>

</body>
</html>

