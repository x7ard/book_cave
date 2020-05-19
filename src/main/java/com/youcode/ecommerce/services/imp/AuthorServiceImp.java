package com.youcode.ecommerce.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.AuthorRepo;
import com.youcode.ecommerce.entities.Author;
import com.youcode.ecommerce.exceptions.ResourceNotFoundException;
import com.youcode.ecommerce.services.AuthorService;

@Service
public class AuthorServiceImp implements AuthorService {

	@Autowired
	AuthorRepo authorDao;

	@Override
	public Author findById(long id) {
		return authorDao.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"sorry the category you're trying to reach with id: " + id + " is not found"));
	}

	@Override
	public Author findByAuthorName(String name) {
		return authorDao.findByName(name);
	}

	@Override
	public List<Author> findAll(Pageable pages) {
		return authorDao.findAll(pages).getContent();
	}

	@Override
	public Author save(Author author) {
		return authorDao.save(author);
	}

	@Override
	public void delete(long id) {
		authorDao.deleteById(id);
	}

}
