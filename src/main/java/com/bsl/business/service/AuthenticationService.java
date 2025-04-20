package com.bsl.business.service;

import com.bsl.business.dto.JwtAuthenticationResponse;
import com.bsl.business.dto.RefreshTokenRequest;
import com.bsl.business.dto.SignInRequest;
import com.bsl.business.dto.SignUpRequest;
import com.bsl.business.entities.User;

public interface AuthenticationService {

	User signup(SignUpRequest signUpRequest);

	JwtAuthenticationResponse signin(SignInRequest signInRequest);

	JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
