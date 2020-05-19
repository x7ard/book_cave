package com.youcode.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.entities.Ebook;

@Repository
public interface EbookRepo extends PagingAndSortingRepository<Ebook, Long> {

	List<Ebook> findAllByCategory(Pageable pageable, Category category);

	List<Ebook> findAllByAuthor(Long id, Pageable pageable);

	List<Ebook> findTop8ByOrderBySellCountDesc();

	List<Ebook> findTop8ByCategoryAndIdIsNotOrderBySellCountDesc(Category category, Long id);

	List<Ebook> findAllByCategoryIsNotOrderBySellCountDesc(Category category, Pageable pageable);

	List<Ebook> findAllByTitleContainingIgnoreCase(String name, Pageable pageable);

	}
