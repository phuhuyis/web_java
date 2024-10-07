<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<fmt:setBundle basename="java.text.resources.LocaleElements"/>
<div class="page-heading">
  <div class="page-title mb-3">
    <div class="row">
      <div class="col-12 col-md-6 order-md-1 order-last">
        <h3>Chi tiết hóa đơn</h3>
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
                    <th>Hình ảnh</th>
                    <th>Tên</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${listChiTiet}">
                    <tr>
                      <td class="text-bold-500">${item.id}</td>
                      <c:forEach var="sanpham" items="${listSanPham}">
                        <c:if test="${sanpham.id == item.sanpham}">
                          <td>
                              <img src="${sanpham.hinhanh}" width="200px" height="200px">
                          </td>
                          <td>
                              ${sanpham.ten}
                          </td>
                          <td>
                            <fmt:formatNumber value="${sanpham.gia}" type="currency"/>
                          </td>
                          <td>
                              ${item.soluong}
                          </td>
                          <td>
                            <fmt:formatNumber value="${sanpham.gia * item.soluong}" type="currency"/>
                          </td>
                        </c:if>
                      </c:forEach>
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
    <div class="d-flex justify-content-end">
      <c:choose>
        <c:when test="${trangthai == 0}">
          <a href="#" class="btn btn-success text-white paid-hoadon" data-id="${id}">Đã thanh toán</a>
        </c:when>
        <c:otherwise>
          <a href="#" class="btn btn-info text-white unpaid-hoadon" data-id="${id}">Chưa thanh toán</a>
        </c:otherwise>
      </c:choose>
    </div>
  </section>
  <!-- Basic Tables end -->
</div>