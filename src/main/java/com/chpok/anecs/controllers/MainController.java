package com.chpok.anecs.controllers;

import com.chpok.anecs.dao.AnecDao;
import com.chpok.anecs.dao.UserSavedAnecDao;
import com.chpok.anecs.models.Anec;
import com.chpok.anecs.models.User;
import com.chpok.anecs.models.UserSavedAnec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    AnecDao anecDao;

    @Autowired
    UserSavedAnecDao userSavedAnecDao;



    @RequestMapping(path = {"/main", "/main/{anec_id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    ModelAndView getMainPage(HttpSession session, @PathVariable(value = "anec_id", required = false) Long id){
        ModelAndView modelAndView = new ModelAndView("main");
        Optional<Anec> anec;

        if(id == null) {
            anec = anecDao.getRandomAnec();
        } else {
            anec = anecDao.get(id);
        }
        anec.ifPresent(value -> session.setAttribute("anec", value));
        return modelAndView;
    }

    @GetMapping(path = "/main/like")
    String addAnecToLiked(HttpSession session){
        Anec anec = (Anec) session.getAttribute("anec");
        User user = (User) session.getAttribute("user");

        userSavedAnecDao.save(new UserSavedAnec(user.getId(), anec.getId()));

        return "redirect:/main";
    }

}
