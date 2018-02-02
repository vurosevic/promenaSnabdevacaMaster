/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.GrupaZahteva;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelGrupaZahteva;
import eps.snabdevanje.promenasnabdevaca.service.GrupaZahtevaService;
import eps.snabdevanje.promenasnabdevaca.service.StatusGrupeZahtevaService;
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
@Component("MBGrupaZahteva")
@SessionScoped
public class MBGrupaZahteva {
    
    @Autowired
    StatusGrupeZahtevaService statusGrupeZahtevaService;
    
    @Autowired
    private GrupaZahtevaService grupaZahtevaService;
    private List<GrupaZahteva> lista;
    private GrupaZahteva selectGrupaZahteva;
    private GrupaZahteva novaGrupaZahteva;
    private Long selectStatusGrupaZahtevaId;
    
    private LazyDataModel<GrupaZahteva> lazyModel;    
    
    @PostConstruct
    public void init(){     
         setLista(grupaZahtevaService.findAll());
         setLazyModel(new LazyDataModelGrupaZahteva(grupaZahtevaService.findAll())); 
         setNovaGrupaZahteva(new GrupaZahteva());
         setSelectGrupaZahteva(null);
         selectStatusGrupaZahtevaId = null;
    }      

    public MBGrupaZahteva() {
    }

    public List<GrupaZahteva> getLista() {
        return lista;
    }

    public void setLista(List<GrupaZahteva> lista) {
        this.lista = lista;
    }

    public GrupaZahteva getSelectGrupaZahteva() {
        return selectGrupaZahteva;
    }

    public void setSelectGrupaZahteva(GrupaZahteva selectGrupaZahteva) {
        this.selectGrupaZahteva = selectGrupaZahteva;
    }

    public GrupaZahteva getNovaGrupaZahteva() {
        return novaGrupaZahteva;
    }

    public void setNovaGrupaZahteva(GrupaZahteva novaGrupaZahteva) {
        this.novaGrupaZahteva = novaGrupaZahteva;
    }

    public LazyDataModel<GrupaZahteva> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<GrupaZahteva> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovuGrupuZahteva(){
        novaGrupaZahteva.setStatusGrupeZahteva(statusGrupeZahtevaService.findById(1L).get()); 
        grupaZahtevaService.save(novaGrupaZahteva);
        init();
    }
    
    public void azurirajGrupuZahteva() {
        selectGrupaZahteva.setStatusGrupeZahteva(statusGrupeZahtevaService.findById(selectStatusGrupaZahtevaId).get());
        grupaZahtevaService.save(selectGrupaZahteva);        
        selectStatusGrupaZahtevaId = null;
    }
    
    public void brisiGrupuZahteva() {        
        grupaZahtevaService.delete(selectGrupaZahteva);
        init();
    }

    public Long getSelectStatusGrupaZahtevaId() {
        return selectStatusGrupaZahtevaId;
    }

    public void setSelectStatusGrupaZahtevaId(Long selectStatusGrupaZahtevaId) {
        this.selectStatusGrupaZahtevaId = selectStatusGrupaZahtevaId;
    }
    
}
