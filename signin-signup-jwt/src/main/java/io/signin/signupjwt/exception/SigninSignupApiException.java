package io.signin.signupjwt.exception;

import org.springframework.http.HttpStatus;

public class SigninSignupApiException extends RuntimeException {
	private HttpStatus status;
	private String message;
	
	public SigninSignupApiException(HttpStatus status,String message) {
	   this.status=status;
	   this.message=message;
	   
	}
	

}
