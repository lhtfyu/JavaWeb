package cn.lht.bookStore.web.filter;

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

import cn.lht.bookStore.entity.User;

/**
 * Servlet Filter implementation class BookStoreFilter
 */
@WebFilter("/*")
public class BookStoreFilter implements Filter {

   
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String url=request.getRequestURI();
		if(url.contains("/CheckcodeServlet")||url.contains("/VerificationCodeServlet")||url.contains("/css/")||url.contains("/js/")||url.contains("/login.jsp")||url.contains("/UserServlet")||url.contains("/index.jsp")||url.contains("/register.jsp")) {
			chain.doFilter(request, response);
		}else {
			User user=(User)request.getSession().getAttribute("loginuser");
			if(user!=null) {
				chain.doFilter(request, response);
			}else {
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
