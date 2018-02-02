/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vladimir
 */

@Entity
@Table(name = "ps_snabdevac")
public class Snabdevac implements Serializable {
    
    @Id 
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)             
    private Long id;
    
    @Column(name = "Naziv")
    @Size(max = 100)    
    private String naziv;
    
    @Column(name = "MB")
    @Size(max = 10)
    private String mb;
    
    @Column(name = "Adresa")
    @Size(max = 255) 
    private String adresa;
    
    @Column(name = "Mesto")
    @Size(max = 50)
    private String mesto;    

    public Snabdevac() {
    }

    public Snabdevac(Long id, String naziv, String mb, String adresa, String mesto) {
        this.id = id;
        this.naziv = naziv;
        this.mb = mb;
        this.adresa = adresa;
        this.mesto = mesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
    
    
    
}
