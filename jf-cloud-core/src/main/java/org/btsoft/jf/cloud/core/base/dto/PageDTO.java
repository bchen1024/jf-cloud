package org.btsoft.jf.cloud.core.base.dto;

/**
 * @author chenbin
 * @date 2018年6月8日 下午9:32:34
 */
public class PageDTO extends BaseDTO {

	private static final long serialVersionUID = 5608150403448082652L;

	private int curPage = 1;

	private int pageSize = 15;

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

}
