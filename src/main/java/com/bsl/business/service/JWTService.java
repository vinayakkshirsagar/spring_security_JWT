package com.bsl.business.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

	public String extractUsername(String token);

	public String generateToken(UserDetails userDetails);

	boolean isTokenValid(String token, UserDetails userDetails);
}
