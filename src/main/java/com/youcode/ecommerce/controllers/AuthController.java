package com.youcode.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.ecommerce.config.JwtTokenUtil;
import com.youcode.ecommerce.entities.JwtRequest;
import com.youcode.ecommerce.entities.JwtResponse;
import com.youcode.ecommerce.entities.User;
import com.youcode.ecommerce.services.imp.UserServiceImp;

@RestController
@CrossOrigin
public class AuthController extends ApiController {

	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserServiceImp userService;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> createAutheticationToken(@RequestBody JwtRequest authRequest) throws Exception {

		authenticate(authRequest.getUsername(), authRequest.getPassword());
		final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			throw new Exception("user_disabled", e);
		} catch (BadCredentialsException e) {
			throw new Exception("invalid_credentials", e);
		}

	}

}
