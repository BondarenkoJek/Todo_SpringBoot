package ua.bondarenkojek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.services.TaskService;
import ua.bondarenkojek.services.UserService;





@Controller
@RequestMapping("/{userName}")
public class PagingPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getUserPage(@PathVariable("userName") String userName, ModelMap model) {

        User user = userService.findByName(userName);


            int countPages = (int) Math.ceil(user.getTaskList().size()/10.0);

        model.addAttribute("userName", user.getUserName());
        model.addAttribute("list", taskService.findAllByUserId(user.getId(), PageRequest.of(0, 10)));
        model.addAttribute("count", countPages);
        model.addAttribute("numberPage", 1);
        return "user";
    }

    @GetMapping("page/{numberPage}")
    public String getUserPageWithNumber(@PathVariable("numberPage") int numberPage, @PathVariable("userName") String userName, ModelMap model) {
        User user = userService.findByName(userName);

        int countPages = (int) Math.ceil(user.getTaskList().size()/10.0);

        if (countPages <=1)
            return "redirect:/" + userName;

        if (countPages < numberPage)
            return "redirect:/" + userName + "/page/" + (numberPage-1);



        model.addAttribute("userName", user.getUserName());
        model.addAttribute("list", taskService.findAllByUserId(user.getId(), PageRequest.of(numberPage - 1, 10)));
        model.addAttribute("count", countPages);
        model.addAttribute("numberPage", numberPage);
        return "user";
    }
}
