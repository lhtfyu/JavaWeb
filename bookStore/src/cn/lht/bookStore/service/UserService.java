package cn.lht.bookStore.service;

import cn.lht.bookStore.dao.UserDao;
import cn.lht.bookStore.dao.UserDaoImp;
import cn.lht.bookStore.entity.User;

public class UserService {
		UserDao dao=new UserDaoImp();
	public boolean userRegister(User user) {
		return dao.userRegister(user);	
	}
	
	public User login(String username) {
		
		return (User)dao.findByUserName(username);
	}
	
	public boolean updateUser(User user) {
		return dao.updateUser(user);
	}
}
