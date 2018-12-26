<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title>Display Payment</title>
    <link href="css/all.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/common/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="/SearchPaymentServlet" id="mainForm" method="post">
    <div class="right">
        <div class="rightCont">
            <p class="g_title fix">content </p>
            <table class="tab1">
                <tbody>
                <tr>
                    <td width="90" align="right">Date：</td>
                    <td>
                        <input name="date" type="text" class="allInput" value="${requestScope.date}"/>
                    </td>
                    <td width="85" align="right"><input type="submit" class="tabSub" value="Search"/></td>
                </tr>
                </tbody>
            </table>
            <div class="zixun fix">
                <table class="tab2" width="100%">
                    <tbody>
                    <tr>
                        <th>Date</th>
                        <th>Outstanding loan(€)</th>
                        <th>Interest(€)</th>
                        <th>Repayment(€)</th>
                        <th>Pay per month(€)</th>
                    </tr>
                    <c:forEach items="${requestScope.payments}" var="payment" varStatus="status">
                        <tr <c:if test="${status.index %2 !=0}">style="background-color:#ECF6EE;"</c:if>>
                            <td>${payment.date}</td>
                            <td><fmt:formatNumber type="number" value="${payment.currentLoan}" pattern="#.00"></fmt:formatNumber></td>
                            <td><fmt:formatNumber type="number" value="${payment.interest}" pattern="#.00"></fmt:formatNumber></td>
                            <td><fmt:formatNumber type="number" value="${payment.repayment}" pattern="#.00"></fmt:formatNumber></td>
                            <td><fmt:formatNumber type="number" value="${payment.repayment+payment.interest}" pattern="#.00"></fmt:formatNumber></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</form>
</body>
</html>