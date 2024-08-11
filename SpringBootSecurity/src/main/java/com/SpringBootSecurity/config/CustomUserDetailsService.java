package com.SpringBootSecurity.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<SimpleGrantedAuthority> roles = null;
	/*this list is of type SimpleGrantedAuthority and 
		is used to store the roles depending on the username */
		
		if (username.equals("admin")) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin", "$2a$10$ijU2vBu8XPAuwsQ/bs4Houm6g1vcvjO7rLO14POquNFaRhV6e7o8W", roles);
		// here we add password in Bcrypt format 
		/* to generate password in Bcrypt format -> search javainuse.com/onlineBcrypt -> 
		 * give username -> Generate Bcrypt Hash */	
		
		}
		
		if (username.equals("user")) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
			return new User("user", "$2a$10$PnpvGXjigIAtWskrq7asser9JTPVy6zmnyf6liNDo3SPn.qZpzOJC", roles);
		// here we add password in Bcrypt format 
		/* to generate password in Bcrypt format -> search javainuse.com/onlineBcrypt -> 
		 * give username -> Generate Bcrypt Hash */	
		
		}
		
		throw new UsernameNotFoundException("User not found with the name : "+username);
		
	}

}
