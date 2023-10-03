package org.mvc.controller;

import org.mvc.dao.UsersDao;
import org.mvc.model.User;
import org.mvc.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    private ModelAndView getAllUsers() {
        List<User> all = usersDao.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersFromServer", all);
        return modelAndView;
    }

    @RequestMapping(path = "/user/name", method = RequestMethod.GET)
    private ModelAndView getUserByFirstName(@RequestParam(value = "first_name", required = false) String firstname) {
        List<User> list = usersDao.findAllByFirstName(firstname);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersFromServer", list);
        return modelAndView;
    }

    @RequestMapping(path = "/user/{user-id}", method = RequestMethod.GET)
    private ModelAndView getUserById(@PathVariable("user-id") Long id) {
        User list = usersDao.find(id).get();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersFromServer", Collections.singleton(list));
        return modelAndView;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    private String addUser(UserForm userForm) {
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName()).build();
        usersDao.save(user);
        return "redirect:/users";
    }
}
