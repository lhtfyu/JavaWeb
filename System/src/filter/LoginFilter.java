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
		//ͳһ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ����·��
		String uri=request.getRequestURI();	
		
		if(uri.contains("/login.jsp")||uri.contains("/Login")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/Code")||uri.contains("/CheckcodeServlet")) {
			//·���а�����Щ��������
			chain.doFilter(request, response);
		}else {
			
			User loginuser=(User)request.getSession().getAttribute("loginuser");
			//�ж�session������loginuser,�оͷ���
			if(loginuser!=null) {
				
				chain.doFilter(request, response);//����
				
			}else {
				//û�о�ת����loginҳ��
				request.setAttribute("login_error","���¼!!!");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
