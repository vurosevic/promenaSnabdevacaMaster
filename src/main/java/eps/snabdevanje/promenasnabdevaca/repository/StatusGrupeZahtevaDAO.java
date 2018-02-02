/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.StatusGrupeZahteva;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("statusGrupeZahtevaDAO")
public interface StatusGrupeZahtevaDAO extends CrudRepository<StatusGrupeZahteva, Long>{

    @Override
    @Query("SELECT sgz FROM StatusGrupeZahteva sgz")
    public List<StatusGrupeZahteva> findAll();

    @Override
    public <S extends StatusGrupeZahteva> S save(S s);

    @Override
    public void delete(StatusGrupeZahteva t);

    @Override
    public Optional<StatusGrupeZahteva> findById(Long id);       
    
}
