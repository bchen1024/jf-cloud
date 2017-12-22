package org.btsoft.jf.cloud.core.service;

import java.io.Serializable;

public interface IBaseService<T,ID extends Serializable> {

    T add(T s);

    void delete(ID id);

    T update(T s);

    T findOne(ID id);

}
