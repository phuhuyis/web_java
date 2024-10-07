<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="page-heading">
  <div class="page-title mb-3">
    <div class="row">
      <div class="col-12 col-md-6 order-md-1 order-last">
        <h3>Quản lý hóa đơn</h3>
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
                    <th>Ngày đặt</th>
                    <th>Khách hàng</th>
                    <th>Trạng thái</th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${listHoaDon}">
                    <tr>
                      <td class="text-bold-500">${item.id}</td>
                      <td>
                        <fmt:formatDate value="${item.ngaydat}" pattern="dd/MM/yyyy" />
                      </td>
                      <c:forEach var="khachhang" items="${listKhachHang}">
                        <c:if test="${khachhang.id == item.khachhang}">
                          <td>
                            ${khachhang.hovaten}
                          </td>
                        </c:if>
                      </c:forEach>
                      <c:choose>
                        <c:when test="${item.trangthai == 0}">
                          <td>
                              Chưa thanh toán
                          </td>
                        </c:when>
                        <c:otherwise>
                          <td>
                            Đã thanh toán
                          </td>
                        </c:otherwise>
                      </c:choose>
                      <td class="text-bold-500">
                        <c:choose>
                          <c:when test="${item.trangthai == 0}">
                            <a href="#" class="btn btn-success text-white paid-hoadon" data-id="${item.id}">Đã thanh toán</a>
                          </c:when>
                          <c:otherwise>
                            <a href="#" class="btn btn-info text-white unpaid-hoadon" data-id="${item.id}">Chưa thanh toán</a>
                          </c:otherwise>
                        </c:choose>
                        <a href="/admin/hoadon/detail/${item.id}" class="btn btn-primary text-white">Chi tiết</a>
                        <a href="#" class="btn btn-danger text-white del-hoadon" data-id="${item.id}">Xóa</a>
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