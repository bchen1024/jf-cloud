package org.btsoft.jf.cloud.core.base.dto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 批量DTO
 * @author chenbin
 * @date 2019-03-07 22:53
 */
public class BatchDTO<T> implements Serializable {

	private static final long serialVersionUID = 1043380491802154813L;
	
	@NotEmpty
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
