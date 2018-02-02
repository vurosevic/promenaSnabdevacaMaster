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
@DiscriminatorValue("FL")
public class KupacFizickoLice extends Kupac {
    
    @Column(name = "JMBG")
    @Size(max = 14)
    private String jmbg;    
    
    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    
    


    
    
}
