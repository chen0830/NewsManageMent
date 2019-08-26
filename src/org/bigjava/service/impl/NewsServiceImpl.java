package org.bigjava.service.impl;

import java.util.List;

import org.bigjava.bean.News;
import org.bigjava.dao.NewsDAO;
import org.bigjava.dao.impl.NewsDAOImpl;
import org.bigjava.service.NewsService;

public class NewsServiceImpl implements NewsService {

	NewsDAO nd = new NewsDAOImpl();
	@Override
	public boolean addNews(News aNews) {
		// TODO Auto-generated method stub
		nd.addNews(aNews);
		return nd.addNews(aNews);
	}

	@Override
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return nd.getNewsById(id);
	}

	@Override
	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		return nd.findAllNews();
	}

	@Override
	public void deleteNewsById(int id) {
		// TODO Auto-generated method stub
		nd.deleteNewsById(id);
	}

	@Override
	public void updateNewsById(News aNews) {
		// TODO Auto-generated method stub
		nd.updateNewsById(aNews);
	}

}
