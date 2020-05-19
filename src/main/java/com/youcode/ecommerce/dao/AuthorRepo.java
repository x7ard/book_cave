package com.youcode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

	public Author findByName(String name);

}
