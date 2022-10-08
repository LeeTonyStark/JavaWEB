<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>个人中心</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/personal.css">
	<link rel="stylesheet" href="../css/css_fileinput.min.css"/>

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
						<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/index.jsp">首页</a>
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
	 
	 <!-- 个人中心主体 -->
	 <div class="container-fluid">
		 <div class="row">
			 <div class="col-md-1"></div>
			 <div class="col-md-2">
				 <button type="button" class="btn btn-primary btn-block"><span class="span1">会员中心</span></button>
				 <hr />
				 
				 <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				   <div class="panel panel-default">
				     <div class="panel-heading" role="tab" id="headingOne">
				       <h4 class="panel-title">
				         <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				           <p class="p1">交易记录</p>
				         </a>
				       </h4>
				     </div>
				     <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				       <div class="list-group">
						   <div class="div1">
							   <a href="personal_order.jsp"><p class="p2">我的订单</p></a>
						   </div>
				       </div>
				     </div>
				   </div>
				   <div class="panel panel-default">
				     <div class="panel-heading" role="tab" id="headingTwo">
				       <h4 class="panel-title">
				         <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				           <p class="p1">个人设置</p>
				         </a>
				       </h4>
				     </div>
				     <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
				       <div class="list-group">
						   <div class="div1">
							   <a href="personal_address.jsp"><p class="p2">地址管理</p></a>
						   </div>
				       </div>
					   
					   <div class="list-group">
						   <div class="div1">
							   <a href="personal_headimage.jsp"><p class="p2">修改头像</p></a>
						   </div>
					   </div>
					   
					   <div class="list-group">
						   <div class="div1">
							   <a href="personal_password.jsp"><p class="p2">修改密码</p></a>
						   </div>
					   </div>
					   
				     </div>
				   </div>
				 </div>
				 
			 </div>
			 <div class="col-md-8">
				<div class="panel panel-default">
				  <div class="panel-heading">
					 <span>您好,zhangsan!欢迎回来!</span>
				  </div>
				  
				  <div class="container-fluid">
					  <div class="row">
						  <div class="col-md-2">
							  <p class="p3"><strong>用户信息</strong></p>
						  </div>
						  <div class="col-md-9"></div>
						  <div class="col-md-1"></div>
					  </div>
					  <div class="row">
						  <div class="col-md-2">
							  
							<div>
								<div style="position: relative;border: 5px solid lightblue;width: 150px;height:150px;margin: 5px auto;border-radius: 50%;">
									<img src="../img/person.jpg" alt="选择并上传头像" id="avatar_img"
										 style="width: 140px;height: 140px;left:0;top: 0;border-radius: 50%;"/>
									<input type="file" id="avatar_file" name="avatar_file"
										   accept="image/jpg,image/png,image/gif"
										   style="width: 100%;height:100%;opacity: 0;position: absolute;left:0;top: 0;"/>
								</div>
								<br/>
							</div>
	
						  </div>
						  <div class="col-md-9">
							  <table class="table">
								  <tr>
									  <td>
										  <span>你的订单交易总数量:&nbsp;2&nbsp;笔</span>
									  </td>
									  <td colspan="2">
										  <span><a href="personal_order.jsp">进入订单列表</a></span>
									  </td>
								  </tr>
								  <tr>
									  <td colspan="2"><span>总消费额:￥2040.00</span></td>
								  </tr>
								  <tr>
									  <td colspan="3">
										  <div class="panel panel-default">
										    <div class="panel-heading">
												<span class="span2">待评价商品:(1)</span>
												<span class="span2">待付款订单:(0)</span>
												<span class="span2">待确认收货:(1)</span>
										    </div>
										  </div>
									  </td>
								  </tr>
							  </table>
						  </div>
						  <div class="col-md-1"></div>
					  </div>
				  </div>
				</div>
				
				 <div class="row">
					 <div class="col-md-12">
						 <br />
						 <hr />
						 
						 <div >
							 <p><strong>我的订单</strong></p>
						 </div>
					 </div>
				 </div>
				 
				 <div class="row">
					 <div class="col-md-12">
						 <table class="table table-striped table1 table-hover">
							 <tr>
								 <th>订单编号</th>
								 <th>下单日期</th>
								 <th>收货人</th>
								 <th>支付方式</th>
								 <th>总金额</th>
								 <th>订单状态</th>
							 </tr>
							 <c:forEach items="${personalOrderList}" var="orderlist">
								 <tr>
									 <td>${orderlist.orderno}</td>
									 <td>${orderlist.ordertime}</td>
									 <td>${orderlist.accept}</td>
									 <td>支付宝</td>
									 <td>￥<span style="color: red">${orderlist.money}</span></td>
									 <c:if test="${orderlist.status == '0'}">
										 <td><span style="color: red">待付款</span></td>
									 </c:if>
									 <c:if test="${orderlist.status == '1'}">
										 <td><span style="color: green">已完成</span></td>
									 </c:if>

								 </tr>
							 </c:forEach>


<%--							 <tr>--%>
<%--								 <td>WN1577852277544477845</td>--%>
<%--								 <td>2022-9-11 18:04:14</td>--%>
<%--								 <td>peiqi</td>--%>
<%--								 <td>货到付款</td>--%>
<%--								 <td>99.8</td>--%>
<%--								 <td>待付款</td>--%>
<%--							 </tr>--%>
							 <tr>
								 <td></td>
								 <td></td>
								 <td></td>
								 <td></td>
								 <td></td>
								 <td><a href="personal_order.jsp">更多订单>></a></td>
							 </tr>
						 </table>
					 </div>
				 </div>
				 
			 </div>
			 <div class="col-md-1"></div>
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
	  
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-1.11.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../js/bootstrap.min.js"></script>
	<script src="../js/js_fileinput.min.js"></script>
	<script src="../js/js_locales_zh.js"></script>
	<script src="../js/personal.js"></script>
  </body>
</html>
