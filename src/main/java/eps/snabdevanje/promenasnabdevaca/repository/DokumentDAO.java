/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.Dokument;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("dokumentDAO")
public interface DokumentDAO extends CrudRepository<Dokument, Long>{

    @Override
    @Query("SELECT d FROM Dokument d")
    public List<Dokument> findAll();

    @Override
    public <S extends Dokument> S save(S s);

    @Override
    public void delete(Dokument t);

    @Query("SELECT d FROM Dokument d WHERE d.promenaSnabdevaca.id=:promenaSnabdevacaId")
    public List<Dokument> findByPromenaSnabdevacaId(@Param("promenaSnabdevacaId") Long promenaSnabdevacaId);
    
}
