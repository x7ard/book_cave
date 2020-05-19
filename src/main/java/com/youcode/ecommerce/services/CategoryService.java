package com.youcode.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.youcode.ecommerce.entities.Category;

public interface CategoryService {

	public Category findByName(String category);

	public Optional<Category> getCategory(Long id);

	public List<Category> findAll();

	public Category findByCategory(Long id);

	public Category save(Category category);

	public void delete(Long id);

	public List<Category> getAllCategories();

}
