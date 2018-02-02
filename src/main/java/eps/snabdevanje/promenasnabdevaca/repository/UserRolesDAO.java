/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.User;
import eps.snabdevanje.promenasnabdevaca.domen.UserRoles;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("userRolesDAO")
public interface UserRolesDAO extends CrudRepository<UserRoles, Long>{

    @Override
    public <S extends UserRoles> S save(S s);

    @Override
    public void deleteAll(Iterable<? extends UserRoles> itrbl);
    
    @Query("SELECT ur FROM UserRoles ur WHERE ur.user=:user")
    public List<UserRoles> findByUser(@Param("user") User user);
    
    @Query("SELECT ur.roles FROM UserRoles ur WHERE ur.user=:user")
    public List<String> findListRolesByUser(@Param("user") User user);            
}
