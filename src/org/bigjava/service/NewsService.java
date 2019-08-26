package org.bigjava.service;

import org.bigjava.bean.News;

public interface NewsService {
	/**
	 *  �������
	 * @param aNews
	 * @return 
	 */
	public boolean addNews(News aNews);

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
	/**
	 * ����idɾ������
	 * @param id
	 */
	public void deleteNewsById(int id);
	
	/**
	 * �޸�����
	 * @param aNews
	 */
	public void updateNewsById(News aNews);
}
