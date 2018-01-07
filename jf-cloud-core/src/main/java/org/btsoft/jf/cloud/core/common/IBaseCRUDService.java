package org.btsoft.jf.cloud.core.common;

import org.apache.ibatis.annotations.Param;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;

import java.util.List;

public interface IBaseCRUDService<T> {

    T createSingle(@Param("vo") T t);

    T findSingle(@Param("vo")T t);

    T updateSingle(@Param("vo")T t);

    T deleteSingle(@Param("vo")T t);

    List<T> findList(@Param("vo")T t);

    PageResult<T> findPageList(@Param("vo")T t, @Param("page")Page page);
}
