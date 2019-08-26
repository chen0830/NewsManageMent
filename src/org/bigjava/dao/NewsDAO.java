package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.News;

public interface NewsDAO {

	/**
	 *  添加新闻
	 * @param aNews
	 * @return 
	 */
	public boolean addNews(News aNews);

	/**
	 * 根据id获取新闻
	 * @param id
	 * @return
	 */
	public News getNewsById(int id);
	
	/**
	 * 查询所有新闻
	 * @return
	 */
	public java.util.List<News> findAllNews();
	/**
	 * 根据新闻主键删除新闻
	 * @param id
	 */
	public void deleteNewsById(int id);
	
	/**
	 * 修改新闻
	 * @param aNews
	 */
	public void updateNewsById(News aNews);
	
}
