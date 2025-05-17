package com.example.crud3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hellow {
    @RequestMapping("/")
    public String hello(Model model){
        String msg = "Alex resenha";
        model.addAttribute("memsagem", msg);
        return "hellow";
    }
}
