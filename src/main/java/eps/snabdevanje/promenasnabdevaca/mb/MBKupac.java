/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.Kupac;
import eps.snabdevanje.promenasnabdevaca.domen.KupacFizickoLice;
import eps.snabdevanje.promenasnabdevaca.domen.KupacPravnoLice;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelKupac;
import eps.snabdevanje.promenasnabdevaca.service.KupacService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBKupac")
@SessionScoped
public class MBKupac {
    
    @Autowired
    KupacService kupacService;
    
    private List<Kupac> listaFl;
    private List<Kupac> listaPl;
    private List<Kupac> listaAll;
    private Kupac selektovaniKupacFl;
    private Kupac selektovaniKupacPl;
    private Kupac noviKupacFl;
    private Kupac noviKupacPl;
    private LazyDataModel<Kupac> lazyModelFl;    
    private LazyDataModel<Kupac> lazyModelPl;    
    
    
    @PostConstruct
    public void init(){     
         setListaFl(kupacService.findAllFl());
         setListaPl(kupacService.findAllPl());
         setListaAll(kupacService.findAllFl());
         listaAll.addAll(listaPl);
         setLazyModelFl(new LazyDataModelKupac(kupacService.findAllFl())); 
         setLazyModelPl(new LazyDataModelKupac(kupacService.findAllPl())); 
         noviKupacFl = new KupacFizickoLice();
         noviKupacPl = new KupacPravnoLice();
         setSelektovaniKupacFl(null);
         setSelektovaniKupacPl(null);         
    }    

    public LazyDataModel<Kupac> getLazyModelFl() {
        return lazyModelFl;
    }

    public void setLazyModelFl(LazyDataModel<Kupac> lazyModelFl) {
        this.lazyModelFl = lazyModelFl;
    }

    public LazyDataModel<Kupac> getLazyModelPl() {
        return lazyModelPl;
    }

    public void setLazyModelPl(LazyDataModel<Kupac> lazyModelPl) {
        this.lazyModelPl = lazyModelPl;
    }

    public List<Kupac> getListaFl() {
        return listaFl;
    }

    public void setListaFl(List<Kupac> listaFl) {
        this.listaFl = listaFl;
    }

    public List<Kupac> getListaPl() {
        return listaPl;
    }

    public void setListaPl(List<Kupac> listaPl) {
        this.listaPl = listaPl;
    }

    public Kupac getSelektovaniKupacFl() {
        return selektovaniKupacFl;
    }

    public void setSelektovaniKupacFl(Kupac selektovaniKupacFl) {
        this.selektovaniKupacFl = selektovaniKupacFl;
    }

    public Kupac getSelektovaniKupacPl() {
        return selektovaniKupacPl;
    }

    public void setSelektovaniKupacPl(Kupac selektovaniKupacPl) {
        this.selektovaniKupacPl = selektovaniKupacPl;
    }

    public Kupac getNoviKupacFl() {
        return noviKupacFl;
    }

    public void setNoviKupacFl(Kupac noviKupacFl) {
        this.noviKupacFl = noviKupacFl;
    }

    public Kupac getNoviKupacPl() {
        return noviKupacPl;
    }

    public void setNoviKupacPl(Kupac noviKupacPl) {
        this.noviKupacPl = noviKupacPl;
    }

    public void dodajNovoPravnoLice(){
        kupacService.save(noviKupacPl);
        init();
    }
    
    public void dodajNovoFizickoLice(){
        kupacService.save(noviKupacFl);
        init();
    }

    
    public void azurirajPravnoLice(){
        kupacService.save(selektovaniKupacPl);        
    }
    
    public void azurirajFizickoLice(){
        kupacService.save(selektovaniKupacFl);
    }
    
    public void brisiPravnoLice() {
        try {
        kupacService.delete(selektovaniKupacPl);
        init();        
        } catch (Exception e) {            
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Захтевани податак се не може обрисати", "Правно лице има евидентиране захтеве. Не може се обрисати.");
            FacesContext.getCurrentInstance().addMessage("growlKey", facesMsg);
        }
    }
    
    public void brisiFizickoLice(){
        try {        
        kupacService.delete(selektovaniKupacFl);
        init();
        } catch (Exception e) {            
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Захтевани податак се не може обрисати", "Правно лице има евидентиране захтеве. Не може се обрисати.");
            FacesContext.getCurrentInstance().addMessage("growlKey", facesMsg);
        }        
    }

    public List<Kupac> getListaAll() {
        return listaAll;
    }

    public void setListaAll(List<Kupac> listaAll) {
        this.listaAll = listaAll;
    }
    
}
