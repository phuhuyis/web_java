<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Contact Start -->
<div class="container-fluid contact py-5">
    <div class="container py-5">
        <div class="p-5 bg-light rounded">
            <div class="row g-4">
                <div class="col-12">
                    <div class="text-center mx-auto" style="max-width: 700px;">
                        <h1 class="text-primary mt-3">Liên hệ</h1>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="h-100 rounded">
                        <iframe class="rounded w-100"
                                style="height: 400px;" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3843.4601635921713!2d108.47447127488569!3d15.567044052686494!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3169dcdfde488d01%3A0xf0312954b094aec7!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBRdeG6o25nIE5hbQ!5e0!3m2!1svi!2s!4v1709005397768!5m2!1svi!2s"
                                loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>
                <div class="col-lg-7">
                    <c:if test="${success != null}">
                        <div class="alert alert-success">
                                ${success}
                        </div>
                    </c:if>
                    <c:if test="${error != null}">
                        <div class="alert alert-danger">
                                ${error}
                        </div>
                    </c:if>
                    <form:form method="post" action="" modelAttribute="contact">
                        <div class="mb-4">
                            <form:input path="tieude" cssClass="w-100 form-control border-0 py-3" placeholder="Tiêu đề..."/>
                            <form:errors path="tieude" cssClass="text-danger"/>
                        </div>
                        <div class="mb-4">
                            <form:textarea path="noidung" cssClass="w-100 form-control border-0" rows="5" cols="10" placeholder="Nội dung..."/>
                            <form:errors path="noidung" cssClass="text-danger"/>
                        </div>
                        <button class="w-100 btn form-control border-secondary py-3 bg-white text-primary " type="submit">Gửi</button>
                    </form:form>
                </div>
                <div class="col-lg-5">
                    <div class="d-flex p-4 rounded mb-4 bg-white">
                        <i class="fas fa-map-marker-alt fa-2x text-primary me-4"></i>
                        <div>
                            <h4>Địa chỉ</h4>
                            <p class="mb-2">Đại học Quảng Nam</p>
                        </div>
                    </div>
                    <div class="d-flex p-4 rounded mb-4 bg-white">
                        <i class="fas fa-envelope fa-2x text-primary me-4"></i>
                        <div>
                            <h4>Email</h4>
                            <p class="mb-2">Phonmixay@gmail.com</p>
                        </div>
                    </div>
                    <div class="d-flex p-4 rounded bg-white">
                        <i class="fa fa-phone-alt fa-2x text-primary me-4"></i>
                        <div>
                            <h4>Số điện thoại</h4>
                            <p class="mb-2">+0123 4567 8910</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Contact End -->