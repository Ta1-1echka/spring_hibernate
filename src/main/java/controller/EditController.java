package controller;

import entity.User;
import hibernate.UserHibernate;
import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.hibernate.FlushMode.*;

/**
 * Created by Tanya on 16.11.2016.
 */
@Controller
@RequestMapping("/edit")
@SessionAttributes(value = "sessionUser")
public class EditController {

    @Autowired
    private UserHibernate userHibernate;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getEditPage(ModelAndView modelAndView, @SessionAttribute("sessionUser") User user) {
        modelAndView.setViewName("editUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView editUser(ModelAndView modelAndView, @ModelAttribute("user") User user,
                                 @SessionAttribute("sessionUser") User sessionUser) {


        boolean res = false;
        if (!user.getLogin().equals(sessionUser.getLogin())) {
            res = userHibernate.isUserExist(user.getLogin());
        }

        if (!res) {
            try {
                userHibernate.updateUser(user);
            }
            catch (Exception e)
            {
                System.out.println("********"+user.toString());
            }
            modelAndView.addObject("user", user);
            modelAndView.addObject("sessionUser", user);
            modelAndView.addObject("message", "Данный пользователь успешно изменен");
        } else {
            modelAndView.addObject("user", sessionUser);
            modelAndView.addObject("message", "Пользователь с Login = " + user.getLogin() + " уже существует");
        }


        modelAndView.setViewName("editUser");
        return modelAndView;
    }
}
