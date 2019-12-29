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
</head>
<body>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <form action="/register" method="post">
                <div class="form-group">
                    登录名 ：<input type="text" class="form-control" placeholder="loginName" name="loginName">
                </div>
                <div class="form-group">
                    密码 ：<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="shaPassword">
                </div>
                <div class="form-group">
                    用户名 ：<input type="text" class="form-control" id="exampleInputName1" placeholder="Name" name="name">
                </div>
                <div class="form-group">
                    邮箱 ：<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" name="email">
                </div>
                <div class="form-group">
                    出生年月 ：<input type="date" class="form-control" id="exampleInputBirthday1" placeholder="Birthday" name="birthday">
                </div>
                <div class="form-group">
                    最高学历 ： <select name="eduQuali">
                                    <option value="1" selected="selected">博士</option>
                                    <option value="2">硕士</option>
                                    <option value="3">本科</option>
                                    <option value="4">专科</option>
                                    <option value="5">高中</option>
                                    <option value="6">其他</option>
                                </select>
                </div>
                <div class="form-group">
                    性别 ： <select name="sex">
                                <option selected="selected">男</option>
                                <option>女</option>
                                <option>其他</option>
                            </select>
                </div>
                <div class="form-group">
                    联系方式 ：<input type="text" class="form-control" id="exampleInputCellphone1" placeholder="cellphone" name="cellphone">
                </div>
                <button type="reset" class="btn btn-default">取消</button>
                <button type="submit" class="btn btn-default" id="login">提交</button>
            </form>
        </div>
        <div class="col-sm-3"></div>
    </div>
</body>
</html>