/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.domen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "ps_dokument")
public class Dokument implements Serializable {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)      
    private Long id;
    
    @Column(name = "Naziv")
    @Size(max = 100)
    private String naziv;
    
    @Column(name = "Putanja")
    @Size(max = 255)
    private String putanja;
    
    @Column(name = "Datum_upisa")
    private Date datumUpisa;
    
    @ManyToOne
    @JoinColumn(name = "Tip_dokumenta_fk")
    private TipDokumenta tipDokumenta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promena_snabdevaca_fk")
    private PromenaSnabdevaca promenaSnabdevaca;    
    
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

    public String getPutanja() {
        return putanja;
    }

    public void setPutanja(String putanja) {
        this.putanja = putanja;
    }

    public Date getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
    }

    public TipDokumenta getTipDokumenta() {
        return tipDokumenta;
    }

    public void setTipDokumenta(TipDokumenta tipDokumenta) {
        this.tipDokumenta = tipDokumenta;
    }

    public Dokument() {
        tipDokumenta = null;
    }

    public PromenaSnabdevaca getPromenaSnabdevaca() {
        return promenaSnabdevaca;
    }

    public void setPromenaSnabdevaca(PromenaSnabdevaca promenaSnabdevaca) {
        this.promenaSnabdevaca = promenaSnabdevaca;
    }
    
    
    
}
