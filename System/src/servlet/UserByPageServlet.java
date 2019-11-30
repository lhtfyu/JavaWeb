package servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageBean;
import service.UserService;
import service.UserServiceImp;

/**
 * Servlet implementation class UserByPageServlet
 */
@WebServlet("/UserByPage")
public class UserByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String c=request.getParameter("currentPage");
		String r=request.getParameter("rows");
		
		if(c == null || "".equals(c)){
            c = "1";
        }
        if(r == null || "".equals(r)){
            r = "5";
        }
        
        
        //获取条件查询的参数
        Map<String, String[]> condtion=request.getParameterMap();       
		int currenPage=Integer.parseInt(c);
		int rows=Integer.parseInt(r);		
		UserService us=new UserServiceImp();
		PageBean pd=us.findUserByPage(currenPage, rows,condtion);
		request.setAttribute("pd",pd);
		request.setAttribute("condition",condtion);
		request.getRequestDispatcher("list.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
