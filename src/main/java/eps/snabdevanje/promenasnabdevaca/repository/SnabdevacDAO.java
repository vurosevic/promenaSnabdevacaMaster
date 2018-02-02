/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.Snabdevac;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("snabdevacDAO")
public interface SnabdevacDAO extends CrudRepository<Snabdevac, Long>{

    @Override
    @Query("SELECT s FROM Snabdevac s")
    public List<Snabdevac> findAll();

    @Override
    public <S extends Snabdevac> S save(S s);

    @Override
    public void delete(Snabdevac t);        

    @Override
    public Optional<Snabdevac> findById(Long id);
    
    
    
}
