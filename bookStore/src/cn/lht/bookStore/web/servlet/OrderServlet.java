package cn.lht.bookStore.web.servlet;

import java.util.ArrayList;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lht.bookStore.entity.Cart;
import cn.lht.bookStore.entity.CartItem;
import cn.lht.bookStore.entity.FenPage;
import cn.lht.bookStore.entity.OrderItem;
import cn.lht.bookStore.entity.Orders;
import cn.lht.bookStore.entity.User;
import cn.lht.bookStore.service.OrderService;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BookStoreServlet//HttpServlet 
{
	private static final long serialVersionUID = 1L;

	OrderService os=new OrderService();
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName=request.getParameter("method");
		try {
			Method method=getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this,request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}*/
	
	protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiverAddress=request.getParameter("receiverAddress");
		String receiverName=request.getParameter("receiverName");
		String receiverPhone=request.getParameter("receiverPhone");
		User user=(User)request.getSession().getAttribute("loginuser");
		Cart cart=(Cart) request.getSession().getAttribute("Cart");
		if(user==null) {
			return;
		}
		if(cart==null) {
			return;
		}
		Orders orders=new Orders();
		orders.setUser(user);
		orders.setOid(UUID.randomUUID().toString());
		orders.setMoney(cart.getCartMoney());
		orders.setOrdertime(new Date());
		orders.setReceiverAddress(receiverAddress);
		orders.setReceiverName(receiverName);
		orders.setReceiverPhone(receiverPhone);
		List<OrderItem> items=new ArrayList<OrderItem>();
		for(Entry<Integer, CartItem> entry:cart.getProducts().entrySet()) {
			OrderItem oitem=new OrderItem();
			oitem.setBuynum(entry.getValue().getQuantity());
			oitem.setOrders(orders);
			oitem.setProduct(entry.getValue().getProduct());
			items.add(oitem);
		}
		orders.setItems(items);		
		os.createOrder(orders);
		request.getSession().setAttribute("order",orders);
		request.getRequestDispatcher("pay.jsp").forward(request,response);
	}
	
	
	protected void ordersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String c=request.getParameter("currentPage");
		if(c==null||"".equals(c)) {
			c="1";
		}
		int currentPage=Integer.parseInt(c);
		FenPage<Orders> ofp=(FenPage<Orders>)os.ordersList(id,currentPage);
		request.setAttribute("ofp",ofp);
		request.getRequestDispatcher("orderlist.jsp").forward(request,response);
	}
	
	protected void orderInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oid =request.getParameter("oid");
		Orders orders=(Orders)os.orderInfo(oid);
		request.setAttribute("oinfo",orders);
		request.getRequestDispatcher("orderInfo.jsp").forward(request,response);
	}

	
	protected void removeordersItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oid=request.getParameter("oid");
		User user=(User)request.getSession().getAttribute("loginuser");
		os.removeordersItem(oid);
		request.getRequestDispatcher("/OrderServlet?method=ordersList&id="+user.getId()).forward(request,response);
	}
	/**
	 * 更新订单状态和库存
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void orderstatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Orders orders=(Orders)request.getSession().getAttribute("order");
		if(orders!=null) {
			os.orderstatus(orders.getOid());
			os.updatePnum(orders);
		}
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
