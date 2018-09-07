package ua.bondarenkojek.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signUp")
    public String signUp(ModelMap model, HttpServletRequest request) {
        if (request.getParameterMap().containsKey("error"))
            model.addAttribute("error", true);
        return "signUp";
    }

    @RequestMapping("/create")
    public String addNewUser(@ModelAttribute("user")User user) {

        if (user == null) {
            return "redirect:/signUp";
        } else
        if (userService.findByName(user.getUserName())!=null) {
            return "redirect:/signUp?error";
        }
        userService.save(user);
        return "redirect:/user/" + user.getUserName();
    }
}
