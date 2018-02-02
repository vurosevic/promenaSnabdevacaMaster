/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.TehnickiCentar;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("tehnickiCentarDAO")
public interface TehnickiCentarDAO extends CrudRepository<TehnickiCentar, Long> {

    @Override
    @Query("SELECT t FROM TehnickiCentar t")
    public List<TehnickiCentar> findAll();

    @Override
    public <S extends TehnickiCentar> S save(S s);

    @Override
    public void delete(TehnickiCentar t);

    @Override
    public Optional<TehnickiCentar> findById(Long id);        
     
}
