<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,org.bigjava.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {}
	a:hover {color:#F00; }
</style>
<script type="text/javascript">
	function edit(nid) {
		window.location.href = "NewsServlet?method=edit_news&id=" + nid;
	}
	function del(nid) {
		if (confirm("确定删除此条新闻?")) {
			window.location.href = "NewsServlet?method=del_news&id=" + nid;
		}
	}
</script>

</head>

<body>


	<h3>Bigjava新闻网</h3>
	
	<table>
	<%
		
		Object obj = request.getAttribute("newsList");
	
		if (obj != null) {
			
			List<News> newsList = (List<News>)obj;
			
			for (int i=0; i<newsList.size(); i++) {
				News aNews = newsList.get(i);
		
	%>
			<tr>
				<td><a href="#"><%=aNews.getTitle() %></a></td>
				<td>
					<input type="button" value="修改" onclick="edit('<%=aNews.getId() %>')" />
					<input type="button" value="删除" onclick="del('<%=aNews.getId() %>')" />
				</td>
			</tr>

	<%
			}
		}
	%>
	</table>
</body>
</html>