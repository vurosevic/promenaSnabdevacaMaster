/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevacaOdlazak;
import eps.snabdevanje.promenasnabdevaca.domen.enumtype.StatusEnum;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelPromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.service.GrupaZahtevaService;
import eps.snabdevanje.promenasnabdevaca.service.KupacService;
import eps.snabdevanje.promenasnabdevaca.service.PromenaSnabdevacaService;
import eps.snabdevanje.promenasnabdevaca.service.SnabdevacService;
import eps.snabdevanje.promenasnabdevaca.service.StatusService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBPromenaSnabdevacaOdlazak")
@ViewScoped
public class MBPromenaSnabdevacaOdlazak {
    
    @Autowired
    private PromenaSnabdevacaService promenaSnabdevacaService;
    
    @Autowired
    SnabdevacService snabdevacService;
    
    @Autowired
    KupacService kupacService;
    
    @Autowired
    StatusService statusService;
    
    @Autowired
    GrupaZahtevaService grupaZahtevaService;
    
    @Autowired
    private MBMernoMesto mbMernoMesto;
    
    @Autowired
    private MBDokument mbDokument;
    
    private List<PromenaSnabdevaca> lista;
    private PromenaSnabdevacaOdlazak selectPromenaSnabdevaca;
    private PromenaSnabdevacaOdlazak novaPromenaSnabdevaca;
    
    private LazyDataModel<PromenaSnabdevaca> lazyModel;        
    
    private Long selectSnabdevacId;
    private Long selectKupacId;
    private Long selectStatusId;
    private Long selectGrupaZahtevaId;
    
    @PostConstruct
    public void init(){     
         setLista(getPromenaSnabdevacaService().findByGrupaZahteva(selectGrupaZahtevaId));
         setLazyModel(new LazyDataModelPromenaSnabdevaca(getPromenaSnabdevacaService().findByGrupaZahteva(selectGrupaZahtevaId)));         
         setNovaPromenaSnabdevaca(new PromenaSnabdevacaOdlazak());
         setSelectPromenaSnabdevaca(null);
         selectKupacId = null;
         selectSnabdevacId = null;
         selectStatusId = null;
    }     
    
    public void refresh(){         
         setLista(getPromenaSnabdevacaService().findByGrupaZahteva(selectGrupaZahtevaId));
         setLazyModel(new LazyDataModelPromenaSnabdevaca(getPromenaSnabdevacaService().findByGrupaZahteva(selectGrupaZahtevaId)));                 
    }
    
    public void refreshMernaMesta(){
        mbMernoMesto.setSelectPromenaSnabdevacaId(selectPromenaSnabdevaca.getId());
        mbMernoMesto.refresh();
    }
    
    public void refreshDokumenta(){
        mbDokument.setSelectPromenaSnabdevacaId(selectPromenaSnabdevaca.getId());
        mbDokument.refresh();
    }

    public MBPromenaSnabdevacaOdlazak() {
        selectGrupaZahtevaId = 2L; //inicijalno, prva grupa, sredi da vuce automatski
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

    public PromenaSnabdevacaOdlazak getNovaPromenaSnabdevaca() {
        return novaPromenaSnabdevaca;
    }

    public void setNovaPromenaSnabdevaca(PromenaSnabdevacaOdlazak novaPromenaSnabdevaca) {
        this.novaPromenaSnabdevaca = novaPromenaSnabdevaca;
    }

    public LazyDataModel<PromenaSnabdevaca> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<PromenaSnabdevaca> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public void dodajNovuPromenuSnabdevacaOdlazak(){
        
        novaPromenaSnabdevaca.setSnabdevac(snabdevacService.findById(selectSnabdevacId).get());
        novaPromenaSnabdevaca.setKupac(kupacService.findById(selectKupacId).get());        
        selectStatusId = Long.valueOf(StatusEnum.U_TOKU.ordinal());
        novaPromenaSnabdevaca.setStatus(statusService.findById(selectStatusId).get());
        
        novaPromenaSnabdevaca.setGrupaZahteva(grupaZahtevaService.findById(selectGrupaZahtevaId).get());        
        novaPromenaSnabdevaca.setDatumKreiranja(Calendar.getInstance().getTime());        
        promenaSnabdevacaService.save(novaPromenaSnabdevaca);
        init();
    }
    
    public void azurirajPromenuSnabdevacaOdlazak(){
        // preuzmi selektovane objekte i ubaci ih u promenu
        selectPromenaSnabdevaca.setSnabdevac(snabdevacService.findById(selectSnabdevacId).get());
        selectPromenaSnabdevaca.setKupac(kupacService.findById(selectKupacId).get());
        selectPromenaSnabdevaca.setStatus(statusService.findById(selectStatusId).get());
        selectPromenaSnabdevaca.setGrupaZahteva(grupaZahtevaService.findById(selectGrupaZahtevaId).get());        
        
        promenaSnabdevacaService.save(selectPromenaSnabdevaca);
        
    }
    
    //////////// Merno Mesto //////////////    
    public void dodajNovoMernoMesto(){        
        mbMernoMesto.dodajNovoMernoMesto(selectPromenaSnabdevaca);
    }
    
    public void azurirajMernoMesto(){
        mbMernoMesto.azurirajMernoMesto();
    }
    
    public void brisiMernoMesto(){
        mbMernoMesto.brisiMernoMesto();
    }
    
    ///////////////////////////////////////
    
    ////////////   Dokument  //////////////    
    public void dodajNoviDokument(){        
        mbDokument.dodajNoviDokument(selectPromenaSnabdevaca);
    }
    
    public void azurirajDokument(){
        mbDokument.azurirajDokument();
    }
    
    public void brisiDokument(){
        mbDokument.brisiDokument();
    }
    
    ///////////////////////////////////////    
    
    public void posaljiNaProveruPromenuSnabdevacaOdlazak(){        
        selectPromenaSnabdevaca.setStatus(statusService.findById(Long.valueOf(StatusEnum.POSLAT_NA_PROVERU.ordinal())).get());
        promenaSnabdevacaService.save(selectPromenaSnabdevaca);        
    }

    public void kompletirajPromenuSnabdevacaOdlazak(){
        selectPromenaSnabdevaca.setStatus(statusService.findById(Long.valueOf(StatusEnum.KOMPLETIRAN.ordinal())).get());
        promenaSnabdevacaService.save(selectPromenaSnabdevaca);
    }    
    
    public void stornirajPromenuSnabdevacaOdlazak(){
        selectPromenaSnabdevaca.setStatus(statusService.findById(Long.valueOf(StatusEnum.STORNIRAN.ordinal())).get());
        promenaSnabdevacaService.save(selectPromenaSnabdevaca);
    }        

    public void SaglasnostReportPDF(ActionEvent actionEvent) throws JRException, IOException{
        String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/saglasnost.jrxml");
        ArrayList<PromenaSnabdevaca> ps = new ArrayList<>();
        ps.add(selectPromenaSnabdevaca);
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ps);
        JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFile); 
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, new HashMap(), beanCollectionDataSource);  
        HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=saglasnost.pdf");       
        FacesContext.getCurrentInstance().responseComplete();
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
        FacesContext.getCurrentInstance().responseComplete();                  
    } 
    
    public void PrigovorReportPDF(ActionEvent actionEvent) throws JRException, IOException{
        String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/prigovor.jrxml");
        ArrayList<PromenaSnabdevaca> ps = new ArrayList<>();
        ps.add(selectPromenaSnabdevaca);
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(ps);
        JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFile); 
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport, new HashMap(), beanCollectionDataSource);  
        HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=prigovor.pdf");       
        FacesContext.getCurrentInstance().responseComplete();
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
        FacesContext.getCurrentInstance().responseComplete();                  
    }    

    public Long getSelectSnabdevacId() {
        return selectSnabdevacId;
    }

    public void setSelectSnabdevacId(Long selectSnabdevacId) {
        this.selectSnabdevacId = selectSnabdevacId;
    }

    public Long getSelectKupacId() {
        return selectKupacId;
    }

    public void setSelectKupacId(Long selectKupacId) {
        this.selectKupacId = selectKupacId;
    }

    public Long getSelectStatusId() {
        return selectStatusId;
    }

    public void setSelectStatusId(Long selectStatusId) {
        this.selectStatusId = selectStatusId;
    }

    public Long getSelectGrupaZahtevaId() {
        return selectGrupaZahtevaId;
    }

    public void setSelectGrupaZahtevaId(Long selectGrupaZahtevaId) {
        this.selectGrupaZahtevaId = selectGrupaZahtevaId;
    }
}
