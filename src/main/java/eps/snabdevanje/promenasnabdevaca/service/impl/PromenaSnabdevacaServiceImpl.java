/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.repository.PromenaSnabdevacaDAO;
import eps.snabdevanje.promenasnabdevaca.service.PromenaSnabdevacaService;
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
@Service("promenaSnabdevacaService")
@Transactional
public class PromenaSnabdevacaServiceImpl implements PromenaSnabdevacaService {
    
    @Autowired
    PromenaSnabdevacaDAO promenaSnabdevacaDAO;

    @Override
    public List<PromenaSnabdevaca> findAll() {
        return promenaSnabdevacaDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends PromenaSnabdevaca> S save(S s) {
        return promenaSnabdevacaDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(PromenaSnabdevaca t) {
        promenaSnabdevacaDAO.delete(t);
    }

    @Override
    public Optional<PromenaSnabdevaca> findById(Long id) {
        return promenaSnabdevacaDAO.findById(id);
    }

    @Override
    public List<PromenaSnabdevaca> findByGrupaZahteva(Long grupaZahtevaId) {
        return promenaSnabdevacaDAO.findByGrupaZahteva(grupaZahtevaId);
    }

    @Override
    public List<PromenaSnabdevaca> findByStatus(Long statusId) {
        return promenaSnabdevacaDAO.findByStatus(statusId);
    }
    
    
    
}
