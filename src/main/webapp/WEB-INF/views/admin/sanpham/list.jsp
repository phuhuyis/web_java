<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-heading">
  <div class="page-title mb-3">
    <div class="row">
      <div class="col-12 col-md-6 order-md-1 order-last">
        <h3>Quản lý sản phẩm</h3>
      </div>
      <div class="col-12 col-md-6 order-md-2 order-first">
        <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
          <ol class="breadcrumb">
            <li class="btn"><a href="/admin/sanpham/create">Tạo mới</a></li>
          </ol>
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
                    <th>Tên</th>
                    <th>Hình ảnh</th>
                    <th>Giá</th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${listSanPham}">
                    <tr>
                      <td class="text-bold-500">${item.id}</td>
                      <td>${item.ten}</td>
                      <td>
                        <img src="${item.hinhanh}" style="width: 200px; height: 200px">
                      </td>
                      <td>${item.gia}</td>
                      <td class="text-bold-500">
                        <a href="/admin/sanpham/edit/${item.id}" class="btn btn-primary text-white">Cập nhập</a>
                        <a href="#" class="btn btn-danger text-white del-sanpham" data-id="${item.id}">Xóa</a>
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