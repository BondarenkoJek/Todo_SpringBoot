package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller

public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String main() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(ModelMap model, HttpServletRequest request) {
        if (request.getParameterMap().containsKey("error"))
            model.addAttribute("error", true);

        return "login";
    }

    @PostMapping(value = "/login")
    public String authentication(@RequestParam("userName") String username,
                                 @RequestParam("userPassword") String userPassword) {

        User user = userService.findUserByNameAndPassword(username, userPassword);
        if (user == null) {
            return "redirect:/login?error";

        } else
            return "redirect:/user/" + username;
    }
}
