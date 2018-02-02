/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.TehnickiCentar;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface TehnickiCentarService {
    public List<TehnickiCentar> findAll();
    public <S extends TehnickiCentar> S save(S s);
    public void delete(TehnickiCentar t);  
    public Optional<TehnickiCentar> findById(Long id);
}
