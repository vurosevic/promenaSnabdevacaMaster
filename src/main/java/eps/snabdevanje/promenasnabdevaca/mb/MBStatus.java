/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.Status;
import eps.snabdevanje.promenasnabdevaca.service.StatusService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBStatus")
@SessionScoped
public class MBStatus {
    
    @Autowired
    StatusService statusService;
    
    private List<Status> lista;
    private Status selectStatus;
    private Status noviStatus;    
    
    @PostConstruct
    public void init(){     
         setLista(statusService.findAll());
         setNoviStatus(new Status());
         setSelectStatus(null);
    }      

    public MBStatus() {
    }

    public List<Status> getLista() {
        return lista;
    }

    public void setLista(List<Status> lista) {
        this.lista = lista;
    }

    public Status getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(Status selectStatus) {
        this.selectStatus = selectStatus;
    }

    public Status getNoviStatus() {
        return noviStatus;
    }

    public void setNoviStatus(Status noviStatus) {
        this.noviStatus = noviStatus;
    }
    
 
}
