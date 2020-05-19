package com.youcode.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youcode.ecommerce.entities.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long> {

	Optional<Roles> findByName(String name);

}
