<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mortgages</title>
    <link rel="stylesheet" type="text/css" href="css/wui.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script type="text/javascript" src="js/wui-date.js" charset="utf-8"></script>


    <style>
        html {
            width: 100%;
            height: 100%;
        }

        body {
            /*background: #fff url("image/bank.jpg") repeat left top;*/
            background-size: 100%;
            font-size: 18px;
            font-family: "Arial", "Tahoma", "微软雅黑", "雅黑";
            line-height: 30px;
            padding: 0px;
            margin: auto;
            text-align: center
        }

        div {
            padding: 5px
        }

        img {
            border: 0px;
            vertical-align: middle;
            padding: 0;
            margin: 0
        }

        input, button {
            font-family: "Arial", "Tahoma", "微软雅黑", "雅黑";
            border: 0;
            vertical-align: middle;
            margin: 8px;
            line-height: 8px;
            font-size: 18px
        }


        input {
            border: 2px solid #ccc;
            padding: 4px 0px;
            border-radius: 3px; /*css3属性IE不支持*/
            padding-left: 1px;
        }

        form {
            position: absolute;
            text-align: center;
            top: 140px;
            left: 0;
            bottom: 0;
            right: 0;
            margin: auto;
        }

        table {
            text-align: center;
            top: 150px;
            left: 0;
            bottom: 0;
            right: 0;
            margin: auto;

        }
    </style>
</head>
<body background="image/bank.jpg">
<br><font color="#ffffff"><p>
    <h1 >Mortgages</h1></font>
<p>
    <font color="#eb20ca">
        <form id="form1" name="form1" method="post" action="/CalculateServlet">
            <table border="0">
                <tr>
                    <td><b>Start Date</b></td>
                    <td>
                        <wui-date
                                name="startDate"
                                format="yyyy-MM"
                                placeholder="Please select a date"
                                id="date1"
                                ng-model="date1"
                                size="L"
                                btns="{'ok':'OK','now':'Today'}"
                        >
                        </wui-date>
                    </td>
                </tr>
                <tr>
                    <td><b>End Date</b></td>
                    <td>
                        <wui-date
                                name="endDate"
                                format="yyyy-MM"
                                placeholder="Please select a date"
                                id="date2"
                                ng-model="date2"
                                size="L"
                                btns="{'ok':'OK','now':'Today'}"
                        >
                        </wui-date>
                    </td>
                </tr>
                <tr>
                    <td><b>Method</b></td>
                    <td><select name="method" style="width:220px;height:35px">
                        <option value="Lineair">Lineair</option>
                        <option value="NoRepay">No Repay</option>
                        <option value="Amortized">Amortized</option>
                    </select></td>
                </tr>

                <tr>
                    <td><b>Loan(€)</b></td>
                    <td><input type="text" name="loan"/></td>
                </tr>

                <tr>
                    <td><b>Rate(%)</b></td>
                    <td><input type="text" name="rate" value="1.5"/></td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input type="submit" class="btn"  value="Submit" style="height:30px;width:225px"/>
                    </td>
                </tr>
            </table>

        </form>
    </font>
</p>
<script type="text/javascript">
    var app = angular.module('app', ["wui.date"]);
</script>

<div style="text-align:center;clear:both;">
    <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
    <script src="/follow.js" type="text/javascript"></script>
</div>
</body>
</html>
