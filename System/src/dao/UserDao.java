package dao;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao {
	/**
	 * ����username��ȡ����
	 * @param user
	 * @return ����
	 */
	public Object findByUserName(String user);
	
	/**
	 * ��ȡ�б�
	 * @return List<User>
	 */
	public List<User> findAll();
	
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return Object
	 */
	public Object findById(int id);
	
	/**
	 * ɾ��
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * ���
	 * @param user
	 */
	public void Add(User user);
	
	/**
	 * ����
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * ����ɾ��
	 * @param ids
	 */
	public void batchDele(String[] ids);
	
	/**
	 * ��ȡ���ݿ��ܼ�¼��
	 * @param condtion
	 * @return
	 */
	public int gettotalCount(Map<String, String[]> condtion);
	
	/**
	 * ������ҳ
	 * @param start ��ʼҳ
	 * @param row  չʾ��������¼
	 * @param condtion ������ѯ����
	 * @return
	 */
	public List findByPage(int start,int row, Map<String, String[]> condtion);
}
