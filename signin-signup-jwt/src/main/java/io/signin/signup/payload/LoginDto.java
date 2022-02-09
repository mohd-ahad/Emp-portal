package io.signin.signup.payload;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class LoginDto implements Serializable {
private String usernameorEmail;
private String password;
public String getUsernameorEmail() {
	return usernameorEmail;
}
public void setUsernameorEmail(String usernameorEmail) {
	this.usernameorEmail = usernameorEmail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
