/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.domen.MernoMesto;
import eps.snabdevanje.promenasnabdevaca.repository.MernoMestoDAO;
import eps.snabdevanje.promenasnabdevaca.service.MernoMestoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vladimir
 */
@Service("mernoMestoService")
@Transactional
public class MernoMestoServiceImpl implements MernoMestoService {

    @Autowired
    MernoMestoDAO mernoMestoDAO;
    
    @Override
    public List<MernoMesto> findAll() {
        return mernoMestoDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)       
    public <S extends MernoMesto> S save(S s) {
        return mernoMestoDAO.save(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)   
    public void delete(MernoMesto t) {
        mernoMestoDAO.delete(t); 
    }

    @Override
    public List<MernoMesto> findByPromenaSnabdevacaId(Long promenaSnabdevacaId) {
        return mernoMestoDAO.findByPromenaSnabdevacaId(promenaSnabdevacaId);
    }
    

    
    
    
}
