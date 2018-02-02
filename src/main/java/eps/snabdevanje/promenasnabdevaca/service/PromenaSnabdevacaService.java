/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Vladimir
 */
public interface PromenaSnabdevacaService {
    
    public List<PromenaSnabdevaca> findAll();
    public <S extends PromenaSnabdevaca> S save(S s);
    public void delete(PromenaSnabdevaca t);    
    public Optional<PromenaSnabdevaca> findById(Long id);   
    public List<PromenaSnabdevaca> findByGrupaZahteva(Long grupaZahtevaId);
    public List<PromenaSnabdevaca> findByStatus(Long statusId);
}
