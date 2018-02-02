/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.StatusGrupeZahteva;
import eps.snabdevanje.promenasnabdevaca.repository.StatusGrupeZahtevaDAO;
import eps.snabdevanje.promenasnabdevaca.service.StatusGrupeZahtevaService;
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
@Service("statusGrupeZahtevaService")
@Transactional
public class StatusGrupeZahtevaImpl implements StatusGrupeZahtevaService {
    
    @Autowired
    StatusGrupeZahtevaDAO statusGrupeZahtevaDAO;

    @Override
    public List<StatusGrupeZahteva> findAll() {
        return statusGrupeZahtevaDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends StatusGrupeZahteva> S save(S s) {
        return statusGrupeZahtevaDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(StatusGrupeZahteva t) {
        statusGrupeZahtevaDAO.delete(t);
    }

    @Override
    public Optional<StatusGrupeZahteva> findById(Long id) {
        return statusGrupeZahtevaDAO.findById(id);
    }
    
    
          
}
