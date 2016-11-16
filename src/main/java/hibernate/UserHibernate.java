package hibernate;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tanya on 10.11.2016.
 */

@Repository
@Transactional("transactionManager")
public class UserHibernate {


    @Autowired
    private HibernateTemplate hibernateTemplate;

    public User getUserById(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    public List<User> getUserByLoginPass(String login, String pass) {
        User u = new User();
        u.setLogin(login);
        u.setPassword(pass);
        return hibernateTemplate.findByExample(u);
    }

    public Serializable createUser(User u) {
        return hibernateTemplate.save(u);
    }

    @Transactional(value = "transactionManager", readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class})
    public void updateUser(User u) {
        hibernateTemplate.update(u);
    }

    public List<User> isUserExist(String login) {
        User u = new User();
        u.setLogin(login);
        return hibernateTemplate.findByExample(u);
    }
}
