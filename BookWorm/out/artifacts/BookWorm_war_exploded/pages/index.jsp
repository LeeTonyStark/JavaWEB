<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

  	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  	<script src="../js/jquery-3.3.1.min.js"></script>

  	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  	<script src="../js/bootstrap.min.js"></script>

	<%--  引入自己写的js  --%>
    <script src="../js/index.js"></script>

	  <script>

		  //展示首页最新商品数据
		  $.ajax({
			  type:"POST",
			  url:"/FindAllHotGoodsLimitServlet",
			  data:"",
			  success:function (data){
				  console.log(data)
				  //将响应过来的数据通过表达式展示在页面中
				  var str1 = "";
				  for(var i = 0;i < data.length;i++){
					  str1 +=
							  '<div class="col-md-2">'+
							  '<a href="/DetailServlet?gid='+data[i].id+'"><img src="/'+ data[i].image +'" /></a>'+
							  '<p class="book_title">'+ data[i].name +'</p>'+
							  '<blockquote>'+
							  '<p class="lead" class="author">'+ data[i].author +'</p>'+
							  '</blockquote>'+
							  '<p class="price">￥' + data[i].salesprice + '</p>'+
							  '<img src="../img/star.png" class="star" />'+
							  '</div>';
				  }

				  $("#hotBook").append(str1)
			  },
			  error:function (msg){
				  alert("页面出现了错误")
			  }
		  },"json")

		  function searchGoods(){
			  var name = $("#search").val()
			  console.log(name)
			  location.href = "${pageContext.request.contextPath}/SearchGoodsListServlet?name=" + name;
		  }
	  </script>

  </head>
  <body>
	  <div class="container-fluid">
		  <div class="row">
			  <div class="col-md-2">
				  <img id="img_2" src="../img/title.jpg"/>
			  </div>
			  <div class="col-md-3">
					<h1 >BookWorm <small style="font-size: 12px;">书犹药也，善读之可以医愚</small></h1>
			  </div>
			  <div class="col-md-1">

			  </div>
			  <div class="col-md-2">
			  </div>
			  <div class="col-md-3">
				<div class="ccc">

					<c:if test="${username != null}">
					<a href="${pageContext.request.contextPath}/ShowPersonal" class="aaa"><span>个人中心</span></a>
					<a href="${pageContext.request.contextPath}/ShowPersonal" class="aaa"><span>我的订单</span></a>
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
				        <a class="navbar-brand active" href="#">首页</a>
				      </div>

				      <!-- Collect the nav links, forms, and other content for toggling -->
				      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				        <ul class="nav navbar-nav" id="mallUl">

				        </ul>
				        <form class="navbar-form navbar-right">
				          <div class="form-group">
				            <input type="text" class="form-control" placeholder="请输入书名">
				          </div>
				          <button type="button" class="btn btn-default" id="search" onclick="searchGoods()">搜索</button>
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
	  
	  <div class="container-fluid">
		  <div class="row">
			  <div class="col-md-2"></div>
			  <div class="col-md-7">
				  <h3 class="lead1">最新上架推荐</h3>
				  <hr />
			  </div>
			  <div class="col-md-3"></div>
		  </div>
	  </div>


	  <div class="container-fluid">
		  <div id="newBook" class="row">
			  <div class="col-md-2"></div>
		  </div>
	  </div>
	  <!-- 书名、作者及价格 -->
	  
	  <!-- 第二行 -->
	  
	  <div class="container-fluid" >
		  <div class="row" style="">
			  <div class="col-md-2"></div>
			  <div class="col-md-7">
				  <h3 class="lead1">热销漫画推荐</h3>
				  <hr />
			  </div>
			  <div class="col-md-3"></div>
		  </div>
	  </div>
	  
	  <div class="container-fluid">
		  <div id="hotBook" class="row">
			  <div class="col-md-2"></div>
<%--			  <div class="col-md-2">--%>
<%--				  <img src="../img/book5.png" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2">--%>
<%--				  <img src="../img/book6.png" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2">--%>
<%--				  <img src="../img/book7.png" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2">--%>
<%--				  <img src="../img/book8.png" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2"></div>--%>
		  </div>
	  </div>
	  
	  <!-- 书名、作者及价格 -->
	  
<%--	  <div class="container-fluid">--%>
<%--		  <div class="row">--%>
<%--			  <div class="col-md-2"></div>--%>
<%--			  <div class="col-md-2">--%>
<%--				  <p class="book_title">妖怪名单I</p>--%>
<%--				  <blockquote>--%>
<%--					<p class="lead" class="author">糖人家</p>--%>
<%--				  </blockquote>--%>
<%--				  <p class="price">￥9.9</p>--%>
<%--				  <img src="../img/star.png" class="star" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2">--%>
<%--				  <p class="book_title">一人之下I</p>--%>
<%--				  <blockquote>--%>
<%--					<p class="lead" class="author">动漫堂</p>--%>
<%--				  </blockquote>--%>
<%--				  <p class="price">￥9.9</p>--%>
<%--				  <img src="../img/star.png" class="star" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2">--%>
<%--				  <p class="book_title">狐妖小红娘I</p>--%>
<%--				  <blockquote>--%>
<%--					<p class="lead" class="author">小新</p>--%>
<%--				  </blockquote>--%>
<%--				  <p class="price">￥9.9</p>--%>
<%--				  <img src="../img/star.png" class="star" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2">--%>
<%--				  <p class="book_title">重生魔术师</p>--%>
<%--					<!-- <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer> -->--%>
<%--				  <blockquote>--%>
<%--					<p class="lead" class="author">谜之44栋</p>--%>
<%--				  </blockquote>--%>
<%--				  <p class="price">￥9.9</p>--%>
<%--				  <img src="../img/star.png" class="star" />--%>
<%--			  </div>--%>
<%--			  <div class="col-md-2"></div>--%>
<%--		  </div>--%>
<%--	  </div>--%>
	  
	  <!-- 第三行 -->
	  <div class="container-fluid">
		  <div class="row">
			  <div class="col-md-2"></div>
			  <div class="col-md-7">
				  <h3 class="lead1">科技文学</h3>
				  <hr />
			  </div>
			  <div class="col-md-3"></div>
		  </div>
	  </div>
	  
	  <div class="container-fluid">
		  <div class="row">
			  <div class="col-md-2"></div>
			  <div class="col-md-2">
				  <img src="../img/book9.png" />
			  </div>
			  <div class="col-md-2">
				  <img src="../img/book10.png" />
			  </div>
			  <div class="col-md-2">
				  <img src="../img/book11.png" />
			  </div>
			  <div class="col-md-2">
				  <img src="../img/book12.png" />
			  </div>
			  <div class="col-md-2"></div>
		  </div>
	  </div>
	  
	  <!-- 书名、作者及价格 -->
	  
	  <div class="container-fluid">
	  		  <div class="row">
	  			  <div class="col-md-2"></div>
	  			  <div class="col-md-2">
	  				  <p class="book_title">万物的由来（轻松涨知<br />识！闲暇时间读一读）<br></p>
	  				  <blockquote>
	  					<p class="lead" class="author">查尔斯•帕纳提 </p>
	  				  </blockquote>
	  				  <p class="price">￥9.9</p>
	  				  <img src="../img/star.png" class="star" />
	  			  </div>
	  			  <div class="col-md-2">
	  				  <p class="book_title">锻炼（我们该如何正确<br>地使用身体）</p>
	  				  <blockquote>
	  					<p class="lead" class="author">丹尼尔·利伯曼</p>
	  				  </blockquote>
	  				  <p class="price">￥9.9</p>
	  				  <img src="../img/star.png" class="star" />
	  			  </div>
	  			  <div class="col-md-2">
	  				  <p class="book_title">贪婪的多巴胺<br />&nbsp<br></p>
	  				  <blockquote>
	  					<p class="lead" class="author">迈克尔·E·朗</p>
	  				  </blockquote>
	  				  <p class="price">￥9.9</p>
	  				  <img src="../img/star.png" class="star" />
	  			  </div>
	  			  <div class="col-md-2">
	  				  <p class="book_title">小米创业思考（雷军首<br>部作品）</p>
	  				    <!-- <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer> -->
	  				  <blockquote>
	  					<p class="lead" class="author">雷军</p>
	  				  </blockquote>
	  				  <p class="price">￥9.9</p>
	  				  <img src="../img/star.png" class="star" />
	  			  </div>
	  			  <div class="col-md-2"></div>
	  		  </div>
	  </div>
	  
	  <!-- 第四行 -->
	  <div class="container-fluid">
	  		  <div class="row">
	  			  <div class="col-md-2"></div>
	  			  <div class="col-md-7">
	  				  <h3 class="lead1">病毒防御书单</h3>
	  				  <hr />
	  			  </div>
				  <div class="col-md-3"></div>
	  		  </div>
	  </div>
	  
	  <div class="container-fluid">
	  		  <div class="row">
	  			  <div class="col-md-2"></div>
	  			  <div class="col-md-2">
	  				  <img src="../img/book13.png" />
	  			  </div>
	  			  <div class="col-md-2">
	  				  <img src="../img/book14.png" />
	  			  </div>
	  			  <div class="col-md-2">
	  				  <img src="../img/book15.png" />
	  			  </div>
	  			  <div class="col-md-2">
	  			  	  <img src="../img/book16.png" />
	  			  </div>
	  			  <div class="col-md-2"></div>
	  		  </div>
	  </div>
	  
	  <!-- 书名、作者及价格 -->
	  
	  <div class="container-fluid">
		  <div class="row">
			  <div class="col-md-2"></div>
			  <div class="col-md-2">
				  <p class="book_title">中国疫苗百年纪实（下）<br /><br></p>
				  <blockquote>
					<p class="lead" class="author">江永红</p>
				  </blockquote>
				  <p class="price">￥9.9</p>
				  <img src="../img/star.png" class="star" />
			  </div>
			  <div class="col-md-2">
				  <p class="book_title">抗击新型冠状病毒，实<br>用心理防护手册</p>
				  <blockquote>
					<p class="lead" class="author">胡文婷</p>
				  </blockquote>
				  <p class="price">￥9.9</p>
				  <img src="../img/star.png" class="star" />
			  </div>
			  <div class="col-md-2">
				  <p class="book_title">新型冠状病毒感染的肺<br/>炎防控知识120</p>
				  <blockquote>
					<p class="lead" class="author">疾病预防控制中心</p>
				  </blockquote>
				  <p class="price">￥9.9</p>
				  <img src="../img/star.png" class="star" />
			  </div>
			  <div class="col-md-2">
				  <p class="book_title">新型冠状病毒预防绘本<br>&nbsp</p>
					<!-- <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer> -->
				  <blockquote>
					<p class="lead" class="author">卫生健康委员会</p>
				  </blockquote>
				  <p class="price">￥9.9</p>
				  <img src="../img/star.png" class="star" />
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
