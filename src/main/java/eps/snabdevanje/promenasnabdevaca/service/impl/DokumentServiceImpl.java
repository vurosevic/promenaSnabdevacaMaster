/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.Dokument;
import eps.snabdevanje.promenasnabdevaca.repository.DokumentDAO;
import eps.snabdevanje.promenasnabdevaca.service.DokumentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("dokumentService")
@Transactional
public class DokumentServiceImpl implements DokumentService {

    @Autowired
    DokumentDAO dokumentDAO;
    
    @Override
    public List<Dokument> findAll() {
        return dokumentDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends Dokument> S save(S s) {
        return dokumentDAO.save(s);                
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(Dokument t) {
        dokumentDAO.delete(t);
    }

    @Override
    public List<Dokument> findByPromenaSnabdevacaId(Long promenaSnabdevacaId) {
        return dokumentDAO.findByPromenaSnabdevacaId(promenaSnabdevacaId);
    }
    
}
