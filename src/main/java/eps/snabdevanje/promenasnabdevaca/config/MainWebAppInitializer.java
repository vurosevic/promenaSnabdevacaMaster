/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eps.snabdevanje.promenasnabdevaca.config;

/**
 *
 * @author Vladimir
 */
import com.sun.faces.config.FacesInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;
import javax.servlet.FilterRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class MainWebAppInitializer extends FacesInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        super.onStartup(classes, servletContext);
    }

    @Override
    public void onStartup(final ServletContext sc) throws ServletException {
        sc.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
        
        final AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.register(SpringSecurityConfig.class);
        sc.addListener(new ContextLoaderListener(root));
        
        FilterRegistration.Dynamic securityFilter = sc.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(null, false, "/*");        

    }

}
