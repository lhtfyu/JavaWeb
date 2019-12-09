package cn.lht.bookStore.service;

import java.util.List;

import org.junit.Test;

import cn.lht.bookStore.dao.OrderDao;
import cn.lht.bookStore.dao.OrderDaoImp;
import cn.lht.bookStore.entity.FenPage;
import cn.lht.bookStore.entity.OrderItem;
import cn.lht.bookStore.entity.Orders;

public class OrderService {
	OrderDao dao=new OrderDaoImp();
	public void createOrder(Orders orders) {
		dao.addOrderItem(orders.getItems());
		dao.addOrder(orders);
		
	}
	public void orderstatus(String oid) {
		dao.orderstatus(oid);
	}
	public void updatePnum(Orders orders) {
		for(OrderItem item:orders.getItems()) {
			dao.updatePnum(item.getProduct().getId(),item.getBuynum());
		}
	}
	public FenPage<Orders> ordersList(int id,int currentPage) {
		FenPage<Orders> ofp=new FenPage<>();
		int totalCount=dao.gettotalCount(id);
		int totalPage=totalCount%ofp.getRows()==0?(totalCount /ofp.getRows()):(totalCount / ofp.getRows())+1;
		int start=(currentPage-1)*ofp.getRows();
		List<Orders> olist=dao.OrderfindByPage(start,ofp.getRows(),id);
		ofp.setCurrentPage(currentPage);
		ofp.setTotalCount(totalCount);
		ofp.setTotalPage(totalPage);
		ofp.setList(olist);
		return ofp;
	}
	@Test
	public void Test11() {
		System.out.println(ordersList(1,1));
	}
	public void removeordersItem(String oid) {
		dao.removeordersItem(oid);
	}
	
	public Orders orderInfo(String oid) {
		
		Orders orders=(Orders)dao.orderInfo(oid);
		return orders;
		
	}
}
