package kabbadi.controller;

import kabbadi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/uispike", method = RequestMethod.GET)
    public ModelAndView uispike() {
        ModelAndView modelAndView = new ModelAndView("uispike");
        Object[] invoices= new Object[40];
        modelAndView.addObject("invoices",invoices);
        return modelAndView;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage() {
        return "redirect:/invoice/list";
     }
}
