package kabbadi.controller;

import kabbadi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage() {
        return "redirect:/invoice/list";
     }
}
