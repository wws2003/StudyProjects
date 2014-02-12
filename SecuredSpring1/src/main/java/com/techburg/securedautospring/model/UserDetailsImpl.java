package com.techburg.securedautospring.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<GrantedAuthority> m_grantedAuthoritiesList = null;
	
	public UserDetailsImpl() {
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
		m_grantedAuthoritiesList = new ArrayList<GrantedAuthority>();
		m_grantedAuthoritiesList.add(grantedAuthority);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return m_grantedAuthoritiesList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "1";
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return "demo";
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
