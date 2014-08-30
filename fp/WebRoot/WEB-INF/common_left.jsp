		<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    
  </head>
  <body>
			<div class="account-container">
				
					<div class="account-avatar">
						<img src="${pageContext.request.contextPath}/img/headshot.png" alt="" class="thumbnail" />
					</div> <!-- /account-avatar -->
				
					<div class="account-details">
					
						<span class="account-name">${userSession.userName }</span>
						
						<span class="account-role">管理员</span>
						
						<!-- <span class="account-actions">
							<a href="javascript:;">账户设置</a> |
							
							<a href="javascript:;">修改密码</a>
						</span> -->
					
					</div> <!-- /account-details -->
				
				</div> <!-- /account-container -->
				
				<hr />
				
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					
					<li onclick="addClassActive(this)">
						<a href="bg/user!index">
							<i class="icon-home"></i>
							首页			
						</a>
					</li>
					
					<li  onclick="addClassActive(this)">
						<a href="bg/content!index" >
							<i class="icon-folder-close"></i>
							内容管理
						</a>
					</li>
					
					<li  onclick="addClassActive(this)">
						<a href="bg/prizewinner!index" >
							<i class="icon-folder-close"></i>
							获奖者管理
						</a>
					</li>
					
				</ul>	
				
				
				
				<hr />
				
				<!-- <div class="sidebar-extra">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
				</div> .sidebar-extra
				 -->
				<br />
	<script type="text/javascript">
	$(window).load(function() {
		$(".active").removeClass("active");
		$("a[href='${pu.url }']").parent().addClass("active");
	});
	function addClassActive(t){
		if("active" != $(t).attr("class")){
			$(".active").removeClass("active");
			$(t).addClass("active");
		}
		//
	}
				
	</script>
  </body>
</html>