package kabbadi.controller;

import kabbadi.domain.User;
import kabbadi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {
	private UserService userService;

	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homepage(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("home");
        String username = principal.getName();
        if (!username.isEmpty()) {
            User user = userService.getUser(username);
            modelAndView.addObject("user", user)
                        .addObject("username", username);
        }
        return modelAndView;
	}
}
