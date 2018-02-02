/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.lazyViews;

import eps.snabdevanje.promenasnabdevaca.domen.MernoMesto;
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
public class LazyDataModelMernoMesto extends LazyDataModel<MernoMesto> {
    
    private List<MernoMesto> datasource;

    public LazyDataModelMernoMesto(List<MernoMesto> datasource) {
        this.datasource = datasource;
    }

    @Override
    public MernoMesto getRowData(String rowKey) {
        for(MernoMesto mm : datasource) {
            if(mm.getId().toString().equals(rowKey))
                return mm;
        }        
        return null; 
    }

    @Override
    public Object getRowKey(MernoMesto object) {
        return object.getId();
    }
    
    @Override
    public List<MernoMesto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {        
        List<MernoMesto> data = new ArrayList<MernoMesto>();
   //filter
        for(MernoMesto mm : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(mm.getClass().getField(filterProperty).get(mm));
 
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
                data.add(mm);
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
