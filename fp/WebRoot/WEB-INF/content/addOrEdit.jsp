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
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  
  
  <body>
 <br/>
	<form id="edit-profile" class="form-horizontal" enctype="multipart/form-data" action="bg/information!addOrEdit" method="post" >
		<input name="information.top" value="0" type="hidden"/>
		<fieldset>
			<input type="hidden" name="information.id" value="${information.id }"/>
			
			<div class="control-group">											
				<label class="control-label" for="title">类别</label>
				<div class="controls">
					<select name="content.type" id="type" onchange="changeType(this)" >
						<option value="0" >活动规则</option>
						<option value="1" >活动时间</option>
						<option value="2" >温馨提示</option>
					</select>
				</div> <!-- /controls -->				
			</div> <!-- /control-group -->
			
			<div class="control-group">											
				<label class="control-label" for="content">内容</label>
				<div class="controls">
					<input type="text" value="" name="content" />
				</div> <!-- /controls -->				
			</div> <!-- /control-group -->
			
			<div class="control-group"  id="time" >											
				<label class="control-label" for="ct">时间</label>
				<div class="controls">
					<div class="input-append date form_datetime" data-date="2012-12-21T15:25:00Z">
					    <input size="16" type="text" value="" readonly>
					    <span class="add-on"><i class="icon-remove"></i></span>
					    <span class="add-on"><i class="icon-th"></i></span>
					</div>
					<input type="text" id="mirror_field" value="" readonly />
					 
				</div> <!-- /controls -->				
			</div> <!-- /control-group -->
			
			<%--<div class="form-actions" style="height: 10px;">
				<button type="button" class="btn btn-primary" onclick="check('title','标题不能为空','ct','内容不能为空');">保存</button> 
			</div> <!-- /form-actions -->
		--%></fieldset>
		
	</form>
	
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/fileupload/jquery.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fileupload/jquery.MultiFile.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fileupload/jquery.MultiFile.pack.js"></script>
	<script type="text/javascript">
	 $(function(){ // wait for document to load 
       $('#fileUpload').MultiFile({ 
        STRING: {
         remove: '<img class="icon-remove" height="16" width="16" alt="x"/>'
        }
       }); 
      });
	</script>
  --%></body>
</html>
