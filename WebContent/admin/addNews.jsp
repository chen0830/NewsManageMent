<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	

	<h3>添加新闻：</h3>
	<form action="NewsServlet" method="post">
		新闻分类：
			<select name = "topic">
				<option value="1">国内</option>
				<option value="2">国外</option>
				<option value="3">财经</option>
			</select>
		新闻标题：<input type="text" name="title" /><br>
		新闻内容：<textarea rows="8" cols="50" name="content"></textarea>
		<input type="submit" />
		<input type="hidden" name="method" value="add_news"/>
	</form>
	<script type="text/javascript">
		window.onload = function() {
			<% 
				Object msg = request.getAttribute("req_msg");
				if (msg != null) {
			%>
		
				var msg = '<%=msg %>';
				alert(msg);
				
			<%
				request.removeAttribute("req_msg");
				}
			%>
		}
	</script>
</body>
</html>