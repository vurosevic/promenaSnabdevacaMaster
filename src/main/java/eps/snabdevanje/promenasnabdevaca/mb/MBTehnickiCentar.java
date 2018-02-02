/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.TehnickiCentar;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelTehnickiCentar;
import eps.snabdevanje.promenasnabdevaca.service.TehnickiCentarService;
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
@Component("MBTehnickiCentar")
@SessionScoped
public class MBTehnickiCentar {
    
    @Autowired
    private TehnickiCentarService tehnickiCentarService;    
    private List<TehnickiCentar> lista;
    private TehnickiCentar selectTc;
    private TehnickiCentar noviTc;

    private LazyDataModel<TehnickiCentar> lazyModel;       
    
    public MBTehnickiCentar() {     
        noviTc = new TehnickiCentar();
    }
    
    @PostConstruct
    public void init(){     
         setLista(tehnickiCentarService.findAll());
         setLazyModel(new LazyDataModelTehnickiCentar(tehnickiCentarService.findAll())); 
         noviTc.setId(0L); 
         noviTc.setNaziv_tc("");
         noviTc.setAdresa_sedista("");
         selectTc = null;
    }    

    public List<TehnickiCentar> getLista() {
        return lista;
    }

    public void setLista(List<TehnickiCentar> lista) {
        this.lista = lista;
    }

    public TehnickiCentar getSelectTc() {
        return selectTc;
    }

    public void setSelectTc(TehnickiCentar selectTc) {
        this.selectTc = selectTc;
    }
    
    public TehnickiCentar getNoviTc() {
        return noviTc;
    }

    public void setNoviTc(TehnickiCentar noviTc) {
        this.noviTc = noviTc;
    }    

    public LazyDataModel<TehnickiCentar> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<TehnickiCentar> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNoviTc(){
        tehnickiCentarService.save(noviTc); 
        init();
    }
    
    public void izmeniTc(){
        tehnickiCentarService.save(selectTc);
    }
    
    public void brisiTc(){
        tehnickiCentarService.delete(selectTc);
        init();
    }
   
}
