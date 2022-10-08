<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: Ditta
  Date: 2022/9/27
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/cart.css">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-1.11.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/cart.js"></script>

    <script>
        $(function (){
            var sumprice = $("sumprice")
            for (var i = 0; i < sumprice.length; i++) {
                console.log(sumprice[i])
            }
            var sum = $("#sumprice").text()
            // console.log(sum)
        })
    </script>

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-3">
            <h1>BookWorm <small style="font-size: 12px;">书犹药也，善读之可以医愚</small></h1>
        </div>
        <div class="col-md-1">

        </div>
        <div class="col-md-2">

        </div>
        <div class="col-md-3">
            <div class="ccc">
					<c:if test="${username != null}">
					<a href="${pageContext.request.contextPath}/pages/personal.jsp" class="aaa"><span>个人中心</span></a>
					<a href="${pageContext.request.contextPath}/pages/personal_order.jsp" class="aaa"><span>我的订单</span></a>
						<div style="width: 150px;height: 26px;margin-top: 30px">
							<span style="color: red">尊敬的${username}您好！</span>
						</div>
							<span style="width: 54px;height: 34px; margin-top: 30px"><a href="${pageContext.request.contextPath}/quitServlet"><button class="btn btn-default">注销</button></a></span>

					</c:if>
					<c:if test="${username == null}">
						<a href="${pageContext.request.contextPath}/pages/Login.jsp" class="aaa"><span>登录</span></a>
						<a href="${pageContext.request.contextPath}/pages/Register.jsp" class="aaa"><span>免费注册</span></a>
					</c:if>
				</div>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<hr/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">

            <p>您当前的位置：首页 >> 购物车</p>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <p style="font-size: 16px;">查看购物车</p>
                </div>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">

                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-1" style="text-align: center;">
                                <input type="checkbox" name="aaa" onclick="selectAll()"/>全选
                            </div>
                            <div class="col-md-2" style="text-align: center;">
                                图片
                            </div>
                            <div class="col-md-4" style="text-align: center;">
                                商品名称
                            </div>
                            <div class="col-md-1" style="text-align: center;">
                                单价
                            </div>
                            <div class="col-md-1" style="text-align: center;">
                                数量
                            </div>
                            <div class="col-md-1" style="text-align: center;">
                                小计
                            </div>
                            <div class="col-md-2" style="text-align: center;">
                                操作
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="container-fluid">
                        <c:forEach items="${cartList}" var="cart">
                            <div class="row">
                                <div class="col-md-1" style="text-align: center;">
                                    <div class="div3">
                                        <input type="checkbox" name="aaa"/>
                                    </div>
                                </div>
                                <div class="col-md-2" style="text-align: center;">
                                    <img class="img2" src="${pageContext.request.contextPath}/${cart.goods.image}"/>
                                </div>
                                <div class="col-md-4" style="text: a;lign: center;">
                                    <div class="div3">
                                        ${cart.goods.name}
                                    </div>
                                </div>
                                <div class="col-md-1" style="text-align: center;">
                                    <span class="div3">
                                        <span style="color: #0f0f0f;font-size: 15px">￥${cart.goods.salesprice}</span>
                                    </span>
                                </div>
                                <div class="col-md-1" style="text-align: center;">
                                    <div class="div3">
                                        ${cart.nums}
                                    </div>
                                </div>
                                <div class="col-md-1" style="text-align: center;">
                                    <div class="div3">
                                        ￥<span style="color: red;" class="sumprice">${cart.price}</span>
                                    </div>
                                </div>
                                <div class="col-md-2" style="text-align: center;">
                                    <div class="div3">
                                        删除
                                    </div>
                                </div>
                            </div>

                            <hr />

                        </c:forEach>
c
                        <hr />

                    </div>
                </div>

                <!-- 金额总计 -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="div4">
                            <p>金额总计(不含运费):￥<span style="color: red;" id="sumprice">${sumprice}</span></p>
                        </div>
                    </div>
                </div>

                <!-- 两个继续购物和结算按钮 -->
                <div class="div5">
                    <button type="button" class="btn btn-success" style="font-size: 18px;"><a href="index.jsp"><span>继续购物</span></a></button>
                    <button type="button" class="btn btn-danger" style="font-size: 18px;"><a href="${pageContext.request.contextPath}/PayDetailServlet?userid=${user.id}"><span>结算</span></a></button>
                </div>

            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<div class="container-fluid" >
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">

            <!-- 热门商品推荐 -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div>
                        <p style="font-size:20px;color:#ff9d26">热门商品推荐</p>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<!-- 热门图书展示 -->
<div class="container-fluid" >
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-2">
            <img class="img3" src="../img/book7.png"/>
        </div>
        <div class="col-md-2">
            <img class="img3" src="../img/book8.png"/>
        </div>
        <div class="col-md-2">
            <img class="img3" src="../img/book9.png"/>
        </div>
        <div class="col-md-2">
            <img class="img3" src="../img/book10.png"/>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<!-- 固定定位的购物车 -->
<div style="width: 50px;height: 50px;position:fixed;top: 340px;right: 0;">
    <a href="${pageContext.request.contextPath}/LookCartServlet"><img src="../img/cart.png" style="width:100%;height:100%;"></img></a>
</div>

<!-- 回到顶部 -->
<div class="container-fluid" id="hind">
    <div clsaa="row">
        <div class="col-md-12">
            <a href="#"><p id="pid">回到顶部</p></a>
        </div>
    </div>
</div>

<!-- 页脚 -->
<div class="container-fluid" id="hind1">
    <div clsaa="row">
        <div class="col-md-12">
            <div class="container" id="hind1_1">
                <div class="row" id="hind1_2">
                    <div class="col-md-2"></div>
                    <div class="col-md-2">了解我们</div>
                    <div class="col-md-2">合作信息</div>
                    <div class="col-md-2">帮助中心与购物指南</div>
                    <div class="col-md-2">亚马逊App下载</div>
                    <div class="col-md-2"></div>
                </div>
                <div class="row" id="hind1_3">
                    <div class="col-md-2"></div>
                    <div class="col-md-2">人才招聘</div>
                    <div class="col-md-2">我要开店</div>
                    <div class="col-md-2">付款与退款</div>
                    <div class="col-md-2">IOS</div>
                    <div class="col-md-2"></div>
                </div>
                <div class="row" id="hind1_4">
                    <div class="col-md-2"></div>
                    <div class="col-md-2">亚马逊科学</div>
                    <div class="col-md-2">加入联盟</div>
                    <div class="col-md-2">退货与换货</div>
                    <div class="col-md-2">Android</div>
                    <div class="col-md-2"></div>
                </div>
                <div class="row" id="hind1_5">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2">帮助中心</div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2"></div>
                </div>
            </div>
        </div>
    </div>
</div>



</body>
</html>

