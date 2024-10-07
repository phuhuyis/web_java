<%@ page import="com.example.websiteqa.model.Giohang" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.websiteqa.model.Sanpham" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<fmt:setBundle basename="java.text.resources.LocaleElements"/>
<!-- Single Page Header start -->
<div class="container-fluid page-header py-5">
    <h1 class="text-center text-white display-6">${title}</h1>
    <ol class="breadcrumb justify-content-center mb-0">
        <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
        <li class="breadcrumb-item active text-white">${title}</li>
    </ol>
</div>
<!-- Single Page Header End -->


<!-- Cart Page Start -->
<div class="container-fluid py-5">
    <div class="container py-5">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Thành tiền</th>
                    <th scope="col">Xử lý</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${carts}">
                    <tr>
                        <c:forEach var="product" items="${products}">
                            <c:if test="${item.sanpham == product.id}">
                                <th scope="row">
                                    <div class="d-flex align-items-center">
                                        <img src="${product.hinhanh}" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="">
                                    </div>
                                </th>
                                <td>
                                    <p class="mb-0 mt-4">${product.ten}</p>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4">
                                        <fmt:formatNumber value="${product.gia}" type="currency"/>
                                    </p>
                                </td>
                                <td>
                                    <div class="input-group quantity mt-4" style="width: 100px;">
                                        <div class="input-group-btn update-cart" data-id="${product.id}" data-quantity="${item.soluong == 1 ? 1 : item.soluong - 1}">
                                            <button class="btn btn-sm btn-minus rounded-circle bg-light border" >
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                        <input type="text" class="form-control form-control-sm text-center border-0" value="${item.soluong}">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-plus rounded-circle bg-light border update-cart" data-id="${product.id}" data-quantity="${item.soluong + 1}">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4">
                                        <fmt:formatNumber value="${product.gia * item.soluong}" type="currency"/>
                                    </p>
                                </td>
                                <td>
                                    <button class="btn btn-md rounded-circle bg-light border mt-4 del-cart" data-id="${product.id}">
                                        <i class="fa fa-times text-danger"></i>
                                    </button>
                                </td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%
            int total = 0;
            for(Giohang item : (List<Giohang>)request.getAttribute("carts")){
                for(Sanpham product : (List<Sanpham>)request.getAttribute("products")){
                    if(item.getSanpham() == product.getId()){
                        total += item.getSoluong() * product.getGia();
                    }
                }
            }
        %>
        <div class="row g-4 justify-content-end">
            <div class="col-8"></div>
            <div class="col-sm-8 col-md-7 col-lg-6 col-xl-4">
                <div class="bg-light rounded">
                    <div class="p-4">
                        <h1 class="display-6 mb-4">Tổng cộng</h1>
                        <div class="d-flex justify-content-between mb-4">
                            <h5 class="mb-0 me-4">Tổng thành tiền:</h5>
                            <p class="mb-0">
                                <fmt:formatNumber value="<%=total%>" type="currency"/>
                            </p>
                        </div>
                    </div>
                    <button class="btn border-secondary rounded-pill px-4 py-3 text-primary text-uppercase mb-4 ms-4 payment" type="button">Thanh toán</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart Page End -->
<div class="modal" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Mời quý khách quét mã QR</h5>
                <button onclick="payment()" type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <img id="qr" width="100%" />
            </div>
        </div>
    </div>
</div>