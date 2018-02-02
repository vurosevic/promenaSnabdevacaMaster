/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.lazyViews;

import eps.snabdevanje.promenasnabdevaca.domen.TipDokumenta;
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
public class LazyDataModelTipDokumenta extends LazyDataModel<TipDokumenta>{
   
    private List<TipDokumenta> datasource;

    public LazyDataModelTipDokumenta(List<TipDokumenta> datasource) {
        this.datasource = datasource;
    }

    @Override
    public TipDokumenta getRowData(String rowKey) {
        for(TipDokumenta td : datasource) {
            if(td.getId().toString().equals(rowKey))
                return td;
        }        
        return null; 
    }

    @Override
    public Object getRowKey(TipDokumenta object) {
        return object.getId();
    }   
    
 @Override
    public List<TipDokumenta> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {        
        List<TipDokumenta> data = new ArrayList<TipDokumenta>();
   //filter
        for(TipDokumenta td : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(td.getClass().getField(filterProperty).get(td));
 
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
                data.add(td);
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
