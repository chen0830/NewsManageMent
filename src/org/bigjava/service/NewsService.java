package org.bigjava.service;

import org.bigjava.bean.News;

public interface NewsService {
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
