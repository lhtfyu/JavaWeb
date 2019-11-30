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


@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));
		String address=request.getParameter("address");
		String qq=request.getParameter("qq");
		String email=request.getParameter("email");
		
		User user=new User();
		user.setAddress(address);
		user.setEmail(email);
		user.setName(name);
		user.setAge(age);
		user.setGender(sex);
		user.setQq(qq);
		user.setId(id);
		
		
		UserService us=new UserServiceImp();
		us.update(user);
		response.sendRedirect("UserByPage");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
