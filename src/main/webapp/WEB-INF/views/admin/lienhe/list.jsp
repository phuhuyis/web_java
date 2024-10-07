<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-heading">
  <div class="page-title mb-3">
    <div class="row">
      <div class="col-12 col-md-6 order-md-1 order-last">
        <h3>Quản lý liên hệ</h3>
      </div>
      <div class="col-12 col-md-6 order-md-2 order-first">
        <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
        </nav>
      </div>
    </div>
  </div>

  <!-- Basic Tables start -->
  <section class="section">
    <div class="row" id="basic-table">
      <div class="col-12 col-md-12">
        <div class="card">
          <div class="card-content">
            <div class="card-body">
              <!-- Table with outer spacing -->
              <div class="table-responsive">
                <table class="table table-lg">
                  <thead>
                  <tr>
                    <th>ID</th>
                    <th>Tiêu đề</th>
                    <th>Nội dung</th>
                    <th>Khách hàng</th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${listLienHe}">
                    <tr>
                      <td class="text-bold-500">${item.id}</td>
                      <td>
                          ${item.tieude}
                        <c:choose>
                          <c:when test="${item.trangthai == 0}">
                            <span class="badge bg-danger ms-2">Đang xử lý</span>
                          </c:when>
                          <c:otherwise>
                            <span class="badge bg-primary ms-2">Hoàn thành</span>
                          </c:otherwise>
                        </c:choose>
                      </td>
                      <td>${item.noidung}</td>
                      <td>
                        <c:forEach items="${listKhachHang}" var="khachhang">
                          <c:if test="${khachhang.id == item.khachhang}">
                            ${khachhang.hovaten}
                          </c:if>
                        </c:forEach>
                      </td>
                      <td class="text-bold-500">
                        <c:choose>
                          <c:when test="${item.trangthai == 0}">
                            <a href="#" class="btn btn-primary text-white success-lienhe" data-id="${item.id}">Hoàn thành</a>
                          </c:when>
                          <c:otherwise>
                            <a href="#" class="btn btn-success text-white progress-lienhe" data-id="${item.id}">Đang xử lý</a>
                          </c:otherwise>
                        </c:choose>
                        <a href="#" class="btn btn-danger text-white del-lienhe" data-id="${item.id}">Xóa</a>
                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- Basic Tables end -->
</div>