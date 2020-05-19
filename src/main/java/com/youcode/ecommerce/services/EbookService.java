package com.youcode.ecommerce.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.entities.Ebook;

public interface EbookService {

	Ebook findbyId(Long id);

	List<Ebook> findAll(Pageable pageable);

	List<Ebook> findAllByCategory(Pageable pageable, Category category);

	List<Ebook> findTop8ByOrderBySellCountDesc();

	List<Ebook> findTop8ByOrderBySellCountDescCacheRefresh();

	List<Ebook> getRelatedEbooks(Category category, Long id);

	List<Ebook> searchEbooks(String keyword, Integer page, Integer size);

	Ebook save(Ebook eBook);

	void deleteById(long id);

}
