package com.youcode.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

	public Category findByLabel(String label);

	public List<Category> findAllByOrderByLabel();

	public List<Category> findByParentCategoryIsNull();

}
