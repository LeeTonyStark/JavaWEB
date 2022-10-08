<%--
  Created by IntelliJ IDEA.
  User: Ditta
  Date: 2022/9/24
  Time: 17:10
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
    <link rel="stylesheet" href="../css/mall_index.css" />
    <!-- Bootstrap -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <%--  引入js  --%>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-1.11.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.min.js"></script>
    <%--  jquery  --%>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <%--  引入获取参数js  --%>
    <script src="${pageContext.request.contextPath}/js/getParam.js"></script>

    <style rel="stylesheet">
        .mainDiv{
            width: 260px;
            height: 475px;
            float: left;
            margin-top: 20px;
        }

        li{
            list-style: none;
        }

        .book_title{
            max-width: 240px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }

    </style>

    <script>
        <%--var cid = getParam.cid;--%>

        <%--function firstPage(){--%>
        <%--    location.href = "${pageContext.request.contextPath}/GoodsListServlet?cid="+ cid +"&pageNo=1";--%>
        <%--}--%>

        <%--function lastPage(){--%>
        <%--    var total = $("#total").text()--%>
        <%--    location.href = "${pageContext.request.contextPath}/GoodsListServlet?cid="+ cid +"&pageNo="+ total;--%>
        <%--}--%>

        <%--function assignPage(num){--%>
        <%--    location.href = "${pageContext.request.contextPath}/GoodsListServlet?cid="+ cid +"&pageNo="+ num;--%>
        <%--}--%>
    </script>


</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <img id="img_2" src="../img/title.jpg"/>
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
                <a href="${pageContext.request.contextPath}/pages/personal.jsp" class="aaa"><span>个人中心</span></a>
                <a href="${pageContext.request.contextPath}/pages/personal_order.jsp" class="aaa"><span>我的订单</span></a>
                <c:if test="${username != null}">
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
        <div class="col-md-1">

        </div>
    </div>
</div>

<hr/>

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
                        <a class="navbar-brand" href="/index.jsp">首页</a>
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

<!-- <hr/> -->

<!-- 第一行最热推荐图书 -->

<!-- <iframe src="personal_order.jsp" frameborder="0"></iframe> -->
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-11">
            <h3 class="lead1">商品列表</h3>
            <hr />
        </div>
    </div>
</div>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-2">
            <h3 align="center">排行榜</h3>
            <div>
                <ul class="list-group">
<%--                    <c:forEach begin="1" items="${pageBean.list}" end="10" var="goods">--%>
<%--                        <li class="list-group-item">Name：<span class="badge" style="color:red;background:lightcoral;">${goods.name}</span></li>--%>
<%--                    </c:forEach>--%>
                    <li class="list-group-item">Name：<span class="badge" style="color:red;background:lightcoral;">1</span></li>
                        <li class="list-group-item">Name：<span class="badge" style="color:green;background:lightgreen;">2</span></li>
                        <li class="list-group-item">Name：<span class="badge" style="color:red;background:lightsalmon;">3</span></li>
                        <li class="list-group-item">Name：<span class="badge" style="color:green;background:pink;">4</span></li>
                        <li class="list-group-item">Name：<span class="badge" style="color:green;background:lightblue;">5</span></li>
                        <li class="list-group-item">Name：<span class="badge" style="color:red;background:lightgray;">6</span></li>
                        <li class="list-group-item">Name：<span class="badge" style="color:green;background:lightseagreen;">7</span></li>
                        <li class="list-group-item">Name：<span class="badge" style="color:green;background:lightsalmon;">8</span></li>
                </ul>
            </div>
        </div>
        <div class="col-md-8">
            <ul id="goodsList">
                <c:forEach items="${pageInfo.list}" var="pa">
                    <li>
                        <div class="mainDiv">
                            <a href="detail.html"><img src="${pa.image}" /></a>
                            <p class="book_title">${pa.name}</p>
                            <blockquote>
                                <p class="lead book_title" class="author">${pa.author}</p>
                            </blockquote>
                            <p class="price">￥${pa.salesprice}</p>
                            <img src="../img/star.png" class="star" /><br>
                            <div class="mainDiv_btn">
                                <button class="btn btn-danger">加入购物车</button>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>

        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<!--	分页  -->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-8">
<%--            <ul class="pagination pagination-lg" id="paging">--%>
<%--                <li><a href="${pageContext.request.contextPath}/GoodsListServlet?cid=">首页</a></li>--%>
<%--                <c:forEach begin="1" end="${pageInfo.pages}" var="num">--%>
<%--                <li><a href="#">${num}</a></li>--%>
<%--                </c:forEach>--%>
<%--                <li><a href="#">尾页</a></li>--%>
<%--                <span>当前第<span>${pageInfo.pageNo}</span>页/共<span id="total">${pageInfo.pages}</span>页</span>--%>

<%--            </ul>--%>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>


<!-- 固定定位的购物车 -->
<div style="width: 50px;height: 50px;position:fixed;top: 340px;right: 0;">
    <a href="success.jsp"><img src="../img/cart.png" style="width:100%;height:100%;"></img></a>
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

