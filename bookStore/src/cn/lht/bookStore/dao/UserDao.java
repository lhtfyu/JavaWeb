package cn.lht.bookStore.dao;

import cn.lht.bookStore.entity.User;

public interface UserDao {
	public boolean userRegister(User user);
	
	public User findByUserName(String username);
	
	public boolean updateUser(User user);
}
