package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("login")
    public String login(ModelMap model, HttpServletRequest request) {
        if (request.getParameterMap().containsKey("error"))
            model.addAttribute("error", true);

        return "login";
    }

    @RequestMapping("registration")
    public String showRegistration() {
        return "registration";
    }


    @RequestMapping(value = "authentication", method = RequestMethod.POST)
    public String authenticationUser(@RequestParam("userName") String username,
                                     @RequestParam("userPassword") String userPassword) {

        User user = userService.findUserByNameAndPassword(username, userPassword);
        if (user == null) {
            return "redirect:/login?error";

        } else
            return "redirect:/user/" + username;
    }
}
