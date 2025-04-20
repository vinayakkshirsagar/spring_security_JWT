package com.bsl.business.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import com.bsl.business.entities.User;

public interface JWTService {

	public String extractUsername(String token);

	public String generateToken(UserDetails userDetails);

	boolean isTokenValid(String token, UserDetails userDetails);

	String generateRereshToken(Map<String, Object> extraClaims, User user);
}
