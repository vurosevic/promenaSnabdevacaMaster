/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.GrupaZahteva;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("grupaZahtevaDAO")
public interface GrupaZahtevaDAO extends CrudRepository<GrupaZahteva, Long>{

    @Override
    @Query("SELECT gz FROM GrupaZahteva gz")
    public List<GrupaZahteva> findAll();

    @Override
    public <S extends GrupaZahteva> S save(S s);

    @Override
    public void delete(GrupaZahteva t);

    @Override
    public Optional<GrupaZahteva> findById(Long id);
    
    
}
