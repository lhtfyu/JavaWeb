package test;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import dao.UserDaoImp;
import entity.User;

public class TestUserDao {

	public static void main(String[] args) {
		UserDao dao=new UserDaoImp();
		User u=(User)dao.findByUserName("libai");
		System.out.println(u);
		ArrayList<User> list=(ArrayList<User>)dao.findAll();
		System.out.println(list);
		
		System.out.println("++++++++++++++++++++++++++++");
	//	System.out.println(dao.gettotalCount());
		System.out.println("++++++++++++++++++++++++++++");
	//	List lists=dao.findByPage(0, 5);
		//System.out.println(lists);
		System.out.println("++++++++++++++++++++++++++++");
	}

}
