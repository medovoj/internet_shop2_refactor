<%@ page import="Constants.Constants" %>
<%@ page import="Constants.Constants" %>
<%@ page import="static Constants.Constants.CURRENT_SHOPPING_CART" %>

<%--
<%@ page
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 01.04.2022
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute(CURRENT_SHOPPING_CART) != null) {%>
    Total count = ${CURRENT_SHOPPING_CART.totalCount}<br>
    Products = <br>${CURRENT_SHOPPING_CART.view}
<% }else{ %>
Shopping cart is null
<% } %>
