package cn.lht.bookStore.dao;

import java.util.List;

import cn.lht.bookStore.entity.OrderItem;
import cn.lht.bookStore.entity.Orders;

public interface OrderDao {
	public void addOrder(Orders order);
	
	public void addOrderItem(List<OrderItem> items);

	public void orderstatus(String oid);

	public void updatePnum(int pid,int pnum);

	public int gettotalCount(int id);

	public List<Orders> OrderfindByPage(int start, int rows,int uid);

	public void removeordersItem(String oid);

	public Orders orderInfo(String oid);

	
}
