/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.MernoMesto;
import java.util.List;

/**
 *
 * @author Vladimir
 */
public interface MernoMestoService {
    
    public List<MernoMesto> findAll();
    public <S extends MernoMesto> S save(S s);
    public void delete(MernoMesto t);    
    public List<MernoMesto> findByPromenaSnabdevacaId(Long promenaSnabdevacaId);
}
