package io.signin.signupjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.signin.signup.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="SignIn_SignUp Api",version="1.0",description="SignIn,SignUp Service"))
@EnableJpaRepositories(basePackageClasses= UserRepository.class)
public class SigninSignupJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigninSignupJwtApplication.class, args);
	}

}
