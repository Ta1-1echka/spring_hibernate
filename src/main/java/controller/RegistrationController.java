package controller;

import entity.User;
import hibernate.UserHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tanya on 11.11.2016.
 */
@Controller
@RequestMapping("/registration")
@SessionAttributes("sessionUser")
public class RegistrationController {

    @Autowired
    private UserHibernate userHibernate;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, @ModelAttribute("user") User user) {


        if (!userHibernate.isUserExist(user.getLogin())) {
            modelAndView.setViewName("welcome");
            userHibernate.createUser(user);
            modelAndView.addObject("user",user);
            modelAndView.addObject("sessionUser",user);
        } else {
            modelAndView.setViewName("registration");
            modelAndView.addObject("message", "Данный пользователь уже существует");
        }
        return modelAndView;
    }
}
