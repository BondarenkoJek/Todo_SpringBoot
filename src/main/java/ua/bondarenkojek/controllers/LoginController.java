package ua.bondarenkojek.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller

public class LoginController {

    @GetMapping("/")
    public String main(Authentication authentication) {
        if (authentication==null)
        return "redirect:/login";
        return "redirect:/user/" + authentication.getName();
    }

    @GetMapping("/login")
    public String getLoginPage(ModelMap model, HttpServletRequest request) {
        if (request.getParameterMap().containsKey("error"))
            model.addAttribute("error", true);

        return "login";
    }
}
