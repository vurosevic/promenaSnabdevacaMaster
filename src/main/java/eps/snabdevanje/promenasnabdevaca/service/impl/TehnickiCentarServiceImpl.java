/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.TehnickiCentar;
import eps.snabdevanje.promenasnabdevaca.repository.TehnickiCentarDAO;
import eps.snabdevanje.promenasnabdevaca.service.TehnickiCentarService;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */


@Service("tehnickiCentarService")
@Transactional
public class TehnickiCentarServiceImpl implements TehnickiCentarService {

    @Autowired
    private TehnickiCentarDAO tehnickiCentarDAO;       
    
    @Override
    public List<TehnickiCentar> findAll() {
       return tehnickiCentarDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public <S extends TehnickiCentar> S save(S s) {
        return tehnickiCentarDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(TehnickiCentar t) {
        tehnickiCentarDAO.delete(t);
    }

    @Override
    public Optional<TehnickiCentar> findById(Long id) {
        return tehnickiCentarDAO.findById(id);
    }
    
    
    
    
}
