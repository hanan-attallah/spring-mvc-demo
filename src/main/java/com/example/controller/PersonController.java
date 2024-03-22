package com.example.controller;

import com.example.model.Address;
import com.example.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String showPersonForm(ModelMap model) {
        model.addAttribute("person", new Person());
        return "person_form";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String submitPersonForm(@ModelAttribute("person") Person person, ModelMap model) {
        // You can add validation or further processing here
        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());

        Address address = person.getAddress();
        if (address != null) {
            model.addAttribute("city", address.getCity());
            model.addAttribute("country", address.getCountry());
        } else {
            // Handle case when Address is null
            model.addAttribute("city", "Unknown");
            model.addAttribute("country", "Unknown");
        }

        return "person_details";
    }

}
