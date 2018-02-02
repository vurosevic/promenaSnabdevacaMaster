/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.mb;

import eps.snabdevanje.promenasnabdevaca.service.UserService;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vladimir
 */
@Component("MBLogin")
@SessionScoped
public class MBLogin {
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationManager authenticationManager;    
    
    @Autowired
    private PasswordEncoder passwordEncoder;        
    
    private String username;
    private String password;
    private String rememberMe = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

public String login2() {
    try {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        this.username, this.password));

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        

    } catch (AuthenticationException ex) {
        return "false";
    }

    return "true";
}    
    
   public String login() throws IOException {
        try {
            Authentication result = null;
                
                UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername());                
                Authentication request = new UsernamePasswordAuthenticationToken(
                        this.getUsername(), this.getPassword(), userDetails.getAuthorities()); 
                
                result = getAuthenticationManager().authenticate(request);
                HttpServletRequest httpServletRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
                HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();                                
                SecurityContextHolder.getContext().setAuthentication(result);                
                FacesContext.getCurrentInstance().getExternalContext().redirect(httpServletRequest.getContextPath() + "/index.xhtml");
                
        } catch (AuthenticationException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Пријава на систем није успешна."));
            return null;
        }
        return "secured";
    }
 
    /**
     * Cancel.
     *
     * @return the string
     */
    public String cancel() {
        return null;
    }
 
    /**
     * Logout.
     *
     * @return the string
     */
    public String logout() throws IOException {
        SecurityContextHolder.clearContext();        
        HttpServletRequest httpServletRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();                
        FacesContext.getCurrentInstance().getExternalContext().redirect(httpServletRequest.getContextPath() + "/login.xhtml");                
        return "loggedout";
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }
    
  
}
