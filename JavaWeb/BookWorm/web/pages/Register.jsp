<%--
  Created by IntelliJ IDEA.
  User: Ditta
  Date: 2022/9/23
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Register</title>

    <!--用百度的静态资源库的cdn安装bootstrap环境-->
    <!-- Bootstrap 核心 CSS 文件 -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>


    <!--为了保险起见，导入了本地的jquery和fontawesome    -->
    <!--jquery-->
    <!-- <script type="text/javascript" src="js/jquery.validate.min.js" ></script> -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="../css/Login.css">
    <!--font-awesome    -->
    <!-- <link rel="stylesheet" href="font-awesome-4\7\0\css\font-awesome.min.css"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!--    引入外部js    -->
<%--    <link rel="stylesheet" href="../js/Register.js">--%>

    <script type="text/javascript">

        //用户名查重
        function usernameOnblur(){
            var inputs = $("#username")
            //发送ajax请求
            $.ajax({
                type:"POST",
                url:"/FindUserByUsernameServlet",
                data:"username=" + inputs.val(),
                success:function (data) {
                    $("#span_uname").html(data)
                },
                error:function (msg) {
                    alert("数据出现了错误")
                }
            })
        }

        //用户名正则校验

        //密码正则校验

        //确认密码校验
        function resetpassword(){
            //获取第一个密码框的内容，与确认密码框进行比对
            var password = $("#password").val()
            var resetpw = $("#resetpw").val()
            if (password == resetpw){
                $("#span_resetpw").html("<font style='color: greenyellow;'>确认密码正确</font>")
            }else {
                $("#span_resetpw").html("<font style='color: red;'>输入有误，请再次输入</font>")
            }
        }

        //刷新验证码
        function imgcode(){
            $("#imgcode").attr("src","${pageContext.request.contextPath}/checkCodeServlet?data=" + new Date().getTime())
        }

        //发送ajax请求获取图片验证码
        function getCheckValue(){
            $.ajax({
                type:"POST",
                url:"/getCheckCode",
                data:"",
                success:function (data){
                    if (data != null && data == $("#vcode").val()){
                        $("#span_vcode").html("<font style='color: greenyellow;'>验证码正确</font>")
                    }else {
                        $("#span_vcode").html("<font style='color: red;'>验证码错误，请重新输入</font>")
                    }
                },
                error:function (msg){
                    alert("页面出现了错误")
                }
            },"json")
        }

        //注册表单提交
        function resist() {
            //注册前先验证五个输入框是否都正确
            return true;
        }

    </script>

</head>
<body>
<div class="container">
    <div class="form row">
        <form class="form-horizontal col-sm-offset col-md-offset-3" action="${pageContext.request.contextPath}/RegisterServlet" onsubmit="return resist()">
            <h3 class="form-title">注册</h3>
            <div class="col-sm-9 col-md-9">
                <div class="form-group">
                <!-- 用户名图标和用户名输入框  -->
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <span id="span_uname" class="span666"></span>
                    <input class="form-control required" type="text" name="username" id="username" placeholder="请输入用户名" required="required" onblur="usernameOnblur()" />
                </div>
                <!-- 密码图标和密码输入框  -->
                <div class="form-group">
                    <i class="fa fa-key" aria-hidden="true"></i>
                    <span id="span_pword" class="span666" style="color: red"></span>
                    <input class="form-control required" type="password" name="password" id="password" placeholder="请输入密码" required />
                </div>
                <!-- 确认密码  -->
                <div class="form-group">
                    <span id="span_querenpwd"></span>
                    <i class="fa fa-check-circle-o" aria-hidden="true"></i>
                    <span id="span_resetpw" class="span666"></span>
                    <input class="form-control required" type="password" id="resetpw" placeholder="请确认密码" required onblur="resetpassword()">
                </div>
                <!--  邮箱  -->
                <div class="form-group">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                    <span id="span_email" class="span666"></span>
                    <input class="form-control required" type="email" name="email" id="email" placeholder="请输入邮箱" required>
                </div>

                <div class="form-group">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                    <span id="span_vcode" class="span666"></span>
                    <input class="form-control required" type="text" name="code" id="vcode" placeholder="验证码" required onblur="getCheckValue()">
                    <img src='${pageContext.request.contextPath}/checkCodeServlet' id="imgcode"/>
                    <span>看不清?</span><span><a href="#" onclick="imgcode()">换一个</a></span>
                </div>

                <!--注册按钮-->
                <div class="form-group">
                    <input type="submit" value="注册" class="btn btn-success pull-right">
                    <a href="index.jsp"><input type="button" class="btn btn-info pull-left" id="back_btn" value="返回"/></a>
                </div>

            </div>
        </form>
    </div>
</div>
</body>
</html>

