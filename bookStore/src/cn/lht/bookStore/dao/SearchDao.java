package cn.lht.bookStore.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.lht.bookStore.entity.FenPage;
import cn.lht.bookStore.entity.Product;
import cn.lht.bookStore.utils.C3p0Util;

public class SearchDao {
	private JdbcTemplate template=new JdbcTemplate(C3p0Util.getDataSource());
	public FenPage<Product> Search(String searchname,int currentPage) {
		FenPage<Product> sfp=new FenPage<>();
		int totalCount=getsearchCount(searchname);
		int start=(currentPage-1)*sfp.getRows();
		List<Product> list=searchPageList(searchname,start,sfp.getRows());
		int totalPage=totalCount%sfp.getRows()==0?(totalCount/sfp.getRows()):(totalCount/sfp.getRows())+1;
		sfp.setList(list);
		sfp.setCurrentPage(currentPage);
		sfp.setTotalPage(totalPage);
		sfp.setTotalCount(totalCount);
		return sfp;
		
		
	}

	private List<Product> searchPageList(String searchname, int start, int rows) {
		String sql="select * from product where name or description LIKE ? limit ?,?";
		 return template.query(sql,new BeanPropertyRowMapper<Product>(Product.class),"%"+searchname+"%",start, rows);
	}

	private int getsearchCount(String searchname) {
		String sql="select count(*) from product where name or description LIKE ?";
		return template.queryForObject(sql,Integer.class,"%"+searchname+"%");
	}
	@Test
	public void Test4() {
		//System.out.println(getsearchCount("java"));
		System.out.println(searchPageList("java",0,1));
		//System.out.println(Search("java",1));
	}
}
