/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.domen.enumtype.StatusEnum;
import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevacaOdlazak;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelPromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.service.PromenaSnabdevacaService;
import eps.snabdevanje.promenasnabdevaca.service.StatusService;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBFinProvera")
//@ManagedBean(name = "MBFinProvera")
@ViewScoped
public class MBFinProvera {    
    
    @Autowired
    private PromenaSnabdevacaService promenaSnabdevacaService;    
    
    @Autowired
    StatusService statusService;    
    
    private List<PromenaSnabdevaca> lista;
    private PromenaSnabdevacaOdlazak selectPromenaSnabdevaca;

    private LazyDataModel<PromenaSnabdevaca> lazyModel;                  
    
    @PostConstruct
    public void init(){     
         setLista(getPromenaSnabdevacaService().findByStatus(Long.valueOf(StatusEnum.POSLAT_NA_PROVERU.ordinal())));
         setLazyModel(new LazyDataModelPromenaSnabdevaca(getPromenaSnabdevacaService().findByStatus(Long.valueOf(StatusEnum.POSLAT_NA_PROVERU.ordinal()))));         
         setSelectPromenaSnabdevaca(null);
    }      

    public void refresh(){
         selectPromenaSnabdevaca = null;
         setLista(getPromenaSnabdevacaService().findByStatus(Long.valueOf(StatusEnum.POSLAT_NA_PROVERU.ordinal())));
         setLazyModel(new LazyDataModelPromenaSnabdevaca(getPromenaSnabdevacaService().findByStatus(Long.valueOf(StatusEnum.POSLAT_NA_PROVERU.ordinal()))));
    }    

    public PromenaSnabdevacaService getPromenaSnabdevacaService() {
        return promenaSnabdevacaService;
    }

    public void setPromenaSnabdevacaService(PromenaSnabdevacaService promenaSnabdevacaService) {
        this.promenaSnabdevacaService = promenaSnabdevacaService;
    }

    public List<PromenaSnabdevaca> getLista() {
        return lista;
    }

    public void setLista(List<PromenaSnabdevaca> lista) {
        this.lista = lista;
    }

    public PromenaSnabdevacaOdlazak getSelectPromenaSnabdevaca() {
        return selectPromenaSnabdevaca;
    }

    public void setSelectPromenaSnabdevaca(PromenaSnabdevacaOdlazak selectPromenaSnabdevaca) {
        this.selectPromenaSnabdevaca = selectPromenaSnabdevaca;
    }

    public LazyDataModel<PromenaSnabdevaca> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<PromenaSnabdevaca> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void odobrenZahtev(){
        selectPromenaSnabdevaca.setStatus(statusService.findById(Long.valueOf(StatusEnum.ODOBREN.ordinal())).get());
        selectPromenaSnabdevaca.setDatumOdobrenja(Calendar.getInstance().getTime());        
        selectPromenaSnabdevaca.setDatumPrigovora(null);
        promenaSnabdevacaService.save(selectPromenaSnabdevaca);  
        init();
    }
    
    public void prigovorNaZahtev(){
        selectPromenaSnabdevaca.setStatus(statusService.findById(Long.valueOf(StatusEnum.ULOZEN_PRIGOVOR.ordinal())).get());
        selectPromenaSnabdevaca.setDatumOdobrenja(null);
        selectPromenaSnabdevaca.setDatumPrigovora(Calendar.getInstance().getTime());
        promenaSnabdevacaService.save(selectPromenaSnabdevaca); 
        init();
    }
}
