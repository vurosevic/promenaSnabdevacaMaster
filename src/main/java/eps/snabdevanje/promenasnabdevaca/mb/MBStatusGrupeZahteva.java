/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.StatusGrupeZahteva;
import eps.snabdevanje.promenasnabdevaca.service.StatusGrupeZahtevaService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBStatusGrupeZahteva")
@SessionScoped
public class MBStatusGrupeZahteva {
    
    @Autowired
    StatusGrupeZahtevaService statusGrupeZahtevaService;
    
    private List<StatusGrupeZahteva> lista;
    private StatusGrupeZahteva selectStatusGrupeZahteva;
    private StatusGrupeZahteva noviStatusGrupeZahteva;   
    
    @PostConstruct
    public void init(){     
         setLista(statusGrupeZahtevaService.findAll());
         setNoviStatusGrupeZahteva(new StatusGrupeZahteva());
         setSelectStatusGrupeZahteva(null);
    }     

    public MBStatusGrupeZahteva() {
    }

    public List<StatusGrupeZahteva> getLista() {
        return lista;
    }

    public void setLista(List<StatusGrupeZahteva> lista) {
        this.lista = lista;
    }

    public StatusGrupeZahteva getSelectStatusGrupeZahteva() {
        return selectStatusGrupeZahteva;
    }

    public void setSelectStatusGrupeZahteva(StatusGrupeZahteva selectStatusGrupeZahteva) {
        this.selectStatusGrupeZahteva = selectStatusGrupeZahteva;
    }

    public StatusGrupeZahteva getNoviStatusGrupeZahteva() {
        return noviStatusGrupeZahteva;
    }

    public void setNoviStatusGrupeZahteva(StatusGrupeZahteva noviStatusGrupeZahteva) {
        this.noviStatusGrupeZahteva = noviStatusGrupeZahteva;
    }
    
    
    
}
