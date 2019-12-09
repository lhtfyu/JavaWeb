package cn.lht.bookStore.service;

import java.util.List;

import org.junit.Test;

import cn.lht.bookStore.dao.ProductDao;
import cn.lht.bookStore.dao.ProductDaoImp;
import cn.lht.bookStore.entity.FenPage;
import cn.lht.bookStore.entity.Product;

public class ProductService {
	ProductDao dao=new ProductDaoImp();
	public FenPage<Product> findByPage(int currentPage,String category){
		FenPage<Product> fp=new FenPage<>();
		int  totalCount=dao.productCount(category);
		int totalPage=totalCount%fp.getRows()==0?(totalCount/fp.getRows()):(totalCount/fp.getRows())+1;
		int start=(currentPage-1)*fp.getRows();
		List<Product> list=dao.findByPageList(category, start,fp.getRows());
		fp.setCurrentPage(currentPage);
		fp.setList(list);
		fp.setCategory(category);
		fp.setTotalCount(totalCount);
		fp.setTotalPage(totalPage);
		return fp;		
	}
	
	public Product findById(int id) {
		return dao.findById(id);	
	}
	@Test
	public void Test02() {
		FenPage<Product> fp=findByPage(1, "¼ÆËã»ú");
		System.out.println(fp);
	}
}
