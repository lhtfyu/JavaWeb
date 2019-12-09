package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;



/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    
   
	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//统一编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取请求路径
		String uri=request.getRequestURI();	
		
		if(uri.contains("/login.jsp")||uri.contains("/Login")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/Code")||uri.contains("/CheckcodeServlet")) {
			//路径有包含这些参数放行
			chain.doFilter(request, response);
		}else {
			
			User loginuser=(User)request.getSession().getAttribute("loginuser");
			//判断session中有无loginuser,有就放行
			if(loginuser!=null) {
				
				chain.doFilter(request, response);//放行
				
			}else {
				//没有就转发回login页面
				request.setAttribute("login_error","请登录!!!");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
