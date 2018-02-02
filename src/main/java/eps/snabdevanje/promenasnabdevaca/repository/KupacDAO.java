/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.Kupac;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("kupacDAO")
public interface KupacDAO extends CrudRepository<Kupac, Long>{

    @Query("SELECT k FROM KupacFizickoLice k")
    public List<Kupac> findAllFl();
    
    @Query("SELECT k FROM KupacPravnoLice k")
    public List<Kupac> findAllPl();    

    @Override
    public Optional<Kupac> findById(Long id);       

    @Override
    public <S extends Kupac> S save(S s);

    @Override
    public void delete(Kupac t);        
    
}
