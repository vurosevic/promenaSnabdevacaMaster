/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.Kupac;
import eps.snabdevanje.promenasnabdevaca.repository.KupacDAO;
import eps.snabdevanje.promenasnabdevaca.service.KupacService;
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
@Service("kupacService")
@Transactional
public class KupacServiceImpl implements KupacService {

    @Autowired
    private KupacDAO kupacDAO;
    
    @Override    
    public List<Kupac> findAllFl() {
        return kupacDAO.findAllFl();
    }    
    
    @Override    
    public List<Kupac> findAllPl() {
        return kupacDAO.findAllPl();
    }        

    @Override
    public Optional<Kupac> findById(Long id) {
        return kupacDAO.findById(id);
    }
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends Kupac> S save(S s) {
        return kupacDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(Kupac t) {
        kupacDAO.delete(t);
    }
    
    
    
}
