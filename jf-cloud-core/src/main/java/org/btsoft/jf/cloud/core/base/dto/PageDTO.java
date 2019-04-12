package org.btsoft.jf.cloud.core.base.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * @author chenbin
 * @date 2018年6月8日 下午9:32:34
 */
public class PageDTO implements Serializable{

	private static final long serialVersionUID = 2130282720558694599L;

	private Integer curPage;

	private Integer pageSize;

	public Integer getCurPage() {
		if(curPage==null ||curPage<=0) {
			curPage=1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageSize() {
		if(pageSize==null ||pageSize<=0) {
			pageSize=15;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
