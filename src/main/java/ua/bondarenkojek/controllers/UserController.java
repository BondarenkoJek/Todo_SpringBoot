package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.models.User;
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

    @RequestMapping
    public String login() {
        return "login";
    }

    @RequestMapping("registration")
    public String showRegistration() {
        return "registration";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String authenticationUser(@RequestParam("userName") String username,
                                     @RequestParam("userPassword") String userPassword) {

        User user = userService.findUserByNameAndPassword(username, userPassword);
        if (user == null) {
            return "redirect:/";
        } else
            return "redirect:/" + username;
    }


    @RequestMapping("create")
    public String addNewUser(@ModelAttribute("user")User user, RedirectAttributes redirectAttributes) {

        if (user == null) {
            return "redirect:/registration";
        } else
            if (userService.findByName(user.getUserName())!=null) {
                return "redirect:/registration";
            }
            userService.save(user);
        return "redirect:/" + user.getUserName();
    }

    @RequestMapping("{userName}")
    public String getUserPage(@PathVariable("userName") String userName, ModelMap model) {
        model.addAttribute("taskList", userService.findByName(userName).getTaskList());
        model.addAttribute("userName", userName);
        return "user";
    }

    @RequestMapping("{userName}/add")
    public String addTaskToUser(@RequestParam("description")String description, @PathVariable("userName") String userName) {

        User user = userService.findByName(userName);
        Task task = new Task(description);
        task.setDate(new Date());
        user.addTask(task);
        userService.save(user);
        return "redirect:/" + userName;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delTaskToUser(@PathVariable("id") Long id) {
        Task task = taskService.findById(id);
        User user = task.getUser();
        user.removeTask(task);
        userService.save(user);
        return "redirect:/" + user.getUserName();
    }

    @RequestMapping(value = "state/{id}", method = RequestMethod.GET)
    public String stateTask(@PathVariable("id") Long id) {
        Task task = taskService.findById(id);
        User user = task.getUser();


        task.setState(task.getState()?false:true);

        taskService.save(task);
        return "redirect:/" + user.getUserName();
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editTask(@PathVariable("id") Long id, @RequestParam("description")String description) {
        Task task = taskService.findById(id);
        User user = task.getUser();

        task.setDescription(description);

        taskService.save(task);
        return "redirect:/" + user.getUserName();
    }



}
