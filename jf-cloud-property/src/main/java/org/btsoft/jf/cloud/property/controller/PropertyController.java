package org.btsoft.jf.cloud.property.controller;

import org.btsoft.jf.cloud.property.entity.Property;
import org.btsoft.jf.cloud.property.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private IPropertyService service;

    @RequestMapping(value="/",method = RequestMethod.POST)
    public Property add(@RequestBody Property property){
        return service.add(property);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public Property update(@PathVariable("id") Long id,@RequestBody Property property){
        property.setId(id);
        return service.update(property);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Property findOne(@PathVariable("id")Long id){
        return service.findOne(id);
    }
}
