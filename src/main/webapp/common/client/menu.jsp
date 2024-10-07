<%@ page import="com.example.websiteqa.model.Taikhoan" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid fixed-top">
    <div class="container topbar bg-primary d-none d-lg-block">
        <div class="d-flex justify-content-between">
            <div class="top-info ps-2">
                <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#" class="text-white">Đại học Quảng Nam</a></small>
                <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">Phonmixay@gmail.com</a></small>
            </div>
        </div>
    </div>
    <div class="container px-0">
        <nav class="navbar navbar-light bg-white navbar-expand-xl">
            <a href="/" class="navbar-brand"><h1 class="text-primary display-6">Trang chủ</h1></a>
            <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="fa fa-bars text-primary"></span>
            </button>
            <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                <div class="navbar-nav mx-auto">
                    <a href="/" class="nav-item nav-link ${active == "home" ? "active" : ""}">Trang chủ</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle ${active == "brand" ? "active" : ""}" data-bs-toggle="dropdown">Nhãn hiệu</a>
                        <div class="dropdown-menu m-0 bg-secondary rounded-0">
                            <c:forEach var="item" items="${nhanhieus}">
                                <a href="/brand/${item.duongdan}" class="dropdown-item">${item.ten}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle ${active == "category" ? "active" : ""}" data-bs-toggle="dropdown">Loại sản phẩm</a>
                        <div class="dropdown-menu m-0 bg-secondary rounded-0">
                            <c:forEach var="item" items="${categories}">
                                <a href="/category/${item.duongdan}" class="dropdown-item">${item.ten}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <a href="/bill" class="nav-item nav-link ${active == "bill" ? "active" : ""}">Hóa đơn</a>
                    <a href="/contact" class="nav-item nav-link ${active == "contact" ? "active" : ""}">Liên hệ</a>
                    <c:choose>
                        <c:when test="${empty sessionScope.user}">
                            <a href="/login" class="nav-item nav-link">Đăng nhập</a>
                        </c:when>
                        <c:otherwise>
                            <% boolean isAdmin = ((Taikhoan)request.getSession().getAttribute("user")).getQuyen() == 1; %>
                            <c:choose>
                                <c:when test="<%=!isAdmin%>">
                                    <a href="/logout" class="nav-item nav-link">Đăng xuất</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/login" class="nav-item nav-link">Đăng nhập</a>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="d-flex m-3 me-0">
                    <button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4" data-bs-toggle="modal" data-bs-target="#searchModal"><i class="fas fa-search text-primary"></i></button>
                    <a href="/cart" class="position-relative me-4 my-auto">
                        <i class="fa fa-shopping-bag fa-2x"></i>
                        <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" id="count-cart" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">0</span>
                    </a>
                    <a href="/account" class="my-auto">
                        <i class="fas fa-user fa-2x"></i>
                    </a>
                </div>
            </div>
        </nav>
    </div>
</div>

<!-- Modal Search Start -->

<div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content rounded-0">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Tìm kiếm từ khóa</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body d-flex align-items-center">
                <div class="input-group w-75 mx-auto d-flex">
                    <form action="/search" class="row w-100">
                        <input name="keyWord" type="search" class="form-control p-3 col" placeholder="Tìm kiếm..." aria-describedby="search-icon-1">
                        <button type="submit" class="btn btn-primary ms-1" style="width: 60px">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal Search End -->