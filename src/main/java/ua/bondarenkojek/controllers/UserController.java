package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.services.TaskService;
import ua.bondarenkojek.services.UserService;


import java.util.Date;


@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;



    @GetMapping("{userName}")
    public String getUserPage(@PathVariable("userName") String userName, ModelMap model) {
        model.addAttribute("taskList", userService.findByName(userName).getTaskList());
        model.addAttribute("userName", userName);
        return "user";
    }

    @GetMapping("add/{userName}")
    public String addTask(@RequestParam("description")String description, @PathVariable("userName") String userName) {

        User user = userService.findByName(userName);
        Task task = new Task(description);
        task.setDate(new Date());
        user.addTask(task);
        userService.save(user);
        return "redirect:/user/" + userName;
    }

    @GetMapping(value = "delete")
    public String deleteTask(@RequestParam("id") Long id) {
        Task task = taskService.findById(id);
        User user = task.getUser();
        user.removeTask(task);
        userService.save(user);
        return "redirect:/user/" + user.getUserName();
    }

    @GetMapping(value = "state")
    public String setStateTask(@RequestParam("id") Long id) {
        Task task = taskService.findById(id);
        User user = task.getUser();


        task.setState(task.getState()?false:true);

        taskService.save(task);
        return "redirect:/user/" + user.getUserName();
    }

    @GetMapping(value = "edit")
    public String editTask(@RequestParam("id") Long id, @RequestParam("description")String description) {
        Task task = taskService.findById(id);
        User user = task.getUser();

        task.setDescription(description);

        taskService.save(task);
        return "redirect:/user/" + user.getUserName();
    }



}
