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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "ps_merno_mesto")
public class MernoMesto implements Serializable {

    public PromenaSnabdevaca getPromenaSnabdevaca() {
        return promenaSnabdevaca;
    }

    public void setPromenaSnabdevaca(PromenaSnabdevaca promenaSnabdevaca) {
        this.promenaSnabdevaca = promenaSnabdevaca;
    }
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Basic(optional = false)             
    private Long id;
    
    @Column(name = "Ed_broj")
    @Size(max = 15)
    private String edBroj;

    @Column(name = "Adresa_mm")
    @Size(max = 255)
    private String adresaMernogMesta;
    
    @Column(name = "Planirana_energija")
    private Double planiranaEnergija;
    
    @Column(name = "Odobrena_snaga")
    private Double odobrenaSnaga;
    
    @Column(name = "Ostvarena_energija")
    private Double ostvarenaEnergija;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tc_fk")
    private TehnickiCentar tehnickiCentar;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promena_snabdevaca_fk")
    private PromenaSnabdevaca promenaSnabdevaca;

    public MernoMesto() {
        tehnickiCentar = null;
    }
        
    
    //dodati vezu vise prema jedan ka 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEdBroj() {
        return edBroj;
    }

    public void setEdBroj(String edBroj) {
        this.edBroj = edBroj;
    }

    public String getAdresaMernogMesta() {
        return adresaMernogMesta;
    }

    public void setAdresaMernogMesta(String adresaMernogMesta) {
        this.adresaMernogMesta = adresaMernogMesta;
    }

    public Double getPlaniranaEnergija() {
        return planiranaEnergija;
    }

    public void setPlaniranaEnergija(Double planiranaEnergija) {
        this.planiranaEnergija = planiranaEnergija;
    }

    public Double getOdobrenaSnaga() {
        return odobrenaSnaga;
    }

    public void setOdobrenaSnaga(Double odobrenaSnaga) {
        this.odobrenaSnaga = odobrenaSnaga;
    }

    public Double getOstvarenaEnergija() {
        return ostvarenaEnergija;
    }

    public void setOstvarenaEnergija(Double ostvarenaEnergija) {
        this.ostvarenaEnergija = ostvarenaEnergija;
    }

    
    public TehnickiCentar getTehnickiCentar() {
        return tehnickiCentar;
    }

    public void setTehnickiCentar(TehnickiCentar tehnickiCentar) {
        this.tehnickiCentar = tehnickiCentar;
    }
    
    
}
