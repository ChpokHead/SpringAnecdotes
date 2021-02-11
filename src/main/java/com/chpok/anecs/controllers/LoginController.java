package com.chpok.anecs.controllers;

import com.chpok.anecs.dao.UserDao;
import com.chpok.anecs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserDao userDao;

    @GetMapping(path = "/login")
    ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping(path = "/login")
    String postLoginPage(HttpSession session, @ModelAttribute("username") String username,
                         @ModelAttribute("password") String password) {
        if (userDao.checkIfUserExist(username, password)) {
            Optional<User> user = userDao.getUserByUsername(username);
            user.ifPresent(value -> session.setAttribute("user", value));
            return "redirect:/main";
        }
        return "redirect:/login";
    }

}
