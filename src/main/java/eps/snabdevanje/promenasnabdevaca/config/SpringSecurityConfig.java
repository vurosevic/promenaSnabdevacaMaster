package eps.snabdevanje.promenasnabdevaca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Vladimir
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"eps.snabdevanje.promenasnabdevaca", "eps.snabdevanje.promenasnabdevaca.repository",
"eps.snabdevanje.promenasnabdevaca.service","eps.snabdevanje.promenasnabdevaca.service.impl",
"eps.snabdevanje.promenasnabdevaca.mb", "eps.snabdevanje.promenasnabdevaca.config"})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService; 
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);        
    }
    
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }    
      
    @Bean
    public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder(11);
    }    

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/javax.faces.resource/**");
    }    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {    
        http.csrf().disable();        
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl(
                        "/login.xhtml");                
        http.authorizeRequests()
                .antMatchers("/").permitAll()               
                .antMatchers("/index**", "/login**").permitAll()
                .antMatchers("/evidencijaodlaska.xhtml").hasAuthority("ROLE_KOORDINATOR")
                .antMatchers("/finprovera.xhtml").hasAuthority("ROLE_FIN")
                .antMatchers("/snabdevaci.xhtml").hasAnyAuthority("ROLE_KOORDINATOR")
                .antMatchers("/tehnickicentri.xhtml").hasAnyAuthority("ROLE_KOORDINATOR")
                .antMatchers("/grupazahteva.xhtml").hasAnyAuthority("ROLE_KOORDINATOR")
                .antMatchers("/kupci.xhtml").hasAnyAuthority("ROLE_KOORDINATOR")
                .antMatchers("/korisnici.xhtml").hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and().csrf().disable().headers().frameOptions().disable()
                .and()
                .formLogin().defaultSuccessUrl("/index.xhtml", true)
                .loginPage("/login.xhtml").permitAll()
                .loginProcessingUrl("/login")              
                .and().exceptionHandling().accessDeniedPage("/greska.xhtml")
                .and()
                .logout().permitAll();
    }

}
