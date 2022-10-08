<%--
  Created by IntelliJ IDEA.
  User: Ditta
  Date: 2022/9/26
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮箱激活</title>
</head>

<!-- Bootstrap -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="../js/jquery-3.3.1.min.js"></script>

<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="../js/bootstrap.min.js"></script>

<%--  引入自己写的js  --%>
<script src="../js/index.js"></script>

<style rel="stylesheet">
    .progress{
        width: 910px;
        height: 20px;
        margin-top: 70px;
        margin-bottom: 50px;
    }
</style>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="progress">
                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                        <span class="sr-only">50% Complete (danger)</span>
                    </div>
                </div>

                <div class="jumbotron">
                    <h1>注册成功!请到邮箱内进行激活</h1>
                    <p>点击下方按钮</p>
                    <p><a class="btn btn-primary btn-lg" href="https://wx.mail.qq.com" role="button">跳转到邮箱</a></p>
                </div>

            </div>
        </div>
    </div>

</body>
</html>
