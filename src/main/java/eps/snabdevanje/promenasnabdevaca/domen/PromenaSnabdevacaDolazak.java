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

/**
 *
 * @author Vladimir
 */
@Entity
@DiscriminatorValue("DO")
public class PromenaSnabdevacaDolazak extends PromenaSnabdevaca {
    
    @Column(name = "datum_potpisivanja_ugovora")
    private Date datumPotpisivanjaUgovora;    

    public Date getDatumPotpisivanjaUgovora() {
        return datumPotpisivanjaUgovora;
    }

    public void setDatumPotpisivanjaUgovora(Date datumPotpisivanjaUgovora) {
        this.datumPotpisivanjaUgovora = datumPotpisivanjaUgovora;
    }
    
    
}
