/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.Dokument;
import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelDokument;
import eps.snabdevanje.promenasnabdevaca.service.DokumentService;
import eps.snabdevanje.promenasnabdevaca.service.TipDokumentaService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBDokument")
@SessionScoped
public class MBDokument {
    
    @Autowired
    DokumentService dokumentService;
    
    @Autowired
    TipDokumentaService tipDokumentaService;
    
    private List<Dokument> lista;
    private Dokument selectDokument;
    private Dokument noviDokument;
    
    private LazyDataModel<Dokument> lazyModel;
    private Long selectTipDokumentaId;   
    private StreamedContent file;
    private Long selectPromenaSnabdevacaId;
    
    public MBDokument() {
        noviDokument = new Dokument();
        selectDokument = new Dokument();
        selectPromenaSnabdevacaId = null;
    }

    @PostConstruct
    public void init(){     
         setLista(dokumentService.findByPromenaSnabdevacaId(selectPromenaSnabdevacaId));
         setLazyModel(new LazyDataModelDokument(dokumentService.findByPromenaSnabdevacaId(selectPromenaSnabdevacaId))); 
         setNoviDokument(new Dokument());
         setSelectDokument(null);
         selectTipDokumentaId = null;
    }     
    
    public void refresh(){
         setLista(dokumentService.findByPromenaSnabdevacaId(selectPromenaSnabdevacaId));
         setLazyModel(new LazyDataModelDokument(dokumentService.findByPromenaSnabdevacaId(selectPromenaSnabdevacaId)));         
         selectDokument=null;
    }
    
    public void clear(){
        selectPromenaSnabdevacaId = null;
        refresh();
    }    
    
    public List<Dokument> getLista() {
        return lista;
    }

    public void setLista(List<Dokument> lista) {
        this.lista = lista;
    }

    public Dokument getSelectDokument() {
        return selectDokument;
    }

    public void setSelectDokument(Dokument selectDokument) {
        this.selectDokument = selectDokument;
    }

    public Dokument getNoviDokument() {
        return noviDokument;
    }

    public void setNoviDokument(Dokument noviDokument) {
        this.noviDokument = noviDokument;
    }

    public LazyDataModel<Dokument> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Dokument> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public Long getSelectTipDokumentaId() {
        return selectTipDokumentaId;
    }

    public void setSelectTipDokumentaId(Long selectTipDokumentaId) {
        this.selectTipDokumentaId = selectTipDokumentaId;
    }
    
    public void dodajNoviDokument(PromenaSnabdevaca promenaSnabdevaca){
        
        //ubaciti upload fajla i kopiranje na odredisnu adresu        
        if (noviDokument.getPutanja()!= null) {
            noviDokument.setTipDokumenta(tipDokumentaService.findById(selectTipDokumentaId).get()); 
            noviDokument.setPromenaSnabdevaca(promenaSnabdevaca);
            dokumentService.save(noviDokument);
            init();
        }
    }
    
    public void azurirajDokument(){
                        
        selectDokument.setTipDokumenta(tipDokumentaService.findById(selectTipDokumentaId).get()); 
        dokumentService.save(selectDokument);
        selectTipDokumentaId = null;
    }
    
    public void brisiDokument(){
        
        //brisati fajl sa odredisne adrese, ako postoji
        if (selectDokument.getPutanja()!= null) {
            File f = new File(selectDokument.getPutanja());
            if (f.delete()) {        
                System.out.println("Fajl " + f.getName() + " se ne moze obrisati");
            }
        }
        
        dokumentService.delete(selectDokument);
        init();
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        String root = "C:\\tmp\\";
        String suuid = UUID.randomUUID().toString().replaceAll("-", "");

        noviDokument.setDatumUpisa(Calendar.getInstance().getTime());
        noviDokument.setPutanja(root + suuid + "_" + file.getFileName()); 
        try (InputStream input = file.getInputstream()) {             
             Files.copy(input, Paths.get(root,suuid + "_" + file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e){
            
        }        
    }    

    public StreamedContent getFile() throws IOException, InterruptedException {       
            Path p = Paths.get(selectDokument.getPutanja());        
            InputStream stream = Files.newInputStream(p);
            file = new DefaultStreamedContent(stream, "application/pdf", p.getFileName().toString());    
            return file;
    }
    
    public Long getSelectPromenaSnabdevacaId() {
        return selectPromenaSnabdevacaId;
    }

    public void setSelectPromenaSnabdevacaId(Long selectPromenaSnabdevacaId) {
        this.selectPromenaSnabdevacaId = selectPromenaSnabdevacaId;
    }
    
}
