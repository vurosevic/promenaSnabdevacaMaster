/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.User;
import java.util.List;

/**
 *
 * @author Vladimir
 */
public interface UserService {
    
    User login(String username, String password);    
    User findByUsername(String username);       
    
    public <S extends User> S save(S s);
    public void delete(User t);
    public List<User> findAll();     
    
}
