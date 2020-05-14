package cs544.project.security;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import cs544.project.domain.User;
import cs544.project.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService{
	private final UserRepository userDomainRepository;

    @Autowired
    public UserSecurityService(UserRepository userDomainRepository) {
        this.userDomainRepository = userDomainRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        User user = userDomainRepository.findByUsername(userName);
        System.out.println(user.getRoles().get(0).getName());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getAuthorities(user));
    }
    
    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        		user.isEnabled(), true, true, true, authorities);
        		//user.getActive(), true, true, true, authorities);
    }
}