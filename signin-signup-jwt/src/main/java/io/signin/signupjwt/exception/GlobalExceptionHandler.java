package io.signin.signupjwt.exception;



import java.util.Date;

import com.google.gson.Gson;
import io.signin.signupjwt.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Gson gson =new Gson();
	//global exception
	///@ExceptionHandler(Exception.class)
	//public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,WebRequest webrequest)
	//{
	//	ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webrequest.getDescription(false));
	//	return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	//}
	
	@ExceptionHandler(value=UnauthorizedExpection.class)
	public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedExpection exception)
	{
		return ResponseHandler.generateresponse("Credential are Wrong",HttpStatus.UNAUTHORIZED);
	}
	
	

}
