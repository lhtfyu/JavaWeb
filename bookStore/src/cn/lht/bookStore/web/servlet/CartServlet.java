package cn.lht.bookStore.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lht.bookStore.entity.Cart;
import cn.lht.bookStore.entity.User;
import cn.lht.bookStore.utils.SessionCartUtil;


@WebServlet("/CartServlet")
public class CartServlet extends BookStoreServlet//HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	protected void AddtoCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Cart cart=(Cart)SessionCartUtil.getSessionCart(request);
		cart.productAddCart(id);	
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}
	
	protected void removeItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Cart cart=(Cart)SessionCartUtil.getSessionCart(request);
		cart.removeItem(id);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
	/**
	 * Ω·’À
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void settleAccounts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("loginuser");
		if(user==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
	}
}
