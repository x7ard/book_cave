package com.youcode.ecommerce.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.EbookRepo;
import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.entities.Ebook;
import com.youcode.ecommerce.exceptions.ResourceNotFoundException;
import com.youcode.ecommerce.services.EbookService;

@Service
public class EbookServiceImp implements EbookService {

	@Autowired
	EbookRepo ebookRepo;

	@Override
	public Ebook findbyId(Long id) {
		return ebookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"sorry the category you're trying to reach with id: " + id + " is not found"));
	}

	@Override
	public List<Ebook> findAll(Pageable pageable) {
		return ebookRepo.findAll(pageable).getContent();
	}

	@Override
	public List<Ebook> findAllByCategory(Pageable pageable, Category category) {
		return ebookRepo.findAllByCategory(pageable, category);
	}

	@Override
	public List<Ebook> findTop8ByOrderBySellCountDesc() {
		return ebookRepo.findTop8ByOrderBySellCountDesc();
	}

	@Override
	public List<Ebook> findTop8ByOrderBySellCountDescCacheRefresh() {
		return ebookRepo.findTop8ByOrderBySellCountDesc();
	}

	@Override
	public List<Ebook> getRelatedEbooks(Category category, Long id) {
		List<Ebook> returnList = ebookRepo.findTop8ByCategoryAndIdIsNotOrderBySellCountDesc(category, id);
		if (returnList.size() < 8) {
			returnList.addAll(ebookRepo.findAllByCategoryIsNotOrderBySellCountDesc(category,
					PageRequest.of(0, 8 - returnList.size())));
		}
		return returnList;
	}

	@Override
	public List<Ebook> searchEbooks(String keyword, Integer page, Integer size) {
		if (page == null || size == null) {
			throw new IllegalArgumentException("Page and size parameters are required");
		}
		PageRequest pageRequest = PageRequest.of(page, size);
		return ebookRepo.findAllByTitleContainingIgnoreCase(keyword, pageRequest);
	}

	@Override
	public Ebook save(Ebook eBook) {
		return ebookRepo.save(eBook);
	}

	@Override
	public void deleteById(long id) {
		ebookRepo.deleteById(id);

	}

}
