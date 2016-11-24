package com.pabloam.projects.googleauth.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(Map<String, Object> model){
        return "hello world!";
    }

    @RequestMapping("/login")
    public String login() {
        return "redirect:/#/";
    }

    @RequestMapping("/user")
    public String user(Principal principal) {
        return principal.getName();
    }
}
