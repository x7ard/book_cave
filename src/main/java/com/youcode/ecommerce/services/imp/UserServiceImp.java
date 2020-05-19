package com.youcode.ecommerce.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.RolesRepo;
import com.youcode.ecommerce.dao.UserRepo;
import com.youcode.ecommerce.entities.Roles;
import com.youcode.ecommerce.entities.User;

@Service
@EnableAutoConfiguration
public class UserServiceImp implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RolesRepo rolesRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		for (int i = 0; i < getAllUsers().size(); i++) {
			if (getAllUsers().get(i).getUsername().equals(username)) {

				User user = userRepo.findByUsername(username);
				return new org.springframework.security.core.userdetails.User(getAllUsers().get(i).getUsername(),
						getAllUsers().get(i).getPassword(), getGrantedAuthorities(user));
			}
		}
		throw new UsernameNotFoundException("User not found : " + username);
	}

	// roles part
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		Set<Roles> roles = user.getRoles();
		for (Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

}
