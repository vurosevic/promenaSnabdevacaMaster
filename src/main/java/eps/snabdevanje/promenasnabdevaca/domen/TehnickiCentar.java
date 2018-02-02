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
@Table(name = "ps_tehnicki_centar")
public class TehnickiCentar implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)            
    private Long id;
    
    @Column(name = "Naziv_tc")
    @Size(max = 100)
    private String naziv_tc;
    
    @Column(name = "Adresa_sedista")
    @Size(max = 255)
    private String adresa_sedista;    

    public TehnickiCentar() {
    }

    public TehnickiCentar(long id, String naziv_tc, String adresa_sedista) {
        this.id = id;
        this.naziv_tc = naziv_tc;
        this.adresa_sedista = adresa_sedista;
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv_tc() {
        return naziv_tc;
    }

    public void setNaziv_tc(String naziv_tc) {
        this.naziv_tc = naziv_tc;
    }

    public String getAdresa_sedista() {
        return adresa_sedista;
    }

    public void setAdresa_sedista(String adresa_sedista) {
        this.adresa_sedista = adresa_sedista;
    }
}
