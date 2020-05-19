package com.youcode.ecommerce.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.CategoryRepo;
import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.exceptions.ResourceNotFoundException;
import com.youcode.ecommerce.services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {

	private final CategoryRepo catRepo;

	@Autowired
	public CategoryServiceImp(CategoryRepo catRepo) {
		this.catRepo = catRepo;
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories = (List<Category>) catRepo.findAll();
		return categories;
	}

	@Override
	public Category findByCategory(Long id) {
		return catRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"sorry the category you're trying to reach with id: " + id + " is not found"));
	}

	@Override
	public Category save(Category category) {
		return catRepo.save(category);
	}

	@Override
	public Category findByName(String category) {
		return catRepo.findByLabel(category);
	}

	@Override
	public void delete(Long id) {
		catRepo.deleteById(id);

	}

	@Override
	public List<Category> getAllCategories() {
		return catRepo.findByParentCategoryIsNull();
	}

	@Override
	public Optional<Category> getCategory(Long id) {
		return catRepo.findById(id);
	}

}
