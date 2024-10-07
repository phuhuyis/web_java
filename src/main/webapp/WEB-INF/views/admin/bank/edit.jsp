<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-heading">
    <div class="page-title mb-3">
        <div class="row">
            <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>Cập nhập tài khoản ngân hàng</h3>
            </div>
        </div>
    </div>

    <!-- Basic Tables start -->
    <section class="section">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-12">
                        <form:form action="" method="post" modelAttribute="bank">
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
                            <div class="form-group">
                                <label for="nganhang" class="mb-2">Ngân hàng</label>
                                <form:select path="nganhang" cssClass="form-control" id="nganhang">
                                    <form:options items="${listBank}" itemValue="bin" itemLabel="shortName"/>
                                </form:select>
                                <form:errors path="nganhang" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="stk" class="mb-2">Số tài khoản</label>
                                <form:input path="stk" type="text" cssClass="form-control" id="stk" placeholder="Nhập số tài khoản..."/>
                                <form:errors path="stk" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="ten" class="mb-2">Tên tài khoản</label>
                                <form:input path="ten" type="text" cssClass="form-control" id="ten" placeholder="Nhập tên tài khoản..."/>
                                <form:errors path="ten" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="noidungchuyenkhoan" class="mb-2">Nội dung chuyển khoản</label>
                                <form:textarea path="noidungchuyenkhoan" type="text" cssClass="form-control" id="noidungchuyenkhoan"
                                            placeholder="Nhập nội dung chuyển khoản..."/>
                                <form:errors path="noidungchuyenkhoan" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary text-white" type="submit">Cập nhập</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Basic Tables end -->
</div>