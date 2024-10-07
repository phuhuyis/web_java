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
        <li class="breadcrumb-item active text-white">Hóa đơn</li>
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
                    <th scope="col">Ngày đặt</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Xử lý</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listBill}">
                    <tr>
                        <td>
                            <fmt:formatDate value="${item.ngaydat}" pattern="dd/MM/yyyy" />
                        </td>
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
                            <a href="/bill/detail/${item.id}" class="btn btn-primary text-white">Chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Cart Page End -->