package cn.lht.bookStore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lht.bookStore.dao.SearchDao;
import cn.lht.bookStore.entity.FenPage;
import cn.lht.bookStore.entity.Product;

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchname=request.getParameter("searchname");
		String c=request.getParameter("currentPage");
		if(c==null||c.equals(c)) {
			c="1";
		}
		int currentPage=Integer.parseInt(c);
		SearchDao dao=new SearchDao();
		FenPage<Product> searchfp=dao.Search(searchname,currentPage);
		searchfp.setCategory(searchname);
		request.setAttribute("searchpage", searchfp);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}
