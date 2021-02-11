package com.chpok.anecs.controllers;

import com.chpok.anecs.dao.UserSavedAnecDao;
import com.chpok.anecs.models.Anec;
import com.chpok.anecs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserPage {

    @Autowired
    UserSavedAnecDao userSavedAnecDao;

    @GetMapping(path = "/userPage")
    ModelAndView getUserPage(HttpSession session) {
        Long userId = ((User)session.getAttribute("user")).getId();
        List<Anec> anecList = userSavedAnecDao.getSavedAnecsByUserId(userId);

        ModelAndView modelAndView = new ModelAndView("userPage");
        modelAndView.addObject("anecList", anecList);

        return modelAndView;
    }
}
