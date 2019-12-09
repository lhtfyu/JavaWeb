package cn.lht.bookStore.entity;

public class OrderItem {
	
	private int buynum;
	private Product product;
	private Orders orders;
	
	@Override
	public String toString() {
		return "OrderItem [buyname=" + buynum + ", product=" + product + ", orders=" + orders + "]";
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	

	
	
}
