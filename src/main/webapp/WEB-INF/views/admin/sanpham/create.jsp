<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-heading">
  <div class="page-title mb-3">
    <div class="row">
      <div class="col-12 col-md-6 order-md-1 order-last">
        <h3>Thêm sản phẩm</h3>
      </div>
    </div>
  </div>

  <!-- Basic Tables start -->
  <section class="section">
    <div class="card">
      <div class="card-body">
        <div class="row">
          <div class="col-md-12">
            <form:form action="" method="post" modelAttribute="sanpham" enctype="multipart/form-data">
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
                <label for="ten" class="mb-2">Tên</label>
                <form:input path="ten" type="text" cssClass="form-control" id="ten" placeholder="Nhập tên sản phẩm..."/>
                <form:errors path="ten" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="gia" class="mb-2">Giá</label>
                <form:input path="gia" type="number" cssClass="form-control" id="gia" placeholder="Nhập giá..."/>
                <form:errors path="gia" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="file" class="mb-2">Hình ảnh</label>
                <form:input path="file" type="file" cssClass="form-control" id="file"/>
                <form:errors path="file" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="danhmuc" class="mb-2">Loại sản phẩm</label>
                <form:select path="danhmuc" cssClass="form-control" id="danhmuc">
                  <form:options items="${danhmucs}" itemValue="id" itemLabel="ten"/>
                </form:select>
                <form:errors path="danhmuc" cssClass="text-danger"/>
              </div>
              <div class="form-group">
                <label for="nhanhieu" class="mb-2">Nhãn hiệu</label>
                <form:select path="nhanhieu" cssClass="form-control" id="nhanhieu">
                  <form:options items="${nhanhieus}" itemValue="id" itemLabel="ten"/>
                </form:select>
                <form:errors path="nhanhieu" cssClass="text-danger"/>
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