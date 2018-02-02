/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.StatusGrupeZahteva;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface StatusGrupeZahtevaService {
    public List<StatusGrupeZahteva> findAll();
    public <S extends StatusGrupeZahteva> S save(S s);
    public void delete(StatusGrupeZahteva t);   
    public Optional<StatusGrupeZahteva> findById(Long id);       
}
