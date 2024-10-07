<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Đăng ký</title>
    <link rel="stylesheet" href="/resources/css/login.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="wrapper">
    <div class="title">
        Đăng ký
    </div>
    <form:form method="post" action="" modelAttribute="khachhang">
        <div class="field">
            <form:input path="hovaten"/>
            <form:label path="hovaten">Họ và tên</form:label>
            <form:errors path="hovaten" cssClass="text-danger"/>
        </div>
        <div class="field" style="margin-top: 40px">
            <form:input path="sdt" type="phone"/>
            <form:label path="sdt">Số điện thoại</form:label>
            <form:errors path="sdt" cssClass="text-danger"/>
        </div>
        <div class="field" style="margin-top: 40px">
            <form:input path="diachi"/>
            <form:label path="diachi">Địa chỉ</form:label>
            <form:errors path="diachi" cssClass="text-danger"/>
        </div>
        <div class="field" style="margin-top: 40px">
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
            <input type="submit" value="Đăng ký">
        </div>
        <div class="signup-link">
            Bạn đã có tài khoản? <a href="/login">Đăng nhập ngay</a>
        </div>
    </form:form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<c:if test="${success != null}">
    <script>
        alert("${success}");
        document.location.href = "/";
    </script>
</c:if>
<c:if test="${error != null}">
    <script>
        alert("${error}");
    </script>
</c:if>

</body>
</html>

