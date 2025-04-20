package com.bsl.business.service;

import com.bsl.business.dto.SignUpRequest;
import com.bsl.business.entities.User;

public interface AuthenticationService {
	User signup(SignUpRequest signUpRequest);

}
