/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.Kupac;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface KupacService {
    
    public List<Kupac> findAllFl();
    public List<Kupac> findAllPl();
    public Optional<Kupac> findById(Long id);
    public <S extends Kupac> S save(S s);
    public void delete(Kupac t);           
    
}
