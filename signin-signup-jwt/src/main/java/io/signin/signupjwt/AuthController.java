package io.signin.signupjwt;
import io.signin.signupjwt.AuthenticationResponse;
import io.signin.signupjwt.exception.UnauthorizedExpection;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.signin.signup.payload.LoginDto;
import io.signin.signup.payload.SignUpDto;
import io.signin.signup.repository.RoleRepository;
import io.signin.signup.repository.UserRepository;

@RestController
//@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
	private JwtUtil jwtTokenUtil;
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    private static final Gson gson =new Gson();
    
    @RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
    

    @PostMapping("/signin")
    public ResponseEntity<io.signin.signupjwt.AuthenticationResponse> authenticateUser(@RequestBody LoginDto loginDto) throws UnauthorizedExpection{
    	
        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
       // return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
        
        UserDetails userDetails = userDetailsService
				.loadUserByUsername(loginDto.getEmail());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignUpDto signUpDto){


        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
           // return new ResponseEntity<>(gson.toJson("Email is already taken"),HttpStatus.BAD_REQUEST);
        	return ResponseHandler.generateresponse("Email is already taken",HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);
       // return new ResponseEntity<>(gson.toJson("User registered successfully"),HttpStatus.OK);
        return ResponseHandler.generateresponse("User registered successfully",HttpStatus.OK);
    }
}
