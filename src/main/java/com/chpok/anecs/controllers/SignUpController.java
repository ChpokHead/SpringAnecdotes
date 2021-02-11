package com.chpok.anecs.controllers;

import com.chpok.anecs.dao.UserDao;
import com.chpok.anecs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/signUp")
    public ModelAndView getSignUpPage() {
        return new ModelAndView("signUp");
    }

    @RequestMapping(path = "/signUp", method = RequestMethod.POST)
    public String postSignUpPage(@ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        if(username != null && password != null)
            userDao.save(new User(username, password));
        return "redirect:/main";
    }
}
