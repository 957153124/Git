package com.javaketang.util;


public class Page {
	
	private int rowTotal;


	private int pageSize = 5;

	
	private int current;

	
	private int total;


	private int startIndex;



	private int endIndex;


	public Page(int rowTotal, int currentPage) {
		this.rowTotal = rowTotal;

		this.current = currentPage;

		this.calculate();
	}

	
	public Page(int rowTotal, int currentPage, int pageSize) {
		this.rowTotal = rowTotal;
		this.current = currentPage;
		this.pageSize = pageSize;
		this.calculate();
	}


	private void calculate() {

		this.total = this.rowTotal / this.pageSize + ((this.rowTotal % this.pageSize) > 0 ? 1 : 0);

		if (current > total) {
			current = total;
		}
		if (current < 1) {
			current = 1;
		}

		startIndex = (this.current - 1) * this.pageSize + 1;

		endIndex = this.current * this.pageSize;

		if (endIndex > this.rowTotal) {
			endIndex = this.rowTotal;
		}

	}

	public int getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(int rowTotal) {
		this.rowTotal = rowTotal;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

}
