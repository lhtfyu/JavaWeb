package dao;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao {
	/**
	 * 根据username获取对象
	 * @param user
	 * @return 对象
	 */
	public Object findByUserName(String user);
	
	/**
	 * 获取列表
	 * @return List<User>
	 */
	public List<User> findAll();
	
	/**
	 * 根据id获取对象
	 * @param id
	 * @return Object
	 */
	public Object findById(int id);
	
	/**
	 * 删除
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * 添加
	 * @param user
	 */
	public void Add(User user);
	
	/**
	 * 更新
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void batchDele(String[] ids);
	
	/**
	 * 获取数据库总记录数
	 * @param condtion
	 * @return
	 */
	public int gettotalCount(Map<String, String[]> condtion);
	
	/**
	 * 条件分页
	 * @param start 开始页
	 * @param row  展示多少条记录
	 * @param condtion 条件查询参数
	 * @return
	 */
	public List findByPage(int start,int row, Map<String, String[]> condtion);
}
