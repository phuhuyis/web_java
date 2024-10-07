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
        <li class="breadcrumb-item">Loại sản phẩm</li>
        <li class="breadcrumb-item active text-white">${title}</li>
    </ol>
</div>
<!-- Single Page Header End -->


<!-- Fruits Shop Start-->
<div class="container-fluid fruite py-5">
    <div class="container py-5">
        <h1 class="mb-4">${title}</h1>
        <div class="row g-4">
            <div class="col-lg-12">
                <div class="row g-4">
                    <div class="col">
                        <div class="row g-4 justify-content-start">
                            <c:forEach items="${products}" var="item">
                                <div class="col-md-6 col-lg-6 col-xl-4">
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
                            <div class="col-12">
                                <div class="pagination d-flex justify-content-center mt-5">
                                    <%
                                        if(Integer.parseInt(request.getAttribute("page").toString()) > 1){
                                            out.print("<a href=\"/category/" + request.getAttribute("metatitle")
                                                    + "/" + (Integer.parseInt(request.getAttribute("page").toString()) - 1) + "\" class=\"rounded\">&laquo;</a>");
                                        }
                                        if(Integer.parseInt(request.getAttribute("page").toString()) == 1){
                                            out.print("<a href=\"/category/" + request.getAttribute("metatitle")
                                                    + "/" + 1 + "\" class=\"rounded\">&laquo;</a>");
                                        }
                                        for(int i = 0; i < Integer.parseInt(request.getAttribute("fullPage").toString()); i++){
                                            if(i + 1 == Integer.parseInt(request.getAttribute("page").toString())){
                                                out.print("<a href=\"/category/" + request.getAttribute("metatitle")
                                                        + "/" + (i + 1) + "\" class=\"active rounded\">" + (i + 1) + "</a>");
                                            }else{
                                                out.print("<a href=\"/category/" + request.getAttribute("metatitle")
                                                        + "/" + (i + 1) + "\" class=\"rounded\">" + (i + 1) + "</a>");
                                            }
                                        }
                                        if(Integer.parseInt(request.getAttribute("page").toString()) < Integer.parseInt(request.getAttribute("fullPage").toString())){
                                            out.print("<a href=\"/category/" + request.getAttribute("metatitle")
                                                    + "/" + (Integer.parseInt(request.getAttribute("page").toString()) + 1) + "\" class=\"rounded\">&raquo;</a>");
                                        }
                                        if(Integer.parseInt(request.getAttribute("page").toString()) == Integer.parseInt(request.getAttribute("fullPage").toString())){
                                            out.print("<a href=\"/category/" + request.getAttribute("metatitle")
                                                    + "/" + Integer.parseInt(request.getAttribute("fullPage").toString()) + "\" class=\"rounded\">&raquo;</a>");
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fruits Shop End-->