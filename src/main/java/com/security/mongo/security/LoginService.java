package com.security.mongo.security;

import java.util.Arrays;
import java.util.List;
import com.security.mongo.domain.Utilisateur;
import com.security.mongo.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
@Service
public class LoginService implements UserDetailsService
{
    private UserService repository;
 
    @Autowired
    public LoginService( UserService repository )
    {
        this.repository = repository;
    }
    
 
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {
        Utilisateur user = repository.getUserByUsername( username );
 
        if( user == null )
            throw new UsernameNotFoundException( "Oops!" );
 
        List<SimpleGrantedAuthority> authorities = Arrays.asList( new SimpleGrantedAuthority( user.getRole() ) );
 
        return new User( user.getUsername(), user.getSHA1Password(), authorities );
        
    }
}