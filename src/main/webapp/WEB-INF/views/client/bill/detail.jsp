<%@ page import="com.example.websiteqa.model.Cthd" %>
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
        <li class="breadcrumb-item">Hóa đơn</li>
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
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listDetail}">
                    <tr>
                        <c:forEach var="product" items="${listProduct}">
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
                                    <p class="mb-0 mt-4">${item.soluong}</p>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4">
                                        <fmt:formatNumber value="${product.gia * item.soluong}" type="currency"/>
                                    </p>
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
            for(Cthd item : (List<Cthd>)request.getAttribute("listDetail")){
                for(Sanpham product : (List<Sanpham>)request.getAttribute("listProduct")){
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
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart Page End -->