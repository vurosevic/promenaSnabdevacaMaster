/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.Snabdevac;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelSnabdevac;
import eps.snabdevanje.promenasnabdevaca.service.SnabdevacService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBSnabdevac")
@SessionScoped
public class MBSnabdevac {
    
    @Autowired
    private SnabdevacService snabdevacService;
    private List<Snabdevac> lista;
    private Snabdevac selectSnabdevac;
    private Snabdevac noviSnabdevac;
    
    private LazyDataModel<Snabdevac> lazyModel;    
    
    @PostConstruct
    public void init(){     
         setLista(snabdevacService.findAll());
         setLazyModel(new LazyDataModelSnabdevac(snabdevacService.findAll())); 
         noviSnabdevac = new Snabdevac();
         selectSnabdevac = null;
    }     

    public MBSnabdevac() {       
    }

    public SnabdevacService getSnabdevacService() {
        return snabdevacService;
    }

    public void setSnabdevacService(SnabdevacService snabdevacService) {
        this.snabdevacService = snabdevacService;
    }

    public List<Snabdevac> getLista() {
        return lista;
    }

    public void setLista(List<Snabdevac> lista) {
        this.lista = lista;
    }

    public Snabdevac getSelectSnabdevac() {
        return selectSnabdevac;
    }

    public void setSelectSnabdevac(Snabdevac selectSnabdevac) {
        this.selectSnabdevac = selectSnabdevac;
    }

    public Snabdevac getNoviSnabdevac() {
        return noviSnabdevac;
    }

    public void setNoviSnabdevac(Snabdevac noviSnabdevac) {
        this.noviSnabdevac = noviSnabdevac;
    }

    public LazyDataModel<Snabdevac> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Snabdevac> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovogSnabdevaca(){
        snabdevacService.save(noviSnabdevac);
        init();
    }
    
    public void izmeniSnabdevaca(){
        snabdevacService.save(selectSnabdevac);
    }
    
    public void brisiSnabdevaca(){
        snabdevacService.delete(selectSnabdevac);
        init();
    }
    
}
