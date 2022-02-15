package io.signin.signup.payload;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class LoginDto implements Serializable {
private String email;
private String password;
public String getEmail() {
	return email;
}
public void setEmail(String Email) {
	this.email = Email;
}
public String getPassword() {
	return password;
}
public void setPassword(String Password) {
	this.password = Password;
}


}
