package org.btsoft.jf.cloud.property.service.impl;

import org.btsoft.jf.cloud.property.entity.Property;
import org.btsoft.jf.cloud.property.repository.IPropertyRepository;
import org.btsoft.jf.cloud.property.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private IPropertyRepository dao;

    @Override
    public Property add(Property s) {
        return dao.save(s);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Property update(Property s) {
        return dao.save(s);
    }

    @Override
    public Property findOne(Long id) {
        return dao.findOne(id);
    }
}
