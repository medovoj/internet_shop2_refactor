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
    <div class="visible-xs-block xs-option-container">
        <a class="pull-right" data-toggle="collapse" href="#productCatalog">Product catalog <span class="caret"></span></a>
        <a data-toggle="collapse" href="#findProducts">Find products <span class="caret"></span></a>
    </div>
    <!-- Search form -->
    <form class="search" action="/products">
        <div id="findProducts" class="panel panel-success collapse">
            <div class="panel-heading">Find products</div>
            <div class="panel-body">
                <div class="input-group">
                    <input type="text" name="query" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                    <a id="goSearch" class="btn btn-default">Go!</a>
                  </span>
                </div>
                <div class="more-options">
                    <a data-toggle="collapse" href="#searchOptions">More filters <span class="caret"></span></a>
                </div>
            </div>
            <div id="searchOptions" class="collapse">
                <div class="panel-heading">Category filters</div>
                <div class="panel-body categories">
                    <label> <input type="checkbox" id="allCategories"> All </label>
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="category" value="1" class="search-option">First (12)</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="category" value="2" class="search-option">Second (56)</label>
                        </div>
                    </div>
                </div>
                <div class="panel-heading">Producers filters</div>
                <div class="panel-body producers">
                    <label> <input type="checkbox" id="allProducers"> All </label>
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="producer" value="1" class="search-option">First (99) </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label><input type="checkbox" name="producer" value="2" class="search-option">Second (44) </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!--/Search form-->
    <!--Categories-->
    <div class="panel panel-success">
        <div class="panel-heading">Product Catalog</div>

        <div class="list-group">
            <a href="/products" class="list-group-item"><span class="badge">12</span>One</a>
            <a href="/products" class="list-group-item"><span class="badge">12</span> Two </a>
            <a href="/products" class="list-group-item"><span class="badge">12</span> Three </a>
            <a href="/products" class="list-group-item"><span class="badge">12</span> Four </a>
            <a href="/products" class="list-group-item"><span class="badge">12</span> Five </a>
        </div>
    </div>
</body>
</html>
