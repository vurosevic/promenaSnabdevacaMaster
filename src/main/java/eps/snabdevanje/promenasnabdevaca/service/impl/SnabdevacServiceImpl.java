/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.Snabdevac;
import eps.snabdevanje.promenasnabdevaca.repository.SnabdevacDAO;
import eps.snabdevanje.promenasnabdevaca.service.SnabdevacService;
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
@Service("snabdevacService")
@Transactional
public class SnabdevacServiceImpl implements SnabdevacService {

    @Autowired
    private SnabdevacDAO snabdevacDAO;
    
    @Override
    public List<Snabdevac> findAll() {
        return snabdevacDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends Snabdevac> S save(S s) {
        return snabdevacDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(Snabdevac t) {
        snabdevacDAO.delete(t); 
    }

    @Override
    public Optional<Snabdevac> findById(Long id) {
        return snabdevacDAO.findById(id);
    }
    
    
    
}
