package org.btsoft.jf.cloud.property.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class PropertyController {

    @RequestMapping("/add")
    public void add(){
        System.out.println("add");
    }

    @RequestMapping("/delete")
    public void delete(){
        System.out.println("delete");
    }
}
