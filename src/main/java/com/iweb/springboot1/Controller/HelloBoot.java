package com.iweb.springboot1.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@Controller
//@ResponseBody
public class HelloBoot {
    @GetMapping("/hello")
    public  Object hello() {
        List<String> list = new ArrayList<String>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        return list;
    }
}
