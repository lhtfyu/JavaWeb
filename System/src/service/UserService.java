package service;

import java.util.List;
import java.util.Map;

import entity.PageBean;
import entity.User;

public interface UserService {
	
	public Object findByUserName(String user);
	
	public List<User> findAll();
	
	public Object findById(int id);
	
	public void delete(User user);	
	
	public void Add(User user);
	
	public void update(User user);
	
	public void batchDele(String[] ids);
	
	public int gettotalCount(Map<String, String[]> condtion);
	
	public PageBean<User> findUserByPage(int cur,int row, Map<String, String[]> condtion);
}
