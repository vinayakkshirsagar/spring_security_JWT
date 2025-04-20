package com.bsl.business.serviceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bsl.business.repository.UserRepository;
import com.bsl.business.service.UserSevice;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSeviceImpl implements UserSevice {

	public UserRepository userRepository;

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return userRepository.findByEmail(username)
						.orElseThrow(() -> new UsernameNotFoundException("User Not ound"));
			}
		};

	}
}
