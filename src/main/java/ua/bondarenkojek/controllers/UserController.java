package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.security.details.UserDetailsImpl;
import ua.bondarenkojek.services.TaskService;
import ua.bondarenkojek.services.UserService;

import java.util.Date;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String home(Authentication authentication) {
        if (authentication==null)
            return "redirect:/login";

        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        User user = details.getUser();

        return "redirect:/" + user.getUserName();
    }

    @GetMapping("add")
    public String addTask(@RequestParam("description")String description, Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        String userName = details.getUser().getUserName();

        User user = userService.findByName(userName);
        Task task = new Task(description);
        task.setDate(new Date());
        user.addTask(task);
        userService.save(user);
        return "redirect:/" + userName;
    }

    @GetMapping(value = "delete")
    public String deleteTask(@RequestParam("id") Long id) {
        Task task = taskService.findById(id);
        User user = task.getUser();
        user.removeTask(task);
        userService.save(user);
        return "redirect:/" + user.getUserName();
    }

    @GetMapping(value = "state")
    public String setStateTask(@RequestParam("id") Long id) {
        Task task = taskService.findById(id);
        User user = task.getUser();

        task.setState(task.getState()?false:true);

        taskService.save(task);
        return "redirect:/" + user.getUserName();
    }

    @GetMapping(value = "edit")
    public String editTask(@RequestParam("id") Long id, @RequestParam("description")String description) {
        Task task = taskService.findById(id);
        User user = task.getUser();

        task.setDescription(description);

        taskService.save(task);
        return "redirect:/" + user.getUserName();
    }
}
