package com.bsl.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsl.business.dto.JwtAuthenticationResponse;
import com.bsl.business.dto.SignInRequest;
import com.bsl.business.dto.SignUpRequest;
import com.bsl.business.entities.User;
import com.bsl.business.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
		return ResponseEntity.ok(authenticationService.signup(signUpRequest));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
		return ResponseEntity.ok(authenticationService.signin(signInRequest));
	}
}
