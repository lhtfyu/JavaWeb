package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;
import service.UserServiceImp;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		
		
		UserService us=new UserServiceImp();
		User u=(User)us.findByUserName(user);			
			if(u==null) {
				request.setAttribute("user_error", "”√ªß√˚¥ÌŒÛ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			if(!password.equals(u.getPassword())) {
				request.setAttribute("mima_error", "√‹¬Î¥ÌŒÛ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			request.getSession().setAttribute("loginuser",u);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
