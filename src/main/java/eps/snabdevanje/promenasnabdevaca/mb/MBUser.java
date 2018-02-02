/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.domen.User;
import eps.snabdevanje.promenasnabdevaca.domen.UserRoles;
import eps.snabdevanje.promenasnabdevaca.lazyViews.LazyDataModelUser;
import eps.snabdevanje.promenasnabdevaca.service.UserRolesService;
import eps.snabdevanje.promenasnabdevaca.service.UserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBUser")
@SessionScoped
public class MBUser {
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserRolesService userRolesService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    private List<User> lista;
    private User selectUser;
    private User noviUser;    
    private String newPasword;
    
    private LazyDataModel<User> lazyModel;   
    private DualListModel<String> rolesNew;    
    private DualListModel<String> rolesSelect;    

    public MBUser() {
        noviUser = new User();
        rolesNew = new DualListModel<>();
        rolesSelect = new DualListModel<>();        
    }
    
    @PostConstruct
    public void init(){     
         setLista(userService.findAll());
         setLazyModel(new LazyDataModelUser(userService.findAll())); 
         setNoviUser(new User());
         setSelectUser(null);     
         setNewPasword(null); 
         
         List<String> source = new ArrayList<>();
         source.add("ROLE_ADMIN");
         source.add("ROLE_KOORDINATOR");         
         source.add("ROLE_FIN");
         source.add("ROLE_MANAGER");
         rolesNew.setSource(source);
         rolesSelect.setSource(new ArrayList<String>()); 
    }     

    public List<User> getLista() {
        return lista;
    }

    public void setLista(List<User> lista) {
        this.lista = lista;
    }

    public User getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(User selectUser) {
        this.selectUser = selectUser;
    }

    public User getNoviUser() {
        return noviUser;
    }

    public void setNoviUser(User noviUser) {
        this.noviUser = noviUser;
    }

    public LazyDataModel<User> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<User> lazyModel) {
        this.lazyModel = lazyModel;
    }
    
    public void promenaSelektovanogUsera(){
        rolesSelect.setTarget(userRolesService.findListRolesByUser(selectUser));
        rolesSelect.getSource().clear();
        Set<String> set = new HashSet<String>(rolesSelect.getTarget());
        for (String rn : rolesNew.getSource()){
             if (!set.contains(rn)) {
                 rolesSelect.getSource().add(rn); 
             }
        }        
    }
    
    public void dodajNovogUsera(){
        noviUser.setPassword(passwordEncoder.encode(noviUser.getPassword()));               
        userService.save(noviUser);                               

        for (String rn : rolesNew.getTarget()){
            userRolesService.save(new UserRoles(userService.findByUsername(noviUser.getUsername()), rn));    
        }
        init();
    }
    
    public void azurirajUsera(){        
        userRolesService.deleteAll(userRolesService.findByUser(selectUser)); 
        
        if (!newPasword.isEmpty()){
            selectUser.setPassword(passwordEncoder.encode(newPasword));
        }
        userService.save(selectUser);        
        for (String rn : rolesSelect.getTarget()){
            userRolesService.save(new UserRoles(userService.findByUsername(selectUser.getUsername()), rn));    
        }        
    }
    
    public void brisiUsera(){
        userService.delete(selectUser);
        init();
    }

    public DualListModel<String> getRolesNew() {
        return rolesNew;
    }

    public void setRolesNew(DualListModel<String> rolesNew) {
        this.rolesNew = rolesNew;
    }

    public DualListModel<String> getRolesSelect() {
        return rolesSelect;
    }

    public void setRolesSelect(DualListModel<String> rolesSelect) {
        this.rolesSelect = rolesSelect;
    }

    public String getNewPasword() {
        return newPasword;
    }

    public void setNewPasword(String newPasword) {
        this.newPasword = newPasword;
    }
  
}
