/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.repository;

import eps.snabdevanje.promenasnabdevaca.domen.MernoMesto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vladimir
 */
@Repository("mernoMestoDAO")
public interface MernoMestoDAO extends CrudRepository<MernoMesto, Long> {

    @Override
    @Query("SELECT m FROM MernoMesto m")
    public List<MernoMesto> findAll();

    @Override
    public <S extends MernoMesto> S save(S s);

    @Override
    public void delete(MernoMesto t);
    
    @Query("SELECT m FROM MernoMesto m WHERE m.promenaSnabdevaca.id=:promenaSnabdevacaId")
    public List<MernoMesto> findByPromenaSnabdevacaId(@Param("promenaSnabdevacaId") Long promenaSnabdevacaId);
   
}
