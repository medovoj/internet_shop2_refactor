<%--
  Created by IntelliJ IDEA.
  User: medovoy
  Date: 09.04.2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<div id="shoppingCart">
    <div class="alert alert-warning hidden-print" role="alert">To make order, please sign in</div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Count</th>
            <th class="hidden-print">Action</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td colspan="2" class="text-right"><strong>Total:</strong></td>
            <td colspan="2" class="total">$5990.00</td>
        </tr>
        </tbody>
    </table>

</div>
