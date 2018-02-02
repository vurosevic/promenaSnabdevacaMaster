/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.domen;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "ps_promena_snabdevaca")
@Inheritance
@DiscriminatorColumn(name = "tip_promene")
public class PromenaSnabdevaca {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")    
    private Long id;    
    
    @Column(name = "broj_ugovora")
    private String brojUgovora;
    
    @Column(name = "ugovor_od")
    private Date datumUgovoraOd;
    
    @Column(name = "ugovor_do")
    private Date datumUgovoraDo;
    
    @Column(name = "otkazni_rok")    
    private String otkazniRok;
    
    @Column(name = "neodredjeno_vreme")
    private boolean neodredjenoVreme;
    
    @Column(name = "datum_kreiranja")
    private Date datumKreiranja;
    
    @ManyToOne
    @JoinColumn(name = "snabdevac_fk")
    private Snabdevac snabdevac;
    
    @ManyToOne
    @JoinColumn(name = "kupac_fk")    
    private Kupac kupac;  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(String brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public Date getDatumUgovoraOd() {
        return datumUgovoraOd;
    }

    public void setDatumUgovoraOd(Date datumUgovoraOd) {
        this.datumUgovoraOd = datumUgovoraOd;
    }

    public Date getDatumUgovoraDo() {
        return datumUgovoraDo;
    }

    public void setDatumUgovoraDo(Date datumUgovoraDo) {
        this.datumUgovoraDo = datumUgovoraDo;
    }

    public String getOtkazniRok() {
        return otkazniRok;
    }

    public void setOtkazniRok(String otkazniRok) {
        this.otkazniRok = otkazniRok;
    }

    public boolean getNeodredjenoVreme() {
        return neodredjenoVreme;
    }

    public void setNeodredjenoVreme(boolean neodredjenoVreme) {
        this.neodredjenoVreme = neodredjenoVreme;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Snabdevac getSnabdevac() {
        return snabdevac;
    }

    public void setSnabdevac(Snabdevac snabdevac) {
        this.snabdevac = snabdevac;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }
    
    
    
}
