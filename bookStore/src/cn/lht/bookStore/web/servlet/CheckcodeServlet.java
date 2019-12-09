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
		//������Ӧ����
		response.setContentType("application/json;charset=utf-8");
		
		  String username = request.getParameter("username");
	        String code=(String)request.getSession().getAttribute("code");
	        
	       // request.getSession().removeAttribute("code");		       
	        Map<String,Object> map = new HashMap<String,Object>();
	        if(code.equalsIgnoreCase(username)){
	            //����
	            map.put("userExsit",true);
	            map.put("msg","��֤����ȷ");
	        }else{
	            //������
	            map.put("userExsit",false);
	            map.put("msg","��֤�����");
	        }

	        //��mapתΪjson�����Ҵ��ݸ��ͻ���
	        //��mapתΪjson
	        ObjectMapper mapper = new ObjectMapper();
	        //���Ҵ��ݸ��ͻ���
	        mapper.writeValue(response.getWriter(),map);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
