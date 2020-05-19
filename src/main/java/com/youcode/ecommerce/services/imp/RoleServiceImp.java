package com.youcode.ecommerce.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.RolesRepo;
import com.youcode.ecommerce.entities.Roles;
import com.youcode.ecommerce.exceptions.ResourceNotFoundException;

@Service
public class RoleServiceImp {

	private final RolesRepo rolesRepo;

	@Autowired
	public RoleServiceImp(RolesRepo rolesRepo) {
		this.rolesRepo = rolesRepo;
	}

	public Roles save(Roles role) {
		return this.rolesRepo.save(role);
	}

	public Roles get(String name, boolean throwExceptionIfNotFound) {
		Optional<Roles> role = this.rolesRepo.findByName(name);
		if (throwExceptionIfNotFound && !role.isPresent())
			throw new ResourceNotFoundException();
		return role.orElse(null);
	}

	public Roles getRoleDontThrow(String name) {
		return get(name, false);
	}

	public Roles getRoleOrThrow(String name) {
		return get(name, true);
	}

	public List<Roles> findAll() {
		return rolesRepo.findAll();
	}

}
