/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.TipDokumenta;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelTipDokumenta;
import eps.snabdevanje.promenasnabdevaca.service.TipDokumentaService;
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
@Component("MBTipDokumenta")
@SessionScoped
public class MBTipDokumenta {
    
    @Autowired
    TipDokumentaService tipDokumentaService;
    
    private List<TipDokumenta> lista;
    private TipDokumenta selectTipDokumenta;
    private TipDokumenta noviTipDokumenta;    
    
    private LazyDataModel<TipDokumenta> lazyModel;       

    public MBTipDokumenta() {
        noviTipDokumenta = new TipDokumenta();
    }
    
    @PostConstruct
    public void init(){     
         setLista(tipDokumentaService.findAll());
         setLazyModel(new LazyDataModelTipDokumenta(tipDokumentaService.findAll())); 
         noviTipDokumenta.setId(0L); 
         noviTipDokumenta.setNaziv("");
         noviTipDokumenta.setOpis("");
         selectTipDokumenta = null;
    }     

    public List<TipDokumenta> getLista() {
        return lista;
    }

    public void setLista(List<TipDokumenta> lista) {
        this.lista = lista;
    }

    public TipDokumenta getSelectTipDokumenta() {
        return selectTipDokumenta;
    }

    public void setSelectTipDokumenta(TipDokumenta selectTipDokumenta) {
        this.selectTipDokumenta = selectTipDokumenta;
    }

    public TipDokumenta getNoviTipDokumenta() {
        return noviTipDokumenta;
    }

    public void setNoviTipDokumenta(TipDokumenta noviTipDokumenta) {
        this.noviTipDokumenta = noviTipDokumenta;
    }

    public LazyDataModel<TipDokumenta> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<TipDokumenta> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNoviTipDokumenta(){
        tipDokumentaService.save(noviTipDokumenta);     
        init();
    }
    
    public void azurirajTipDokumenta(){
        tipDokumentaService.save(selectTipDokumenta);
    }
    
    public void brisiTipDokumenta(){
        tipDokumentaService.delete(selectTipDokumenta);        
        init();
    }
    
}
