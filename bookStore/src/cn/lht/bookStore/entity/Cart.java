package cn.lht.bookStore.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.lht.bookStore.dao.ProductDao;
import cn.lht.bookStore.dao.ProductDaoImp;


public class Cart {
	Map<Integer,CartItem> products=new HashMap<Integer, CartItem>();
	/**
	 * 商品添加到购物车
	 * @param id
	 */
	public void productAddCart(int id) {
		ProductDao dao=new ProductDaoImp();
		Product p=(Product)dao.findById(id);
		CartItem item=products.get(p.getId());
		if(p!=null) {
			if(item==null) {
				 item=new CartItem(p);
				 products.put(p.getId(),item);
			}else {
				item.increment();
			}
		}
	}
	
	public Map<Integer, CartItem> getProducts() {
		return products;
	}
	public void setProducts(Map<Integer, CartItem> products) {
		this.products = products;
	}
	
	/**
	 * 获取购物车总金额
	 * @return
	 */
	public Double getCartMoney() {
		double money=0;
		for(CartItem item : products.values()) {
			money += item.getItemMoney();
		}
		return money;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<CartItem> getItems() {
		return products.values();
		
	}

	public void removeItem(int id) {
		products.remove(id);	
	}
}
