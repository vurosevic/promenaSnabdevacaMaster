/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.Snabdevac;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface SnabdevacService {
    
    public List<Snabdevac> findAll();
    public <S extends Snabdevac> S save(S s);
    public void delete(Snabdevac t);             
    public Optional<Snabdevac> findById(Long id);
}
