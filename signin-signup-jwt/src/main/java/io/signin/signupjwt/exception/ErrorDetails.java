package io.signin.signupjwt.exception;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {
	private String field;
	private String code;
	private String message;
	}

