/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.service;

import eps.snabdevanje.promenasnabdevaca.domen.Status;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Vladimir
 */
public interface StatusService {
 
    public List<Status> findAll();
    public <S extends Status> S save(S s);
    public void delete(Status t);   
    public Optional<Status> findById(Long id);
}
