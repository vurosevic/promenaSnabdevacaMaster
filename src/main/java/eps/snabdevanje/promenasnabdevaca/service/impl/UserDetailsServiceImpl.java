package eps.snabdevanje.promenasnabdevaca.service.impl;

import eps.snabdevanje.promenasnabdevaca.repository.UserDAO;
import eps.snabdevanje.promenasnabdevaca.domen.User;
import eps.snabdevanje.promenasnabdevaca.domen.enumtype.UserRoleEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vladimir
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username: " + username);
        }
        
        List<GrantedAuthority> authorities = buildUserAuthorities(user.getRoles());
        return buildUser(user, authorities);
    }

    private List<GrantedAuthority> buildUserAuthorities(Set<UserRoleEnum> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        for (UserRoleEnum role : roles) {
            list.add(new SimpleGrantedAuthority(role.name()));
        }
        return list;
    }

    private UserDetails buildUser(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }

}
