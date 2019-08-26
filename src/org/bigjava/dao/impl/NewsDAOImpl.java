package org.bigjava.dao.impl;

import java.util.List;
import java.sql.*;

import org.bigjava.bean.News;
import org.bigjava.dao.NewsDAO;
import org.bigjava.util.*;

public class NewsDAOImpl implements NewsDAO {

	@Override
	public void addNews(News aNews) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			String sql="insert into news(title,content,createTime,fk_topic_id) value (?,?,?,?)";
			
			conn = SimpleDBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, aNews.getTitle());
			pstmt.setObject(2, aNews.getContent());
			pstmt.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setObject(4, aNews.getFk_topic_id());
			
			pstmt.executeUpdate();
			
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			SimpleDBUtil.closeAll(null, pstmt, conn);
		}
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		return null;
	}

}
