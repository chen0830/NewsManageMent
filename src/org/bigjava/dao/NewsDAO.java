package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.News;

public interface NewsDAO {

	/**
	 *  �������
	 * @param aNews
	 */
	public void addNews(News aNews);

	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	public News getNewsById(int id);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public java.util.List<News> findAllNews();
	
}
