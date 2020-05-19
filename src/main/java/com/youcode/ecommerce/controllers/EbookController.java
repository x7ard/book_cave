package com.youcode.ecommerce.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.ecommerce.entities.Author;
import com.youcode.ecommerce.entities.Category;
import com.youcode.ecommerce.entities.Ebook;
import com.youcode.ecommerce.services.AuthorService;
import com.youcode.ecommerce.services.CategoryService;
import com.youcode.ecommerce.services.EbookService;

@RestController
@CrossOrigin
public class EbookController extends ApiController {

	@Autowired
	EbookService ebookService;

	@Autowired
	CategoryService catService;

	@Autowired
	AuthorService authorService;

	private boolean isBlank(String param) {
		return param.isEmpty() || param.trim().equals("");
	}

	private Sort getSort(String sort) {
		switch (sort) {
		case "lowest":
			return Sort.by(Sort.Direction.ASC, "price");
		case "highest":
			return Sort.by(Sort.Direction.DESC, "price");
		case "name":
			return Sort.by(Sort.Direction.ASC, "name");
		default:
			return null;
		}
	}

	@GetMapping("/ebooks")
	public ResponseEntity getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "category", required = false) String category) {
		if (page == null || size == null) {
			throw new IllegalArgumentException("Page and size parameters are required");
		}
		PageRequest pageRequest;
		if (sort != null && !isBlank(sort)) {
			Sort sortRequest = getSort(sort);
			if (sortRequest == null) {
				throw new IllegalArgumentException("Invalid sort parameter");
			}
			pageRequest = PageRequest.of(page, size, sortRequest);
		} else {
			pageRequest = PageRequest.of(page, size);
		}
		if (category != null && !isBlank(category)) {
			Category productCategory = catService.findByName(category);
			if (productCategory == null) {
				throw new IllegalArgumentException("Invalid category parameter");
			}
			List returnList = ebookService.findAllByCategory(pageRequest, productCategory);
			return new ResponseEntity<List>(returnList, HttpStatus.OK);
		}

		List returnList = ebookService.findAll(pageRequest);
		return new ResponseEntity<>(returnList, HttpStatus.OK);

	}

	@GetMapping("/ebook/{id}")
	public ResponseEntity getFullById(@PathVariable("id") Long id) {
		Ebook ebook = ebookService.findbyId(id);
		if (ebook == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ebook>(ebook, HttpStatus.OK);
	}

	@RequestMapping(value = "/ebooks/mostselling", method = RequestMethod.GET)
	public ResponseEntity getByMostSelling() {
		List returnList = ebookService.findTop8ByOrderBySellCountDesc();
		return new ResponseEntity<List>(returnList, HttpStatus.OK);
	}

	// some logic
	@RequestMapping(value = "/ebooks/interested", method = RequestMethod.GET)
	public ResponseEntity getByInterested() {
		List returnList = ebookService.findTop8ByOrderBySellCountDesc();
		return new ResponseEntity<List>(returnList, HttpStatus.OK);
	}

	// search
	@RequestMapping(value = "/ebooks/search", method = RequestMethod.GET, params = { "page", "size", "keyword" })
	public ResponseEntity searchProduct(@RequestParam("page") Integer page, @RequestParam("size") Integer size,
			@RequestParam("keyword") String keyword) {
		List returnList = ebookService.searchEbooks(keyword, page, size);
		return new ResponseEntity<List>(returnList, HttpStatus.OK);
	}

	@PostMapping("/admin/ebook/{authorId}/{categoryId}")
	public Ebook createEbook(@PathVariable("authorId") Long authorId, @PathVariable("categoryId") Long categoryId,
			@RequestBody Ebook ebook) {
		Author author = authorService.findById(authorId);
		Category category = catService.findByCategory(categoryId);
		ebook.setCategory(category);
		ebook.setAuthor(author);
		return ebookService.save(ebook);
	}

	@DeleteMapping("/admin/ebook/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
		ebookService.deleteById(id);
		return new ResponseEntity<String>("the ebook is deleted successfully", HttpStatus.OK);
	}

	// comprissi l'image bash nstoriwha fi db

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}

		try {
			outputStream.close();
		} catch (IOException e) {
		}

		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	// uncompressi les images bash njibhom man db

	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {

		} catch (DataFormatException e) {
		}

		return outputStream.toByteArray();
	}
}
