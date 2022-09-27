<%--
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 10.04.2022
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shop" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="productList">
        <jsp:include page="../fragment/product-list.jsp"/>
        <div class="text-center">
            <a id="loadMore" class="btn btn-primary">Load more products</a>
        </div>
        <shop:add-popup/>
    </div>
</body>
</html>
