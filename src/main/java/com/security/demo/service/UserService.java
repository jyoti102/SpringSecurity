package com.security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.demo.dao.UserRepository;
import com.security.demo.model.User;

/**
 * @author Jyoti Singh
 *
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	/**
	 * Implement the UserDetails interface
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found in database.");
		}
		return new UserDetailImpl(user);
	}

}
