package org.btsoft.jf.cloud.core.common;

import org.apache.ibatis.annotations.Param;
import org.btsoft.jf.cloud.core.entity.Page;

import java.util.List;

public interface IBaseCRUDMapper<T> {

    int createSingle(@Param("vo") T t);

    T findSingle(@Param("vo")T t);

    int updateSingle(@Param("vo")T t);

    int deleteSingle(@Param("vo")T t);

    List<T> findList(@Param("vo")T t);

    List<T> findPageList(@Param("vo")T t, @Param("page")Page page);

    int findCount(@Param("vo")T t);
}
