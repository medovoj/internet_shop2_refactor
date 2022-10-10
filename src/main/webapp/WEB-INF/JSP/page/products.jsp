<%--
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 10.04.2022
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="ishop" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<div id="productList" data-page-count="${pageCount}" data-page-number="1">
    <div class="row">
        <jsp:include page="../fragment/product-list.jsp" />
    </div>
    <c:if test="${pageCount > 1 }">
        <div class="text-center hidden-print">
            <a id="loadMore" class="btn btn-success">Load more products</a>
        </div>
    </c:if>
</div>
<ishop:add-product-popup />
