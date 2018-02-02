/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.MernoMesto;
import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelMernoMesto;
import eps.snabdevanje.promenasnabdevaca.service.MernoMestoService;
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
@Component("MBMernoMesto")
//@ManagedBean(name = "MBMernoMesto")
@SessionScoped
public class MBMernoMesto {
    
    @Autowired
    private MernoMestoService mernoMestoService;
    
    @Autowired
    private TehnickiCentarService tehnickiCentarService;    
    
    private List<MernoMesto> lista;
    private MernoMesto selectMernoMesto;
    private MernoMesto novoMernoMesto;
    
    private LazyDataModel<MernoMesto> lazyModel;
    private Long selectTehnickiCentarId;
    private Long selectPromenaSnabdevacaId;

    public MBMernoMesto() {
        novoMernoMesto = new MernoMesto();
        selectPromenaSnabdevacaId = null;
    }    
    
    @PostConstruct
    public void init(){              
         setLista(mernoMestoService.findByPromenaSnabdevacaId(getSelectPromenaSnabdevacaId()));
         setLazyModel(new LazyDataModelMernoMesto(mernoMestoService.findByPromenaSnabdevacaId(getSelectPromenaSnabdevacaId()))); 
         setNovoMernoMesto(new MernoMesto());
         setSelectMernoMesto(null);                  
    }     
    
    public void refresh(){
         setLista(mernoMestoService.findByPromenaSnabdevacaId(getSelectPromenaSnabdevacaId()));
         setLazyModel(new LazyDataModelMernoMesto(mernoMestoService.findByPromenaSnabdevacaId(getSelectPromenaSnabdevacaId())));         
         selectMernoMesto=null;
    }
    
    public void clear(){
        selectPromenaSnabdevacaId = null;
        refresh();
    }

    public List<MernoMesto> getLista() {
        return lista;
    }

    public void setLista(List<MernoMesto> lista) {
        this.lista = lista;
    }

    public MernoMesto getSelectMernoMesto() {
        return selectMernoMesto;
    }

    public void setSelectMernoMesto(MernoMesto selectMernoMesto) {
        this.selectMernoMesto = selectMernoMesto;
    }

    public MernoMesto getNovoMernoMesto() {
        return novoMernoMesto;
    }

    public void setNovoMernoMesto(MernoMesto novoMernoMesto) {
        this.novoMernoMesto = novoMernoMesto;
    }

    public LazyDataModel<MernoMesto> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<MernoMesto> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void dodajNovoMernoMesto(PromenaSnabdevaca promenaSnabdevaca){
        novoMernoMesto.setTehnickiCentar(tehnickiCentarService.findById(selectTehnickiCentarId).get());         
        novoMernoMesto.setPromenaSnabdevaca(promenaSnabdevaca);
        mernoMestoService.save(novoMernoMesto);        
        init();
    }
    
    public void azurirajMernoMesto(){
        selectMernoMesto.setTehnickiCentar(tehnickiCentarService.findById(selectTehnickiCentarId).get()); 
        mernoMestoService.save(selectMernoMesto);
    }
    
    public void brisiMernoMesto(){
        mernoMestoService.delete(selectMernoMesto);
        init();
    }

    public Long getSelectTehnickiCentarId() {
        return selectTehnickiCentarId;
    }

    public void setSelectTehnickiCentarId(Long selectTehnickiCentarId) {
        this.selectTehnickiCentarId = selectTehnickiCentarId;
    }

    public Long getSelectPromenaSnabdevacaId() {
        return selectPromenaSnabdevacaId;
    }

    public void setSelectPromenaSnabdevacaId(Long selectPromenaSnabdevacaId) {
        this.selectPromenaSnabdevacaId = selectPromenaSnabdevacaId;
    }
    
}
