<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 align="center" >购物车</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
    </tr>

    <c:forEach items="${pro.data.product.name}" var="oi" varStatus="st">
        <tr>
            <td>${pro.data.product.name}</td>
            <td>${pro.data.product.price}</td>
            <td>${pro.data.num}</td>
            <td>${pro.data.product.price*pro.data.num}</td>
        </tr>
    </c:forEach>
</table>