package org.btsoft.jf.cloud.core.base.result;

import java.util.List;

import org.btsoft.jf.cloud.core.base.vo.PageVO;

/**
 * 分页结果实体对象
 * 
 * @param <T>
 */
public class PageResult<T> {

	private PageVO pageVO;

	private List<T> result;

	public PageResult() {

	}

	public PageResult(List<T> result, PageVO page) {
		this.result = result;
		this.pageVO = page;
	}

	public PageResult(List<T> result, PageVO page, int total) {
		this.result = result;
		this.pageVO = page;
		this.pageVO.setTotal(total);
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
}
