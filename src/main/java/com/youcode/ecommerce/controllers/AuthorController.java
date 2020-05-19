package com.youcode.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.ecommerce.entities.Author;
import com.youcode.ecommerce.services.AuthorService;

@RestController
@CrossOrigin
public class AuthorController extends ApiController {

	@Autowired
	AuthorService authorService;

	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAllAuthors(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {

		if (page == null || size == null) {
			throw new IllegalArgumentException("Page and size parameters are required");
		}
		PageRequest pageRequest = PageRequest.of(page, size);
		List<Author> returnList = authorService.findAll(pageRequest);
		return new ResponseEntity<List<Author>>(returnList, HttpStatus.OK);

	}

	@PostMapping("/admin/author")
	public Author createAuthor(@RequestBody Author author) {
		return authorService.save(author);
	}

	@DeleteMapping("/admin/author/{id}")
	public ResponseEntity<String> deleteAuthor(@PathVariable("id") Long id) {
		authorService.delete(id);
		return new ResponseEntity<String>("author deleted with success", HttpStatus.OK);

	}

}
