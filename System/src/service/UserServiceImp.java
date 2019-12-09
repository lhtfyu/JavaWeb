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
	 * 根据用户名查询得到User对象
	 */
	@Override
	public Object findByUserName(String user) {
		return dao.findByUserName(user);
	}
	
	/**
	 * 查询得到List<User>
	 */
	@Override
	public List findAll() {
		return dao.findAll();
	}
	
	/**
	 * 根据id查询得到User对象
	 */
	@Override
	public Object findById(int id) {	
		return dao.findById(id);
	}
	/**
	 * 根据User查询删除User对象
	 */
	@Override
	public void delete(User user) {
		dao.delete(user);
	}
	/**
	 * 增加
	 */
	@Override
	public void Add(User user) {
		dao.Add(user);
	}
	/**
	 * 更新
	 */
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		dao.update(user);
	}
	/**
	 * 批量删除
	 */
	@Override
	public void batchDele(String[] ids) {
		
		dao.batchDele(ids);
	}
	
	/**
	 * 获取数据库总记录数
	 */
	@Override
	public int gettotalCount(Map<String, String[]> condtion) {
		
		return dao.gettotalCount(condtion);
	}
	
	/**
	 * 条件分页
	 */
	@Override
	public PageBean<User> findUserByPage(int cur, int row,Map<String, String[]> condtion) {
		PageBean<User> pd=new PageBean<>();
		int count=dao.gettotalCount(condtion);//数据库总记录数
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
