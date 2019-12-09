package cn.lht.bookStore.entity;

public class CartItem {
	private Product product;
	private int quantity;
	
	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public Double getItemMoney() {
		return product.getPrice()*quantity;
		
	}
	public void increment() {		
		this.quantity++;
	}
}
