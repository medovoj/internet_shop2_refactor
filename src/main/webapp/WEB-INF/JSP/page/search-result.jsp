<%--
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 30.09.2022
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<div class="alert alert-info">
  <p>Found <strong>${productCount }</strong> products</p>
</div>

<jsp:include page="products.jsp" />
