/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.lazyViews;

import eps.snabdevanje.promenasnabdevaca.domen.Kupac;
import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevaca;
import eps.snabdevanje.promenasnabdevaca.domen.PromenaSnabdevacaOdlazak;
import eps.snabdevanje.promenasnabdevaca.domen.Snabdevac;
import eps.snabdevanje.promenasnabdevaca.domen.Status;
import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Vladimir
 */
public class LazySorterPromenaSnabdevaca implements Comparator<PromenaSnabdevaca> {

    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorterPromenaSnabdevaca(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }    
    
    @Override
    public int compare(PromenaSnabdevaca o1, PromenaSnabdevaca o2) {
        try {
            
            String sortProperty = this.sortField;
            String sortProperty2 = ""; 
            Field field1;
            Field field2;
            Object value1=null;
            Object value2=null;
            
            if (sortProperty.indexOf('\'') > 0) {
             //atribut izvedene klase, uzmi naziv atributa
             sortProperty = sortProperty.substring(sortProperty.indexOf("'") + 1, sortProperty.indexOf("']"));
            }

            if (sortProperty.indexOf('.') > 0) {
             // postoji slozen atribut
              sortProperty2 = sortProperty.substring(sortProperty.indexOf(".") + 1, sortProperty.length());  
              sortProperty = sortProperty.substring(0, sortProperty.indexOf("."));  
            }

            try {
                field1 = PromenaSnabdevaca.class.getDeclaredField(sortProperty);      
            } catch (java.lang.NoSuchFieldException ex) {
                field1 = PromenaSnabdevacaOdlazak.class.getDeclaredField(sortProperty);      
            }
            
            try {
                field2 = PromenaSnabdevaca.class.getDeclaredField(sortProperty);      
            } catch (java.lang.NoSuchFieldException ex) {
                field2 = PromenaSnabdevacaOdlazak.class.getDeclaredField(sortProperty);      
            }            
            
            field1.setAccessible(true);            
            field2.setAccessible(true);
            
            if (field1.getType()==eps.snabdevanje.promenasnabdevaca.domen.Kupac.class) {
                field1 = Kupac.class.getDeclaredField(sortProperty2);      
                field1.setAccessible(true);
                value1 = String.valueOf(field1.get(((Kupac)(o1.getKupac()))));       
                field2 = Kupac.class.getDeclaredField(sortProperty2);      
                field2.setAccessible(true);                
                value2 = String.valueOf(field2.get(((Kupac)(o2.getKupac()))));       
            } else if (field1.getType()==eps.snabdevanje.promenasnabdevaca.domen.Snabdevac.class) {
                field1 = Snabdevac.class.getDeclaredField(sortProperty2);      
                field1.setAccessible(true);
                value1 = String.valueOf(field1.get(o1.getSnabdevac()));    
                field2 = Snabdevac.class.getDeclaredField(sortProperty2);      
                field2.setAccessible(true);               
                value2 = String.valueOf(field2.get(o2.getSnabdevac()));                    
            } else if (field1.getType()==eps.snabdevanje.promenasnabdevaca.domen.Status.class) {
                field1 = Status.class.getDeclaredField(sortProperty2);      
                field1.setAccessible(true);
                value1 = String.valueOf(field1.get(((PromenaSnabdevacaOdlazak)(o1)).getStatus()));    
                field2 = Status.class.getDeclaredField(sortProperty2);      
                field2.setAccessible(true);
                value2 = String.valueOf(field2.get(((PromenaSnabdevacaOdlazak)(o2)).getStatus()));    
            } else {
                    value1 = field1.get(o1);
                    value2 = field2.get(o2);                         
            };
                     
            int value = -1;
            if ((value1 != null)&&(value2 != null)){
                value = ((Comparable)value1).compareTo(value2);                
            } else if (value1 == null) {
                value = 1;
            } else if (value1 == null) {
                value = 0;
            }
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
    
}
