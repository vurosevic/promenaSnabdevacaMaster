/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.Status;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("statusDAO")
public interface StatusDAO extends CrudRepository<Status, Long>{

    @Override
    @Query("SELECT s FROM Status s")
    public List<Status> findAll();

    @Override
    public <S extends Status> S save(S s);

    @Override
    public void delete(Status t);

    @Override
    public Optional<Status> findById(Long id);
    
    
    
}
