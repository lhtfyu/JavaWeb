package dao;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

import entity.User;
import util.C3p0Util;
import util.SQLutil;

public class UserDaoImp implements UserDao {
	
	private JdbcTemplate template=new JdbcTemplate(C3p0Util.getDataSource());
	
	/**
	 * ����username�õ�User����
	 */
	@Override
	public Object findByUserName(String user) {
		/*User u=null;
		Connection conn=SQLutil.getConnection();
		
		
		String sql="select * from user where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setAddress(rs.getString("address"));
				u.setUsername(user);
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setId(rs.getInt("id"));
				u.setGender(rs.getString("gender"));
				u.setQq(rs.getString("qq"));
				u.setAge(rs.getInt("age"));
				u.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;*/	
		 User us=null;
		 try {
	            String sql = "select * from user where username = ? ";
	            us = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user);
	           
	        } catch (Exception e) {
	            e.printStackTrace();	           
	        }
		 return us;
	}

	/**
	 * ��ѯ�����û���Ϣ
	 */
	@Override
	public List<User> findAll() {
		/*List list=new ArrayList();
		User u=null;
		Connection conn=C3p0Util.getConnection();
		String sql="select * from user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setAddress(rs.getString("address"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setId(rs.getInt("id"));
				u.setGender(rs.getString("gender"));
				u.setQq(rs.getString("qq"));
				u.setAge(rs.getInt("age"));
				u.setName(rs.getString("name"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;*/
		 String sql = "select * from user";
	        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
	        return users;
	}

	/**
	 * ɾ���û�
	 */
	@Override
	public void delete(User user) {
		/*Connection conn=SQLutil.getConnection();
		String sql="delete from user where id=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		
        String sql = "delete from user where id = ?";
     
        template.update(sql, user.getId());
		
	}
	
	
	/**
	 * ����id�õ�User����
	 */
	@Override
	public Object findById(int id) {
	/*	User u=null;
		Connection conn=C3p0Util.getConnection();
		String sql="select * from user where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setAddress(rs.getString("address"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setId(id);
				u.setGender(rs.getString("gender"));
				u.setQq(rs.getString("qq"));
				u.setAge(rs.getInt("age"));
				u.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;*/
		
		 String sql = "select * from user where id = ?";
	     
  User user= template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
		return user;
	}
	
	/**
	 * ���
	 */
	@Override
	public void Add(User user) {
	/*	Connection conn=SQLutil.getConnection();
		String sql="insert into user(name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setInt(3,user.getAge());
			ps.setString(4,user.getAddress());
			ps.setString(5,user.getQq());
			ps.setString(6,user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		String sql="insert into user(name,gender,age,address,qq,email) values(?,?,?,?,?,?)";
       
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
	
		
	}
	
	/**
	 * ����
	 */
	@Override
	public void update(User user) {
		/*Connection conn=SQLutil.getConnection();
		String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setInt(3,user.getAge());
			ps.setString(4,user.getAddress());
			ps.setString(5,user.getQq());
			ps.setString(6,user.getEmail());
			ps.setInt(7,user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
		template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
	}
	
	/**
	 * ����ɾ��
	 */
	@Override
	public void batchDele(String[] ids) {
		
		for (int i=0;i<ids.length;i++) {
			User user=(User)findById(Integer.parseInt(ids[i]));
			delete(user);
		}
	}

	/**
	 * ��ȡ���ݿ��¼����
	 */
	@Override
	public int gettotalCount(Map<String, String[]> condtion) {
		/*Connection conn=C3p0Util.getConnection();
		String sql="select count(*) from user";
		PreparedStatement ps;
		int count=0;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;*/
		 //1.����ģ���ʼ��sql
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.����map
        Set<String> keySet = condtion.keySet();
        //��������ļ���
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //�ų���ҳ��������
            if("currentPage".equals(key) || "rows".equals(key)||"uid".equals(key)){
                continue;
            }
            //��ȡvalue
            String value = condtion.get(key)[0];
            //�ж�value�Ƿ���ֵ
            if(value != null && !"".equals(value)){
                //��ֵ
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//��������ֵ
            }
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
	}

	/**
	 * ������ҳ�б�
	 */
	@Override
	public List findByPage(int start, int row,Map<String, String[]> condtion) {
		/*List list=new ArrayList();
		User u=null;
		Connection conn=C3p0Util.getConnection();
		String sql="select * from user limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,start);
			ps.setInt(2,row);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setAddress(rs.getString("address"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setId(rs.getInt("id"));
				u.setGender(rs.getString("gender"));
				u.setQq(rs.getString("qq"));
				u.setAge(rs.getInt("age"));
				u.setName(rs.getString("name"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	*/	
		
		 String sql = "select * from user  where 1 = 1 ";

	        StringBuilder sb = new StringBuilder(sql);
	        //2.����map
	        Set<String> keySet = condtion.keySet();
	        //��������ļ���
	        List<Object> params = new ArrayList<Object>();
	        for (String key : keySet) {

	            //�ų���ҳ��������
	            if("currentPage".equals(key) || "rows".equals(key)||"uid".equals(key)){
	                continue;
	            }

	            //��ȡvalue
	            String value = condtion.get(key)[0];
	            //�ж�value�Ƿ���ֵ
	            if(value != null && !"".equals(value)){
	                //��ֵ
	                sb.append(" and "+key+" like ? ");
	                params.add("%"+value+"%");//��������ֵ
	            }
	        }

	        //��ӷ�ҳ��ѯ
	        sb.append(" limit ?,? ");
	        //��ӷ�ҳ��ѯ����ֵ
	        params.add(start);
	        params.add(row);
	        sql = sb.toString();	    
	        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
	}

}
