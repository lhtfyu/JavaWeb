package cn.lht.bookStore.web.servlet;

import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VerificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width=180,height=30;
		char[] cs=new char[4];
		
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		Graphics g=img.getGraphics();
		g.setColor(Color.PINK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(0,0,width-1,height-1);
		String str="1234567890qwertyuiopasdfghjklmnbvcxzASDFGHJKLMNBVCXZQWERTYUIOP";
		Random rd=new Random();
		for(int i=1;i<=200;i++) {
			g.drawOval(rd.nextInt(width), rd.nextInt(height), 0, 1);
		}
		g.setFont(new Font("Î¢ÈíÑÅºÚ",5,20));
		g.setColor(Color.BLUE);
		for(int i=0;i<4;i++) {
			int index=rd.nextInt(str.length());
			char c=str.charAt(index);
			cs[i]=c;
			g.drawString(c+"", width/4*i, height/2);
		}
		g.setColor(Color.BLACK);
		for(int i=1;i<=10;i++) {
			g.drawLine(rd.nextInt(width), rd.nextInt(height),rd.nextInt(width), rd.nextInt(height));
		}
		
		String s=new String(cs);
	
		request.getSession().setAttribute("code",s);
		
		ImageIO.write(img,"jpg",response.getOutputStream());//ÒÔÍ¼Æ¬Êä³ö
	}
	
}
