<%--
  Created by IntelliJ IDEA.
  User: Ditta
  Date: 2022/9/26
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>详情页</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/detail.css">

    <script type="text/javascript">
        function addCart(){

            //获取前台的数据
            var goodsid = $("#cart_goodsid").html()
            var price = $("#cart_price").html()
            var nums = $("#nums").val()

            console.log(goodsid + "..." + price + "..." + nums)

            //发送ajax请求，将前台数据传入后台
            $.ajax({
                type:"GET",
                url:"/AddCartServlet",
                data:"goodsid=" + goodsid + "&price=" + price + "&nums=" + nums,
                success:function (data){
                    alert(data)
                },
                error:function (msg){
                    alert("页面出现了错误")
                }
            },"json")
        }
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
						<div style="width: 144px;height: 26px;margin-top: 30px">
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

<div class="container-fluid" style="font-size: 20px;">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.jsp">首页</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">动漫<span class="sr-only">(current)</span></a></li>
                            <li><a href="#">文学</a></li>
                            <li><a href="#">历史</a></li>
                            <li><a href="#">哲学</a></li>
                            <li><a href="#">教育</a></li>
                            <li><a href="#">艺术与摄影</a></li>
                            <li><a href="#">烹饪与美食</a></li>
                            <li><a href="#">科技</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">电子书<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">文学</a></li>
                                    <li><a href="#">经济管理</a></li>
                                    <li><a href="#">人文社科</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">漫画</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="https://www.jiumodiary.com/">点击搜索更多</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="请输入书名">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>

                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-3">
                <div style="width: 325px;height: 434px;margin-left: 41px;margin-top: 24px">
                    <img style="width: 325px;height: 434px" src="${pageContext.request.contextPath}/${detailGoods.image}" />
                </div>
            </div>
            <%--        <div class="col-md-1"></div>--%>
            <div class="col-md-7" style="margin-left: -50px">

                <%--  提供1个隐藏域，存放商品id  --%>
                <div hidden id="cart_goodsid">${detailGoods.id}</div>

                <div class="well">
                    <h1>${detailGoods.name}</h1>
                    <hr />
                    <img src="../img/fenxiang.png" />
                    <div class="text_p">
                        <p style="color: black; font-size: 18px;" class="lead">销售价：¥<span style="color: #FF0000; font-size: 30px;" id="cart_price">${detailGoods.salesprice}</span></p>
                        <p style="color: black; font-size: 18px;" class="lead">市场价：<del>¥${detailGoods.marketprice}</del></p>
                        <p style="color: black; font-size: 18px;" class="lead">作者： ${detailGoods.author}</p>
                        <p style="color: black; font-size: 18px;" class="lead">出版社：${detailGoods.publisher}</p>
                        <p style="color: black; font-size: 18px;" class="lead">出版时间：${detailGoods.pubtime}</p>
                        <p style="color: black; font-size: 18px;" class="lead">库存：现货(${detailGoods.stock})</p>
                        <p style="line-height: 5px;color: black; font-size: 18px;" class="lead">顾客评分：☆☆☆☆☆(已有0人评价)</p>
                    </div>
                    <div class="alert alert-warning alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>提示:</strong> 请输入商品数量
                    </div>
                        <div class="input-append spinner text-center" data-trigger="spinner">
                            <span>购买数量为:</span><input type="text" value="1" data-rule="quantity" id="nums">
                            <div class="add-on">
                                <a href="javascript:;" class="spin-up" data-spin="up"><i class="icon-sort-up"></i></a>
                                <a href="javascript:;" class="spin-down" data-spin="down"><i class="icon-sort-down"></i></a>
                            </div>
                        </div>
                </div>

                <!-- 购买和加入购物车按钮 -->
                <div class="text_p2"></div>
                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default" onclick="buy()"><img src="../img/cart.png" style="width:8%;height:8%;float: left;"></img><h4 style="color: red;"><strong>立即购买</strong></h4></button>
                    </div>
                    <!-- <div class="btn-group" role="group">
                      <button type="button" class="btn btn-default"></button>
                    </div> -->



                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default" onclick="addCart()"><img src="../img/cart.png" style="width:8%;height:8%;float: left;"></img><h4 style="color: blue;"><strong>加入购物车</strong></h4></button>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>

    </div>
</div>
<div style="margin-top: 40px;"></div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-6">
            <hr />
            <div style="margin-left: -30px;">
                <p style="font-size:18px;line-height: 45px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${detailGoods.description}</p>
            </div>
            <hr />
        </div>
        <div class="col-md-1"></div>
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

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="../js/jquery-3.3.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="../js/bootstrap.min.js"></script>

</body>
</html>


