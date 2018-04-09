package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by go on 2017/7/12.
 */

@Controller
public class MyControl {



    @RequestMapping("/hello")
    @ResponseBody
    public String say(){
        return  "Hello World";
    }


    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host","http://blog.didispace.com");
        return "index";
    }
}
