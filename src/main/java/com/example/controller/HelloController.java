package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap){

        // Handle null ModelMap gracefully
        if (modelMap == null) {
            modelMap = new ModelMap();
        }

        // add attribute to load modelMap
        modelMap.addAttribute("message", "Hello! Today is March 22, 2024.");

        // return the name of the file to be loaded "hello_world.jsp"
        return "hello";
    }
}
