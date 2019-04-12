package org.btsoft.jf.cloud.core.base.entity;

import java.util.List;

import org.btsoft.jf.cloud.core.base.vo.PageVO;

/**
 * 分页实体对象
 * @author chenbin
 * @date 2018-11-27 22:42
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

	public PageResult(List<T> result, PageVO page, Long total) {
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
