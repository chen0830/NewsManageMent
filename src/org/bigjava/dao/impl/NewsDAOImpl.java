package org.bigjava.dao.impl;

import java.util.List;

import org.bigjava.bean.News;
import org.bigjava.dao.NewsDAO;

public class NewsDAOImpl implements NewsDAO {

	@Override
	public void addNews(News aNews) {
		// TODO Auto-generated method stub
		aNews.setTitle(null);
		aNews.setNewsName(null);
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
