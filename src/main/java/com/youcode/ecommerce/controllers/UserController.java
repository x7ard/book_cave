package com.youcode.ecommerce.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController extends ApiController {

	@PostMapping("/profile/register")
	public ResponseEntity<String> signup() {

		return new ResponseEntity<String>("signup done !", HttpStatus.OK);
	}

}
