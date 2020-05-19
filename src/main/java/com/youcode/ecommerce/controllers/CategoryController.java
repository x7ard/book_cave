package com.youcode.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.exceptions.ResourceNotFoundException;
import com.youcode.ecommerce.services.CategoryService;

@RestController
@CrossOrigin
public class CategoryController extends ApiController {

	@Autowired
	CategoryService catService;

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return catService.getAllCategories();
	}

	@GetMapping("/categories/{id}")
	public Category getCategory(@PathVariable long id) {
		return catService.findByCategory(id);
	}

	@PostMapping("/admin/categories")
	public Category createCategory(@RequestBody Category category) {
		category.checkCategory();
		return catService.save(category);
	}

	@PostMapping("/admin/categories/{id}")
	public ResponseEntity<Category> addSubCategory(@PathVariable("id") Long id, @RequestBody Category subCategory) {
		Category category = catService.getCategory(id)
				.orElseThrow(() -> new ResourceNotFoundException("there is no category with this id"));
		subCategory.setParentCategory(category);
		subCategory.checkCategory();
		catService.save(subCategory);
		return ResponseEntity.ok(subCategory);
	}

	@DeleteMapping("/admin/categories/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {
		catService.delete(id);
	}

}
