<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 09.04.2022
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#ishopNav" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="products">My Shop</a>
            </div>



            <div class="collapse navbar-collapse" id="shopNav">
                <ul id="currentShoppingCart" class="nav navbar-nav navbar-right ">
                    <li class="dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             Shopping cart (<span class="total-count">0</span>)<span class="caret"></span>
                        </a>
                        <div class="dropdown-menu shopping-cart-desc">
                            Total count: <span class="total-count">${CURRENT_SHOPPING_CART.totalCount}</span><br>
                            Total cost: <span class="total-cost">${CURRENT_SHOPPING_CART.totalCost}</span><br>
                            <a href="shopping-cart" class="btn btn-primary">View cart</a>
                        </div>
                    </li>
                </ul>
                <c:choose>
                    <c:when test="${CURRENT_ACCOUNT != null }">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a>Welcome ${CURRENT_ACCOUNT.description }</a></li>
                            <li><a href="my-orders">My orders</a></li>
                            <li><a href="sign-out">Sign out</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <form action="sign-in" method="post">
                            <button type="submit" class="btn btn-primary navbar-btn navbar-right sign-in">
                                <i class="fa fa-facebook-official" aria-hidden="true"></i> Sign in
                            </button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
