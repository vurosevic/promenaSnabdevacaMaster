/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.Dokument;
import java.util.List;

/**
 *
 * @author Vladimir
 */
public interface DokumentService {

    public List<Dokument> findAll();
    public <S extends Dokument> S save(S s);
    public void delete(Dokument t);  
    public List<Dokument> findByPromenaSnabdevacaId(Long promenaSnabdevacaId);
    
}
