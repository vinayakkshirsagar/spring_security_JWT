package com.bsl.business.serviceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bsl.business.dto.JwtAuthenticationResponse;
import com.bsl.business.dto.SignInRequest;
import com.bsl.business.dto.SignUpRequest;
import com.bsl.business.entities.ROLE;
import com.bsl.business.entities.User;
import com.bsl.business.repository.UserRepository;
import com.bsl.business.service.AuthenticationService;
import com.bsl.business.service.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTService jwtService;
	
	
	public User signup(SignUpRequest signUpRequest) {
		User user = new User();
		user.setFirstName(signUpRequest.getFirstName());
		user.setSecondName(signUpRequest.getLastName());
		user.setRole(ROLE.USER);
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		return userRepository.save(user);
	}
	
	public JwtAuthenticationResponse signin(SignInRequest signInRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
		
		var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid Email or Password."));
		var jwt=jwtService.generateToken(user);
		var refreshToken = jwtService.generateRereshToken(new HashMap<>(),user);
		
		JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
		jwtAuthenticationResponse.setToken(jwt);
		jwtAuthenticationResponse.setRefreshToken(refreshToken);
		return jwtAuthenticationResponse;
	}	
}
