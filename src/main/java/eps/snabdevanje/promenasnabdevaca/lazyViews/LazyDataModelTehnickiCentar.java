/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.lazyViews;

import eps.snabdevanje.promenasnabdevaca.domen.TehnickiCentar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Vladimir
 */
public class LazyDataModelTehnickiCentar extends LazyDataModel<TehnickiCentar> {
    
    private List<TehnickiCentar> datasource;

    public LazyDataModelTehnickiCentar(List<TehnickiCentar> datasource) {
        this.datasource = datasource;
    }

    @Override
    public TehnickiCentar getRowData(String rowKey) {
        for(TehnickiCentar tc : datasource) {
            if(tc.getId().toString().equals(rowKey))
                return tc;
        }        
        return null; 
    }

    @Override
    public Object getRowKey(TehnickiCentar object) {
        return object.getId();
    }

    @Override
    public List<TehnickiCentar> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
        List<TehnickiCentar> data = new ArrayList<TehnickiCentar>();
        
   //filter
        for(TehnickiCentar tc : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(tc.getClass().getField(filterProperty).get(tc));
 
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
                data.add(tc);
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

    @Override
    public List<TehnickiCentar> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {        
        List<TehnickiCentar> data = new ArrayList<TehnickiCentar>();
   //filter
        for(TehnickiCentar tc : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(tc.getClass().getField(filterProperty).get(tc));
 
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
                data.add(tc);
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
