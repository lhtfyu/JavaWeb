package service;

import java.util.List;
import java.util.Map;

import dao.UserDao;
import dao.UserDaoImp;
import entity.PageBean;
import entity.User;

public class UserServiceImp implements UserService{
		UserDao dao=new UserDaoImp();
	/**
	 * �����û�����ѯ�õ�User����
	 */
	@Override
	public Object findByUserName(String user) {
		return dao.findByUserName(user);
	}
	
	/**
	 * ��ѯ�õ�List<User>
	 */
	@Override
	public List findAll() {
		return dao.findAll();
	}
	
	/**
	 * ����id��ѯ�õ�User����
	 */
	@Override
	public Object findById(int id) {	
		return dao.findById(id);
	}
	/**
	 * ����User��ѯɾ��User����
	 */
	@Override
	public void delete(User user) {
		dao.delete(user);
	}
	/**
	 * ����
	 */
	@Override
	public void Add(User user) {
		dao.Add(user);
	}
	/**
	 * ����
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}
	/**
	 * ����ɾ��
	 */
	@Override
	public void batchDele(String[] ids) {
		
		dao.batchDele(ids);
	}
	
	/**
	 * ��ȡ���ݿ��ܼ�¼��
	 */
	@Override
	public int gettotalCount(Map<String, String[]> condtion) {
		
		return dao.gettotalCount(condtion);
	}
	
	/**
	 * ������ҳ
	 */
	@Override
	public PageBean<User> findUserByPage(int cur, int row,Map<String, String[]> condtion) {
		PageBean<User> pd=new PageBean<>();
		int count=dao.gettotalCount(condtion);//���ݿ��ܼ�¼��
		pd.setTotalCount(count);
		
		int totalPage=(count%row)==0?count/row:(count/row)+1;
		pd.setTotalPage(totalPage);
		if(cur<=0) {
			cur=1;
		}
		if(cur>totalPage) {
			cur=totalPage;
		}
		pd.setCurrentPage(cur);
		pd.setRows(row);
		
		int start=(cur-1)*row;
		List list=dao.findByPage(start, row,condtion);
		pd.setList(list);
		
		
		return pd;
	}

}
