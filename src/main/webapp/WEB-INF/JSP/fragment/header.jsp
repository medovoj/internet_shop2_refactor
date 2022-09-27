<%--
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 09.04.2022
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#ishopNav" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/products">My Shop</a>
            </div>
            <div class="collapse navbar-collapse" id="shopNav">
                <ul id="currentShoppingCart" class="nav navbar-nav navbar-right ">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i> Shopping cart (<span class="total-count">0</span>)<span class="caret"></span>
                        </a>
                        <div class="dropdown-menu shopping-cart-desc">
                            Total count: <span class="total-count">0</span><br>
                            Total cost: <span class="total-cost">0</span><br>
                            <a href="/shopping-cart" class="btn btn-primary">View cart</a>
                        </div>
                    </li>
                </ul>
                <a href="#" class="btn btn-primary navbar-btn navbar-right sign-in"> Sign in</a>
            </div>
        </div>
    </nav>
</body>
</html>
