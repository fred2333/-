<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="js/jquery-2.1.3.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <script type="text/javascript" src="js/bootstrap。min.js"></script><!-- 注意，此处不需要引用该js文件，是“。”-->
    <style type="text/css">
    	body{
    		background-color: #f4e9c6 !important;
    	}
    	#letf-nav{
    		background-color: #efe !important;
    	}
        @media (min-width: 768px){
            #letf-nav{
                width: 230px;
                margin-top: 60px;
                position: absolute;
                height: 800px;
                background-color: #eee;
            }
            #my-search{
                margin-top: 10px;
            }
            #page-main{
                margin-left: 260px;
            }
            #navbar-brand{
                margin-left: 30px;
                font-weight: 350;
                font-size: 25px;
            }
            img{
                width: 170px;
                height: 250px;
            }
        }
    </style>

</head>
<body>
    <nav class="navbar navbar-inverse navbar-static-top">
        <!-- 顶部导航左侧标志 -->
        <div class="navbar-header">
            <a href="index.jsp"  id="navbar-brand" class="navbar-brand">小型在线商城V1.0</a>
        </div>
        
        <!-- 顶部导航右侧注销，欢迎 -->
        <ul class="nav navbar-nav navbar-right" style="margin-right:25px;">
        <s:if test="#session.user == null">
            <li><a href="login.jsp"><span class="glyphicon glyphicon-off"></span>&nbsp;登录</a></li>
            <li><a href="register.jsp"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;注册</a></li>
        </s:if>
        <s:else>
            <li><a href="Order_listAllOrderByUid"><span class="glyphicon glyphicon-th"></span>&nbsp;我的订单</a></li>
            <li><a href="cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;我的购物车</a></li>
            <li><a href="User_logout"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span>&nbsp;个人信息管理</a>
              <ul class="dropdown-menu">
                <li><a href="list_info.jsp">查看个人信息</a></li>
                <li><a href="update_info_input.jsp">修改个人信息</a></li>
                <li><a href="change_password_input.jsp">修改密码</a></li>
              </ul>
            </li>
        </s:else>
        </ul>
        
        <div id="letf-nav">
            <ul class="nav">

                <!-- 搜索框 -->
                
                <li>
                    <div class="input-group">
                    <!--    input加上类form-control后，效果为：
							控件具有4px的圆角
							设置阴影效果，元素得到焦点时，呈现蓝色边框效果-->
                        <input type="text" name="pname" class="form-control" id="pname" required>
                        <span class="input-group-btn" id="my-search">
                            <a id="a" href="#" class="btn btn-default">
                                <span class="glyphicon glyphicon-search"></span>
                            </a>
                        </span>
                    </div>
                </li>
                

                <!-- 类别管理 -->
                <ul class="nav nav-pills nav-stacked">
                <s:iterator value="#session.categories" var="xx">
                  <li><a href="Product_listAllProductByPageAndCid?cid=<s:property value="#xx.cid"/>&p=1"><span class="glyphicon glyphicon-info-sign"><!--bootstrap中组件（Glyphicons 字体图标）的感叹号 --></span>&nbsp;&nbsp;&nbsp;<s:property value="#xx.cname"/></a></li>
                </s:iterator>
              </ul>
          </ul>
      </div>
  </nav>

<script type="text/javascript">
	$(document).ready(function(){
	$("#a").bind("click", f);
		function f(){
			var pname = $("#pname").val();
			pname=encodeURI(pname);
			$("#a").attr("href","Product_listAllProductByPageAndPname?p=1&pname="+pname);
		}
	});
</script>
</body>
</html>
