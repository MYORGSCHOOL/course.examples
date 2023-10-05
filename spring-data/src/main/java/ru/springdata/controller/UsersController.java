package ru.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.springdata.model.User;
import ru.springdata.model.UserForm;
import ru.springdata.service.UserService;

import java.util.List;

@Controller
@EnableScheduling
@RequiredArgsConstructor
public class UsersController {

    private final UserService service;
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    private ModelAndView getAllUsers() {
        List<User> all = service.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersFromServer", all);
        return modelAndView;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public String addUser(UserForm form) {
        User build = User.builder().lastName(form.getLastName())
                .firstName(form.getFirstName()).build();
        service.save(build);
        return "redirect:/users";
    }
}
