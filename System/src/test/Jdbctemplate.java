package test;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import util.C3p0Util;

public class Jdbctemplate {
	
	@Test
	public void Test01() {
		JdbcTemplate jt=new JdbcTemplate(C3p0Util.getDataSource());
		String sql="update user set age=20 where name='Àî°×' ";
		int i=jt.update(sql);
		System.out.println(i);
	}
}
