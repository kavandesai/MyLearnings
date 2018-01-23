package com.db.awmd.challenge.service;

import com.db.awmd.challenge.domain.User;

public interface UserService {

	public void saveUser(User user);
	public User findUserByEmail(String email);
}
