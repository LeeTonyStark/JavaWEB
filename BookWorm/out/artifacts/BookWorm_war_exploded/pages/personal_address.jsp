<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="../css/personal_address.css">
	<script src="../js/province.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-3.3.1.min.js"></script>
  	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
  	<script src="../js/bootstrap.min.js"></script>
  	<script src="../js/address.js"></script>

	  <script>

		  function save(){
			  var accept = $("#accept").val()//收件人
			  var shen = $("#province option:selected").text()//省
			  $("#shen_1").html(shen)
			  var shen_1 = $("#shen_1").text()
			  var shi = $("#city option:selected").text()//市
			  $("#shi_1").html(shi)
			  var shi_1 = $("#shi_1").text()
			  var xian = $("#area option:selected").text()//区
			  $("#xian_1").html(xian)
			  var xian_1 = $("#xian_1").text()
			  var address = $("#address").val()//街道地址
			  var telphone = $("#telphone").val()//手机号
			  var types = ""



			  if($("#type").val() != "checked"){
				  types = "y"
			  }else {
				  types = "n"
			  }

			  //发送ajax请求，将参数传递给后台
			  $.ajax({
				  type:"POST",
				  url:"/AddAddressServlet",
				  contentType: "application/x-www-form-urlencoded",
				  data:"accept=" + accept + "&province=" + shen_1 + "&city=" + shi_1 + "&area=" + xian_1 + "&address=" + address + "&telphone=" + telphone + "&type=" + types,
				  success:function (data){
					  alert(data)
				  },
				  error:function (msg){
					  alert("页面出现了错误")
				  }
			  })
		  }

	  </script>

  </head>
  <body  onload='getProvince()'>
	  
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
							   <a href="personal_order.html"><p class="p2">我的订单</p></a>
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
							   <a href="personal_headimage.html"><p class="p2">修改头像</p></a>
						   </div>
					   </div>
					   
					   <div class="list-group">
						   <div class="div1">
							   <a href="personal_password.html"><p class="p2">修改密码</p></a>
						   </div>
					   </div>
					   
				     </div>
				   </div>
				 </div>
				 
			 </div>
			 <div class="col-md-8">
				
				 <div class="row">
					 <div class="col-md-12">
						 
						 <div style="border-bottom: 4px solid red;width: 100%;height: 48px;margin-bottom: 30px;">
							 <button type="button" class="btn btn-danger">
								 <span style="font-size: 24px;"><strong>订单详情</strong></span>
							 </button>
						 </div>

					 </div>
				 </div>
				 
				 <div class="row">
					 <div class="col-md-12">
						 <div class="panel panel-default">
						   <div class="panel-heading">
							   <span><strong>已保存的有效地址</strong></span>
							   <a href="${pageContext.request.contextPath}/FindAllAddressServlet"><span style="text-align: center">点我刷新</span></a>
						   </div>
						   <table class="table table-striped table1 table-hover">
							 <tr>
								 <th>收货人</th>
								 <th>所在地区</th>
								 <th>街道地址</th>
								 <th>手机</th>
								 <th>操作</th>
							 </tr>

							   <c:forEach items="${addresslist}" var="list">
								   <tr>
									   <td>${list.accept}</td>
									   <td>${list.province}${list.city}${list.area}</td>
									   <td>${list.address}</td>
									   <td>${list.telphone}</td>
									   <td>
										   <a>修改</a>
										   <a>删除</a>
										   <c:if test="${list.type == 'n'}">
											   <a>设为默认</a>
										   </c:if>
										   <c:if test="${list.type == 'y'}">
											   <a>默认地址</a>
										   </c:if>
									   </td>
								   </tr>
							   </c:forEach>

						   </table>
						 </div>
					 </div>
				 </div>
				 
				 
				 <div class="row">
					 <div class="col-md-12">
						 <div class="panel panel-default">
						   <div class="panel-heading">
							   <span><strong>收货地址</strong></span>
						   </div>
						   <form action="${pageContext.request.contextPath}/AddAddressServlet" method="GET">
							   <div hidden>
								   <span id="shen_1"></span>
							   </div>
							   <div hidden>
								   <span id="shi_1"></span>
							   </div>
							   <div hidden>
								   <span id="xian_1"></span>
							   </div>
							   <table class="table table2">
								   <tr>
									   <td>
										   <span>收货人姓名:</span><input type="text" id="accept"/>
									   </td>
								   </tr>
								   <tr>
									   <td>
										   <span>所在地区:</span>
											<select id="province" onchange="chooseProvince(this)">
												<option>请选择省</option>
											</select>
											<select id="city" onchange="chooseCity(this)">
												<option>请选择市</option>
											</select>
											<select id="area">
												<option>请选择区</option>
											</select>
									   </td>
								   </tr>
								   <tr>
									   <td>
										   <span>街道地址:</span><input type="text" id="address"/>
									   </td>
								   </tr>
								   <tr>
									   <td>
										   <span>手机号码:</span><input type="text" id="telphone"/>
									   </td>
								   </tr>
								   <tr>
									   <td>
										   <span>设为默认:</span><input type="checkbox" value="uncheck" name="check" id="type" onclick="this.value=(this.value=='uncheck')?'checked':'uncheck'">
									   </td>
								   </tr>
								   <tr>
									   <td>
										   <button type="button" class="btn btn-success" onclick="save()"><span>保存</span></button>
										   <button type="button" class="btn btn-danger"><span>取消</span></button>
									   </td>
								   </tr>
							   </table>
							   
						   </form>
						 </div>
					 </div>
				 </div>
				 
				 
			 </div>
			 <div class="col-md-1"></div>
		 </div>
	 </div>
	 
	 
	 
	  
	  <!-- 固定定位的购物车 -->
	  <div style="width: 50px;height: 50px;position:fixed;top: 340px;right: 0;">
		  <a href="success.html"><img src="../img/cart.png" style="width:100%;height:100%;"></img></a>
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
	  


  </body>
</html>
