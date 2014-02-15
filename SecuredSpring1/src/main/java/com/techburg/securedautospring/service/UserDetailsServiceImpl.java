package com.techburg.securedautospring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.techburg.securedautospring.model.UserDetailsImpl;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Going to load an User by name " + arg0);
		if("demo".equals(arg0)) {
			System.out.println("A UserDetails instance to be created");
			return new UserDetailsImpl();
		}
		else throw new UsernameNotFoundException("Can't not find user with name " + arg0);
	}
	
}


