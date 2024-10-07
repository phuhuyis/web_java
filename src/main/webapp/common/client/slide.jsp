<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Hero Start -->
<div class="container-fluid py-5 mb-5 hero-header">
    <div class="container py-5">
        <div class="row g-5 align-items-center">
            <div class="col-md-12 col-lg-7">
                <h4 class="mb-3 text-secondary">100% Sản phẩm chính hãng</h4>
                <h1 class="mb-5 display-3 text-primary">Thời trang chính hãng - giá rẻ</h1>
            </div>
            <div class="col-md-12 col-lg-5">
                <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                    <div class="carousel-inner" role="listbox">
                        <% int i = 0; %>
                        <c:forEach items="${slides}" var="item">
                            <c:choose>
                                <c:when test="<%= i == 0 %>">
                                    <div class="carousel-item active rounded">
                                        <img src="${item.duongdan}" class="img-fluid w-100 h-100 bg-secondary rounded" alt="First slide">
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="carousel-item rounded">
                                        <img src="${item.duongdan}" class="img-fluid w-100 h-100 rounded" alt="Second slide">
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <% i++; %>
                        </c:forEach>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Hero End -->