package org.btsoft.jf.cloud.core.base.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
	private Integer curPage;

	/**
	 * 每页大小
	 */
	private Integer pageSize;

	/**
	 * 总记录数
	 */
	private Long total;

	/**
	 * 总页数
	 */
	private Integer totalPages;

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getTotalPages() {
		this.totalPages = (int) Math.floor((double) ((this.total + this.pageSize - 1) / this.pageSize));
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
