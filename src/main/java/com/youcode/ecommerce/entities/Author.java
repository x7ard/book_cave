package com.youcode.ecommerce.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author extends AuditEntities {

	private static final long serialVersionUID = 7529192546294488408L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String bio;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private List<Ebook> ebooks;

	public Author() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Ebook> getEbooks() {
		return ebooks;
	}

	public void setEbooks(List<Ebook> ebooks) {
		this.ebooks = ebooks;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", bio=" + bio + ", ebooks=" + ebooks + "]";
	}

}
