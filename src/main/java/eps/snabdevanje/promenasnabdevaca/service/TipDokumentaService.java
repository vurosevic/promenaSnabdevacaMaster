/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.TipDokumenta;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface TipDokumentaService {
    
    public List<TipDokumenta> findAll();
    public <S extends TipDokumenta> S save(S s);
    public void delete(TipDokumenta t);      
    public Optional<TipDokumenta> findById(Long id);
    
}
