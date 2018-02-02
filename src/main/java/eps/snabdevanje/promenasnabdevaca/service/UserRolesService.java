/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.User;
import eps.snabdevanje.promenasnabdevaca.domen.UserRoles;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Vladimir
 */
public interface UserRolesService {
    
    public <S extends UserRoles> S save(S s);
    public void deleteAll(Iterable<? extends UserRoles> itrbl);   
    public List<UserRoles> findByUser(User user);
    public List<String> findListRolesByUser(User user);      
}
