<%@page import="org.bigjava.util.SimpleDBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.sql.*,org.bigjava.bean.Topic" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Connection conn = SimpleDBUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from topic");
		ResultSet rs = pstmt.executeQuery();
		List topicList = new ArrayList();
		while (rs.next()) {
			topicList.add(new Topic(rs.getInt(1), rs.getString(2)));
		}
	%>
	
	<select name="topic">
	</select>
	
	
	<script type="text/javascript">
		window.onload = function() {
			var topicOjb = document.getElementsByName("topic")[0];
			
			<%
				for (int i=0; i<topicList.size(); i++) {
					Topic topic = (Topic)topicList.get(i);
			%>
					var opt = document.createElement("option");
					opt.innerHTML = '<%=topic.getTopicName()%>';
					opt.value = <%=topic.getId() %>;
					topicOjb.options.add(opt);
			<%
				}
			%>
		}
	</script>
</body>
</html>