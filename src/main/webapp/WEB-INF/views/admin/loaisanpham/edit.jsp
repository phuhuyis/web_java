<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-heading">
    <div class="page-title mb-3">
        <div class="row">
            <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>Cập nhập loại sản phẩm</h3>
            </div>
        </div>
    </div>

    <!-- Basic Tables start -->
    <section class="section">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-12">
                        <form:form action="" method="post" modelAttribute="loaisanpham">
                            <c:if test="${success != null}">
                                <div class="alert alert-success">
                                        ${success}
                                </div>
                            </c:if>
                            <c:if test="${error != null}">
                                <div class="alert alert-danger">
                                        ${error}
                                </div>
                            </c:if>
                            <div class="form-group">
                                <label for="basicInput" class="mb-2">Tên</label>
                                <form:input path="ten" type="text" cssClass="form-control" id="basicInput" placeholder="Nhập tên loại sản phẩm..."/>
                                <form:errors path="ten" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="duongdan" class="mb-2">Đường dẫn</label>
                                <form:input path="duongdan" type="text" cssClass="form-control" id="duongdan" placeholder="Nhập đường dẫn..."/>
                                <form:errors path="duongdan" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary text-white" type="submit">Cập nhập</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Basic Tables end -->
</div>