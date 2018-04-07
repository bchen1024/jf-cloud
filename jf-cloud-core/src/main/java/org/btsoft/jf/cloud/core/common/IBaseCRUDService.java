package org.btsoft.jf.cloud.core.common;

import java.util.List;

import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;

public interface IBaseCRUDService<T> {

    T createSingle(T t);

    T findSingle(T t);

    T updateSingle(T t);

    T deleteSingle(T t);
    
    void deleteMultiple(List<T> t);

    List<T> findList(T t);

    PageResult<T> findPageList(T t, Page page);
}
