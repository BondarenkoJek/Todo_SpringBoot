package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.models.UserRole;
import ua.bondarenkojek.models.UserState;
import ua.bondarenkojek.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String getSignUpPage(ModelMap model, HttpServletRequest request) {
        if (request.getParameterMap().containsKey("error"))
            model.addAttribute("error", true);
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("user")User user) {

        if (user == null) {
            return "redirect:/signUp";
        } else
        if (userService.findByName(user.getUserName())!=null) {
            return "redirect:/signUp?error";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserState(UserState.ACTIVE);
        user.setUserRole(UserRole.USER);
        userService.save(user);
        return "redirect:/user/" + user.getUserName();
    }
}
