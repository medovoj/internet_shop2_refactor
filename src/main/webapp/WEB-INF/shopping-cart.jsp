<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
<%@ page
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 01.04.2022
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${CURRENT_SHOPPING_CART != null}">
        Total Count: ${CURRENT_SHOPPING_CART.totalCount}<br>
        Products: <br>
        <c:forEach var="it" items="${CURRENT_SHOPPING_CART.items}">
            ${it.idProduct} -&gt;${it.count}<br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        Shopping cart is null.
    </c:otherwise>
</c:choose>

