/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("userDAO")
public interface UserDAO extends CrudRepository<User, Long>{
    
    @Query("SELECT u FROM User u WHERE username = :username AND password = :password")
    User login(@Param("username") String username, @Param("password") String password);
    
    @Query("SELECT u FROM User u WHERE username = :username")
    User findByUsername(@Param("username") String username);    

    @Override
    public <S extends User> S save(S s);

    @Override
    public void delete(User t);

    @Override
    public List<User> findAll();
        
    
    
}
