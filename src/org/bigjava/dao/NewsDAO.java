package org.bigjava.dao;

import java.util.List;

import org.bigjava.bean.News;

public interface NewsDAO {

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
	 * ������������ɾ������
	 * @param id
	 */
	public void deleteNewsById(int id);
	
	/**
	 * �޸�����
	 * @param aNews
	 */
	public void updateNewsById(News aNews);
	
}
