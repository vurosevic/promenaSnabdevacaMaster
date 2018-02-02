/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.TipDokumenta;
import eps.snabdevanje.promenasnabdevaca.repository.TipDokumentaDAO;
import eps.snabdevanje.promenasnabdevaca.service.TipDokumentaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("tipDokumentaService")
@Transactional
public class TipDokumentaServiceImpl implements TipDokumentaService {

    @Autowired
    TipDokumentaDAO tipDokumentaDAO;
    
    @Override
    public List<TipDokumenta> findAll() {
        return tipDokumentaDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends TipDokumenta> S save(S s) {
        return tipDokumentaDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(TipDokumenta t) {
        tipDokumentaDAO.delete(t);
    }

    @Override
    public Optional<TipDokumenta> findById(Long id) {
        return tipDokumentaDAO.findById(id);
    }
    
    
    
}
