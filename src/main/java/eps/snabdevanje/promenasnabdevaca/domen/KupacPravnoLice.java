/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.domen;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

/**
 *
 * @author Vladimir
 */
@Entity
@DiscriminatorValue("PL")
public class KupacPravnoLice extends Kupac {    
    
    @Column(name = "PIB")
    @Size(max = 10)    
    private String pib;
    
    @Column(name = "MB")
    @Size(max = 10)    
    private String mb;
    
    @Column(name = "Kontakt_osoba")
    @Size(max = 50)    
    private String kontaktOsoba;

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb;
    }

    public String getKontaktOsoba() {
        return kontaktOsoba;
    }

    public void setKontaktOsoba(String kontaktOsoba) {
        this.kontaktOsoba = kontaktOsoba;
    }
    
    
}
