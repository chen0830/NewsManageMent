package org.bigjava.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.bigjava.bean.News;
import org.bigjava.dao.NewsDAO;
import org.bigjava.util.*;

public class NewsDAOImpl implements NewsDAO {

	@Override
	public boolean addNews(News aNews) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			String sql="insert into news(title,content,createTime,fk_topic_id) value (?,?,?,?)";
			
			conn = SimpleDBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, aNews.getTitle());
			pstmt.setObject(2, aNews.getContent());
			pstmt.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setObject(4, aNews.getFk_topic_id());
			
			int rows = pstmt.executeUpdate();
			flag = rows > 0 ? true : false;
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			SimpleDBUtil.closeAll(null, pstmt, conn);
		}
		return flag;
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		News aNews = null;
		try {
			
			String sql="select * from news where id = ?";
			conn = SimpleDBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				aNews = new News();
				aNews.setId(rs.getInt(1));
				aNews.setTitle(rs.getString(2));
				aNews.setContent(rs.getString("content"));
				aNews.setCreateTime(rs.getDate("createTime"));
				aNews.setFk_topic_id(rs.getInt("fk_topic_id"));
			}

					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			SimpleDBUtil.closeAll(rs, pstmt, conn);
		}
		return aNews;
	}

	@Override
	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<News> newsList = null;
		
		try {
			
			String sql = "select * from news";
			conn = SimpleDBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			newsList = new ArrayList<>();
			while (rs.next()) {
				News aNews = new News();
				aNews.setId(rs.getInt(1));
				aNews.setTitle(rs.getString(2));
				aNews.setContent(rs.getString("content"));
				aNews.setCreateTime(rs.getDate("createTime"));
				aNews.setFk_topic_id(rs.getInt("fk_topic_id"));
				
				newsList.add(aNews);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			SimpleDBUtil.closeAll(rs, pstmt, conn);
		}
		
		return newsList;
	}

	@Override
	public void deleteNewsById(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			String sql = "delete from news where id = ?";
			conn = SimpleDBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			SimpleDBUtil.closeAll(null, pstmt, conn);
		}
	}

	@Override
	public void updateNewsById(News aNews) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			String sql = "update news set title=?, content=?, fk_topic_id=? where id = ?";
			conn = SimpleDBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aNews.getTitle());
			pstmt.setString(2, aNews.getContent());
			pstmt.setInt(3, aNews.getFk_topic_id());
			pstmt.setInt(4, aNews.getId());
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			SimpleDBUtil.closeAll(null, pstmt, conn);
		}
	}

}
