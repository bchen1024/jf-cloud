package org.btsoft.jf.cloud.property.controller;

import org.btsoft.jf.cloud.property.repository.IPropertyRepository;
import org.btsoft.jf.cloud.property.entity.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class PropertyController {

    @Autowired
    private IPropertyRepository dao;

    @RequestMapping(method = RequestMethod.POST)
    public Property add(@RequestBody Property property){
        return dao.save(property);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        dao.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Property update(@RequestBody Property property){
        return dao.save(property);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Property findOne(Long id){
        return dao.findOne(id);
    }
}
