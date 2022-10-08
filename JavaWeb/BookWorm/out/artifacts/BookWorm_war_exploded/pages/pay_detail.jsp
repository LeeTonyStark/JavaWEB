<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>核对订单信息</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/pay_detail.css">

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
			  <div class="col-md-1"></div>
		  </div>
	  </div>
	  
	  <hr/>
	  
	  <div class="container-fluid">
		  <div class="row">
			  <div class="col-md-2"></div>
			  <div class="col-md-8">
				  
				  <p>您当前的位置：首页 >> 填写核对订单信息</p>
				  <div class="panel panel-default">
				    <div class="panel-heading">
						<span><strong>填写核对订单信息</strong></span>
					</div>
					
					<div class="panel-body">
					  <div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								
							<hr />
							<blockquote>
								<p>收货人信息</p>
							</blockquote>
							<table class="table table-hover">
							  <tr class="info">
								  <td colspan="3">
									  <span>常用收货地址</span>
								  </td>
							  </tr>
								<c:forEach items="${allAddress}" var="address">
									<tr>
										<td>
											<input type="radio" name="radio" />&nbsp;&nbsp;&nbsp;<span>${address.accept}</span>
										</td>
										<td><span>${address.telphone}</span></td>
										<td><span>${address.province}${address.city}${address.area}</span></td>
									</tr>
								</c:forEach>


<%--							  <tr>--%>
<%--								  <td>--%>
<%--									 <input type="radio" name="radio" />&nbsp;&nbsp;&nbsp;<span>lisi</span>--%>
<%--								  </td>--%>
<%--								  <td><span>13514857753</span></td>--%>
<%--								  <td><span>四川 成都市 青羊区 清江东路1号</span></td>--%>
<%--							  </tr>--%>

							</table>
							
							
							<hr />
							<blockquote>
								<p>支付方式</p>
							</blockquote>
							<table class="table table-hover">
							  <tr>
								  <td>
									 <input type="radio" name="radio" checked value="1" />&nbsp;&nbsp;&nbsp;<span>支付宝</span>
								  </td>
								  <td><span>支付手续费￥0.0</span></td>
							  </tr>
<%--							  <tr>--%>
<%--								  <td>--%>
<%--									 <input type="radio" name="radio" />&nbsp;&nbsp;&nbsp;<span>货到付款</span>--%>
<%--								  </td>--%>
<%--								  <td><span>支付手续费￥0.0</span></td>--%>
<%--							  </tr>--%>
							</table>

							<hr />
							<blockquote>
								<p>购买的商品</p>
							</blockquote>
							<table class="table table-hover">
							  <tr class="info">
								  <td class="td1">
									 <span>图片</span>
								  </td>
								  <td colspan="2" class="td1"><span>商品名称</span></td>
								  <td class="td1"><span>单价</span></td>
								  <td class="td1"><span>数量</span></td>
								  <td class="td1"><span>小计</span></td>
							  </tr>
								<c:forEach items="${cartList}" var="cart">
								  <tr>
									  <td class="td1">
										  <img class="img1" src="${pageContext.request.contextPath}/${cart.goods.image}" />
									  </td>
									  <td colspan="2" class="td1">
										  <div class="div1">
											  <span>${cart.goods.name}</span>
										  </div>
									  </td>
									  <td class="td1">
										  <div class="div1">
											  <span>￥${cart.goods.salesprice}</span>
										  </div>
									  </td>
									  <td class="td1">
										  <div class="div1">
											  <span>${cart.nums}</span>
										  </div>
									  </td>
									  <td class="td1">
										  <div class="div1">
											  <span>￥${cart.price}</span>
										  </div>
									  </td>
							  		</tr>
								</c:forEach>
							</table>
						
							  </div>
						   </div>

					  </div>
					</div>
				  </div>
				  
				  <div class="panel panel-default">
					  
				    <div class="panel-heading">
						<span><strong>结算信息</strong></span>
					</div>
					<div class="div3">
					  <p>商品总金额：<span style="color: red;">${sumprice}</span> + 运费总计 <span style="color: red">0.0</span>元</p>
					  <p class="text-right">应付总额:￥<span style="color: red;">${sumprice}</span>元</p>
					</div> 
				  </div>
				  
					<div class="div2">
						<button type="button" class="btn btn-danger"><a href="${pageContext.request.contextPath}/OrderInfoServlet"><span class="span1">确认无误，提交订单</span></a></button>
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
	  </div>
  </body>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-1.11.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.min.js"></script>

</html>
