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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Vladimir
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class LazyDataModelPromenaSnabdevaca extends LazyDataModel<PromenaSnabdevaca>{
    
   private List<PromenaSnabdevaca> datasource;

    public LazyDataModelPromenaSnabdevaca(List<PromenaSnabdevaca> datasource) {
        this.datasource = datasource;
    }

    @Override
    public PromenaSnabdevaca getRowData(String rowKey) {
        for(PromenaSnabdevaca ps : datasource) {
            if(ps.getId().toString().equals(rowKey))
                return ps;
        }        
        return null; 
    }

    @Override
    public Object getRowKey(PromenaSnabdevaca object) {
        return object.getId();
    }        
    
    @Override
    public List<PromenaSnabdevaca> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {        
        List<PromenaSnabdevaca> data = new ArrayList<PromenaSnabdevaca>();
   //filter
        for(PromenaSnabdevaca ps : datasource) {
            boolean match = true;
      
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        String filterProperty2 = "";
                        Object filterValue = filters.get(filterProperty);
                        
                           Field field;
                           Field field2;
                           String fieldValue;                      

                           if (filterProperty.indexOf('\'') > 0) {
                            //atribut izvedene klase, uzmi naziv atributa
                            filterProperty = filterProperty.substring(filterProperty.indexOf("'") + 1, filterProperty.indexOf("']"));
                           }
                           
                           if (filterProperty.indexOf('.') > 0) {
                            // postoji slozen atribut
                             filterProperty2 = filterProperty.substring(filterProperty.indexOf(".") + 1, filterProperty.length());  
                             filterProperty = filterProperty.substring(0, filterProperty.indexOf("."));  
                           }

                           try {
                               field = PromenaSnabdevaca.class.getDeclaredField(filterProperty);      
                           } catch (java.lang.NoSuchFieldException ex) {
                               field = PromenaSnabdevacaOdlazak.class.getDeclaredField(filterProperty);      
                           }
                            field.setAccessible(true);
                            
                            if (field.getType()==java.util.Date.class){
                               Date tmp = (Date)(field.get(ps));
                               Format formatter = new SimpleDateFormat("dd.MM.yyyy");
                               fieldValue = formatter.format(tmp);
                            } else if (field.getType()==eps.snabdevanje.promenasnabdevaca.domen.Kupac.class) {
                                field2 = Kupac.class.getDeclaredField(filterProperty2);      
                                field2.setAccessible(true);
                                fieldValue = String.valueOf(field2.get(((Kupac)(ps.getKupac()))));       
                            } else if (field.getType()==eps.snabdevanje.promenasnabdevaca.domen.Snabdevac.class) {
                                field2 = Snabdevac.class.getDeclaredField(filterProperty2);      
                                field2.setAccessible(true);
                                fieldValue = String.valueOf(field2.get(ps.getSnabdevac()));    
                            } else if (field.getType()==eps.snabdevanje.promenasnabdevaca.domen.Status.class) {
                                field2 = Status.class.getDeclaredField(filterProperty2);      
                                field2.setAccessible(true);
                                fieldValue = String.valueOf(field2.get(((PromenaSnabdevacaOdlazak)(ps)).getStatus()));    
                            }
                            else                     
                            fieldValue = String.valueOf(field.get(ps));   
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(ps);
            }
        }
 
        //sort
        if(sortField != null) {
            Collections.sort(data, new LazySorterPromenaSnabdevaca(sortField, sortOrder));
        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }           
    }      
    
}
