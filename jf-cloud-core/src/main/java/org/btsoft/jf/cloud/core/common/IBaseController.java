package org.btsoft.jf.cloud.core.common;

import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import java.util.List;

public interface IBaseController<T> {

    T createSingle(T t);

    T findSingle(T t);

    T updateSingle(T t);

    T deleteSingle(T t);

    List<T> findList(T t);

    PageResult<T> findPageList(T t, Page page);
}
