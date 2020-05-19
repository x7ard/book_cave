package com.youcode.ecommerce.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.youcode.ecommerce.entities.Author;

public interface AuthorService {

	public Author findById(long id);

	public Author findByAuthorName(String name);

	public List<Author> findAll(Pageable pages);

	public Author save(Author author);

	public void delete(long id);

}
