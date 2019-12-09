package cn.lht.bookStore.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.lht.bookStore.entity.Cart;


public class SessionCartUtil {
	public static Cart getSessionCart(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		Cart sc = (Cart) session.getAttribute("Cart");
		if (sc == null) {
			sc = new Cart();
		}
		session.setAttribute("Cart", sc);
		return sc;
	
	}
}
