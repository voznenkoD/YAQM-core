package org.perspectiveJuniors.YAQM.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.perspectiveJuniors.YAQM.dao.IDaoUser;
import org.perspectiveJuniors.YAQM.dao.impl.DaoUser;
import org.perspectiveJuniors.YAQM.entity.AbstractUser;
import org.perspectiveJuniors.YAQM.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by eljetto on 6/2/15.
 */
@Service("userAuthService")
public class UserAuthService implements UserDetailsService{

    @Autowired
    private IDaoUser userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String login)
            throws UsernameNotFoundException {

        AbstractUser user = ((DaoUser) userDao).findByUserName(login);
        List<GrantedAuthority> authorities =
                buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);

    }

    private User buildUserForAuthentication(AbstractUser user,
            List<GrantedAuthority> authorities) {
        return new User(user.getPersonalData().getLogin(), user.getPersonalData().getPassword(),
                true, true, true, true, authorities);
        //TODO all fake true parameters to learn
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}
