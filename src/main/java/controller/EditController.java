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
@SessionAttributes(value = "user")
public class EditController {

    @Autowired
    private UserHibernate userHibernate;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getEditPage(ModelAndView modelAndView, @SessionAttribute("user") User user) {
        modelAndView.setViewName("editUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView editUser(ModelAndView modelAndView, @ModelAttribute("user") User user) {
        userHibernate.updateUser(user);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }
}
