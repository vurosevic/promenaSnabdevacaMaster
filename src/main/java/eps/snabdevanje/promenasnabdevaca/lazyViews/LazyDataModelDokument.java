/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.lazyViews;

import eps.snabdevanje.promenasnabdevaca.domen.Dokument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Vladimir
 */
public class LazyDataModelDokument extends LazyDataModel<Dokument>{
    
    private List<Dokument> datasource;

    public LazyDataModelDokument(List<Dokument> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Dokument getRowData(String rowKey) {
        for(Dokument dok : datasource) {
            if(dok.getId().toString().equals(rowKey))
                return dok;
        }        
        return null; 
    }

    @Override
    public Object getRowKey(Dokument object) {
        return object.getId();
    }

    @Override
    public List<Dokument> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {        
        List<Dokument> data = new ArrayList<Dokument>();
   //filter
        for(Dokument dok : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(dok.getClass().getField(filterProperty).get(dok));
 
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
                data.add(dok);
            }
        }
 
//        //sort
//        if(sortField != null) {
//            Collections.sort(data, new LazySorter(sortField, sortOrder));
//        }
 
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
