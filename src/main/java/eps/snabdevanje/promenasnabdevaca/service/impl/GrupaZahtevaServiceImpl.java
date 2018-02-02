/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.GrupaZahteva;
import eps.snabdevanje.promenasnabdevaca.repository.GrupaZahtevaDAO;
import eps.snabdevanje.promenasnabdevaca.service.GrupaZahtevaService;
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
@Service("grupaZahtevaService")
@Transactional
public class GrupaZahtevaServiceImpl implements GrupaZahtevaService {
    
    @Autowired
    GrupaZahtevaDAO grupaZahtevaDAO;

    @Override
    public List<GrupaZahteva> findAll() {
        return grupaZahtevaDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends GrupaZahteva> S save(S s) {
        return grupaZahtevaDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(GrupaZahteva t) {
        grupaZahtevaDAO.delete(t);
    }

    @Override
    public Optional<GrupaZahteva> findById(Long id) {
        return grupaZahtevaDAO.findById(id);
    }
    
}
