package org.btsoft.jf.cloud.core.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IBaseCRUDMapper<T> {

	int createSingle(@Param("vo") T t);

	T findSingle(@Param("vo") T t);

	int updateSingle(@Param("vo") T t);

	int deleteSingle(@Param("vo") T t);

	int deleteMultiple(@Param("list") List<T> t);

	List<T> findPageList(@Param("vo") T t);

}
