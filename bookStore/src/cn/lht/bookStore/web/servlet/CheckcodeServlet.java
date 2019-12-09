package cn.lht.bookStore.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/CheckcodeServlet")
public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应类型
		response.setContentType("application/json;charset=utf-8");
		
		  String username = request.getParameter("username");
	        String code=(String)request.getSession().getAttribute("code");
	        
	       // request.getSession().removeAttribute("code");		       
	        Map<String,Object> map = new HashMap<String,Object>();
	        if(code.equalsIgnoreCase(username)){
	            //存在
	            map.put("userExsit",true);
	            map.put("msg","验证码正确");
	        }else{
	            //不存在
	            map.put("userExsit",false);
	            map.put("msg","验证码错误");
	        }

	        //将map转为json，并且传递给客户端
	        //将map转为json
	        ObjectMapper mapper = new ObjectMapper();
	        //并且传递给客户端
	        mapper.writeValue(response.getWriter(),map);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
