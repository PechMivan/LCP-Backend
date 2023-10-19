package com.lcp.app.repository;

import com.lcp.app.entity.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository< Role, Long> {

	Role findByRoleName(String roleName);
}
