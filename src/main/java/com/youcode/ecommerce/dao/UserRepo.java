package com.youcode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);

	User findByUsername(String username);

	Boolean existsByEmail(String email);

}
