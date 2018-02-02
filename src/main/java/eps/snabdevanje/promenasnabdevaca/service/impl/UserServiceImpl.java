/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.User;
import eps.snabdevanje.promenasnabdevaca.repository.UserDAO;
import eps.snabdevanje.promenasnabdevaca.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    
    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends User> S save(S s) {
        return userDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(User t) {
        userDAO.delete(t);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
    
}
