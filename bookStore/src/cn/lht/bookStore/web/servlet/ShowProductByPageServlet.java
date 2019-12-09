package cn.lht.bookStore.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lht.bookStore.dao.ProductDao;
import cn.lht.bookStore.dao.ProductDaoImp;
import cn.lht.bookStore.entity.FenPage;
import cn.lht.bookStore.entity.Product;
import cn.lht.bookStore.service.ProductService;

/**
 * Servlet implementation class ShowProductByPageServlet
 */
@WebServlet("/showProductByPage")
public class ShowProductByPageServlet extends BookStoreServlet//HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ProductService ps=new ProductService();
	
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
	
	protected void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strid=request.getParameter("id");
		int id=Integer.parseInt(strid);
		Product pd=(Product)ps.findById(id);
		request.setAttribute("product",pd);
		request.getRequestDispatcher("product_info.jsp").forward(request,response);
	}
	protected void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("category");
		String c=request.getParameter("currentPage");
		if(c==null||"".equals(c)) {
			c="1";
		}
		int currentPage=Integer.parseInt(c);
		FenPage<Product> fp=ps.findByPage(currentPage, category);
		request.getSession().setAttribute("fp",fp);
		request.getRequestDispatcher("product_list.jsp").forward(request,response);
	}

}
