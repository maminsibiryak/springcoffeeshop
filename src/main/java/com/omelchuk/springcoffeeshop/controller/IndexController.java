package com.omelchuk.springcoffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {



    @GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            strings.add("i="+i);
        }
        model.put("name", "Andrey");




        return new ModelAndView("index", model);
    }
}
