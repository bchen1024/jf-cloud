package org.btsoft.jf.cloud.core.base.service;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;

public interface IBaseCRUDService<T> {

	int createSingle(T t);

	T findSingle(T t);

	int updateSingle(T t);

	int deleteSingle(T t);

	int deleteMultiple(List<T> t);

	PageResult<T> findPageList(T t, PageDTO pageDTO);
}
