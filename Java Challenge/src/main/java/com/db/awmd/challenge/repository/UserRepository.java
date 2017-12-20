package com.db.awmd.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.awmd.challenge.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
