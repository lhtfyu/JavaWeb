package cn.lht.bookStore.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.lht.bookStore.entity.Product;
import cn.lht.bookStore.entity.User;
import cn.lht.bookStore.utils.C3p0Util;

public class ProductDaoImp implements ProductDao {
	private JdbcTemplate template=new JdbcTemplate(C3p0Util.getDataSource());
	/**
	 *获取数据库总记录数
	 */
	@Override
	public int productCount(String category) {
		if(category != null&&!category.equals("")) {
		String sql = "select count(*) from product where category=?";
		 return template.queryForObject(sql,Integer.class,category);
		}else {
			String sql = "select count(*) from product";
			 return template.queryForObject(sql,Integer.class);
		}
	}
		

	@Override
	public List<Product> findByPageList(String category,int start,int row) {
		String sql = "select * from product  where 1 = 1 ";
		StringBuilder sb = new StringBuilder(sql);
		 List<Object> params = new ArrayList<Object>();	
		 if(category != null&&!"".equals(category)) {
			 sb.append(" and category=?");
			params.add(category);
		 }
		 sb.append(" limit ?,?");
		 params.add(start);
		 params.add(row);
		  sql = sb.toString();

		  return template.query(sql,new BeanPropertyRowMapper<Product>(Product.class),params.toArray());
	}
	
	@Test
	public void Test01() {
		List<Product> list=findByPageList("计算机", 0,2);
 		System.out.println(list);
	}


	@Override
	public Product findById(int id) {
		String sql="select * from product where id=?";
		 Product pd=template.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class), id);
		return pd;
	}
}
