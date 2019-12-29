<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>调问-专业且开源的问卷表单系统</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--boot css -->
    <link rel="stylesheet" href="./js/plugs/bootstrap-3.3.0-dist/dist/css/bootstrap.min.css">
    <!--jquery js-->
    <script src="./js/plugs/jquery/js/jquery-3.3.1.min.js"></script>
    <!--boot js-->
    <script src="./js/plugs/bootstrap-3.3.0-dist/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
        })
    </script>
</head>
<body>
    <!--生成导航条-->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <!--生成导航标题-->
            <div class="navbar-header">
                <div>
                    <img src="./images/logo/LOGO-17.png" class="img-responsive" alt="Responsive image" align="middle" height="46">
                </div>
                <!--<a href="" class="navbar-brand">后台管理系统</a>-->
            </div>
            <span class="titleTempSpan">OSS</span>
            <div style="float: right">
                <input class="btn btn-default" type="submit" value="登录" align="right">
            </div>
        </div>
    </nav>

    <!--栅栏系统-->
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <form action="/login" method="post">
                <div class="form-group">
                    邮箱 ：<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                </div>
                <div class="form-group">
                    密码 ：<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default" id="login">Submit</button>
            </form>
        </div>
        <div class="col-sm-3"></div>
    </div>
</body>
</html>