package com.db.awmd.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.awmd.challenge.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);
}
