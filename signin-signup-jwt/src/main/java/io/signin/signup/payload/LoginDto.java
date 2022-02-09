package io.signin.signup.payload;

import lombok.Data;

@Data
public class LoginDto {
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
