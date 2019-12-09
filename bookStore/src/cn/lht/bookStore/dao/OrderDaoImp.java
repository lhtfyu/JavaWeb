package cn.lht.bookStore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import cn.lht.bookStore.entity.OrderItem;
import cn.lht.bookStore.entity.Orders;
import cn.lht.bookStore.entity.Product;
import cn.lht.bookStore.utils.C3p0Util;

public class OrderDaoImp implements OrderDao {
	private JdbcTemplate template=new JdbcTemplate(C3p0Util.getDataSource());
	@Override
	public void addOrder(Orders order) {
		String sql="insert into orders values(?,?,?,?,?,?,?,?)";
		 List<Object> params = new ArrayList<Object>();	
		 params.add(order.getOid());
		 params.add(order.getMoney());
		 params.add(order.getReceiverAddress());
		 params.add(order.getReceiverName());
		 params.add(order.getReceiverPhone());
		 params.add(order.getPaystate());
		 params.add(order.getOrdertime());
		 params.add(order.getUser().getId());
		 template.update(sql,params.toArray());
	}
	@Override
	public void addOrderItem(List<OrderItem> items) {
		String sql="insert into orderitem values(?,?,?)";
		for(OrderItem item : items) {
			template.update(sql,item.getOrders().getOid(),item.getProduct().getId(),item.getBuynum());
		}
	}
	@Override
	public void orderstatus(String oid) {
		String sql="UPDATE orders SET paystate=1 WHERE oid=?";
		template.update(sql,oid);	
	}
	@Override
	public void updatePnum(int pid, int pnum) {
		// TODO Auto-generated method stub
		String sql="UPDATE product SET pnum=pnum-? WHERE id=?";
		template.update(sql,pnum,pid);
	}
	@Override
	public int gettotalCount(int id) {
		String sql = "select count(*) from orders where uid=?";
		return template.queryForObject(sql,Integer.class,id);
	}
	
	
	@Override
	public List<Orders> OrderfindByPage(int start, int rows,int uid) {
		String sql = "select * from orders where uid=? limit ?,?";
		StringBuilder sb = new StringBuilder(sql);
		 List<Object> params = new ArrayList<Object>();	
		 params.add(uid);
		 params.add(start);
		 params.add(rows);
		 return template.query(sql,new BeanPropertyRowMapper<Orders>(Orders.class),params.toArray());		
	}
	
	@Override
	public void removeordersItem(String oid) {
		String sql="DELETE FROM orders WHERE oid=?";
		template.update(sql,oid);
	}
	
	@Override
	public Orders orderInfo(String oid) {
		String sql="select * from orders where oid=?";
		Orders orders=template.queryForObject(sql, new BeanPropertyRowMapper<Orders>(Orders.class), oid);
		List<OrderItem> items=new ArrayList<OrderItem>();
		String sql2="select o.*,p.name,p.price from orderitem o,product p where o.pid=p.id and oid=?";
		
		template.query(sql2,new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				OrderItem item = new OrderItem();
				item.setBuynum(rs.getInt("buynum"));
				Product p=new Product();
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				item.setProduct(p);
				items.add(item);
			}			
		},oid);
		
		orders.setItems(items);
		return orders;
	}
	
	@Test
	public void Test3() {
		System.out.println(orderInfo("4f364693-153e-4a0f-a13e-677229ef9cda").getItems());
	}
}
