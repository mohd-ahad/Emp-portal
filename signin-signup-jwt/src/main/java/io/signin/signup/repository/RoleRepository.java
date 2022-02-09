package io.signin.signup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.signin.signupjwt.Role;
public interface RoleRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByName(String name);

}
