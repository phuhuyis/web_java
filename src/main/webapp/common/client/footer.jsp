<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
    <div class="container py-5">
        <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
            <div class="row g-4">
                <div class="col-lg-3">
                    <a href="#">
                        <h1 class="text-primary mb-0">Phonmixay</h1>
                        <p class="text-secondary mb-0">Thời trang nam - nữ</p>
                    </a>
                </div>
                <div class="col-lg-6">
                    <div class="position-relative mx-auto">
                        <input class="form-control border-0 w-100 py-3 px-4 rounded-pill" type="number" placeholder="Your Email">
                        <button type="submit" class="btn btn-primary border-0 border-secondary py-3 px-4 position-absolute rounded-pill text-white" style="top: 0; right: 0;">Subscribe Now</button>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="d-flex justify-content-end pt-3">
                        <a class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-outline-secondary btn-md-square rounded-circle" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row g-5">
            <div class="col-lg-3 col-md-6">
                <div class="footer-item">
                    <h4 class="text-light mb-3">Tại sao mọi người thích chúng tôi!</h4>
                    <p class="mb-4">Chúng tôi có hơn 50 năm kinh nghiệm về các sản phẩm thời trang uy tín, chất lượng, giá cả phải chăng</p>
                    <a href="" class="btn border-secondary py-2 px-4 rounded-pill text-primary">Xem thêm</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="d-flex flex-column text-start footer-item">
                    <h4 class="text-light mb-3">Menu điều hướng</h4>
                    <a class="btn-link" href="/">Trang chủ</a>
                    <a class="btn-link" href="/bill">Hóa đơn</a>
                    <a class="btn-link" href="/cart">Giỏ hàng</a>
                    <a class="btn-link" href="/contact">Liên hệ</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="d-flex flex-column text-start footer-item">
                    <h4 class="text-light mb-3">Tài khoản</h4>
                    <a class="btn-link" href="/account">Tài khoản của bạn</a>
                    <a class="btn-link" href="/bill">Hóa đơn</a>
                    <a class="btn-link" href="/cart">Giỏ hàng</a>
                    <c:choose>
                        <c:when test="${empty sessionScope.user}">
                            <a class="btn-link" href="/login">Đăng nhập</a>
                        </c:when>
                        <c:otherwise>
                            <% boolean isAdmin = ((Taikhoan)request.getSession().getAttribute("user")).getQuyen() == 1; %>
                            <c:choose>
                                <c:when test="<%=!isAdmin%>">
                                    <a class="btn-link" href="/logout">Đăng xuất</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn-link" href="/login">Đăng nhập</a>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-item">
                    <h4 class="text-light mb-3">Liên hệ</h4>
                    <p>Địa chỉ: Đại học Quảng Nam</p>
                    <p>Email: Phonmixay@gmail.com</p>
                    <p>Số điện thoại: +0123 4567 8910</p>
                    <p>Payment Accepted</p>
                    <img src="/resources/client/img/payment.png" class="img-fluid" alt="">
                </div>
            </div>
        </div>
    </div>
</div>