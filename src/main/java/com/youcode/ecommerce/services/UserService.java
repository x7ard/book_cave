package com.youcode.ecommerce.services;

import java.security.Principal;
import java.util.Optional;

import com.youcode.ecommerce.entities.User;

public interface UserService {

	public User getUser(Principal principal);

	Optional<User> get(String username);

	User updateUser(Principal principal, User user);
}
