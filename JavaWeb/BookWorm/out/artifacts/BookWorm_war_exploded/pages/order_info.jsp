<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>订单支付界面</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/order_info.css">
  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="../js/jquery-1.11.0.min.js"></script>
  <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  <script src="../js/bootstrap.min.js"></script>

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
				  
				<div class="panel panel-default">
				  <div class="panel-heading">
					 <span>成功提交订单</span>
				  </div>
				  
				  <div class="container-fluid">
					  <div class="row">
						  <div class="col-md-1"></div>
						  <div class="col-md-10">
							  <img src="../img/success.png"/>
						  </div>
						  <div class="col-md-1"></div>
					  </div>
				  </div>
				  
				  <div class="container-fluid">
					  <div class="row">
						  <div class="col-md-1"></div>
						  <div class="col-md-10">
							  <span>订单已提交</span>
							  <hr />
							  
							  
							  <div class="container-fluid">
								  <div class="row">
									  <div class="col-md-1"></div>

									  <div class="col-md-10">
										  <span>订单信息</span>
											  <table class="table table-hover">
												  <tr>
													  <td>
														  <span>订单编号:</span>
														  <span style="color: red;">${payOrder.orderno}</span>
													  </td>
												  </tr>
												  <tr>
													  <td>
														  <span>订单金额:</span>
														  ￥<span style="color: red;">${payOrder.money}</span>
													  </td>
												  </tr>
												  <tr>
													  <td>
														  <span>支付方式:</span>
														  <span>支付宝</span>
													  </td>
												  </tr>
											  </table>

										  <div class="div3">
											  <form action="${pageContext.request.contextPath}/OrderPayServlet" method="post">
<%--											  <form action="${pageContext.request.contextPath}/alipay/alipay.trade.page.pay.jsp" method="post">--%>
													<%--  WIDout_trade_no:订单编号  --%>
													<%--  WIDtotal_amount:付款金额  --%>
												  <input type="hidden" name="WIDout_trade_no" value="${payOrder.orderno}"/>
												  <input type="hidden" name="WIDtotal_amount" value="${payOrder.money}"/>
												  <button type="submit" class="btn btn-danger"><span class="span1">立即支付</span></button>
											  </form>
										  </div>
										  
										  <br />

									  </div>
									  <div class="col-md-1"></div>
								  </div>
							  </div>
							  
							  
						  </div>
						  <div class="col-md-1"></div>
					  </div>	
				  </div>
				  
				</div>
				
			 <div class="col-md-2"></div>
		  </div>
	  </div>
	  
	  <!-- 固定定位的购物车 -->
	  <div style="width: 50px;height: 50px;position:fixed;top: 340px;right: 0;">
		  <a href="success.jsp"><img src="../img/cart.png" style="width:100%;height:100%;"></img></a>
	  </div>
	  
	  <!-- 回到顶部 -->
	  <!-- <div class="container-fluid" id="hind">
		  <div clsaa="row">
			  <div class="col-md-12">
				  <a href="#"><p id="pid">回到顶部</p></a>
			  </div>
		  </div>
	  </div> -->
	  
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


</html>
