<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<fmt:setBundle basename="java.text.resources.LocaleElements"/>
<%@ include file="/common/client/slide.jsp"%>

<%@ include file="/common/client/policy.jsp"%>

<!-- Fruits Shop Start-->
<div class="container-fluid fruite py-5">
    <div class="container py-5">
        <div class="tab-class text-center">
            <div class="row g-4">
                <div class="col-lg-4 text-start">
                    <h1>Sản phẩm</h1>
                </div>
                <div class="col-lg-8 text-end">
                    <ul class="nav nav-pills d-inline-flex text-center mb-5">
                        <li class="nav-item">
                            <a class="d-flex m-2 py-2 bg-light rounded-pill active" data-bs-toggle="pill" href="#tab-1">
                                <span class="text-dark" style="width: 130px;">Tất cả</span>
                            </a>
                        </li>
                        <% i = 2;%>
                        <c:forEach var="item" items="${categories}">
                            <li class="nav-item">
                                <a class="d-flex py-2 m-2 bg-light rounded-pill" data-bs-toggle="pill" href="#tab-<%=i%>">
                                    <span class="text-dark" style="width: 130px;">${item.ten}</span>
                                </a>
                            </li>
                            <% i++;%>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="tab-content">
                <div id="tab-1" class="tab-pane fade show p-0 active">
                    <div class="row g-4">
                        <div class="col-lg-12">
                            <div class="row g-4">
                                <c:forEach items="${products}" var="item">
                                    <div class="col-md-6 col-lg-4 col-xl-3">
                                        <div class="rounded position-relative fruite-item">
                                            <div class="fruite-img">
                                                <img src="${item.hinhanh}" class="img-fluid w-100 rounded-top" alt="">
                                            </div>
                                            <c:forEach var="brand" items="${nhanhieus}">
                                                <c:if test="${brand.id == item.nhanhieu}">
                                                    <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">${brand.ten}</div>
                                                </c:if>
                                            </c:forEach>
                                            <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                <h5 style="height: 50px">${item.ten}</h5>
                                                <div class="d-flex justify-content-between flex-lg-wrap">
                                                    <p class="text-dark fs-5 fw-bold mb-0">
                                                        <fmt:formatNumber value="${item.gia}" type="currency"/>
                                                    </p>
                                                    <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary add-cart" data-id="${item.id}" data-quantity="1"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <% i = 2;%>
                <c:forEach var="item" items="${categories}">
                    <div id="tab-<%=i%>" class="tab-pane fade show p-0">
                        <div class="row g-4">
                            <div class="col-lg-12">
                                <div class="row g-4">
                                    <c:forEach var="product" items="${allProduct}">
                                        <c:if test="${product.danhmuc == item.id}">
                                            <div class="col-md-6 col-lg-4 col-xl-3">
                                                <div class="rounded position-relative fruite-item">
                                                    <div class="fruite-img">
                                                        <img src="${product.hinhanh}" class="img-fluid w-100 rounded-top" alt="">
                                                    </div>
                                                    <c:forEach var="brand" items="${nhanhieus}">
                                                        <c:if test="${brand.id == product.nhanhieu}">
                                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">${brand.ten}</div>
                                                        </c:if>
                                                    </c:forEach>
                                                    <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                        <h5 style="height: 50px">${product.ten}</h5>
                                                        <div class="d-flex justify-content-between flex-lg-wrap">
                                                            <p class="text-dark fs-5 fw-bold mb-0">
                                                                <fmt:formatNumber value="${product.gia}" type="currency"/>
                                                            </p>
                                                            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary add-cart" data-id="${product.id}" data-quantity="1"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% i++;%>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!-- Fruits Shop End-->


<!-- Featurs Start -->
<div class="container-fluid service py-5">
    <div class="container py-5">
        <div class="row g-4 justify-content-center">
            <div class="col-md-6 col-lg-4">
                <a href="#">
                    <div class="service-item bg-secondary rounded border border-secondary">
                        <img src="/resources/client/img/banner-1.png" class="img-fluid rounded-top w-100" alt="" style="height: 400px">
                        <div class="px-4 rounded-bottom">
                            <div class="service-content bg-primary text-center p-4 rounded">
                                <h5 class="text-white">Thời trang nam</h5>
                                <h5 class="mb-0">Giảm giá 20%</h5>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-6 col-lg-4">
                <a href="#">
                    <div class="service-item bg-dark rounded border border-dark">
                        <img src="/resources/client/img/banner-2.png" class="img-fluid rounded-top w-100" alt="" style="height: 400px">
                        <div class="px-4 rounded-bottom">
                            <div class="service-content bg-light text-center p-4 rounded">
                                <h5 class="text-primary">Chính sách giao hàng</h5>
                                <h5 class="mb-0">Miễn phí giao hàng</h5>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-6 col-lg-4">
                <a href="#">
                    <div class="service-item bg-primary rounded border border-primary">
                        <img src="/resources/client/img/banner-3.png" class="img-fluid rounded-top w-100" alt="" style="height: 400px">
                        <div class="px-4 rounded-bottom">
                            <div class="service-content bg-secondary text-center p-4 rounded">
                                <h5 class="text-white">Sản phẩm mới</h5>
                                <h5 class="mb-0">Giảm ngay 30.000 đ</h5>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
<!-- Featurs End -->


<!-- Vesitable Shop Start-->
<div class="container-fluid vesitable py-5">
    <div class="container py-5">
        <h1 class="mb-0">Sản phẩm của chúng tôi</h1>
        <div class="owl-carousel vegetable-carousel justify-content-center">
            <c:forEach items="${allProduct}" var="item">
                <div class="border border-primary rounded position-relative vesitable-item">
                    <div class="vesitable-img">
                        <img src="${item.hinhanh}" class="img-fluid w-100 rounded-top" alt="">
                    </div>
                    <c:forEach var="brand" items="${nhanhieus}">
                        <c:if test="${brand.id == item.nhanhieu}">
                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">${brand.ten}</div>
                        </c:if>
                    </c:forEach>
                    <div class="p-4 rounded-bottom">
                        <h5 style="height: 50px">${item.ten}</h5>
                        <div class="d-flex justify-content-between flex-lg-wrap">
                            <p class="text-dark fs-5 fw-bold mb-0"><fmt:formatNumber value="${item.gia}" type="currency"/></p>
                            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary add-cart" data-id="${item.id}" data-quantity="1"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!-- Vesitable Shop End -->