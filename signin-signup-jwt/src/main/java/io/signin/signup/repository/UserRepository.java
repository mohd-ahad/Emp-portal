package io.signin.signup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.signin.signupjwt.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	// Optional<User> findByUsernameOrEmail(String email);
	    Boolean existsByEmail(String email);

}
