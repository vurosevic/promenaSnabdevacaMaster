/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.User;
import eps.snabdevanje.promenasnabdevaca.domen.UserRoles;
import eps.snabdevanje.promenasnabdevaca.repository.UserRolesDAO;
import eps.snabdevanje.promenasnabdevaca.service.UserRolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("userRolesService")
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    UserRolesDAO userRolesDAO;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED) 
    public <S extends UserRoles> S save(S s) {
        return userRolesDAO.save(s);
    }

    @Override
    public void deleteAll(Iterable<? extends UserRoles> itrbl) {
        userRolesDAO.deleteAll(itrbl);
    }

    @Override
    public List<String> findListRolesByUser(User user) {
        return userRolesDAO.findListRolesByUser(user);
    }

    @Override
    public List<UserRoles> findByUser(User user) {
        return userRolesDAO.findByUser(user);
    }
    
}
