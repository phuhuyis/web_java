<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar" class="active">
    <div class="sidebar-wrapper active">
        <div class="sidebar-menu">
            <ul class="menu">

                <li class="sidebar-item ${active == "loaisanpham" ? "active" : ""}">
                    <a href="/admin/loaisanpham" class='sidebar-link'>
                        <span>Quản lý loại sản phẩm</span>
                    </a>
                </li>

                <li class="sidebar-item ${active == "nhanhieu" ? "active" : ""}">
                <a href="/admin/nhanhieu" class='sidebar-link'>
                    <span>Quản lý nhãn hiệu</span>
                </a>
                </li>

                <li class="sidebar-item ${active == "sanpham" ? "active" : ""}">
                    <a href="/admin/sanpham" class='sidebar-link'>
                        <span>Quản lý sản phẩm</span>
                    </a>
                </li>

                <li class="sidebar-item ${active == "khachhang" ? "active" : ""}">
                <a href="/admin/khachhang" class='sidebar-link'>
                    <span>Quản lý khách hàng</span>
                </a>
                </li>

                <li class="sidebar-item ${active == "hoadon" ? "active" : ""}">
                    <a href="/admin/hoadon" class='sidebar-link'>
                        <span>Quản lý hóa đơn</span>
                    </a>
                </li>

                <li class="sidebar-item ${active == "lienhe" ? "active" : ""}">
                    <a href="/admin/lienhe" class='sidebar-link'>
                        <span>Quản lý liên hệ</span>
                    </a>
                </li>

                <li class="sidebar-item ${active == "bank" ? "active" : ""}">
                    <a href="/admin/bank/edit" class='sidebar-link'>
                        <span>Quản lý tài khoản ngân hàng</span>
                    </a>
                </li>

                <li class="sidebar-item ${active == "slide" ? "active" : ""}">
                    <a href="/admin/slide" class='sidebar-link'>
                        <span>Quản lý slide</span>
                    </a>
                </li>

                <li class="sidebar-item ${active == "report" ? "active" : ""}">
                    <a href="/admin/report" class='sidebar-link'>
                        <span>Báo cáo, thống kê</span>
                    </a>
                </li>

            </ul>
        </div>
        <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
    </div>
</div>
<div id="main" class="d-flex flex-column" style="min-height: 100vh;">
    <header class="mb-3">
        <a href="#" class="burger-btn d-block d-xl-none">
            <i class="bi bi-justify fs-3"></i>
        </a>
    </header>