<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">${title}</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
        <li class="breadcrumb-item">Tài khoản</li>
        <li class="breadcrumb-item active text-white">${title}</li>
    </ol>
</div>

<div class="container-fluid py-5">
    <div class="container py-5">
        <h1 class="mb-4">${title}</h1>
        <c:if test="${success != null}">
            <div class="alert alert-success">
                    ${success}
            </div>
        </c:if>
        <form:form method="post" action="" modelAttribute="khachhang">
            <div class="row g-5">
                <div class="col-md-12 col-lg-12 col-xl-12">
                    <div class="form-item">
                        <label class="form-label my-3">Họ và tên<sup>*</sup></label>
                        <form:input path="hovaten" type="text" cssClass="form-control"></form:input>
                        <form:errors path="hovaten" cssClass="text-danger"/>
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3">Địa chỉ<sup>*</sup></label>
                        <form:textarea path="diachi" cssClass="form-control"></form:textarea>
                        <form:errors path="diachi" cssClass="text-danger"/>
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3">Số điện thoại<sup>*</sup></label>
                        <form:input path="sdt" type="phone" cssClass="form-control"></form:input>
                        <form:errors path="sdt" cssClass="text-danger"/>
                    </div>
                    <div class="form-item">
                        <label class="form-label my-3">Mật khẩu<sup>*</sup></label>
                        <form:input path="password" type="password" cssClass="form-control"></form:input>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>
                    <div class="form-item d-flex justify-content-center my-3">
                        <button class="btn btn-primary text-white">Cập nhập thông tin</button>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>