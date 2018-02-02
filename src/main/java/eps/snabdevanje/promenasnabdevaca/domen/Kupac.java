/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.domen;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Vladimir
 */
@Entity
@Table(name = "ps_kupac")
@Inheritance
@DiscriminatorColumn(name = "Tip_kupca")
public class Kupac {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")            
    private Long id;    

    @Column(name = "Naziv")
    @Size(max = 50)
    private String naziv;    
    
    @Column(name = "Adresa")
    @Size(max = 255)
    private String adresa;
    
    @Column(name = "Telefon")
    @Size(max = 20)
    private String telefon;
    
    @Column(name = "Email")
    @Size(max = 50)
    private String email;

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Kupac() {
    }

    public Kupac(Long id, String adresa, String telefon, String email) {
        this.id = id;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }
        
    
    
}
