package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.services.UserService;

@Controller
@RequestMapping("/administrator")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect: /administrator";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("User")User user) {
        userService.save(user);
        return "redirect: /administrator";
    }
}
