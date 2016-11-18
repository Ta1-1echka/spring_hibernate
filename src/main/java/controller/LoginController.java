package controller;

import entity.User;
import hibernate.UserHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Tanya on 10.11.2016.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("sessionUser")
public class LoginController {

    @Autowired
    private UserHibernate userHibernate;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView getUser(ModelAndView modelAndView, @RequestParam("login") String login,
                                @RequestParam("password") String password) {
        List<User> list = userHibernate.getUserByLoginPass(login, password);
        if(!list.isEmpty())
        {

            modelAndView.setViewName("welcome");
            modelAndView.addObject("user",list.get(0));
            modelAndView.addObject("sessionUser",list.get(0));

        }
        else {
            modelAndView.setViewName("login");
            modelAndView.addObject("message", "Неверно введен login или password");
        }
        return modelAndView;
    }
}