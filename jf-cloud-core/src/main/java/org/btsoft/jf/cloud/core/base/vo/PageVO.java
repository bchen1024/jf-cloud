package org.btsoft.jf.cloud.core.base.vo;

import java.io.Serializable;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午9:38:06
 */
public class PageVO implements Serializable {

	private static final long serialVersionUID = 7671229239640243728L;

	/**
	 * 当前第几页
	 */
	private int curPage = 1;

	/**
	 * 每页大小
	 */
	private int pageSize=15;

	/**
	 * 总记录数
	 */
	private long total;

	/**
	 * 总页数
	 */
	private int totalPages;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getTotalPages() {
		this.totalPages = (int) Math.floor((double) ((this.total + this.pageSize - 1) / this.pageSize));
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
