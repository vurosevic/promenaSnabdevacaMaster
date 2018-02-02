/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.domen;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vladimir
 */
@Entity
@DiscriminatorValue("OD")
public class PromenaSnabdevacaOdlazak extends PromenaSnabdevaca {
    
    private static final long serialVersionUID = 8418755936628469234L;
    
    @Column(name = "datum_prijema")
    private Date datumPrijema;
    
    @Column(name = "datum_odobrenja")
    private Date datumOdobrenja;
    
    @Column(name = "datum_prigovora")
    private Date datumPrigovora;    
    
    @ManyToOne
    @JoinColumn(name = "status_fk")    
    private Status status;    
        
    @ManyToOne
    @JoinColumn(name = "grupa_zahteva_fk")    
    private GrupaZahteva grupaZahteva;       

    public Date getDatumPrijema() {
        return datumPrijema;
    }

    public void setDatumPrijema(Date datumPrijema) {
        this.datumPrijema = datumPrijema;
    }

    public Date getDatumOdobrenja() {
        return datumOdobrenja;
    }

    public void setDatumOdobrenja(Date datumOdobrenja) {
        this.datumOdobrenja = datumOdobrenja;
    }

    public Date getDatumPrigovora() {
        return datumPrigovora;
    }

    public void setDatumPrigovora(Date datumPrigovora) {
        this.datumPrigovora = datumPrigovora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public GrupaZahteva getGrupaZahteva() {
        return grupaZahteva;
    }

    public void setGrupaZahteva(GrupaZahteva grupaZahteva) {
        this.grupaZahteva = grupaZahteva;
    }
    
    
}
