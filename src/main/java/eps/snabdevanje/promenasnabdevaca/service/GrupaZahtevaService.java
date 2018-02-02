/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.GrupaZahteva;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface GrupaZahtevaService {

    public List<GrupaZahteva> findAll();
    public <S extends GrupaZahteva> S save(S s);
    public void delete(GrupaZahteva t);
    public Optional<GrupaZahteva> findById(Long id);

}
