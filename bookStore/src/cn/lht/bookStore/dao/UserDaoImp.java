package cn.lht.bookStore.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.lht.bookStore.entity.User;
import cn.lht.bookStore.utils.C3p0Util;


public class UserDaoImp implements UserDao {
	private JdbcTemplate template=new JdbcTemplate(C3p0Util.getDataSource());
	@Override
	public boolean userRegister(User user) {
		String sql="insert into user(username,phone,sex,info,password,email) values(?,?,?,?,?,?)";
	       
       int index= template.update(sql,user.getUsername(),user.getPhone(),user.getSex(),user.getInfo(),user.getPassword(),user.getEmail());
		if(index==1) {
			return true;
		}else {
       return false;
		}
	}
	@Override
	public User findByUserName(String username) {
		 User us=null;
		 try {
	            String sql = "select * from user where username = ? ";
	            us = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
	           
	        } catch (Exception e) {
	            e.printStackTrace();	           
	        }
		 return us;
		
	}
	@Override
	public boolean updateUser(User user) {
		String sql = "update user set password = ?,sex = ? ,phone=? where id = ?";
		int index=template.update(sql, user.getPassword(),user.getSex(),user.getPhone(), user.getId());
		if(index==1) {
			return true;
		}else {
			return false;
		}
	}

}
