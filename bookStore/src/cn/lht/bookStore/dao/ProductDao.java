package cn.lht.bookStore.dao;

import java.util.List;

import cn.lht.bookStore.entity.Product;

public interface ProductDao {
	public int productCount(String category);
	
	public List<Product> findByPageList(String category,int start,int row);

	public Product findById(int id);
}
