/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.TipDokumenta;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("tipDokumentaDAO")
public interface TipDokumentaDAO extends CrudRepository<TipDokumenta, Long>{

    @Override
    @Query("SELECT td FROM TipDokumenta td")
    public List<TipDokumenta> findAll();

    @Override
    public <S extends TipDokumenta> S save(S s);

    @Override
    public void delete(TipDokumenta t);    

    @Override
    public Optional<TipDokumenta> findById(Long id);       
    
}
