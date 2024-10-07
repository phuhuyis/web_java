<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-heading">
  <div class="page-title mb-3">
    <div class="row">
      <div class="col-12 col-md-6 order-md-1 order-last">
        <h3>Thêm khách hàng</h3>
      </div>
    </div>
  </div>

  <!-- Basic Tables start -->
  <section class="section">
    <div class="card">
      <div class="card-body">
        <div class="row">
          <div class="col-md-12">
            <form:form action="" method="post" modelAttribute="khachhang">
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
                <label for="basicInput" class="mb-2">Họ và tên</label>
                <form:input path="hovaten" type="text" cssClass="form-control" id="basicInput" placeholder="Nhập họ và tên..."/>
                <form:errors path="hovaten" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="sdt" class="mb-2">Số điện thoại</label>
                <form:input path="sdt" type="text" cssClass="form-control" id="sdt" placeholder="Nhập số điện thoại..."/>
                <form:errors path="sdt" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="diachi" class="mb-2">Địa chỉ</label>
                <form:textarea path="diachi" type="text" cssClass="form-control" id="diachi" placeholder="Nhập địa chỉ..."/>
                <form:errors path="diachi" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="username" class="mb-2">Tài khoản</label>
                <form:input path="username" type="text" cssClass="form-control" id="username" placeholder="Nhập tài khoản..."/>
                <form:errors path="username" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="password" class="mb-2">Mật khẩu</label>
                <form:input path="password" type="password" cssClass="form-control" id="password" placeholder="Nhập mật khẩu..."/>
                <form:errors path="password" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <button class="btn btn-primary text-white" type="submit">Thêm mới</button>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- Basic Tables end -->
</div>