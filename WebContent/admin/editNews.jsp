<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.bigjava.bean.News" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
	News aNews = (News)request.getAttribute("editNews"); 
%>
		



</head>
<body onload="initialNewsData()">

	<h3>修改新闻:</h3>
	<form action="NewsServlet" method="post">
		新闻ID: <input type="text" value="" name="id" readonly="readonly" />
		新闻分类:
			<select name="topic">
				<option value="1">国内</option>
				<option value="2">国外</option>
				<option value="3">财经</option>
			</select><br />
		新闻标题: <input type="text" name="title" /><br />
		新闻内容: <textarea rows="8" cols="50" name="content"></textarea><br />
		<input type="submit" />
		
		<input type="hidden" name="method" value="edit_news_submit" />
	</form>
</body>


<script type="text/javascript">
	function initialNewsData() {
		//alert(1);
		document.getElementsByName("id")[0].value = '<%= aNews.getId() %>';
		document.getElementsByName("title")[0].value = '<%= aNews.getTitle() %>';
		document.getElementsByName("content")[0].value = '<%= aNews.getContent() %>';
		document.getElementsByName("topic")[0].options[<%=aNews.getFk_topic_id()%>-1].selected = true;
	}
</script>
</html>