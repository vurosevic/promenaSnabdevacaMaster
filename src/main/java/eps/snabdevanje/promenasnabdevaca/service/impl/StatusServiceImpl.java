/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.Status;
import eps.snabdevanje.promenasnabdevaca.repository.StatusDAO;
import eps.snabdevanje.promenasnabdevaca.service.StatusService;
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
@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDAO statusDAO;
    
    @Override
    public List<Status> findAll() {
        return statusDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends Status> S save(S s) {
        return statusDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(Status t) {
        statusDAO.delete(t);
    }    

    @Override
    public Optional<Status> findById(Long id) {
        return statusDAO.findById(id);
    }
    
    
    
}
