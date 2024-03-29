package cn.lht.bookStore.entity;

import java.util.List;

public class FenPage<T> {
	private int totalPage;
	private List<T> list;
	private int currentPage;
	private int rows=4;
	 private int totalCount;
	 private String category;
	 
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "FenPage [totalPage=" + totalPage + ", list=" + list + ", currentPage=" + currentPage + ", rows=" + rows
				+ ", totalCount=" + totalCount + "]";
	}
	 
}
