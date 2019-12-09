package cn.lht.bookStore.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lht.bookStore.entity.User;
import cn.lht.bookStore.service.UserService;


@WebServlet("/UserServlet")
public class UserServlet extends BookStoreServlet//HttpServlet 
{
	private static final long serialVersionUID = 1L;

	UserService us=new UserService();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	}*/
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=us.login(username);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				request.getSession().setAttribute("loginuser",user);
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}else {
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}else {
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

	/**
	 * 已登录的用户更新信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("gender");
		String phone=request.getParameter("telephone");
		Integer id=Integer.parseInt(request.getParameter("id"));
		User user=new User();
		user.setId(id);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setSex(sex);
		if(us.updateUser(user)) {
			request.getSession().removeAttribute("loginuser");
			request.getRequestDispatcher("modifyUserInfoSuccess.jsp").forward(request,response);
		}
	}

	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("loginuser");
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("gender");
		String phone=request.getParameter("telephone");
		String info=request.getParameter("introduce");
		User user=new User();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setInfo(info);
		user.setPhone(phone);
		
		boolean isRegiister=us.userRegister(user);
		if(isRegiister) {
			request.getRequestDispatcher("registersuccess.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}
	}
}
