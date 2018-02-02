/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.domen;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ps_grupa_zahteva")
public class GrupaZahteva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)              
    private Long id;
    
    @Column(name = "mesec")
    @Size(max = 10)
    private String mesec;
    
    @Column(name = "godina")
    @Size(max = 4)
    private String godina;
    
    @ManyToOne
    @JoinColumn(name = "status_gz_fk")
    private StatusGrupeZahteva statusGrupeZahteva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    public StatusGrupeZahteva getStatusGrupeZahteva() {
        return statusGrupeZahteva;
    }

    public void setStatusGrupeZahteva(StatusGrupeZahteva statusGrupeZahteva) {
        this.statusGrupeZahteva = statusGrupeZahteva;
    }
    
    
}
