package com.bsl.business.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JWTService {
	public String generateToken(UserDetails userDetails);

	public String extractUsername(String token);
}
