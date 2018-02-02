/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("promenaSnabdevacaDAO")
public interface PromenaSnabdevacaDAO extends CrudRepository<PromenaSnabdevaca, Long>{

    @Override
    @Query("SELECT ps FROM PromenaSnabdevaca ps")
    public List<PromenaSnabdevaca> findAll();

    @Override
    public <S extends PromenaSnabdevaca> S save(S s);

    @Override
    public void delete(PromenaSnabdevaca t);

    @Override
    public Optional<PromenaSnabdevaca> findById(Long id);
        
    @Query("SELECT ps FROM PromenaSnabdevacaOdlazak ps WHERE ps.grupaZahteva.id=:grupaZahtevaId")
    public List<PromenaSnabdevaca> findByGrupaZahteva(@Param("grupaZahtevaId") Long grupaZahtevaId);
    
    @Query("SELECT ps FROM PromenaSnabdevacaOdlazak ps WHERE ps.status.id=:statusId")
    public List<PromenaSnabdevaca> findByStatus(@Param("statusId") Long statusId);
    
}
